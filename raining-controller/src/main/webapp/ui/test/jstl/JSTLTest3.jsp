<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL3-choose-when</title>
</head>
<body>
    <c:choose>
        <c:when test="${param.age < 18}">
            小屁孩
        </c:when>
        <c:when test="${param.age < 25}">
            青年
        </c:when>
        <c:when test="${param.age < 35}">
            壮年
        </c:when>
        <c:otherwise>
            老年
        </c:otherwise>
        
    </c:choose>



</body>
</html>
