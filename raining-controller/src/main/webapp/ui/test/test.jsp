<%--
  Created by IntelliJ IDEA.
  User: xiao
  Date: 2023/4/8
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/ErrorPage.jsp" %>
<html>
<head>
    <title>jsp测试</title>
</head>
<body>

<%
    request.setAttribute("username", "xiaojl");

%>

${username}

</body>
</html>
