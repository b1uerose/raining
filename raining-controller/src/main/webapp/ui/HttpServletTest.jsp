<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>请求</h1>
<form action="/raining/httpservletrequest" method="get">
    <ul>
        <li><label for="username">用户名：</label><input type="text" name="username" id="username"></li>
        <li><label for="password">密码：</label><input type="password" name="password" id="password"></li>
        <li>
            <label for="hobbit">
                <div id="hobbit">
                    抽烟<input type="checkbox" name="hobbit" value="smoke">
                    喝酒<input type="checkbox" name="hobbit" value="drink">
                    其他<input type="checkbox" name="hobbit" value="other">
                </div>
            </label>
        </li>
        <li><input type="submit" value="登录"></li>
    </ul>
</form>

<h1>POST请求</h1>
<form action="/raining/httpservletrequest" method="post">
    <ul>
        <li><label for="username1">用户名：</label><input type="text" name="username" id="username1"></li>
        <li><label for="password1">密码：</label><input type="password" name="password" id="password1"></li>
        <li><input type="submit" value="登录"></li>
    </ul>
</form>
</body>
</html>