<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="../style.css">
<title>Beer Me!</title>
</head>
<body class="background-blank">
<div class="background">
	
	<div class="beer"></div>
	<div class="label">
		<img src="${ beer.labels.medium }">
	</div>
	<div class="beer-name">
		<c:if test="${ not empty message }">
			<h1>${ message }</h1>
		</c:if>
		<c:if test="${ not empty beer.name }">
			<h1>${ beer.name }</h1>
		</c:if>
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
	<div id="locations">
		<div id="currentLocation" style="display:block">
		<c:choose>
			<c:when test="${ not empty currentUserLocation }">
				${ currentUserLocation.locality } ${ currentUserLocation.region }
				<br><br>
				<button onclick="listLocationFunction()">change</button> 
				<button onclick="addLocationFunction()">add</button>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${ not empty userLocations }">
						<c:forEach var="userLocation" items="${ userLocations }">
							<c:if test="${ userLocation.main }">
								Current Location:<br>
								${ userLocation.locality } ${ userLocation.region } 
								<br><br>
								<button onclick="listLocationFunction()">change</button> 
								<button onclick="addLocationFunction()">add</button>								
							</c:if>
						</c:forEach>				
					</c:when>
					<c:otherwise>
						<form action="/location/add">
						<div class="locForm">
							<h2>Enter a Location:</h2>
							<p>City: <input type="text" name="locality"/></p>
							<p>State: <input type="text" name="region"/></p>
							<p>Zip Code: <input type="number" name="postalCode"/></p>
							<input type="boolean" name="main" value="true" style="display:none"/>
							<button type="submit">submit</button>
						</div>
						</form>	
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
		</div>
		<div id="listLocation" style="display:none">
			<c:forEach var="userLocation" items="${ userLocations }">
				<p>${ userLocation.locality } ${ userLocation.region }<br>
				<a href="/location/${ userLocation.id }/set">select</a>
				<a href="/location/${ userLocation.id }/delete">delete</a>
				<c:choose>
					<c:when test="${ userLocation.main }">
						<strong>main</strong>
					</c:when>
					<c:otherwise>
						<a href="/location/${ userLocation.id }/main">main</a>
					</c:otherwise>
				</c:choose></p>
			</c:forEach>
			<br><br>
			<button onclick="addLocationFunction()">add</button>
			<button onclick="listLocationFunction()">cancel</button>
		</div>
		<div id="addLocation" style="display:none">
			<form action="/location/add">
			<div class="locForm">
				<h2>Add a Location:</h2>
				<p>City: <input type="text" name="locality" required/></p>
				<p>State: <input type="text" name="region" required/></p>
				<p>Zip Code: <input type="number" name="postalCode"/></p>
				<p>Main Location?
				<input type="radio" name="main" value="true"/>yes
				<input type="radio" name="main" value="false"/>no</p>
				<button type="submit">submit</button>
				<button onclick="addLocationFunction()">cancel</button>
			</div>
			</form>	
		</div>
	</div>
	<div class="beerMeSelect">
	<form action="/beerme/mood">
		<select id="options" name="mood">
			<option value="hoppy">HOPPY</option>
			<option value="energetic">ENERGETIC</option>
			<option value="sunny">SUNNY</option>
			<option value="social">SOCIAL</option>
			<option value="bitter">BITTER</option>
			<option value="fruity">FRUITY</option>
			<option value="stout">STOUT</option>
		</select> 
		<button class="beerMeButton" type="submit"><img alt="BEER ME!" src="/images/button.png" width="50%"></button>
	</form>
	</div>
</div>
<script>

	currentLocation = document.getElementById("currentLocation");
	listLocation = document.getElementById("listLocation");
	addLocation = document.getElementById("addLocation");
	
	function listLocationFunction() {
		if (listLocation.style.display === "none") {
			currentLocation.style.display = "none";
			listLocation.style.display = "block";
			addLocation.style.display = "none";
		} else {
			currentLocation.style.display = "block";
			listLocation.style.display = "none";
			addLocation.style.display = "none";
		}
	}

	function addLocationFunction() {
		if (addLocation.style.display === "none") {
			currentLocation.style.display = "none";
			listLocation.style.display = "none";
			addLocation.style.display = "block";
		} else {
			currentLocation.style.display = "block";
			listLocation.style.display = "none";
			addLocation.style.display = "none";
		}
	}
	
</script>
</body>
</html>