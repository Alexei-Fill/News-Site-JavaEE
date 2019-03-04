<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <LINK TYPE="text/css" rel="stylesheet" href="<c:url value="/resources/news.css"/>" />
</head>
<body>
<div class="roof">
    <b style="margin-bottom: 20px;">newsManagment</b>
    <b style="margin-left: 65%;"><u>
        <a
                style="margin: 15px; color:blue; cursor: pointer; ">Russian</a>
        <a
                style="margin: 15px; color:blue; cursor: pointer;">English</a></u></b>


    <a >currentUser</a>
    <a routerLink="/login-rest" >login </a>

    <a
            style="margin: 15px; color:blue; cursor: pointer;"  >Sign out</a>

</div>
<div class="smenu">
    <h2 align="center">news</h2>
    <h4><a href="/EjEx2/listNews">newsList</a></h4>
    <h4 ><a href="/EjEx2/editNews">addNews</a></h4>
</div>

<div >
    <form action="/deleteNews" >
  title  <p>${news.newsTitle}</p>
    <h6></h6>
    brief
    <p>${news.newsBrief}</p>
    <h6></h6>
 date
    <p>${news.newsDate}</p>
    <h6></h6>
    content
    <p>${news.newsContent}</p>
    <h6></h6>
        <a href="/EjEx2/editNews?id=${news.newsId}"><input type="button" value="edit"/></a>
        <input style="" type="submit" value="delete"/>
    </form>
</div>
</body>
</html>
