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
<div class="search">
<br><a href="/">home</a><br><br>
	<div>
		<button onclick="resetFunction()">start over</button>
	</div>
	<br>
	<div id="enterStyleButton" style="display:block">
		<button onclick="searchStyleFunction()">get beer by style</button>
	</div>
	<div id="enterStyle" style="display:none">
		<form action="/search/style">
			<div>style:<input name="styleSearch"></div>
			<button type="submit">submit</button>
		</form>
	</div>
	<div id="enterUPCButton" style="display:block">
		<button onclick="searchUPCFunction()">get beer by UPC</button>
	</div>
	<div id="enterUPC" style="display:none">
		<form action="/search/beer/upc">
			<div>upc:<input name="code"></div>
			<button type="submit">submit</button>
		</form>
	</div>
	<div id="enterGEOButton" style="display:block">
		<button onclick="searchGEOFunction()">get beer by GEO</button>
	</div>
	<div id="enterGEO" style="display:none">
		<form action="/search/GEO">
			<h3>GEOPOINT</h3>
			<div>lattitude:<input type="number" step="0.000001" name="lat" required></div>
			<div>longitude:<input type="number" step="0.000001" name="lng" required></div>
			<div>radius:<input type="number" step="0.1" name="radius" value="10"></div>
			<div>unit:<input type="radio" name="unit" value="mi" checked>miles</div>
			<div><input type="radio" name="unit" value="km">kilometers</div>
			<p>With Social Accounts: <input type="radio" name="withSocialAccounts" value="Y">yes<input type="radio" name="withSocialAccounts" value="N" checked>no</p>
			<p>With Guilds: <input type="radio" name="withGuilds" value="Y">yes<input type="radio" name="withGuilds" value="N" checked>no</p>
			<p>With Alternate Names: <input type="radio" name="withAlternateNames" value="Y">yes<input type="radio" name="withAlternateNames" value="N" checked>no</p>
			<button type="submit">submit</button>
		</form>
	</div>
	<div id="randomBeerButton" style="display:block">
		<button onclick="randomBeerFunction()">random beer</button>
	</div>
	<div id="randomBeer" style="display:none">
		<p><h2>OPTIONAL:</h2></p>
		<form action="/random/beer">
			<p>ABV(alcohol 3-13% avg): <input type="number" name="abv" min="1" max="100"></p>
			<p>IBU(bitterness): <input type="number" name="ibu" min="1" max="100"></p>
			<p>Glassware id: <input type="number" name="glasswareId"></p>
			<p>Srm(color) id: <input type="number" name="srmId"></p>
			<p>Availability id: <input type="number" name="availableId"></p>
			<p>Style id: <input type="number" name="styleId"></p>
			<p>Is Organic: <input type="radio" name="isOrganic" value="Y">yes<input type="radio" name="isOrganic" value="N" checked>no</p>
			<p>Has Labels: <input type="radio" name="hasLabels" value="Y">yes<input type="radio" name="hasLabels" value="N" checked>no</p>
			<p>Year: <input type="number" name="year" pattern="[1-9]{4}"></p>
			<p>With Breweries: <input type="radio" name="withBreweries" value="Y">yes<input type="radio" name="withBreweries" value="N" checked>no</p>
			<p>With Social Accounts: <input type="radio" name="withSocialAccounts" value="Y">yes<input type="radio" name="withSocialAccounts" value="N" checked>no</p>
			<p>With Ingredients: <input type="radio" name="withIngredients" value="Y">yes<input type="radio" name="withIngredients" value="N" checked>no</p>
			<button type="submit">Random Beer</button>
		</form>
	</div>
	<div id="randomBreweryButton" style="display:block">
		<button onclick="randomBreweryFunction()">random brewery</button>
	</div>
	<div id="randomBrewery" style="display:none">
		<p><h2>OPTIONAL:</h2></p>
		<form action="/random/brewery">
			<p>Established: <input type="number" name="established" pattern="[1-9]{4}"></p>
			<p>Is Organic: <input type="radio" name="isOrganic" value="Y">yes<input type="radio" name="isOrganic" value="N" checked>no</p>
			<p>With Social Accounts: <input type="radio" name="withSocialAccounts" value="Y">yes<input type="radio" name="withSocialAccounts" value="N" checked>no</p>
			<p>With Guilds: <input type="radio" name="withGuilds" value="Y">yes<input type="radio" name="withGuilds" value="N" checked>no</p>
			<p>With Locations: <input type="radio" name="withLocations" value="Y">yes<input type="radio" name="withLocations" value="N" checked>no</p>
			<p>With Alternate Names: <input type="radio" name="withAlternateNames" value="Y">yes<input type="radio" name="withAlternateNames" value="N" checked>no</p>
			<button type="submit">Random Brewery</button>
		</form>
	</div>
</div>

<!-- ******************* search for ***************** -->
<!-- div class="searchFor"> 
	<div id="searchForButton" style="display:block">
		<button onclick="searchForFunction()">Search for</button>
	</div>
	<div id="searchFor" style="display:none">
		<p>Search for:</p>
		
		<!-- -------- beer --------- -->
		<!-- div id="beer" style="display:none">
		<by-upc><by-style><by-breweryId><by-beerId>
			<button onclick="beerFunction()">Beer</button>
		</by-beerId></by-breweryId></by-beerStyle></by-upc>
		</div>
		
		<!-- -------- brewery --------- -->
		<!-- div id="searchBreweriesButton" style="display:block">
		<!-- by-locations><by-beerId><by-breweryId -->
			<!--button onclick="breweryFunction()">Brewery</button>

		</div>
		<!-- div id="searchBreweries" style="display:none">
			<p><h2>OPTIONAL:</h2></p>
			<form action="/searchBreweries">
				<p>Page: <input type="number" name="p"></p>
				<p>Name: <input name="name"></p>
				<p>Ids (max 10): <input name="ids"></p>
				<p>Established: <input type="number" name="established"></p>
				<p>Is Organic: <input type="radio" name="isOrganic" value="Y">yes<input type="radio" name="isOrganic" value="N" checked>no</p>
				<p>Has Images: <input type="radio" name="hasImages" value="Y">yes<input type="radio" name="hasImages" value="N" checked>no</p>
				<p>Since (updates since - max 30 days): <input type="number" name="since"></p>
				<p>Status: <input type="number" name="status"></p>
				<p>Order: <input name="order"></p>
				<select>
  					<option name="sort" value="ASC">Ascending</option>
  					<option name="sort" value="DESC">Descending</option>
  				</select>
  				<p>Random Count (sort "random", max 10): <input type="number" name="randomCount"></p>
				<p>With Social Accounts: <input type="radio" name="withSocialAccounts" value="Y">yes<input type="radio" name="withSocialAccounts" value="N" checked>no</p>
				<p>With Guilds: <input type="radio" name="withGuilds" value="Y">yes<input type="radio" name="withGuilds" value="N" checked>no</p>
				<p>With Locations: <input type="radio" name="withLocations" value="Y">yes<input type="radio" name="withLocations" value="N" checked>no</p>
				<p>With Alternate Names: <input type="radio" name="withAlternateNames" value="Y">yes<input type="radio" name="withAlternateNames" value="N" checked>no</p>
				<button type="submit">Random Brewery</button>
			</form>
		</div>
		
		<!-- ============== other ============== -->
		<!-- -------- adjunct --------- -->
		<!-- div id="adjunctButton" style="display:block">
		<by-beerId><by-adjunctId><by-all>
			<button onclick="adjunctFunction()">Adjunct</button>
		<by-all></by-adjunctId><by-beerId>
		</div>
		
		<!-- -------- event --------- -->
		<!-- div id="eventButton" style="display:block">
		<by-beerId>
			<button onclick="eventFunction()">Event</button>
		</by-beerId>
		</div>
				
		<!-- -------- fermentable --------- -->
		<!-- div id="fermentableButton" style="display:block">
		<by-fermentableId><by-beerId>
			<button onclick="fermentableFunction()">Fermentable</button>
		</by-beerId></by-fermentableId>
		</div>
		
		<!-- -------- hop --------- -->
		<!-- div id="hopButton" style="display:block">
		<by-hopId><by-beerId>
			<button onclick="hopFunction()">Hop</button>
		</by-beerId><by-hopId>
		</div>
		
		<!-- -------- ingredient --------- -->
		<!-- div id="ingredientButton" style="display:block">
		<by-ingredientId></by-beerId>
			<button onclick="ingredientFunction()">Ingredient</button>
		</by-beerId></by-ingredientId>
		</div>
		
		<!-- -------- variation --------- -->
		<!-- div id="variationButton" style="display:block">
		<by-beerId>
			<button onclick="variationFunction()">Variation</button>
		</by-beerId>
		</div>
		
		<!-- -------- yeast --------- -->
		<!--div id="yeastButton" style="display:block">
		<by-yeastId><by-beerId>
			<button onclick="yeastFunction()">Yeast</button>
		</by-beerId></by-yeastId>
		</div>
		
		<!-- -------- brewery alternate names --------- -->
		<!--div id="altNameButton" style="display:block">
		<by-breweryId>
			<button onclick="altNameFunction()">Brewery Alternate Name</button>
		</by-breweryId>
		</div>
		
		<!-- -------- guilds --------- -->
		<!--div id="guildButton" style="display:block">
		<by-guildId><by-breweryId>
			<button onclick="guildFunction()">Guild</button>
		</by-breweryId></by-guildId>
		</div>
		
		<!-- -------- brewery locations --------- -->
		<!--div id="locationsButton" style="display:block">
		<by-breweryId>
			<button onclick="locationsFunction()">Locations</button>
		</by-breweryId>
		</div>
		
		<!-- -------- social account --------- -->
		<!--div id="brewerySocialButton" style="display:block">
		<by-socialId><by-breweryId><by-beerId>
			<button onclick="socialFunction()">Brewery Social Account</button>
		</by-beerId></by-breweryId></by-socialId>
		</div>
		
		<!-- -------- category --------- -->
		<!--div id="categoryButton" style="display:block">
		<by-categoryId>
			<button onclick="categoryFunction()">Category</button>
		</by-categoryId>
		</div>
		
		<!-- -------- fluid size --------- -->
		<!--div id="fluidSizeButton" style="display:block">
		<by-fluidSizeId>
			<button onclick="fluidSizeFunction()">Fluid Size</button>
		</by-fluidSizeId>
		</div>
		
		<!-- -------- glassware --------- -->
		<!--div id="glasswareButton" style="display:block">
		<by-glasswareId>
			<button onclick="glasswareFunction()">Glassware</button>
		</by-glasswareId>
		</div>
		
		<!-- -------- style --------- -->
		<!--div id="styleButton" style="display:block">
		<by-styleId>
			<button onclick="styleFunction()">Style</button>
		</by-styleId>
		</div>
		
	</div>
</div>
<!-- ******************* search by ***************** -->
<!--div class="searchBy">
	<div id="searchByButton" style="display:block">
		<button onclick="searchByFunction()">Search by</button>
	</div>
	<div id="searchBy" style="display:none">
		<p>Search by:</p>
		
		<!-- -------- all --------- -->
		<!--for-adjunct><for-upc><for-brewery><for-beer>
			<button onclick="allButtonFunction()" id="all">GET ALL</button>
		</for-beer></for-brewery></for-upc></for-adjunct>
		
		<!-- -------- beer id --------- -->
		<!--for-adjunct><for-brewery><for-beer>
			<button onclick="beerIdButtonFunction()" id="beerId">Beer Id</button>
		</for-beer></for-brewery></for-adjunct>
		
		<!-- -------- brewery id --------- -->
		<!--div id="breweryIdButton" style="display:block">
		<for-brewery>
			<button onclick="breweryIdFunction()">Brewery Id</button>
		</for-brewery>
		</div>
		<div id="breweryId" style="display:none">
			<form action="/searchBy">
				<input name="breweryId">
			<button type="submit">beer me</button>
			</form>
		</div>
		
		<!-- -------- location --------- -->
		<!--div id="locationButton" style="display:block">
		<for-brewery>
			<button onclick="locationFunction()">Location</button>
		</for-brewery>
		</div>
		<div id="location" style="display:none">
			<form action="/locationResults">
				<h2>Search by location only</h2>
				<p>City: <input type="text" name="locality"/></p>
				<p>State: <input type="text" name="region"/></p>
				<p>Zip Code: <input type="number" name="postalCode"/></p>
				<button type="submit">submit</button>
			</form>
		</div>
		
		<!-- ============== other ============== -->
		<!-- -------- adjunct id --------- -->
		<!--div id="adjunctId" style="display:block">
		<for-adjunct>
		<button onclick="adjunctIdFunction()">Adjunct Id</button>
		</for-adjunct>
		</div>
		<div id="adjunct" style="display:none">
			<p>Adjunct: <input type="text" name="adjunct"/></p>
		</div>
		
		<!-- -------- category id --------- -->
		<!--div id="categoryId" style="display:block">
		<for-category>
			<button onclick="categoryIdFunction()">Category Id</button>
		</for-category>
		</div>
		<div id="category" style="display:none">
			<p>Category: <input type="text" name="category"/></p>
		</div>
		
		<!-- -------- fermentable id --------- -->
		<!--div id="fermentableId" style="display:block">
		<for-fermentable>
			<button onclick="fermentableIdFunction()">Fermentable Id</button>
		</for-fermentable>
		</div>
		<div id="fermentable" style="display:none">
			<p>Fermentable: <input type="text" name="fermentable"/></p>
		</div>
		
		<!-- -------- fluid size id --------- -->
		<!--div id="fluidSizeId" style="display:block">
		<for-fluidSize>
			<button onclick="fluidSizeIdFunction()">Fluid Size Id</button>
		</for-fluidSize>
		</div>
		<div id="fluidSize" style="display:none">
			<p>Fluid Size: <input type="text" name="fluidSize"/></p>
		</div>
		
		<!-- -------- glassware id --------- -->
		<!--div id="glasswareId" style="display:block">
		<for-glassware>
			<button onclick="glasswareIdFunction()">Glassware Id</button>
		</for-glassware>
		</div>
		<div id="glassware" style="display:none">
			<p>Glassware: <input type="text" name="glassware"/></p>
		</div>
		
		<!-- -------- guild id --------- -->
		<!--div id="guildId" style="display:block">
		<for-guild>
			<button onclick="guildIdFunction()">Guild Id</button>
		</for-guild>
		</div>
		<div id="guild" style="display:none">
			<p>Guild: <input type="text" name="guild"/></p>
		</div>
		
		<!-- -------- hop id --------- -->
		<!--div id="hopId" style="display:block">
		<for-hop>
			<button onclick="hopIdFunction()">Hop Id</button>
		</for-hop>
		</div>
		<div id="hop" style="display:none">
			<p>Hop: <input type="text" name="hop"/></p>
		</div>
		
		<!-- -------- ingredient id --------- -->
		<!--div id="ingredientId" style="display:block">
		<for-ingredient>
			<button onclick="ingredientIdFunction()">Ingredient Id</button>
		</for-ingredient>
		</div>
		<div id="ingredient" style="display:none">
			<p>Ingredient: <input type="text" name="ingredient"/></p>
		</div>
		
		<!-- -------- social site id --------- -->
		<!--div id="socialSiteId" style="display:block">
		<for-socialSite>
			<button onclick="socialSiteIdFunction()">Social Site Id</button>
		</for-socialSite>
		</div>
		<div id="socialSite" style="display:none">
			<p>Social Site: <input type="text" name="socialSite"/></p>
		</div>
		
		<!-- -------- style id --------- -->
		<!--div id="styleId" style="display:block">
		<for-beerStyle>
			<button onclick="beerStyleIdFunction()">Style Id</button>
		</for-beerStyle>
		</div>
		<div id="style" style="display:none">
			<p>Style: <input type="text" name="style"/></p>
		</div>
		
		<!-- -------- yeast id --------- -->
		<!--div id="yeastId" style="display:block">
		<for-yeast>
			<button onclick="yeastIdFunction()">Yeast Id</button>
		</for-yeast>
		</div>
		<div id="yeast" style="display:none">
			<p>Yeast: <input type="text" name="yeast"/></p>
		</div>
		
	</div>
</div>

<!-- ******************** input form ******************** -->

	<div id="inputForm" style="display:none">
		<form action="/searchResults">
			<button>search</button>
		</form>
	</div>
</div>

<!-- ******************** javascript ****************** -->
<script>


var enterStyleButton = document.getElementById("enterStyleButton");
var enterUPCButton = document.getElementById("enterUPCButton");
var enterGEOButton = document.getElementById("enterGEOButton");

var enterStyle = document.getElementById("enterStyle");
var enterUPC = document.getElementById("enterUPC");
var enterGEO = document.getElementById("enterGEO");

var randomBreweryButton = document.getElementById("randomBreweryButton");
var randomBeerButton = document.getElementById("randomBeerButton");
var searchForButton = document.getElementById("searchForButton");
var searchByButton = document.getElementById("searchByButton");

var randomBrewery = document.getElementById("randomBrewery");
var randomBeer = document.getElementById("randomBeer");
var searchFor = document.getElementById("searchFor");
var searchBy = document.getElementById("searchBy");

<!-- -------- search Style button --------- -->
function searchStyleFunction() {
		if (enterStyleButton.style.display === "block") {
		enterStyleButton.style.display = "none";
		enterUPCButton.style.display = "none";
		enterGEOButton.style.display = "none";
		enterStyle.style.display = "block";
		randomBreweryButton.style.display = "none";
		randomBeerButton.style.display = "none";
		searchForButton.style.display = "none";
		searchByButton.style.display = "none";
	}
}
<!-- -------- search UPC button --------- -->
function searchUPCFunction() {
	if (enterUPCButton.style.display === "block") {
		enterStyleButton.style.display = "none";
		enterUPCButton.style.display = "none";
		enterGEOButton.style.display = "none";
		enterUPC.style.display = "block";
		randomBreweryButton.style.display = "none";
		randomBeerButton.style.display = "none";
		searchForButton.style.display = "none";
		searchByButton.style.display = "none";
	}
}
<!-- -------- search GEO button --------- -->
function searchGEOFunction() {
	if (enterGEOButton.style.display === "block") {
		enterStyleButton.style.display = "none";
		enterUPCButton.style.display = "none";
		enterGEOButton.style.display = "none";
		enterGEO.style.display = "block";
		randomBreweryButton.style.display = "none";
		randomBeerButton.style.display = "none";
		searchForButton.style.display = "none";
		searchByButton.style.display = "none";
	}
}
<!-- -------- random beer button --------- -->
function randomBeerFunction() {
		if (randomBeerButton.style.display === "block") {
		enterStyleButton.style.display = "none";
		enterUPCButton.style.display = "none";
		enterGEOButton.style.display = "none";
		randomBreweryButton.style.display = "none";
		randomBeerButton.style.display = "none";
		randomBrewery.style.display = "none";
		randomBeer.style.display = "block";
		searchForButton.style.display = "none";
		searchByButton.style.display = "none";
	}
}
<!-- -------- random brewery button --------- -->
function randomBreweryFunction() {
	if (randomBreweryButton.style.display === "block") {
		enterStyleButton.style.display = "none";
		enterUPCButton.style.display = "none";
		enterGEOButton.style.display = "none";
		enterStyle.style.display = "none";
		enterUPC.style.display = "none";
		enterGEO.style.display = "none";
		randomBreweryButton.style.display = "none";
		randomBeerButton.style.display = "none";
		randomBrewery.style.display = "block";
		randomBeer.style.display = "none";
		searchForButton.style.display = "none";
		searchByButton.style.display = "none";
		searchFor.style.display = "none";
		searchBy.style.display = "none";
	}		
}
<!-- -------- reset button --------- -->
function resetFunction() {
	enterStyleButton.style.display = "block";
	enterUPCButton.style.display = "block";
	enterGEOButton.style.display = "block";
	enterStyle.style.display = "none";
	enterUPC.style.display = "none";
	enterGEO.style.display = "none";
	randomBreweryButton.style.display = "block";
	randomBeerButton.style.display = "block";
	randomBrewery.style.display = "none";
	randomBeer.style.display = "none";
	searchForButton.style.display = "block";
	searchByButton.style.display = "block";
	searchFor.style.display = "none";
	searchBy.style.display = "none";
}

<!-- -------- search for/by --------- -->
function searchForFunction() {
	if (searchForButton.style.display === "block") {
		enterStyleButton.style.display = "none";
		enterUPCButton.style.display = "none";
		enterGEOButton.style.display = "none";
		enterStyle.style.display = "none";
		enterUPC.style.display = "none";
		enterGEO.style.display = "none";
		randomBreweryButton.style.display = "none";
		randomBeerButton.style.display = "none";
		randomBrewery.style.display = "none";
		randomBeer.style.display = "none";
		searchForButton.style.display = "none";
		searchByButton.style.display = "none";
		searchFor.style.display = "block";
		searchBy.style.display = "none";
	}
}

function searchByFunction() {
	if (searchByButton.style.display === "block") {
		enterStyleButton.style.display = "none";
		enterUPCButton.style.display = "none";
		enterGEOButton.style.display = "none";
		enterStyle.style.display = "none";
		enterUPC.style.display = "none";
		enterGEO.style.display = "none";
		randomBreweryButton.style.display = "none";
		randomBeerButton.style.display = "none";
		randomBrewery.style.display = "none";
		randomBeer.style.display = "none";
		searchForButton.style.display = "none";
		searchByButton.style.display = "none";
		searchFor.style.display = "none";
		searchBy.style.display = "block";
	}
}
	
</script>

</body>
</html>