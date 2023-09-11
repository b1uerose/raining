package com.xiao.raining.dao.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * 解析mybatis核心配置文件
 * Author: xiaojl
 * Date:2023-05-17 21:53
 */
public class ParseMyBatisConfigByDom4j {
    
    @Test
    public void testParseMyBatisConfig() throws Exception {
        String mybatis_config = "mybatis-config.xml";

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(mybatis_config);
        //通过dom4j获取document对象
        SAXReader reader = new SAXReader();
        Document document = reader.read(is);
        
        //1、获取文档的根标签
        Element rootElement = document.getRootElement();
        System.out.println("根标签的名称：" + rootElement.getName());

        //2、根据xpath获取environments标签
        String xpath = "/configuration/environments";
        Element environmentElement = (Element) document.selectSingleNode(xpath);
        //2.1、获取默认的environment
        String defaultEnvironment = environmentElement.attributeValue("default");
        System.out.println("default environment is " + defaultEnvironment);
        
        //2.2、根据默认的environment，获取对应的environment标签
        xpath = "/configuration/environments/environment[@id='" + defaultEnvironment + "']";
        Element defaultEnvironmentElement = (Element) document.selectSingleNode(xpath);
        
        //3、输出默认environment的信息
        
        //3.1、事务管理器
        Element transactionManagerElement = defaultEnvironmentElement.element("transactionManager");
        String transactionType = transactionManagerElement.attributeValue("type");
        System.out.println("事务管理器为：" + transactionType);

        //3.2、数据源
        Element dataSourceElement = defaultEnvironmentElement.element("dataSource");
        String datasourceType = dataSourceElement.attributeValue("type");
        System.out.println("数据源类型：" + datasourceType);

        List<Element> propertyElements = dataSourceElement.elements();
        propertyElements.forEach(propertyElement -> {
            String propertyName = propertyElement.attributeValue("name");
            String propertyValue = propertyElement.attributeValue("value");
            System.out.println(propertyName + ":" + propertyValue);
        });
        
        //4、获取mapper，如果不想从根节点开始，用//
        xpath = "//mappers";
        Element mappersElement = (Element) document.selectSingleNode(xpath);
        List<Element> mapperElements = mappersElement.elements();
        mapperElements.forEach(mapperElement -> {
            String resource = mapperElement.attributeValue("resource");
            System.out.println("mapper的resource为：" + resource);
        });
    }
    
    @Test
    public void testParseMapper() throws Exception {
        String mapperFilePath = "mapper/CarMapper2.xml";
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(mapperFilePath);
        SAXReader reader = new SAXReader();
        Document document = reader.read(is);
        
        String xpath = "/mapper";
        Element mapperElement = (Element) document.selectSingleNode(xpath);
        String namespace = mapperElement.attributeValue("namespace");
        System.out.println("namespace is " + namespace);

        List<Element> childElements = mapperElement.elements();
        
        childElements.forEach(element -> {
            String id = element.attributeValue("id");
            System.out.println("id is " + id);

            String resultType = element.attributeValue("resultType");
            System.out.println("resultType is " + resultType);

            String sql = element.getTextTrim();

            System.out.println("sql is " + sql);

            String translatedSql = sql.replaceAll("#\\{[0-9A-Za-z_$]*}", "?");
            System.out.println("转换后的sql：" + translatedSql);

        });


    }
    
    
}
