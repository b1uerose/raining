<%@ page import="com.xiao.raining.vo.dept.DeptVo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门列表</title>
</head>
<body>
<script type="text/javascript">
    function deleteDept(id) {
        if (window.confirm("确定要删除吗")) {
            window.location.href = "<%=request.getContextPath()%>/dept/delete?id="+id
        }
    }
    
    var contextPath = '<%=application.getContextPath()%>';

</script>
<h1 align="center">部门列表</h1>
<table align="center" border="1px" width="50%">
    <tr>
        <th>部门编码</th>
        <th>部门名称</th>
        <th>城市</th>
        <th>操作</th>
    </tr>
    
    <%
        List<DeptVo> deptList = (List<DeptVo>) request.getAttribute("deptList");
        String contextPath = request.getContextPath();
        for (DeptVo deptVo : deptList) {
            //out.write("<tr>");
            //out.write("    <td>" + deptVo.getVcode() + "</td>");
            //out.write("    <td>" + deptVo.getVname() + "</td>");
            //out.write("    <td>" + deptVo.getVlocation() + "</td>");
            //out.write("    <td>");
            //out.write("        <a href=\"javascript:void(0)\" onclick=\"deleteDept(" + deptVo.getId() + ")\">删除</a>");
            //out.write("        <a href=\""+contextPath+"/ui/dept/jsp/EditDept.jsp\">修改</a>");
            //out.write("        <a href=\""+contextPath+"/ui/dept/jsp/DeptDetail.jsp\">详情</a>");
            //out.write("    </td>");
            //out.write("</tr>");
    %>
            <tr>
                <td><%= deptVo.getVcode()%></td>
                <td><%= deptVo.getVname()%></td>
                <td><%= deptVo.getVlocation()%></td>
                <td>
                    <a href="javascript:void(0)" onclick="deleteDept(<%=deptVo.getId()%>)">删除</a>
                    <a href="<%=request.getContextPath()%>/dept/modify?id=<%=deptVo.getId()%>">修改</a>
                    <a href="<%=request.getContextPath()%>/dept/detail?id=<%=deptVo.getId()%>">详情</a>
                </td>
            </tr>
    <%
        }
    %>
    <tr>
</table>

<a href="<%=request.getContextPath()%>/ui/dept/jsp/AddDept.jsp">新增</a>
<a href="<%=request.getContextPath()%>/logout">退出登录</a>
</body>
</html>
