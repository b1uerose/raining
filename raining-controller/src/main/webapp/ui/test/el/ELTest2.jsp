<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象</title>
</head>
<body>

    <h3>通过内置对象param来获取请求的参数</h3>
    <ul>
        <li>用户名:<%= request.getParameter("username")%></li>
        <li>用户名:${param.username}</li>
    </ul>
    <hr>

    <h3>通过内置对象paramValues获取多个参数</h3>
    <ul>
        <li>爱好：<%= request.getParameterMap().get("hobby")%></li>
        <li>爱好：${paramValues.hobby[0]}</li>
    </ul>

    <hr>
    <h3>通过内置对象</h3>
    <ul>
        <li>host: <%= request.getHeader("host")%></li>
        <li>host: ${header.host}</li>
    </ul>

    ${initParam.appname}


    ${cookie}

</body>
</html>
