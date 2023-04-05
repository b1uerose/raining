<%@ page import="javax.xml.ws.RequestWrapper" %>
<%@ page import="com.xiao.raining.vo.dept.DeptVo" %><%--
  Created by IntelliJ IDEA.
  User: xiao
  Date: 2023/4/4
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改部门</title>
</head>
<body>
<h1>修改部门</h1>

<%
    DeptVo deptVo = (DeptVo) request.getAttribute("deptVo");
%>

<form action="<%=request.getContextPath()%>/dept/modifySave" method="post">
    <ul>
        <li style="display: none"><label for="id">id</label><input type="text" name="id" id="id" value="<%=deptVo.getId()%>"></li>
        <li><label for="vcode">部门编号</label><input type="text" name="vcode" id="vcode" value="<%=deptVo.getVcode()%>"></li>
        <li><label for="vname">部门名称</label><input type="text" name="vname" id="vname" value="<%=deptVo.getVname()%>"></li>
        <li><label for="vlocation">部门位置</label><input type="text" name="vlocation" id="vlocation" value="<%=deptVo.getVlocation()%>"></li>
    </ul>
    <input type="submit" value="修改保存">
</form>
</body>
</html>
