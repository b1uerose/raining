<%@ page import="com.xiao.raining.vo.user.UserVo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>

<%
    UserVo vo1 = new UserVo();
    vo1.setVcode("xiao");
    vo1.setVname("肖");

    UserVo vo2 = new UserVo();
    vo2.setVcode("sun");
    vo2.setVname("孙");
    
    List<UserVo> userVoList = new ArrayList<>();
    userVoList.add(vo1);
    userVoList.add(vo2);
    
    request.setAttribute("users", userVoList);
%>

<%
    List<UserVo> vos = (List<UserVo>) request.getAttribute("users");
    for (UserVo vo : vos) {
%>
    code:<%=vo.getVcode()%>, name:<%=vo.getVname()%> <br>
<%
    }
%>

</body>
</html>
