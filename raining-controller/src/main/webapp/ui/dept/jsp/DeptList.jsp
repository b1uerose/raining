<%--
  Created by IntelliJ IDEA.
  User: xiao
  Date: 2023/4/4
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门列表</title>
</head>
<body>
<script type="text/javascript">
    function deleteDept(id) {
        if (window.confirm("确定要删除吗")) {
            window.location.href = "<%=request.getContextPath()%>/dept/deptlist?id="+id
        }
    }
    
    var contextPath = '<%=application.getContextPath()%>';

</script>
<h1 align="center">部门列表</h1>
<table align="center" border="1px" width="50%">
    <tr>
        <th>部门编码</th>
        <th>部门名称</th>
        <th>城市</th>
        <th>操作</th>
    </tr>
    <tr>
        <td>1</td>
        <td>销售部</td>
        <td>厦门</td>
        <td>
            <a href="javascript:void(0)" onclick="deleteDept(1)">删除</a>
            <a href="<%=request.getContextPath()%>/ui/dept/jsp/EditDept.jsp">修改</a>
            <a href="<%=request.getContextPath()%>/ui/dept/jsp/DeptDetail.jsp">详情</a>
        </td>
    </tr>
    <tr>
        <td>1</td>
        <td>销售部</td>
        <td>厦门</td>
        <td>
            <a href="javascript:void(0)" onclick="deleteDept(1)">删除</a>
            <a href="<%=request.getContextPath()%>/ui/dept/jsp/EditDept.jsp">修改</a>
            <a href="<%=request.getContextPath()%>/ui/dept/jsp/DeptDetail.jsp">详情</a>
        </td>
    </tr>
    <tr>
        <td>1</td>
        <td>销售部</td>
        <td>厦门</td>
        <td>
            <a href="javascript:void(0)" onclick="deleteDept(1)">删除</a>
            <a href="<%=request.getContextPath()%>/ui/dept/jsp/EditDept.jsp">修改</a>
            <a href="<%=request.getContextPath()%>/ui/dept/jsp/DeptDetail.jsp">详情</a>
        </td>
    </tr>
</table>

<a href="<%=request.getContextPath()%>/ui/dept/jsp/AddDept.jsp">新增</a>
</body>
</html>
