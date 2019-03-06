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
<div>
    <form  accept-charset="UTF-8"  id = "edit"  method="post"
            <c:if test="${news.newsId != null}"> action="edit" > </c:if>
            <c:if test="${news.newsId == null}"> action="add" > </c:if>

        <input name = "newsId" hidden="false" type="text" size="25" value ="${news.newsId}"/>
        <label>title <input name = "newsTitle"  type="text"  value ="${news.newsTitle}"/> </label><br>
        <label>date  <input name = "newsDate"  type="text"  value ="${news.newsDate}"/></label><br>
        <label>brief <input name = "newsBrief"  type="text"  value ="${news.newsBrief}"/></label><br>
        <label> content <input name = "newsContent"  type="text"  value ="${news.newsContent}"/></label><br>

        <input type ="submit"   value ="sub"  />

    </form>
</div>
</body>
</html>
