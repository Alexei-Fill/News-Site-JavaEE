<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <LINK TYPE="text/css" rel="stylesheet" href="<c:url value="/resources/news.css"/>"/>
</head>
<body>
<div class="roof">
    <b style="margin-bottom: 20px;">newsManagment</b>
    <b style="margin-left: 65%;"><u>
        <a style="margin: 15px; color:blue; cursor: pointer; ">Russian</a>***************************************************
        <a style="margin: 15px; color:blue; cursor: pointer;">English</a></u></b>

    <c:if test="${customPrincipal == null}">
    <a href="/EjEx2/login">login </a>
    </c:if>
<c:if test="${customPrincipal != null}">
    <a>${customPrincipal.name}</a>
    <a href="/EjEx2/logout" style="margin: 15px; color:blue; cursor: pointer;">Sign out</a>
</c:if>
</div>
<div class="smenu">
    <h2 align="center">news</h2>
    <h4><a href="/EjEx2/listNews">newsList</a></h4>
<c:if test="${customPrincipal != null}">
    <h4><a href="/EjEx2/editNews">addNews</a></h4>
</c:if>
</div>
<form action="delete" method="post">
    <c:forEach items="${listNews}" var="news">
        <div class="content" align="center">
            <b> title </b>
            <span style="padding-left: 20px"> ${news.title} </span>
            <span style="float: right;"> <i><u>${news.date}</u></i></span>
            <h5>${news.brief}</h5>
            <span style="float: right;">
    <a href="/EjEx2/news?id=${news.id}">  view</a>
  <c:if test="${customPrincipal != null}">
  <a href="/EjEx2/editNews?id=${news.id}"> edit</a>

            <input type="checkbox" name="deleteNews" value="${news.id}"/>
  </c:if>

       </span>
            <h5></h5>
        </div>
    </c:forEach>
<c:if test="${customPrincipal != null}">
<input style="float: right;" type="submit" value="delete"/>
</c:if>

</form>
</body>
</html>
