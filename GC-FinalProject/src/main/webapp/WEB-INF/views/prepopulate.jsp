<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>Beer Me!</title>
<title>Populate DataBase</title>
</head>
<body class="background-blank">
<div>
	<br><h3>Populate Database...</h3><br>
	
	<c:if test="${ not empty name }">
		<h2> ${ name } ADDED!</h2>
	</c:if>

	<c:forEach var="entity" items="${ entities }">
	 <p><a href="/populate/${ entity.key }">${ entity.key }</a>
	 <c:if test="${ entity.value }">
	 	 - already added
	 </c:if>
	 </p>
	</c:forEach>
	
</div>
</body>
</html>