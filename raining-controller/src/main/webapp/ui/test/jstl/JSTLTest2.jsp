<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:if test="${empty param.username}">
        用户名不能为空
    </c:if>

    <c:if test="${not empty param.username}" var="ele" scope="page">
        welcome ${param.username}
    </c:if>

    <c:forEach var="i" begin="1" end="10" step="2" varStatus="">
        ${i} <br>
    </c:forEach>

    


</body>
</html>
