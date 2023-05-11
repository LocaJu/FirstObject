<%--
  Created by IntelliJ IDEA.
  User: 77286
  Date: 2023/1/21
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>商品</title>
</head>
<body>
<h1>${user.username}欢迎你</h1>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="100%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>
    <tr>
        <c:forEach items="${brands}" var="brand">
    <tr align="center">
        <td>${brand.id}</td>
        <td>${brand.brandName}</td>
        <td>${brand.companyName}</td>
        <td>${brand.ordered}</td>
        <td>${brand.description}</td>
        <c:if test="${brand.status==0}">
            <td>禁用</td>
        </c:if>
        <c:if test="${brand.status!=0}">
            <td>启用</td>
        </c:if>

        <td ><a href="/tomcatDemo2/selectByIdServlet?id=${brand.id}">编辑</a>
            <a id="delete" href="/tomcatDemo2/deleteByIdServlet?id=${brand.id}">删除</a></td>
    </tr>
    </c:forEach>
    </tr>
</table>

<script>
    document.getElementById('add').onclick=function(){
        location.href="addBrand.jsp";
    }

    

</script>
</body>
</html>
