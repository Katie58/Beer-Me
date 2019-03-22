package co.finalfour.beerme.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import co.finalfour.beerme.entity.populatetables.Adjunct;
import co.finalfour.beerme.entity.populatetables.Category;
import co.finalfour.beerme.entity.populatetables.Fermentable;
import co.finalfour.beerme.entity.populatetables.Glass;
import co.finalfour.beerme.entity.populatetables.Guild;
import co.finalfour.beerme.entity.populatetables.Hop;
import co.finalfour.beerme.entity.populatetables.Ingredient;
import co.finalfour.beerme.entity.populatetables.SocialSite;
import co.finalfour.beerme.entity.populatetables.Style;
import co.finalfour.beerme.entity.populatetables.Yeast;
import co.finalfour.beerme.entity.populatetables.AdjunctResponse;
import co.finalfour.beerme.entity.populatetables.CategoryResponse;
import co.finalfour.beerme.entity.populatetables.FermentableResponse;
import co.finalfour.beerme.entity.populatetables.GlassResponse;
import co.finalfour.beerme.entity.populatetables.GuildResponse;
import co.finalfour.beerme.entity.populatetables.HopResponse;
import co.finalfour.beerme.entity.populatetables.IngredientResponse;
import co.finalfour.beerme.entity.populatetables.SocialSiteResponse;
import co.finalfour.beerme.entity.populatetables.StyleResponse;
import co.finalfour.beerme.entity.populatetables.YeastResponse;

@Component//response imports are commented out, must change first
public class PopulateTablesApiService {
	
	@Value("${paidbeer.key}")
	private String paidKey;
	
	public Integer currentPage;
	public Integer numberOfPages;
	public static Integer totalResults;
	public static String status;

	private RestTemplate restTemplate = new RestTemplate();

	public List<Adjunct> findAllAdjuncts() {
		List<Adjunct> adjuncts = new ArrayList<>();
		AdjunctResponse response;
		int p = 0;
		do {
			p++;
			String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/adjuncts/")
					.queryParam("p", p)
					.queryParam("key", paidKey)
					.toUriString();
			response = restTemplate.getForObject(url, AdjunctResponse.class);
			for (Adjunct adjunct : response.getData()) {
				adjuncts.add(adjunct);
			}
			System.out.println("Adjuncts url: " + url);
			System.out.println("status: " + response.getStatus());
			System.out.println("Results: " + response.getTotalResults());
			System.out.println("pages: " + response.getCurrentPage() + " of " + response.getNumberOfPages());
		} while (response.getCurrentPage() < response.getNumberOfPages());
		return adjuncts;
	}
	
	public List<Category> findAllCategories() {
		List<Category> categories = new ArrayList<>();
		CategoryResponse response;

			String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/categories/")
					.queryParam("key", paidKey)
					.toUriString();
			response = restTemplate.getForObject(url, CategoryResponse.class);
			for (Category category : response.getData()) {
				categories.add(category);
			}
			System.out.println("Categories url: " + url);
			System.out.println("status: " + response.getStatus());

		return categories;
	}
	
	public List<Fermentable> findAllFermentables() {
		List<Fermentable> fermentables = new ArrayList<>();
		FermentableResponse response;
		int p = 0;
		do {
			p++;
			String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/fermentables/")
					.queryParam("p", p)
					.queryParam("key", paidKey)
					.toUriString();
			response = restTemplate.getForObject(url, FermentableResponse.class);
			for (Fermentable fermentable : response.getData()) {
				fermentables.add(fermentable);
			}
			System.out.println("Fermentables url: " + url);
			System.out.println("status: " + response.getStatus());
			System.out.println("Results: " + response.getTotalResults());
			System.out.println("pages: " + response.getCurrentPage() + " of " + response.getNumberOfPages());
		} while (response.getCurrentPage() < response.getNumberOfPages());
		return fermentables;
	}
	
	public List<Glass> findAllGlassware() {
		List<Glass> glassware = new ArrayList<>();
		GlassResponse response;

			String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/glassware/")
					.queryParam("key", paidKey)
					.toUriString();
			response = restTemplate.getForObject(url, GlassResponse.class);
			for (Glass glass : response.getData()) {
				glassware.add(glass);
			}
			System.out.println("Glassware url: " + url);
			System.out.println("status: " + response.getStatus());
			
		return glassware;
	}
	
	public List<Guild> findAllGuilds() {
		List<Guild> guilds = new ArrayList<>();
		GuildResponse response;
		int p = 0;
		do {
			p++;
			String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/guilds/")
					.queryParam("p", p)
					.queryParam("key", paidKey)
					.toUriString();
			response = restTemplate.getForObject(url, GuildResponse.class);
			for (Guild guild : response.getData()) {
				guilds.add(guild);
			}
			System.out.println("Guilds url: " + url);
			System.out.println("status: " + response.getStatus());
			System.out.println("Results: " + response.getTotalResults());
			System.out.println("pages: " + response.getCurrentPage() + " of " + response.getNumberOfPages());
		} while (response.getCurrentPage() < response.getNumberOfPages());
		return guilds;
	}
	
	public List<Hop> findAllHops() {
		List<Hop> hops = new ArrayList<>();
		HopResponse response;
		int p = 0;
		do {
			p++;
			String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/hops/")
					.queryParam("p", p)
					.queryParam("key", paidKey)
					.toUriString();
			response = restTemplate.getForObject(url, HopResponse.class);
			for (Hop hop : response.getData()) {
				hops.add(hop);
			}
			System.out.println("Hops url: " + url);
			System.out.println("status: " + response.getStatus());
			System.out.println("Results: " + response.getTotalResults());
			System.out.println("pages: " + response.getCurrentPage() + " of " + response.getNumberOfPages());
		} while (response.getCurrentPage() < response.getNumberOfPages());
		return hops;
	}
	
	public List<Ingredient> findAllIngredients() {
		List<Ingredient> ingredients = new ArrayList<>();
		IngredientResponse response;
		int p = 0;
		do {
			p++;
			String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/ingredients/")
					.queryParam("p", p)
					.queryParam("key", paidKey)
					.toUriString();
			response = restTemplate.getForObject(url, IngredientResponse.class);
			for (Ingredient ingredient : response.getData()) {
				ingredients.add(ingredient);
			}
			System.out.println("Ingredients url: " + url);
			System.out.println("status: " + response.getStatus());
			System.out.println("Results: " + response.getTotalResults());
			System.out.println("pages: " + response.getCurrentPage() + " of " + response.getNumberOfPages());
		} while (response.getCurrentPage() < response.getNumberOfPages());
		return ingredients;
	}
	
	public List<SocialSite> findAllSocialSites() {
		List<SocialSite> socialSites = new ArrayList<>();
		SocialSiteResponse response;

			String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/socialsites/")
					.queryParam("key", paidKey)
					.toUriString();
			response = restTemplate.getForObject(url, SocialSiteResponse.class);
			for (SocialSite socialSite : response.getData()) {
				socialSites.add(socialSite);
			}
			System.out.println("Social Sites url: " + url);
			System.out.println("status: " + response.getStatus());

		return socialSites;
	}
	
	public List<Style> findAllStyles() {
		List<Style> styles = new ArrayList<>();
		StyleResponse response;

			String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/styles/")
					.queryParam("key", paidKey)
					.toUriString();
			response = restTemplate.getForObject(url, StyleResponse.class);
			for (Style style : response.getData()) {
				styles.add(style);
			}
			System.out.println("Styles url: " + url);
			System.out.println("status: " + response.getStatus());

		return styles;
	}
	
	public List<Yeast> findAllYeasts() {
		List<Yeast> yeasts = new ArrayList<>();
		YeastResponse response;
		int p = 0;
		do {
			p++;
			String url = UriComponentsBuilder.fromHttpUrl("http://api.brewerydb.com/v2/yeasts/")
					.queryParam("p", p)
					.queryParam("key", paidKey)
					.toUriString();
			response = restTemplate.getForObject(url, YeastResponse.class);
			for (Yeast yeast : response.getData()) {
				yeasts.add(yeast);
			}
			System.out.println("Yeasts url: " + url);
			System.out.println("status: " + response.getStatus());
			System.out.println("Results: " + response.getTotalResults());
			System.out.println("pages: " + response.getCurrentPage() + " of " + response.getNumberOfPages());
		} while (response.getCurrentPage() < response.getNumberOfPages());
		return yeasts;
	}
	
}
