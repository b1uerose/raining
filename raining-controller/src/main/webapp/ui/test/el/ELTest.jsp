<%@ page import="com.xiao.raining.vo.user.UserVO" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
 el表达式测试
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    UserVO user = new UserVO();
    user.setVcode("xiaojl");
    user.setVname("肖金龙");
    
    request.setAttribute("userVo", user);
    
    session.setAttribute("data", "session");
    request.setAttribute("data", "request");
    application.setAttribute("data", "application");
    pageContext.setAttribute("data", "pageContext");
    
    //{key:  value: }
    Map<String, String> userMap = new HashMap<>();
    userMap.put("vcode", "sunl");
    
    request.setAttribute("usermap", userMap);
    
    
    //
    String[] userArray = new String[] {"1","2","3","4"};
    request.setAttribute("array", userArray);
%>

${userVo.vcode}

${pageScope.data}
<br>
${requestScope.data}
<br>
${sessionScope.data}
<br>
${applicationScope.data}
<br>

${userVo["vcode"]}
EL表示是显示为""。<br>
EL表达式：${xssss}
<%=request.getAttribute("xssss")%>

<br>
EL表达式从map中取数据 
<br>
${usermap.vcode}
<hr>

EL表达式从数据中取数据
${array[1]}


<br>
应用的上下文： ${pageContext.request.contextPath}


<%= ((HttpServletRequest)pageContext.getRequest()).getContextPath()%>