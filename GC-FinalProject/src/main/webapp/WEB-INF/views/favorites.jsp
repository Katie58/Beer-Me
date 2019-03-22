<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>Favorite Beers</title>
</head>
<body class="background-blank">
<div class="overlay">
	<br><br>
	<div>
		<c:choose>
			<c:when test="${ not empty action }">
				${ name } ${ action }
			</c:when>
			<c:otherwise>
				Places to be & Beers to drink...
			</c:otherwise>
		</c:choose>
	</div>
	<div>
	<c:choose>
		<c:when test="${ not empty beers }">
			<h1>BEERS</h1>
		</c:when>
	</c:choose>
	<hr style="width:50%">
		<c:forEach var="beer" items="${ beers }">
			<dl>
				<dt><h2><a class="beer-link" href="/beer/${ beer.beerId }/details">${ beer.name }</a></h2></dt>
				<dt>Rating: 
					<c:choose>
						<c:when test="${ not empty beer.rating }">
							${ beer.rating }<br>
							<a class="edit" href="/beer/${ beer.id }/0/ratingUpdate">edit</a>								
						</c:when>
						<c:otherwise>
							<a href="/beer/${ beer.id }/1/ratingUpdate"> 1 </a>
							<a href="/beer/${ beer.id }/2/ratingUpdate"> 2 </a>
							<a href="/beer/${ beer.id }/3/ratingUpdate"> 3 </a>
							<a href="/beer/${ beer.id }/4/ratingUpdate"> 4 </a>
							<a href="/beer/${ beer.id }/5/ratingUpdate"> 5 </a>	
						</c:otherwise>				
					</c:choose>
					<a class="edit" href="/beer/${ beer.id }/delete">delete</a>
				</dt>
				<c:choose>
					<c:when test="${ not empty beer.ingredients }">
						<dl>
							<dt>Ingredients</dt>
							<c:forEach var="ingredient" items="${ beer.ingredients }">
								<dd>${ ingredient }</dd>
							</c:forEach>
						</dl>
					</c:when>
				</c:choose>
			</dl>
			<hr style="width:15%">
		</c:forEach>
	</div>
	<div>
	<c:choose>
		<c:when test="${ not empty breweries }">
			<h1>BREWERIES</h1>
		</c:when>
	</c:choose>
		<hr style="width:50%">
		<c:forEach var="brewery" items="${ breweries }">
			<dl>
				<dt><h3>${ brewery.breweryName }</h3></dt>
				<dt>Rating: 
					<c:choose>
						<c:when test="${ not empty brewery.rating }">
							${ brewery.rating }<br>
							<a class="edit" href="/brewery/${ brewery.id }/0/ratingUpdate">edit</a>
						</c:when>
						<c:otherwise>
							<a href="/brewery/${ brewery.id }/1/ratingUpdate"> 1 </a>
							<a href="/brewery/${ brewery.id }/2/ratingUpdate"> 2 </a>
							<a href="/brewery/${ brewery.id }/3/ratingUpdate"> 3 </a>
							<a href="/brewery/${ brewery.id }/4/ratingUpdate"> 4 </a>
							<a href="/brewery/${ brewery.id }/5/ratingUpdate"> 5 </a>
							<br>
						</c:otherwise>
					</c:choose>
					<a class="edit" href="/brewery/${ brewery.id }/delete">delete</a> 
				</dt>
				<c:choose>
						<c:when test="${ not empty brewery.beers }">
							<c:forEach var="beer" items="${ brewery.beers }">
								| <a class="beer-link" href="/beer/${ beer.beerId }/details">${ beer.name }</a> |
							</c:forEach>
						</c:when>
					</c:choose>
				<c:forEach var="location" items="${ brewery.locations }">
					<dt>
						<c:choose>
							<c:when test="${ location.isPrimary eq 'Y'.charAt(0) }">
								Primary Location 
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${ not empty location.yearOpened }">
								Established ${ location.yearOpened }
							</c:when>
						</c:choose>
					</dt>
					<c:choose>
						<c:when test="${ location.inPlanning eq 'Y'.charAt(0) }">
						<dt>
							Coming Soon!
						</dt>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${ location.isClosed eq 'Y'.charAt(0) }">
						<dt>
							Sorry, this location is closed.
						</dt>
						</c:when>
					</c:choose>
					<dt>
						<c:choose>
							<c:when test="${ not empty location.streetAddress }">
								${ location.streetAddress }<br>
							</c:when>
						</c:choose>
						${ location.locality }, ${ location.region } ${ location.postalCode }<br>
						${ location.country.displayName }<br>
						<a href="tel:${ location.phone }">${ location.phone }</a>
					</dt>
				</c:forEach>
			</dl>
			<hr style="width:15%">	
		</c:forEach>
		<div>Return <a href="/">home</a>.</div>
	</div>
	<c:choose>
		<c:when test="${ not empty abvStats }">
			<div>
				<h3>ABV </h3>
				<c:forEach var="stat" items="${ abvStats }">
					<c:if test="${ not empty stat.value }">
						| ${ stat.key }:${ stat.value } |
					</c:if>
				</c:forEach>
			</div>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${ not empty ibuStats }">
			<div>
				<h3>IBU </h3>
				<c:forEach var="stat" items="${ ibuStats }">
					<c:if test="${ not empty stat.value }">
						| ${ stat.key }:${ stat.value } |
					</c:if>
				</c:forEach>
			</div>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${ not empty originalGravityStats }">
			<div>
				<h3>OG </h3>
				<c:forEach var="stat" items="${ originalGravityStats }">
					<c:if test="${ not empty stat.value }">
						| ${ stat.key }:${ stat.value } |
					</c:if>
				</c:forEach>
			</div>
		</c:when>
	</c:choose>
</div>
</body>
</html>