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
        <a style="margin: 15px; color:blue; cursor: pointer; ">Russian</a>
        <a style="margin: 15px; color:blue; cursor: pointer;">English</a></u></b>
    <a>currentUser</a>
    <a routerLink="/login-rest">login </a>
    <a style="margin: 15px; color:blue; cursor: pointer;">Sign out</a>
</div>
<div class="smenu">
    <h2 align="center">news</h2>
    <h4><a href="/EjEx2/listNews">newsList</a></h4>
    <h4><a href="/EjEx2/editNews">addNews</a></h4>
</div>
<form action="delete" method="post">
    <c:forEach items="${listNews}" var="news">
        <div class="content" align="center">
            <b> title </b>
            <span style="padding-left: 20px"> ${news.newsTitle} </span>
            <span style="float: right;"> <i><u>${news.newsDate}</u></i></span>
            <h5>${news.newsBrief}</h5>
            <span style="float: right;">
    <a href="/EjEx2/news?id=${news.newsId}">  view</a>
    <a href="/EjEx2/editNews?id=${news.newsId}"> edit</a>

            <input type="checkbox" name="deleteNews" value="${news.newsId}"/>
       </span>
            <h5></h5>
        </div>
    </c:forEach>
    <input style="float: right;" type="submit" value="delete"/>
</form>
</body>
</html>
