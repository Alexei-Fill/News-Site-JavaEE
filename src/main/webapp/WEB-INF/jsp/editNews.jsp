<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div>
    <form  accept-charset="UTF-8"  id = "editNews"  method="post" action="editNews" >

        <input name = "newsId" hidden="false" type="text" size="25" value ="${news.newsId}"/>
        <input name = "newsTitle"  type="text"  value ="${news.newsTitle}"/>
        <input name = "newsDate"  type="text"  value ="${news.newsDate}"/>
        <input name = "newsBrief"  type="text"  value ="${news.newsBrief}"/>
        <input name = "newsContent"  type="text"  value ="${news.newsContent}"/>

        <input type ="submit"   value ="sub"  />

        </form>
</div>
</body>
</html>
