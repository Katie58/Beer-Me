<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../style.css">
<title>${ beer.name }</title>
</head>
<body>
<div class="background">
	<div class="beer"></div>
	<div class="label">
		<img src="${ beer.labels.medium }">
	</div>
	<div class="beer-name">
		<h1>${ beer.name }</h1>
		<c:choose>
			<c:when test="${ not empty beer.year }">
				<h2>${ beer.year }</h2>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${ local }">
				<h3>This beer is local!</h3>
			</c:when>
		</c:choose>
			<p><a href="/favorites">favorites</a>
			 | <a href="/search">search</a></p>
			 | <a href="/beerme">home</a></p>
	</div>
	<div class="beer-box">
		<div class="beer-details">
			<h3>
			<c:choose>
				<c:when test="${ not empty beer.abv }">
					ABV: ${ beer.abv } 
				</c:when>
			</c:choose>	
			<c:choose>
				<c:when test="${ not empty beer.ibu }">
					 | IBU: ${ beer.ibu } | 
				</c:when>
			</c:choose>	
			<c:choose>
				<c:when test="${ not empty beer.originalGravity }">
					 OG: ${ beer.originalGravity }
				</c:when>
			</c:choose>	
			</h3>
		</div>
		<c:choose>
			<c:when test="${ not empty beer.foodPairings }">
				<div class="beer-details">
					Pairs well with: ${ beer.foodPairings }
				</div>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${ not empty beer.description }">
				<div class="beer-details">
					${ beer.description }
				</div>
			</c:when>
		</c:choose>	
	</div>
</div>
</body>
</html>