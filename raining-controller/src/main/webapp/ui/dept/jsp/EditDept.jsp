<%@ page import="javax.xml.ws.RequestWrapper" %><%--
  Created by IntelliJ IDEA.
  User: xiao
  Date: 2023/4/4
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增部门</title>
</head>
<body>
<h1>新增部门</h1>
<form action="<%=request.getContextPath()%>/dept/deptedit" method="post">
    <ul>
        <li><label for="vcode">部门编号</label><input type="text" name="vcode" id="vcode" value="001"></li>
        <li><label for="vname">部门名称</label><input type="text" name="vname" id="vname" value="销售部"></li>
        <li><label for="vlocation">部门位置</label><input type="text" name="vlocation" id="vlocation" value="厦门"></li>
    </ul>
    <input type="submit" value="修改保存">
</form>
</body>
</html>
