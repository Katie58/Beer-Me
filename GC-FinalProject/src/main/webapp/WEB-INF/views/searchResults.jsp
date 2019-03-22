<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../style.css">
<link rel="stylesheet" href="../../../style.css">
<title>Beer Me | ${ name }</title>
</head>
<body class="background-blank">
<div>
	<br><a href="/">home</a><br><br>
	<c:choose>
		<c:when test="${ not empty search }">
			<h1>${ search } details</h1>
			<hr style="width:50%">
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="${ not empty locations }">
			<h1>Locations</h1>
			<c:forEach var = "location" items = "${ locations }">
				<dl> 
					<dt>${ location.name }
						<c:if test = "${ not empty location.yearOpened }">
							 - Established ${ location.yearOpened }
						</c:if>
						<a href="/location/${ location.id }/add">favorite</a>
					</dt>
					<dd>
						${ location.streetAddress } 
					 	${ location.locality }, 
					 	${ location.region } 
					 	${ location.postalCode }
					 	${ location.country.displayName }
					</dd>
					<dd>
						<c:if test = "${ location.inPlanning == 89 }">
							 Coming Soon!
						</c:if>
					</dd>
					<dd>
						<c:if test = "${ location.isClosed == 89 }">
							 Sorry, this location is closed.
						</c:if>
					</dd>
					<dd>
						<c:if test = "${ location.isPrimary == 89 }">
							 Primary Location.
						</c:if>
					</dd>
					<dd>
						${ location.locationTypeDisplay }
					</dd>
					<dd>
						<c:if test = "${ location.openToPublic == 89 }">
							 Open to the public.
						</c:if>
					</dd>
				</dl>
			</c:forEach>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test = "${not empty beer}">
		<br><a href="/search/beer/${beer.beerId}/details">${beer.name}</a><br>
		<a href="/beer/${ beer.beerId }/add">favorite</a><br>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty beers }">
		<h1>Beers</h1>
		<c:forEach var = "beer" items = "${beers}">
		<br><a href="/search/beer/${beer.tableId}/details">${beer.name}</a><br>
		<a href="/beer/${ beer.beerId }/add">favorite</a><br>
		</c:forEach>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test = "${not empty brewery}">
		<c:if test = "${ not empty brewery.breweryNameShortDisplay }">
			<br>${brewery.breweryNameShortDisplay} 
		</c:if>
		<c:if test = "${ not empty brewery.established }">
			 ${ brewery.established }<br>
		</c:if>
		<c:if test = "${ not empty brewery.brandClassification }">
			<br>${ brewery.brandClassification }<br>
		</c:if>
		<c:if test = "${ not empty brewery.isOrganic  }">
			| Organic |
		</c:if>
		<c:if test = "${ not empty brewery.isMassOwned  }">
			| Mass Owned |
		</c:if>
			<c:if test = "${ not empty brewery.isInBusiness  }">
			| In Business |
		</c:if>
			<c:if test = "${ not empty brewery.isVerified  }">
			| Verified |
		</c:if>
		<c:if test = "${ not empty brewery.website  }">
			<br>${ brewery.website }<br>
		</c:if>
		<c:if test = "${ not empty brewery.description  }">
			<br>${ brewery.description }<br>
		</c:if>	
		<a href="/brewery/${ beer.breweryId }/add">favorite</a><br>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty breweries }">
		<h1>Breweries</h1>
		<c:forEach var = "brewery" items = "${breweries}">
		<br><a href="/search/brewery/${brewery.tableId}/details">${brewery.breweryName}</a><br>
		</c:forEach>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test = "${not empty adjunct}">
			<c:if test = "${ not empty adjunct.name }">
				<h1>${adjunct.name}</h1>
			</c:if>
			<c:if test = "${ not empty adjunct.category }">
				 ${ adjunct.category }<br>
			</c:if>
			<c:if test = "${ not empty adjunct.categoryDisplay }">
				 ${ adjunct.categoryDisplay }<br>
			</c:if>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty adjuncts }">
		<h1>Adjuncts</h1>
		<c:forEach var = "adjunct" items = "${adjuncts}">
		<br><a href="/search/adjunct/${adjunct.tableId}/details">${adjunct.name}</a><br>
		</c:forEach>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test = "${not empty category}">
			<c:if test = "${ not empty category.name }">
				<h1>${category.name}</h1>
			</c:if>
			<c:if test = "${ not empty category.description }">
				 ${ category.description }<br>
			</c:if>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty categories }">
		<h1>Categories</h1>
		<c:forEach var = "category" items = "${categories}">
			<c:choose>
				<c:when test="${ not empty category.description }">
					<br><a href="/search/category/${category.tableId}/details">${category.name}</a><br>
				</c:when>
				<c:otherwise>
					<br>${ category.name }<br>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test = "${not empty fermentable}">
			<c:if test = "${ not empty fermentable.name }">
				<h1>${fermentable.name}</h1>
			</c:if>
			<c:if test = "${ not empty fermentable.countryOfOrigin }">
				<br>${fermentable.countryOfOrigin} 
			</c:if>
			<c:if test = "${ not empty fermentable.srmPrecise }">
				| SRM Precise: ${fermentable.srmPrecise} |
			</c:if>
			<c:if test = "${ not empty fermentable.moistureContent }">
				| Moisture Content: ${fermentable.moistureContent} |
			</c:if>
			<c:if test = "${ not empty fermentable.dryYield }">
				| Dry Yield: ${fermentable.dryYield} |
			</c:if>
			<c:if test = "${ not empty fermentable.potential }">
				| Potential: ${fermentable.potential} |
			</c:if>
			<c:if test = "${ not empty fermentable.protein }">
				| Protein: ${fermentable.protein} |
			</c:if>
			<c:if test = "${ not empty fermentable.maxInBatch }">
				| Max In Batch: ${fermentable.maxInBatch} |
			</c:if>
			<c:if test = "${ not empty fermentable.requiresMashing }">
				| Requires Mashing: ${fermentable.requiresMashing} |
			</c:if>
			<c:if test = "${ not empty fermentable.category }">
				<h2>${ fermentable.category }</h2>
			</c:if>
			<c:if test = "${ not empty fermentable.categoryDisplay }">
				<br>${ fermentable.categoryDisplay }
			</c:if>
			<c:if test = "${ not empty fermentable.description }">
				 ${ fermentable.description }<br>
			</c:if>
			<c:if test = "${ not empty fermentable.srm }">
				 ${ fermentable.srm.name } hex: ${ fermentable.srm.hex }<br>
			</c:if>
			<c:if test = "${ not empty characteristics }">
			<br>Characteristics:
			<c:forEach var="character" items="${ characteristics }">
				<br>${ character.name }
				<br>${ character.description }<br>
			</c:forEach>
			</c:if>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty fermentables }">
		<h1>Fermentables</h1>
		<c:forEach var = "fermentable" items = "${fermentables}">
		<br><a href="/search/fermentable/${fermentable.tableId}/details">${fermentable.name}</a><br>
		</c:forEach>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test = "${not empty glass}">
			<c:if test = "${ not empty glass.name }">
				<h1>${glass.name}</h1>
				<div class="${ glass.name }"></div>
			</c:if>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty glassware }">
		<h1>Glassware</h1>
		<c:forEach var = "glass" items = "${glassware}">
		<br><a href="/search/glass/${glass.tableId}/details">${glass.name}</a><br>
		</c:forEach>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test ="${not empty guild}">
		<br><a href="/search/guild/${guild.id}/details">${guild.name}</a><br>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty guilds }">
		<h1>Guilds</h1>
		<c:forEach var = "guild" items = "${guilds}">
		<br><a href="/search/guild/${guild.tableId}/details">${guild.name}</a><br>
		</c:forEach>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test ="${not empty hop}">
		<br><a href="/search/hop/${hop.id}/details">${hop.name}</a><br>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty hops }">
		<h1>Hops</h1>
		<c:forEach var = "hop" items = "${hops}">
		<br><a href="/search/hop/${hop.tableId}/details">${hop.name}</a><br>
		</c:forEach>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test ="${not empty ingredient}">
		<br><a href="/search/ingredient/${ingredient.id}/details">${ingredient.name}</a><br>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty ingredients }">
		<h1>Ingredients</h1>
		<c:forEach var = "ingredient" items = "${ingredients}">
		<br><a href="/search/ingredient/${ingredient.tableId}/details">${ingredient.name}</a><br>
		</c:forEach>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test ="${not empty socialSite}">
		<br><a href="/search/socialSite/${socialSite.id}/details">${socialSite.name}</a><br>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty socialSites }">
		<h1>Social Sites</h1>
		<c:forEach var = "socialSite" items = "${socialSites}">
		<br><a href="/search/socialSite/${socialSite.tableId}/details">${socialSite.name}</a><br>
		</c:forEach>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test ="${not empty style}">
		<br><a href="/search/style/${style.id}/details">${style.name}</a><br>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty styles }">
		<h1>Styles</h1>
		<c:forEach var = "style" items = "${styles}">
		<br><a href="/search/style/${style.tableId}/details">${style.name}</a><br>
		</c:forEach>
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test ="${not empty yeast}">
		<br><a href="/search/yeast/${yeast.id}/details">${yeast.name}</a><br>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${not empty yeasts }">
		<h1>Yeasts</h1>
		<c:forEach var = "yeast" items = "${yeasts}">
		<br><a href="/search/yeast/${yeast.tableId}/details">${yeast.name}</a><br>
		</c:forEach>
		</c:when>
	</c:choose>

</div>
</body>
</html>