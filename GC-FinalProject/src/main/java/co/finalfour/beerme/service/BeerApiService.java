package co.finalfour.beerme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import co.finalfour.beerme.entity.beer.Beer;
import co.finalfour.beerme.entity.beer.Ingredient;
import co.finalfour.beerme.entity.location.Brewery;
import co.finalfour.beerme.entity.location.Location;
import co.finalfour.beerme.entity.response.BeerResponse;
import co.finalfour.beerme.entity.response.BeerSingleResponse;
import co.finalfour.beerme.entity.response.BreweryResponse;
import co.finalfour.beerme.entity.response.BrewerySingleResponse;
import co.finalfour.beerme.entity.response.IngredientResponse;
import co.finalfour.beerme.entity.response.LocationResponse;


@Component
public class BeerApiService {

	@Value("${freebeer.key}")
	private String key;

	private RestTemplate restTemplate = new RestTemplate();
	
	public List<Brewery> findBreweries() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/breweries/")
				.queryParam("key", key)
				.toUriString();
		BreweryResponse response = restTemplate.getForObject(url, BreweryResponse.class);		
		return response.getData();
	}
	
	public Brewery findBreweryById(String id) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/brewery/" + id + "/")
				.queryParam("key", key)
				.toUriString();
		System.out.println("BREWERY URL = " + url);
		BrewerySingleResponse response = restTemplate.getForObject(url, BrewerySingleResponse.class);		
		return response.getData();		
	}
	
	public List<Beer> findBeers() {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beers/")
				.queryParam("key", key)
				.toUriString();
		BeerResponse response = restTemplate.getForObject(url, BeerResponse.class);		
		return response.getData();
	}
	
	public Beer findBeerById(String id) {
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/" + id + "/")
				.queryParam("key", key)
				.toUriString();
		System.out.println("BEER URL = " + url);
		BeerSingleResponse response = restTemplate.getForObject(url, BeerSingleResponse.class);		
		return response.getData();		
	}
	
	public List<Brewery> findBreweriesByLocation(String postalCode, String locality, String region) {
		
				String queryKey = "";
				String queryValue = "";
				
				if (postalCode != "") {
					queryKey = "postalCode";
					queryValue = postalCode;
				} else if (locality != "") {
					queryKey = "locality";
					queryValue = locality;
				} else if (region != "") {
					queryKey = "region";
					queryValue = region;
				} 
				
				String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/locations/")	
				.queryParam(queryKey, queryValue)
				.queryParam("key", key)
				.toUriString();
				
				System.out.println(url);
				
		BreweryResponse response = restTemplate.getForObject(url, BreweryResponse.class);				
		return response.getData();
	}
	//To search beers at a particular brewery.
	public List<Beer> findBeersByBreweries(String breweryIdString){

												//Sample: http://api.brewerydb.com/v2/brewery/BznahA/beers?key=b2599794d8cfacff731e8ed3493f43bd
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/brewery/"+breweryIdString+"/beers?key="+key)
				.toUriString();
		System.out.println(url);
		BeerResponse response = restTemplate.getForObject(url, BeerResponse.class );
        return response.getData();
//		BreweryResponse response = restTemplate.getForObject(url, BreweryResponse.class);
//		return response.getData();
		
	}
	//To search beers by abv
	public List<Beer> findBeersByAbv(String name, String styleId){
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/"+name+"/"+styleId+"/abv"+key)
				.toUriString();
		BeerResponse response = restTemplate.getForObject(url, BeerResponse.class );
		return response.getData();
	}
	
	//To search ingredients.
	//public List<Beer> findBeersBy
	public List<Ingredient> findIngredientsByBeer(String id){
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/"+id+"/ingredients/?key="+key)
				.toUriString();
		System.out.println("URL" + url);
		IngredientResponse response = restTemplate.getForObject(url, IngredientResponse.class );
		System.out.println("Response = "+response);
		return response.getData();
	}
	
	public List<Location> findLocationsByBreweryId(String id){
		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/brewery/" + id + "/locations/")
				.queryParam("key", key)
				.toUriString();
		LocationResponse response = restTemplate.getForObject(url, LocationResponse.class);		
		return response.getData();	
	}
//	public List<Style> randomStyle(String styleSearch) {
//		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/search/style")
//				.queryParam("q", styleSearch)
//				.queryParam("key", key)
//				.toUriString();
//		StyleResponse response = restTemplate.getForObject(url, StyleResponse.class);		
//		return response.getData();	
//	}
//	public List<Beer> getBeerByStyleId(String styleId) {
//		String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/beer/")
//				.queryParam("styleId", styleId)
//				.queryParam("key", key)
//				.toUriString();
//		BeerResponse response = restTemplate.getForObject(url, BeerResponse.class);		
//		return response.getData();			
//	}
	
}