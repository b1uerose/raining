<%@ page import="com.xiao.raining.vo.user.UserVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.xiao.raining.vo.dept.DeptVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>

<%
    UserVO vo1 = new UserVO();
    vo1.setVcode("xiao");
    vo1.setVname("肖");

    UserVO vo2 = new UserVO();
    vo2.setVcode("sun");
    vo2.setVname("孙");
    
    List<UserVO> userVoList = new ArrayList<>();
    userVoList.add(vo1);
    userVoList.add(vo2);
    
    request.setAttribute("users", userVoList);
    
    
    List<DeptVO> deptList = new ArrayList<>();
    DeptVO vo = new DeptVO();
    vo.setVcode("1");
    vo.setVname("1部");

    DeptVO vo3 = new DeptVO();
    vo3.setVcode("2");
    vo3.setVname("2部");

    deptList.add(vo);
    deptList.add(vo3);
    
    request.setAttribute("dept", deptList);
%>

<%--<%--%>
<%--    List<UserVo> vos = (List<UserVo>) request.getAttribute("users");--%>
<%--    for (UserVo vo : vos) {--%>
<%--%>--%>
<%--    code:<%=vo.getVcode()%>, name:<%=vo.getVname()%> <br>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>

<c:forEach items="${users}" var="userVo" varStatus="varObj">
    序号：${varObj.count},vcode:${userVo.vcode}, vname: ${userVo.vname} <br>
</c:forEach>

<c:forEach items="${dept}" var="deptVo">
    vcode:${deptVo.vcode}, vname: ${deptVo.vname}
</c:forEach>

</body>
</html>
