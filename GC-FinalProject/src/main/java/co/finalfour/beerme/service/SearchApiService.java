package co.finalfour.beerme.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import co.finalfour.beerme.entity.apigeneral.SocialSite;
import co.finalfour.beerme.entity.beer.Adjunct;
import co.finalfour.beerme.entity.beer.Beer;
import co.finalfour.beerme.entity.beer.Category;
import co.finalfour.beerme.entity.beer.Fermentable;
import co.finalfour.beerme.entity.beer.FluidSize;
import co.finalfour.beerme.entity.beer.Glass;
import co.finalfour.beerme.entity.beer.Hop;
import co.finalfour.beerme.entity.beer.Ingredient;
import co.finalfour.beerme.entity.beer.Style;
import co.finalfour.beerme.entity.beer.Yeast;
import co.finalfour.beerme.entity.location.AlternateName;
import co.finalfour.beerme.entity.location.Brewery;
import co.finalfour.beerme.entity.location.Guild;
import co.finalfour.beerme.entity.location.Location;
import co.finalfour.beerme.entity.response.AdjunctResponse;
import co.finalfour.beerme.entity.response.AdjunctSingleResponse;
import co.finalfour.beerme.entity.response.BeerResponse;
import co.finalfour.beerme.entity.response.BeerSingleResponse;
import co.finalfour.beerme.entity.response.BreweryResponse;
import co.finalfour.beerme.entity.response.BrewerySingleResponse;
import co.finalfour.beerme.entity.response.CategoryResponse;
import co.finalfour.beerme.entity.response.CategorySingleResponse;
import co.finalfour.beerme.entity.response.FermentableResponse;
import co.finalfour.beerme.entity.response.FermentableSingleResponse;
import co.finalfour.beerme.entity.response.FluidSizeResponse;
import co.finalfour.beerme.entity.response.FluidSizeSingleResponse;
import co.finalfour.beerme.entity.response.GlassResponse;
import co.finalfour.beerme.entity.response.GlassSingleResponse;
import co.finalfour.beerme.entity.response.GuildResponse;
import co.finalfour.beerme.entity.response.GuildSingleResponse;
import co.finalfour.beerme.entity.response.HopResponse;
import co.finalfour.beerme.entity.response.HopSingleResponse;
import co.finalfour.beerme.entity.response.IngredientResponse;
import co.finalfour.beerme.entity.response.IngredientSingleResponse;
import co.finalfour.beerme.entity.response.LocationResponse;
import co.finalfour.beerme.entity.response.LocationSingleResponse;
import co.finalfour.beerme.entity.response.SocialSiteResponse;
import co.finalfour.beerme.entity.response.SocialSiteSingleResponse;
import co.finalfour.beerme.entity.response.StyleResponse;
import co.finalfour.beerme.entity.response.StyleSingleResponse;
import co.finalfour.beerme.entity.response.YeastResponse;
import co.finalfour.beerme.entity.response.YeastSingleResponse;

@Component
public class SearchApiService {

	@Value("${freebeer.key}")
	private String freeKey;
	
	@Value("${paidbeer.key}")
	private String paidKey;

	private RestTemplate restTemplate = new RestTemplate();

////////////////////// get beer /////////////////////
	
	//-------------- list of beers ---------------//
	
	public List<Beer> findAllBeers() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beers/")
				.queryParam("key", freeKey)
				.toUriString();
		BeerResponse response = restTemplate.getForObject(url, BeerResponse.class);		
		System.out.println("findAllBeers URL: " + url);
		return response.getData();
	}
	
	//*****PAIDKEY
	public List<Beer> findBeersByBreweryId(String beerId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/brewery/" + beerId + "/beers/")
				.queryParam("key", paidKey)
				.toUriString();
		BeerResponse response = restTemplate.getForObject(url, BeerResponse.class);		
		System.out.println("findBeersByBreweryId URL: " + url);
		return response.getData();
	}
	
	public List<Beer> findBeersByStyleId(Long styleId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beers/")
				.queryParam("styleId", styleId)
				.queryParam("key", freeKey)
				.toUriString();
		BeerResponse response = restTemplate.getForObject(url, BeerResponse.class);		
		System.out.println("findBeersByStyleId URL: " + url);
		return response.getData();			
	}
	
	//*****PAIDKEY
	public List<Beer> findVariationsByBeerId(String beerId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/" + beerId + "/variations")
				.queryParam("key", paidKey)
				.toUriString();
		BeerResponse response = restTemplate.getForObject(url, BeerResponse.class);		
		System.out.println("findVariationsByBeerId URL: " + url);
		return response.getData();
	}
	
	//--------------- single beer ----------------//
	
	public Beer findBeerById(String beerId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/" + beerId + "/")
				.queryParam("key", freeKey)
				.toUriString();
		BeerSingleResponse response = restTemplate.getForObject(url, BeerSingleResponse.class);	
		System.out.println("findBeerById URL: " + url);
		return response.getData();		
	}
	
	public Beer randomBeer(Beer beer) {
		System.out.println("GETTING RANDOM BEER");
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/random/")
				.queryParam("abv", beer.getAbv())
				.queryParam("ibu", beer.getIbu())
				.queryParam("glasswareId", beer.getGlasswareId())
				.queryParam("srmId", beer.getSrmId())
				.queryParam("availableId", beer.getAvailableId())
				.queryParam("styleId", beer.getStyleId())
				.queryParam("isOrganic", beer.getIsOrganic())
				.queryParam("hasLabels", beer.getHasLabels())
				.queryParam("year", beer.getYear())
				.queryParam("withBreweries", beer.getWithBreweries())
				.queryParam("withSocialAccounts", beer.getWithSocialAccounts())
				.queryParam("withIngredients", beer.getWithIngredients())
				.queryParam("key", freeKey)
				.toUriString();
		BeerSingleResponse response = restTemplate.getForObject(url, BeerSingleResponse.class);		
		System.out.println("randomBeer URL: " + url);
		return response.getData();			
	}
	
	//*****PAIDKEY
	public List<Beer> findBeerByUPC(Long code) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/search/upc/")
				.queryParam("code", code)
				.queryParam("key", paidKey)
				.toUriString();
		BeerResponse response = restTemplate.getForObject(url, BeerResponse.class);	
		System.out.println("findBeerByUPC: " + url);
		return response.getData();		
	}
	
//////////////////// get brewery ////////////////////
	
	//------------ list of breweries -----------//

	public List<Brewery> findAllBreweries() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/breweries/")
				.queryParam("key", freeKey)
				.toUriString();
		BreweryResponse response = restTemplate.getForObject(url, BreweryResponse.class);		
		System.out.println("findAllBreweries: " + url);
		return sortBreweries(response);
	}
	
	public List<Brewery> findBreweriesByBeerId(String breweryId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/" + breweryId + "/breweries/")
				.queryParam("key", freeKey)
				.toUriString();
		BreweryResponse response = restTemplate.getForObject(url, BreweryResponse.class);		
		System.out.println("findBreweriesByBeerId: " + url);
		return sortBreweries(response);
	}
	
	public List<Brewery> findBreweriesByParams(	
			Integer p, 
			String name, 
			String ids,
			Integer established,
			char isOrganic,
			char hasImages,
			String since,
			String status,
			String order,
			String sort,
			Integer randomCount,
			char withSocialAccounts,
			char withGuilds,	
			char withLocations,	
			char withAlternateNames) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/breweries/")
				.queryParam("p", p)
				.queryParam("name", name)
				.queryParam("ids", ids)
				.queryParam("established", established)
				.queryParam("isOrganic", isOrganic)
				.queryParam("hasImages", hasImages)
				.queryParam("since", since)
				.queryParam("status", status)
				.queryParam("order", order)
				.queryParam("sort", sort)
				.queryParam("randomCount", randomCount)
				.queryParam("withSocialAccounts", withSocialAccounts)
				.queryParam("withGuilds", withGuilds)
				.queryParam("withLocations", withLocations)
				.queryParam("withAlternateNames", withAlternateNames)
				.queryParam("key", freeKey)
				.toUriString();
		BreweryResponse response = restTemplate.getForObject(url, BreweryResponse.class);		
		System.out.println("findBreweriesByParams: " + url);
		return sortBreweries(response);	
	}
		
	//------------- single brewery -------------//
	//************************************************************change back to free
	public Brewery findBreweryById(String breweryId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/brewery/" + breweryId + "/")
				.queryParam("key", paidKey)
				.toUriString();
		BrewerySingleResponse response = restTemplate.getForObject(url, BrewerySingleResponse.class);		
		System.out.println("findBreweryById: " + url);
		return response.getData();		
	}
	
	public Brewery randomBrewery(Brewery brewery) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/brewery/random/")
				.queryParam("established", brewery.getBreweryEstablished())
				.queryParam("isOrganic", brewery.getBreweryIsOrganic())
				.queryParam("withSocialAccounts", brewery.getWithSocialAccounts())
				.queryParam("withGuilds", brewery.getWithGuilds())
				.queryParam("withAlternateNames", brewery.getWithAlternateNames())
				.queryParam("key", freeKey)
				.toUriString();
		BrewerySingleResponse response = restTemplate.getForObject(url, BrewerySingleResponse.class);		
		System.out.println("randomBrewery: " + url);
		return response.getData();			
	}
	
	public List<String> findBreweryAltNameById(String breweryId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/brewery/" + breweryId + "/alternatenames/")
				.queryParam("key", freeKey)
				.toUriString();
		BreweryResponse response = restTemplate.getForObject(url, BreweryResponse.class);	
		System.out.println("findBreweryAltNameById: " + url);
		List<Brewery> breweries = response.getData();
		List<String> names = new ArrayList<>();
		if (!breweries.isEmpty()) {
			for (Brewery brewery : breweries) {
				for (AlternateName name : brewery.getAlternateNames()) {
					names.add(name.getAltName());
				}
			}	
		}
		return names;		
	}
	
	//------------- locations -------------//
	//**********************************************************change back to free
	public Location findLocationById(String locationId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/location/" + locationId + "/")
				.queryParam("key", paidKey)
				.toUriString();
		LocationSingleResponse response = restTemplate.getForObject(url, LocationSingleResponse.class);		
		System.out.println("findLocationById: " + url);
		return response.getData();		
	}
	
	//*****PAIDKEY
	public List<Location> findLocationsByGeo(Double lat, Double lng, Double radius,
			String unit, Character withSocialAccounts, Character withGuilds, Character withAlternateNames) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/search/geo/point/")
				.queryParam("lat", lat)
				.queryParam("lng", lng)
				.queryParam("radius", radius)
				.queryParam("unit", unit)
				.queryParam("withSocialAccounts", withSocialAccounts)
				.queryParam("withGuilds", withGuilds)
				.queryParam("withAlternateNames", withAlternateNames)
				.queryParam("key", paidKey)
				.toUriString();
		System.out.println("GEO URL: " + url);
		LocationResponse response = restTemplate.getForObject(url, LocationResponse.class);		
		System.out.println("findLocationsByGeo: " + url);
		return sortLocations(response);
	}
	
	public List<Location> findLocationsByParams(
			Integer p,
			String ids,
			String locality,
			String region,
			Integer postalCode,
			char isPrimary,
			char inPlanning,
			char isClosed,
			String locationType,
			String countryIsoCode,
			String since,
			String status,
			String order,
			String sort) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/locations/")
				.queryParam("p", p)
				.queryParam("ids", ids)
				.queryParam("locality", locality)
				.queryParam("region", region)
				.queryParam("postalCode", postalCode)
				.queryParam("isPrimary", isPrimary)
				.queryParam("inPlanning", inPlanning)
				.queryParam("isClosed", isClosed)
				.queryParam("locationType", locationType)
				.queryParam("countryIsoCode", countryIsoCode)
				.queryParam("since", since)
				.queryParam("status", status)
				.queryParam("order", order)
				.queryParam("sort", sort)
				.queryParam("key", freeKey)
				.toUriString();
		LocationResponse response = restTemplate.getForObject(url, LocationResponse.class);		
		System.out.println("findLocationsByParams: " + url);
		return sortLocations(response);
	}
	
	//*****PAIDKEY - optional
	public List<Location> findLocationsByBasicSearch(
			String locality,
			String region,
			String postalCode) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/locations/")
				.queryParam("locality", locality)
				.queryParam("region", region)
				.queryParam("postalCode", postalCode)
				.queryParam("key", freeKey)
				.toUriString();
		LocationResponse response = restTemplate.getForObject(url, LocationResponse.class);	
		if (response == null) {
			url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/locations/")
					.queryParam("region", region)
					.queryParam("key", freeKey)
					.toUriString();
			response = restTemplate.getForObject(url, LocationResponse.class);
		}
		System.out.println("findLocationsByBasicSearch: " + url);
		return sortLocations(response);
	}
	
	public List<Location> findLocationsByBasicSearchFree(
			String locality,
			String region,
			String postalCode) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/locations/")
				.queryParam("region", region)
				.queryParam("key", freeKey)
				.toUriString();
		LocationResponse response = restTemplate.getForObject(url, LocationResponse.class);	
		return sortLocations(response);
	}
		
	///////////////// get other ///////////////////
	
	//------------ adjunct -------------//
	public Adjunct findAdjunctById(Long adjunctId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/adjunct/" + adjunctId + "/")
				.queryParam("key", freeKey)
				.toUriString();
		AdjunctSingleResponse response = restTemplate.getForObject(url, AdjunctSingleResponse.class);		
		System.out.println("findAdjunctById: " + url);
		return response.getData();		
	}
	
	public List<Adjunct> findAllAdjuncts() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/adjuncts/")
				.queryParam("key", freeKey)
				.toUriString();
		AdjunctResponse response = restTemplate.getForObject(url, AdjunctResponse.class);		
		System.out.println("findAllAdjuncts: " + url);
		return response.getData();
	}
	
	public List<Adjunct> findAdjunctsByBeerId(String beerId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/" + beerId + "/adjuncts")
				.queryParam("key", freeKey)
				.toUriString();
		AdjunctResponse response = restTemplate.getForObject(url, AdjunctResponse.class);		
		System.out.println("findAdjunctsByBeerId: " + url);
		return response.getData();
	}
	
	//-------------- style ---------------//
	public Style findStyleById(Long styleId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/style/" + styleId + "/")
				.queryParam("key", freeKey)
				.toUriString();
		StyleSingleResponse response = restTemplate.getForObject(url, StyleSingleResponse.class);		
		System.out.println("findStyleById: " + url);
		return response.getData();		
	}
	
	public List<Style> findStylesByQuery(String styleSearch) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/search/style/")
				.queryParam("q", styleSearch)
				.queryParam("key", freeKey)
				.toUriString();
		StyleResponse response = restTemplate.getForObject(url, StyleResponse.class);	
		System.out.println("findStylesByQuery URL: " + url);
		System.out.println("RESPONSE: " + response);
		return response.getData();	
	}
	
	public Style findStyleByBeerId(String beerId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/" + beerId + "/")
				.queryParam("key", freeKey)
				.toUriString();
		BeerSingleResponse response = restTemplate.getForObject(url, BeerSingleResponse.class);	
		System.out.println("findStyleByBeerId: " + url);
		return response.getData().getStyle();
	}
	
	//-------------- hop ---------------//
	public Hop findHopById(Long hopId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/hop/" + hopId + "/")
				.queryParam("key", freeKey)
				.toUriString();
		HopSingleResponse response = restTemplate.getForObject(url, HopSingleResponse.class);		
		System.out.println("findHopById: " + url);
		return response.getData();		
	}

	public List<Hop> findAllHops() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/hops/")
				.queryParam("key", freeKey)
				.toUriString();
		HopResponse response = restTemplate.getForObject(url, HopResponse.class);		
		System.out.println("findAllHops: " + url);
		return response.getData();
	}
	
	public List<Hop> findHopsByBeerId(String beerId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/" + beerId + "/hops")
				.queryParam("key", freeKey)
				.toUriString();
		HopResponse response = restTemplate.getForObject(url, HopResponse.class);		
		System.out.println("findHopsByBeerId: " + url);
		return response.getData();
	}
	
	//-------------- fermentable ---------------//
	public Fermentable findFermentableById(Long fermentableId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/fermentable/" + fermentableId + "/")
				.queryParam("key", freeKey)
				.toUriString();
		FermentableSingleResponse response = restTemplate.getForObject(url, FermentableSingleResponse.class);		
		System.out.println("findFermentableById: " + url);
		return response.getData();		
	}

	public List<Fermentable> findAllFermentables() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/fermentables/")
				.queryParam("key", freeKey)
				.toUriString();
		FermentableResponse response = restTemplate.getForObject(url, FermentableResponse.class);		
		System.out.println("findAllFermentables: " + url);
		return response.getData();
	}
	
	public List<Fermentable> findFermentablesByBeerId(String beerId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/" + beerId + "/fermentables")
				.queryParam("key", freeKey)
				.toUriString();
		FermentableResponse response = restTemplate.getForObject(url, FermentableResponse.class);		
		System.out.println("findFermentablesByBeerId: " + url);
		return response.getData();
	}
	
	//-------------- ingredient ---------------//
	public Ingredient findIngredientById(Long ingredientId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/ingredient/" + ingredientId + "/")
				.queryParam("key", freeKey)
				.toUriString();
		IngredientSingleResponse response = restTemplate.getForObject(url, IngredientSingleResponse.class);		
		System.out.println("findIngredientById: " + url);
		return response.getData();		
	}

	public List<Ingredient> findAllIngredients() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/ingredients/")
				.queryParam("key", freeKey)
				.toUriString();
		IngredientResponse response = restTemplate.getForObject(url, IngredientResponse.class);		
		System.out.println("findAllIngredients: " + url);
		return response.getData();
	}
	
	public List<Ingredient> findIngredientsByBeerId(String beerId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/" + beerId + "/ingredients")
				.queryParam("key", freeKey)
				.toUriString();
		IngredientResponse response = restTemplate.getForObject(url, IngredientResponse.class);		
		System.out.println("findIngredientsByBeerId: " + url);
		return response.getData();
	}
	
	//-------------- yeast ---------------//
	public Yeast findYeastById(Long yeastId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/yeast/" + yeastId + "/")
				.queryParam("key", freeKey)
				.toUriString();
		YeastSingleResponse response = restTemplate.getForObject(url, YeastSingleResponse.class);		
		System.out.println("findYeastById: " + url);
		return response.getData();		
	}

	public List<Yeast> findAllYeasts() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/yeasts/")
				.queryParam("key", freeKey)
				.toUriString();
		YeastResponse response = restTemplate.getForObject(url, YeastResponse.class);		
		System.out.println("findAllYeasts: " + url);
		return response.getData();
	}
	
	public List<Yeast> findYeastsByBeerId(String beerId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/" + beerId + "/yeasts")
				.queryParam("key", freeKey)
				.toUriString();
		YeastResponse response = restTemplate.getForObject(url, YeastResponse.class);		
		System.out.println("findYeastsByBeerId: " + url);
		return response.getData();
	}
	
	//-------------- guilds ---------------//
	public Guild findGuildById(String guildId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/guild/" + guildId + "/")
				.queryParam("key", freeKey)
				.toUriString();
		GuildSingleResponse response = restTemplate.getForObject(url, GuildSingleResponse.class);		
		System.out.println("findGuildById: " + url);
		return response.getData();		
	}

	public List<Guild> findAllGuilds() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/guilds/")
				.queryParam("key", freeKey)
				.toUriString();
		GuildResponse response = restTemplate.getForObject(url, GuildResponse.class);		
		System.out.println("findAllGuilds: " + url);
		return response.getData();
	}
	
	public List<Guild> findGuildsByBreweryId(String breweryId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/guild/" + breweryId + "/guilds")
				.queryParam("key", freeKey)
				.toUriString();
		GuildResponse response = restTemplate.getForObject(url, GuildResponse.class);		
		System.out.println("findGuildsByBreweryId: " + url);
		return response.getData();
	}
	
	//-------------- category ---------------//
	public Category findCategoryById(String categoryId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/category/" + categoryId + "/")
				.queryParam("key", freeKey)
				.toUriString();
		CategorySingleResponse response = restTemplate.getForObject(url, CategorySingleResponse.class);		
		System.out.println("findCategoryById: " + url);
		return response.getData();		
	}

	public List<Category> findAllCategories() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/categories/")
				.queryParam("key", freeKey)
				.toUriString();
		CategoryResponse response = restTemplate.getForObject(url, CategoryResponse.class);		
		System.out.println("findAllCategories: " + url);
		return response.getData();
	}
	
	//-------------- fluidsize ---------------//
	public FluidSize findFluidSizeById(String fluidSizeId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/fluidSize/" + fluidSizeId + "/")
				.queryParam("key", freeKey)
				.toUriString();
		FluidSizeSingleResponse response = restTemplate.getForObject(url, FluidSizeSingleResponse.class);		
		System.out.println("findFluidSizeById: " + url);
		return response.getData();		
	}

	public List<FluidSize> findAllFluidSizes() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/fluidSizes/")
				.queryParam("key", freeKey)
				.toUriString();
		FluidSizeResponse response = restTemplate.getForObject(url, FluidSizeResponse.class);		
		System.out.println("findAllFluidSizes: " + url);
		return response.getData();
	}
	
	//-------------- glassware ---------------//
	public Glass findGlassById(String glassId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/glass/" + glassId + "/")
				.queryParam("key", freeKey)
				.toUriString();
		GlassSingleResponse response = restTemplate.getForObject(url, GlassSingleResponse.class);		
		System.out.println("findGlassById: " + url);
		return response.getData();		
	}

	public List<Glass> findAllGlassware() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/glassware/")
				.queryParam("key", freeKey)
				.toUriString();
		GlassResponse response = restTemplate.getForObject(url, GlassResponse.class);		
		System.out.println("findAllGlassware: " + url);
		return response.getData();
	}
	
	//-------------- social sites ---------------//
	public SocialSite findSocialSiteById(String socialSiteId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/socialSite/" + socialSiteId + "/")
				.queryParam("key", freeKey)
				.toUriString();
		SocialSiteSingleResponse response = restTemplate.getForObject(url, SocialSiteSingleResponse.class);		
		System.out.println("findSocialSiteById: " + url);
		return response.getData();		
	}

	public List<SocialSite> findAllSocialSites() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/socialSites/")
				.queryParam("key", freeKey)
				.toUriString();
		SocialSiteResponse response = restTemplate.getForObject(url, SocialSiteResponse.class);		
		System.out.println("findAllSocialSites: " + url);
		return response.getData();
	}
	
	public List<SocialSite> findSocialSitesByBreweryId(String breweryId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/socialSite/" + breweryId + "/socialSites")
				.queryParam("key", freeKey)
				.toUriString();
		SocialSiteResponse response = restTemplate.getForObject(url, SocialSiteResponse.class);		
		System.out.println("findSocialSitesByBreweryId: " + url);
		return response.getData();
	}
	
	public List<SocialSite> findSocialSitesByBeerId(String beerId) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/socialSite/" + beerId + "/socialSites")
				.queryParam("key", freeKey)
				.toUriString();
		SocialSiteResponse response = restTemplate.getForObject(url, SocialSiteResponse.class);		
		System.out.println("findSocialSitesByBeerId: " + url);
		return response.getData();
	}
	
	//-------------- event (future implementation?) ---------------//
//	public boolean findEventsByBeerId(Long beerId) {
//		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/" + beerId + "/events")
//				.queryParam("key", freeKey)
//				.toUriString();
//		EventResponse response = restTemplate.getForObject(url, EventResponse.class);		
//		return response.getData();		
//	}
	
	//////////////////////////////////////////////////////////////////
	
	public List<Brewery> sortBreweries(BreweryResponse response) {
		List<Brewery> breweries = response.getData();
		if (!breweries.isEmpty()) {
			for (int i = 0; i < breweries.size(); i++) {
				if (breweries.get(i).getBreweryIsInBusiness() == 'N') {
					breweries.remove(i);
					continue;				
				} else if (breweries.get(i).getBreweryIsVerified() == 'N') {
					breweries.remove(i);
					continue;				
				}
			}
		}
		return breweries;
	}
	
	public List<Location> sortLocations(LocationResponse response) {
		List<Location> locations = response.getData();
		if (!locations.isEmpty()) {
			for (int i = 0; i < locations.size(); i++) {
				if (locations.get(i).getIsClosed() == 'Y') {
					locations.remove(i);
					continue;				
				} else if (locations.get(i).getOpenToPublic() == 'N') {
					locations.remove(i);
					continue;				
				} else if (locations.get(i).getLocationType().equalsIgnoreCase("office")) {
					locations.remove(i);
					continue;				
				}
			}
		}
		return locations;
	}
	
}

