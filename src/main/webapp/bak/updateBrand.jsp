<%--
  Created by IntelliJ IDEA.
  User: 77286
  Date: 2023/1/22
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>编辑品牌</title>
</head>
<body>

<h3>编辑品牌</h3>
<form action="/tomcatDemo2/updateServlet" method="post">
<%--    隐藏域--%>
    <input type="hidden" name="id" value="${brandEdit.id}">

    品牌名称：<input name="brandName" value="${brandEdit.brandName}"><br>
    企业名称：<input name="companyName" value="${brandEdit.companyName}"><br>
    排序：<input name="ordered" value="${brandEdit.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brandEdit.brandName}</textarea><br>
    状态：
    <c:if test="${brandEdit.status==0}">
        <input type="radio" name="status" value="0" checked>禁用
        <input type="radio" name="status" value="1">启用<br>
    </c:if>
    <c:if test="${brandEdit.status!=0}">
        <input type="radio" name="status" value="0" >禁用
        <input type="radio" name="status" value="1" checked>启用<br>
    </c:if>

    <input type="submit" value="提交">
</form>
</body>
</html>