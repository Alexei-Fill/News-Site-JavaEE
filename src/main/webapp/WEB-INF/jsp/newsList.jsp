<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<LINK TYPE="text/css" rel="stylesheet" href="/resources/news.css"/>
<head>

</head>
<body>
<c:forEach items="${listNews}" var="news">
    <div>
        <a href="/EjEx2/news?id=${news.newsId}">${news.newsTitle}</a>||
    </div>
</c:forEach>

</body>
</html>
