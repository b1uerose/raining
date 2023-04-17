<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
    <ul>
        <li><label for="vcode">用户名</label><input type="text" id="vcode" name="vcode"></li>
        <li><label for="vpassword">密码</label><input type="password" id="vpassword" name="vpassword"></li>
<%--        <li><label for="isLoginInTenDays">10天内免登录</label><input type="checkbox" id="isLoginInTenDays" name="isLoginInTenDays"></li>--%>
    </ul>
    <input type="submit" value="登录">
</form>

</body>
</html>
