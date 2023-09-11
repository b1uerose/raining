package com.xiao.raining.test.maven.deploy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Deploy {

    public static final String DEPLOYSSH = "mvn deploy:deploy-file -Dmaven.test.skip=true -DgroupId=%s -DartifactId=%s -Dversion=%s -Dfile=%s -Dpackaging=%s -Durl=%s -DrepositoryId=%s -s %s";
    private static String repository;
    private static String targetRepositoryUrl;
    private static String targetRepositoryId;
    private static String deploySettings;
    private static String[] versions;
    private static String currentDirectory;
    public static Set<String> jarList = new HashSet<String>();
    public static Set<String> pomList = new HashSet<String>();
	public static void main(String[] args) throws IOException {
		repository = args[0];//仓库地址
		targetRepositoryUrl = args[1];//目标url
		targetRepositoryId = args[2];//仓库id
		deploySettings = args[3];//部署settings指定文件
		String[] syncDirs = args[4].split(",");
		versions = args[5].split(",");//待同步版本
		currentDirectory = args[6];//文件目录
		System.out.println("文件路径:"+currentDirectory);
		File targetFile = new File(currentDirectory + File.separator+"deploy.txt");
		if(targetFile.exists()) {
			targetFile.delete();
		}
		System.out.println("step3: 生成部署脚本");
		System.out.println("仓库地址:"+repository);
		for(String syncDir : syncDirs) {
			String rootPath = repository +syncDir;
			System.out.println("执行目标:"+rootPath);
			File root =  new File(rootPath);
			scanJarOrPom(root);
			
		}
		writeFile(targetFile);
        

	}
	/**
	 * 写文件
	 * @param targetFile
	 * @throws IOException 
	 */
    private static void writeFile(File targetFile){
    	FileWriter fw = null;
    	try {
        	fw = new FileWriter(targetFile,true);
        	for(String ssh : jarList) {
        		fw.write(ssh+";");
            }
            for(String ssh : pomList) {
            	fw.write(ssh+";");
            }
    	}catch(IOException e) {
    		e.printStackTrace();
    	}finally {
    		try {
                if(fw!=null)
                //4.流资源的关闭
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    	}
	}
	private static void scanJarOrPom(File parent) {
        File[] children = parent.listFiles();
        if(children == null) {
            return;
        }else{
            for(File child : children){
            	boolean isVersion = false;
            	for(String version : versions) {
            		if(parent.getName().endsWith(version)) {
            			isVersion = true;
            			break;
            		}
            	}
                if(child.isDirectory()){
                    scanJarOrPom(child);
                }else if (!child.getName().contains("-sources.jar") && (child.getName().endsWith(".jar") || child.getName().endsWith(".pom")) && isVersion) {
                    String filePath = child.getAbsolutePath();
                    String type = child.getName().contains(".pom")?"pom":"jar";
                    String version = parent.getName();
                    String artifactId = new File(parent.getParent()).getName();
                    String groupId = new File(parent.getParent()).getParent().replace(repository+"/","").replace("/",".");
                    String ssh = String.format(DEPLOYSSH, groupId,artifactId,version,filePath,type,targetRepositoryUrl,targetRepositoryId,deploySettings);
                    if("pom".equals(type)) {
                    	pomList.add(ssh);
                    }else if("jar".equals(type)){
                    	jarList.add(ssh);
                    }
                }
            }
        }
    }

}
