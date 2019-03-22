<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>Beer Me | search</title>
</head>
<body class="background-blank">
<div style="text-align:center">
<br><a href="/">home</a><br><br>
	<c:choose>
		<c:when test="${ not empty search }">
			<c:forEach var="kv" items="${ search }">
				<p><a href="${ kv.value }"><h1>${ kv.key }</h1></a><p>
			</c:forEach>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="${ not empty entities }">
			<c:forEach var="entity" items="${ entities }">
				<p><a href="/find/${ entity }"><h1>${ entity }</h1></a><p>
			</c:forEach>
		</c:when>
	</c:choose>

</div>
</body>
</html>