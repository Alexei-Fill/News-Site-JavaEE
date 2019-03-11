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
        <a style="margin: 15px; color:blue; cursor: pointer; ">Russian</a>
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
<div >
    <form action="/deleteNews" >
  title  <p>${news.title}</p>
    <h6></h6>
    brief
    <p>${news.brief}</p>
    <h6></h6>
 date
    <p>${news.date}</p>
    <h6></h6>
    content
    <p>${news.content}</p>
    <h6></h6>
<c:if test="${customPrincipal != null}">
<a href="/EjEx2/editNews?id=${news.id}"><input type="button" value="edit"/></a>
        <input style="" type="submit" value="delete"/>
</c:if>

    </form>
</div>
</body>
</html>
