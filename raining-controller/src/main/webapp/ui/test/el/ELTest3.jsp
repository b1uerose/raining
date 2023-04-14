<%--
  Created by IntelliJ IDEA.
  User: xiao
  Date: 2023/4/9
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>运算符</title>
</head>
<body>

\${1 + "abc"}

${empty param.vcode ? "没有输入用户名" : param.vcode}
${not empty param.vcode ? param.vcode : "没有输入用户名"}

</body>
</html>
