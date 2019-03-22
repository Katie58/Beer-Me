package co.finalfour.beerme.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
import co.finalfour.beerme.entity.location.Brewery;
import co.finalfour.beerme.entity.location.Guild;
import co.finalfour.beerme.entity.location.Location;
import co.finalfour.beerme.service.SearchApiService;

@Controller
public class SearchController {
	
	@Autowired
	private SearchApiService searchApiService;
	
	@RequestMapping("/search")
	public ModelAndView search() {
		Map<String,String> search = new HashMap<>();
		search.put("DataBase", "/find");
		search.put("API", "/search/api");
		return new ModelAndView("search", "search", search);
	}
	
	@RequestMapping("/search/api")
	public ModelAndView searchApi() {
		ModelAndView mav = new ModelAndView("searchAPI");
		return mav;
	}
	
	//////////////////////// beer ///////////////////////
	
	//------------------ single beer -------------------//
	
	@RequestMapping("/search/beer") 
	public ModelAndView searchBeerBy(@RequestParam("beerId") String beerId) {
		Beer beer = searchApiService.findBeerById(beerId);
		return new ModelAndView("searchResults", "beer", beer);
	}
	
	//*****PAIDKEY
	@RequestMapping("/search/beer/upc")
	public ModelAndView searchBeerByUPC(@RequestParam("code") Long code) {
		System.out.println("searchBeerByUPC: " + code);
		List<Beer> beers = searchApiService.findBeerByUPC(code);
		return new ModelAndView("searchResults", "beers", beers);
	}
	
	@RequestMapping("/random/beer")
	public ModelAndView searchRandomBeer(Beer random) {
		System.out.println("GET RANDOM BEER");
		Beer beer = searchApiService.randomBeer(random);
		return new ModelAndView("searchResults", "beer", beer);
	}
	
	//------------------ list of beers -----------------//
	
	@RequestMapping("/search/beers/all")
	public ModelAndView searchAllBeers() {
		List<Beer> beers= searchApiService.findAllBeers();
		return new ModelAndView("searchResults", "beers", beers);
	}
	
	@RequestMapping("/search/beers") 
	public ModelAndView searchBeersByBreweryId(	
			@RequestParam("breweryId") String breweryId,
			@RequestParam("styleId") Long styleId) {
		ModelAndView mav = new ModelAndView("searchResults");
		if(!breweryId.equalsIgnoreCase("null")) {
			List<Beer> beers = searchApiService.findBeersByBreweryId(breweryId);
			mav.addObject("search", "brewery");
			mav.addObject("beers", beers);
		}
		if(styleId > 0) {
			List<Beer> beers = searchApiService.findBeersByStyleId(styleId);
			mav.addObject("search", "style");
			mav.addObject("beers", beers);
		}
		return mav;		
	}
	
	//*****PAIDKEY
	@RequestMapping("/search/variations")
	public ModelAndView searchVariationsByBeerId(
			@RequestParam("beerId") String beerId) {
		List<Beer> beers = searchApiService.findVariationsByBeerId(beerId);
		return new ModelAndView("searchResults", "beers", beers);
	}
	
	////////////////////// brewery //////////////////////
	
	//------------------ single brewery -----------------//
	
	@RequestMapping("/search/brewery/{id}/") 
	public ModelAndView searchBreweryBy(
			@PathVariable("breweryId") String breweryId) {
		ModelAndView mav = new ModelAndView("searchResults");		
		if(!breweryId.equalsIgnoreCase("null")) {
			Brewery brewery = searchApiService.findBreweryById(breweryId);
			mav.addObject("brewery", brewery);
		}
		return mav;
	}
	
	@RequestMapping("/random/brewery")
	public ModelAndView searchRandomBrewery(Brewery random) {
		Brewery brewery = searchApiService.randomBrewery(random);
		return new ModelAndView("searchResults", "brewery", brewery);
	}
	
	//----------------- list of breweries ----------------//
	
	@RequestMapping("/search/breweries/all")
	public ModelAndView searchAllBreweries() {
		List<Brewery> breweries= searchApiService.findAllBreweries();
		return new ModelAndView("searchResults", "breweries", breweries);
	}
	
	@RequestMapping("/search/breweries/{id}") 
	public ModelAndView searchBreweriesBy(
			@PathVariable("beerId") String beerId) {
		ModelAndView mav = new ModelAndView("searchResults");
		if(!beerId.equalsIgnoreCase("null")) {
			List<Brewery> breweries = searchApiService.findBreweriesByBeerId(beerId);
			mav.addObject("breweries", breweries);
		}
		return mav;
	}
	
	@RequestMapping("/search/breweries")
	public ModelAndView searchBreweries(
			@RequestParam("p") int p, 
			@RequestParam("name") String name, 
			@RequestParam("ids") String ids,
			@RequestParam("established") int established,
			@RequestParam("isOrganic") char isOrganic,
			@RequestParam("hasImages") char hasImages,
			@RequestParam("since") String since,
			@RequestParam("status") String status,
			@RequestParam("order") String order,
			@RequestParam("sort") String sort,
			@RequestParam("randomCount") int randomCount,
			@RequestParam("withSocialAccounts") char withSocialAccounts,
			@RequestParam("withGuilds") char withGuilds,	
			@RequestParam("withLocations") char withLocations,	
			@RequestParam("withAlternateNames") char withAlternateNames) {
		ModelAndView mav = new ModelAndView("searchResults");		
		List<Brewery> breweries = searchApiService.findBreweriesByParams(
				p, name, ids, established, isOrganic, hasImages, since,
				status, order, sort, randomCount, withSocialAccounts, withGuilds,	
				withLocations, withAlternateNames);
				
		mav.addObject("breweries", breweries);
		return mav;
	}
	
	////////////////////// locations //////////////////////
	
	//----------------- list of locations ----------------//
	
    @RequestMapping("/basicsearch/locations")
    public ModelAndView basicSearchForLocations(
        @RequestParam(value="locality", required=false) String locality,
        @RequestParam(value="region", required=false) String region,
        @RequestParam(value="postalCode", required=false) String postalCode) {    
    	ModelAndView mav = new ModelAndView("searchResults");
    	List<Location> locations = searchApiService.findLocationsByBasicSearch(
    			locality, region, postalCode);
        mav.addObject("locations", locations);
    	return mav;
    }
    
    @RequestMapping("/search/locations")
    public ModelAndView searchForLocations(
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
	ModelAndView mav = new ModelAndView("searchResults");
	List<Location> locations = searchApiService.findLocationsByParams(
			p, ids, locality, region, postalCode, isPrimary, inPlanning,
			isClosed, locationType, countryIsoCode, since, status, order, sort);
    mav.addObject("locations", locations);
	return mav;
    }
    
	//*****PAIDKEY
	@RequestMapping("/search/GEO")
	public ModelAndView searchLocationsByGeo(
			@RequestParam("lat") Double lat,
			@RequestParam("lng") Double lng,
			@RequestParam("radius") Double radius,
			@RequestParam("unit") String unit,
			@RequestParam("withSocialAccounts") Character withSocialAccounts,
			@RequestParam("withGuilds") Character withGuilds,
			@RequestParam("withAlternateNames") Character withAlternateNames) {
		System.out.println("SEARCHING GEO");
		List<Location> locations = searchApiService.findLocationsByGeo(lat, lng, radius, unit, withSocialAccounts, withGuilds, withAlternateNames);
		return new ModelAndView("searchResults", "locations", locations);
	}
	
	///////////////////////// other ////////////////////////

	//----- style -----//
	@RequestMapping("/search/style/{id}/")
	public ModelAndView searchStyleId(@PathVariable("styleId") Long styleId) {
		Style style = searchApiService.findStyleById(styleId);
		return new ModelAndView("searchResults", "style", style);
	}
	
	@RequestMapping("/search/style")
	public ModelAndView searchStyleByQuery(@RequestParam("styleSearch") String styleSearch) {
		ModelAndView mav = new ModelAndView("searchResults");
		List<Style> styles = searchApiService.findStylesByQuery(styleSearch);
		mav.addObject("search", styleSearch);
		mav.addObject("styles", styles);
		return mav;
	}
	
	//----- adjunct -----//
	@RequestMapping("/search/adjunct/{id}/")
	public ModelAndView searchAdjunctById(@PathVariable("id") Long adjunctId) {
		Adjunct adjunct = searchApiService.findAdjunctById(adjunctId);
		return new ModelAndView("searchResults", "adjunct", adjunct);
	}
	
	@RequestMapping("/search/adjuncts/all")
	public ModelAndView searchAllAdjuncts() {
		List<Adjunct> adjuncts = searchApiService.findAllAdjuncts();
		return new ModelAndView("searchResults", "adjuncts", adjuncts);
	}
	
	@RequestMapping("/search/adjuncts")
	public ModelAndView searchAdjunctsByBeerId(
			@RequestParam("beerId") String beerId) {
		List<Adjunct> adjuncts = searchApiService.findAdjunctsByBeerId(beerId);
		return new ModelAndView("searchResults", "adjuncts", adjuncts);
	}
	
	//----- hop -----//
	@RequestMapping("/search/hop/{id}/")
	public ModelAndView searchHopId(@PathVariable("id") Long hopId) {
		Hop hop = searchApiService.findHopById(hopId);
		return new ModelAndView("searchResults", "hops", hop);
	}
	
	@RequestMapping("/search/hops/all")
	public ModelAndView searchAllHop() {
		List<Hop> hops = searchApiService.findAllHops();
		return new ModelAndView("searchResults", "hops", hops);
	}
	
	@RequestMapping("/search/hops")
	public ModelAndView searchHopsByBeerId(
			@RequestParam("beerId") String beerId) {
		List<Hop> hops = searchApiService.findHopsByBeerId(beerId);
		return new ModelAndView("searchResults", "hops", hops);
	}
	
	//----- fermentable -----//
	@RequestMapping("/search/fermentable/{id}/")
	public ModelAndView searchFermentableById(@PathVariable("id") Long fermentableId) {
		Fermentable fermentable = searchApiService.findFermentableById(fermentableId);
		return new ModelAndView("searchResults", "fermentables", fermentable);
	}
	
	@RequestMapping("/search/fermentables/all")
	public ModelAndView searchAllFermentables() {
		List<Fermentable> fermentables = searchApiService.findAllFermentables();
		return new ModelAndView("searchResults", "fermentables", fermentables);
	}
	
	@RequestMapping("/search/fermentables")
	public ModelAndView searchFermentablesByBeerId(
			@RequestParam("beerId") String beerId) {
		List<Fermentable> fermentables = searchApiService.findFermentablesByBeerId(beerId);
		return new ModelAndView("searchResults", "fermentables", fermentables);
	}
	
	//----- ingredient -----//
	@RequestMapping("/search/ingredient/{id}/")
	public ModelAndView searchIngredientById(@PathVariable("id") Long ingredientId) {
		Ingredient ingredient = searchApiService.findIngredientById(ingredientId);
		return new ModelAndView("searchResults", "ingredient", ingredient);
	}
	
	@RequestMapping("/search/ingredients/all")
	public ModelAndView searchAllIngredients() {
		List<Ingredient> ingredients = searchApiService.findAllIngredients();
		return new ModelAndView("searchResults", "ingredient", ingredients);
	}
	
	@RequestMapping("/search/ingredients")
	public ModelAndView searchIngredientsByBeerId(
			@RequestParam("beerId") String beerId) {
		List<Ingredient> ingredients = searchApiService.findIngredientsByBeerId(beerId);
		return new ModelAndView("searchResults", "ingredient", ingredients);
	}
	
	//////////////////////// miscellaneous ///////////////////////////
	
	//----- brewery alternate names -----//
	@RequestMapping("/search/brewery/altName")
	public ModelAndView searchBreweryAltNameByBreweryId(
			@RequestParam("breweryId") String breweryId) {
		List<String> altNames = searchApiService.findBreweryAltNameById(breweryId);
		return new ModelAndView("searchResults", "altNames", altNames);
	}
	
	//----- brewery guilds -----//
	@RequestMapping("/search/guild/{id}/")
	public ModelAndView searchGuildById(@PathVariable("id") String guildId) {
		Guild guild = searchApiService.findGuildById(guildId);
		return new ModelAndView("searchResults", "guild", guild);
	}
	
	@RequestMapping("/search/guilds/all")
	public ModelAndView searchAllGuilds() {
		List<Guild> guilds = searchApiService.findAllGuilds();
		return new ModelAndView("searchResults", "guilds", guilds);
	}
	
	@RequestMapping("/search/guilds")
	public ModelAndView searchGuildsByBreweryId(
			@RequestParam("breweryId") String breweryId) {
		List<Guild> guilds = searchApiService.findGuildsByBreweryId(breweryId);
		return new ModelAndView("searchResults", "guild", guilds);
	}
	
	//----- category -----//
	@RequestMapping("/search/category/{id}/")
	public ModelAndView searchCategoryById(@PathVariable("id") String categoryId) {
		Category category = searchApiService.findCategoryById(categoryId);
		return new ModelAndView("searchResults", "category", category);
	}
	
	@RequestMapping("/search/categories/all")
	public ModelAndView searchAllCategories() {
		List<Category> categories = searchApiService.findAllCategories();
		return new ModelAndView("searchResults", "categories", categories);
	}
	
	//----- fluidSize -----//
	@RequestMapping("/search/fluidSize/{id}/")
	public ModelAndView searchFluidSizeById(@PathVariable("id") String fluidSizeId) {
		FluidSize fluidSize = searchApiService.findFluidSizeById(fluidSizeId);
		return new ModelAndView("searchResults", "fluidSize", fluidSize);
	}
	
	@RequestMapping("/search/fluidSize/all")
	public ModelAndView searchAllFluidSizes() {
		List<FluidSize> fluidSizes = searchApiService.findAllFluidSizes();
		return new ModelAndView("searchResults", "fluidSizes", fluidSizes);
	}
	
	//----- glassware -----//
	@RequestMapping("/search/glass/{id}/")
	public ModelAndView searchGlassById(@PathVariable("id") String glassId) {
		Glass glass = searchApiService.findGlassById(glassId);
		return new ModelAndView("searchResults", "glass", glass);
	}
	
	@RequestMapping("/search/glassware/all")
	public ModelAndView searchAllGlassware() {
		List<Glass> glassware = searchApiService.findAllGlassware();
		return new ModelAndView("searchResults", "glassware", glassware);
	}
	
	//----- social site -----//
	@RequestMapping("/search/socialsite/{id}/")
	public ModelAndView searchSocialSiteById(@PathVariable("id") String socialSiteId) {
		SocialSite socialSite = searchApiService.findSocialSiteById(socialSiteId);
		return new ModelAndView("searchResults", "socialSite", socialSite);
	}
	
	@RequestMapping("/search/socialsites/all")
	public ModelAndView searchAllSocialSites() {
		List<SocialSite> socialSites = searchApiService.findAllSocialSites();
		return new ModelAndView("searchResults", "socialSites", socialSites);
	}
	
	@RequestMapping("/search/brewerysocialsites")
	public ModelAndView searchSocialSitesByBreweryId(
			@RequestParam("breweryId") String breweryId) {
		List<SocialSite> socialSites = searchApiService.findSocialSitesByBreweryId(breweryId);
		return new ModelAndView("searchResults", "socialSite", socialSites);
	}
	
	@RequestMapping("/search/beersocialsites")
	public ModelAndView searchSocialSitesByBeerId(
			@RequestParam("beerId") String beerId) {
		List<SocialSite> socialSites = searchApiService.findSocialSitesByBeerId(beerId);
		return new ModelAndView("searchResults", "socialSite", socialSites);
	}
	
	///////////////////////// mult search ///////////////////////////
	
	@RequestMapping("/search/beers/style")
	public ModelAndView searchBeersByStyle(@RequestParam("style") String style) {
		ModelAndView mav = new ModelAndView("searchResults");
		List<Style> styles = searchApiService.findStylesByQuery(style);
		List<Beer> temp = new ArrayList<>();
		List<Beer> beers = new ArrayList<>();
		for (Style s : styles) {
			temp = searchApiService.findBeersByStyleId(s.getId());
			for (Beer b : temp) {
				beers.add(b);
			}
		}
		mav.addObject("search", style);
		mav.addObject("beers", beers);
		return mav;
	}
	
}
