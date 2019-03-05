<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <a href="/EjEx2/login" >login </a>

    <a
            style="margin: 15px; color:blue; cursor: pointer;"  >Sign out</a>

</div>
<div class="smenu">
    <h2 align="center">news</h2>
    <h4><a href="/EjEx2/listNews">newsList</a></h4>
    <h4 ><a href="/EjEx2/editNews">addNews</a></h4>
</div>

<form method="post" action="j_security_check" style = "margin-left: 40%;">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <h3>login</h3>
    <input  name = "j_username"  type="text"  />
    <h3>password</h3>
    <input   name = "j_password" type="password" />
    <div style = "margin-bottom:10px;"></div>
    <input type ="submit" value ="signIn"/>
</form>

<c:if  test = "${param.error!= null}" >
    <p>
       incLoginOrPass
    </p> </c:if>


</body>
</html>
