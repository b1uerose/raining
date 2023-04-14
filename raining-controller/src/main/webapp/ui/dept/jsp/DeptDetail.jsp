<%@ page import="com.xiao.raining.vo.dept.DeptVO" %><%--
  Created by IntelliJ IDEA.
  User: xiao
  Date: 2023/4/4
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门详情</title>
</head>
<body>
<h1>部门详情</h1>
<hr >

<%--<%--%>
<%--    DeptVo deptVo = (DeptVo) request.getAttribute("deptVo");--%>
<%--%>--%>
<ul>
    <li>部门编码：${deptVo.vcode}</li>
    <li>部门名称：${deptVo.vname}</li>
    <li>部门位置：${deptVo.vlocation}</li>
<%--    <li>部门编码：<%= deptVo.getVcode()%></li>--%>
<%--    <li>部门名称：<%= deptVo.getVname()%></li>--%>
<%--    <li>部门位置：<%= deptVo.getVlocation()%></li>--%>
</ul>

<input type="button" value="返回" onclick="window.history.back()">
</body>
</html>
