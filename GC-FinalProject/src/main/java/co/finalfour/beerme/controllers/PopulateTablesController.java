package co.finalfour.beerme.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.finalfour.beerme.dao.PopulateTableDao;
import co.finalfour.beerme.dao.SearchDataBaseDao;
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
import co.finalfour.beerme.service.PopulateTablesApiService;

@Controller
public class PopulateTablesController {

	@Autowired
	private PopulateTablesApiService populateTablesApiService;
	
	@Autowired
	private PopulateTableDao populateTableDao;
	
	@Autowired
	private SearchDataBaseDao searchDataBaseDao;
	
	@RequestMapping("/find")
	public ModelAndView find() {
		List<String> entities = new ArrayList<>();
		entities.add("adjuncts");
		entities.add("categories");
		entities.add("fermentables");
		entities.add("glassware");
		entities.add("guilds");
		entities.add("hops");
		entities.add("ingredients");
		entities.add("socialsites");
		entities.add("styles");
		entities.add("yeasts");
		return new ModelAndView("search", "entities", entities);
	}
	
	@RequestMapping("/find/{entity}")
	public ModelAndView findAllEntity(@PathVariable("entity") String entity) {
		ModelAndView mav = new ModelAndView("searchResults");
		
		if (entity.equalsIgnoreCase("adjuncts")) {
			List<Adjunct> adjuncts = searchDataBaseDao.findAllAdjuncts();
			mav.addObject("adjuncts", adjuncts);
		}
		if (entity.equalsIgnoreCase("categories")) {
			List<Category> categories = searchDataBaseDao.findAllCategories();
			mav.addObject("categories", categories);
		}
		if (entity.equalsIgnoreCase("fermentables")) {
			List<Fermentable> fermentables = searchDataBaseDao.findAllFermentables();
			mav.addObject("fermentables", fermentables);
		}
		if (entity.equalsIgnoreCase("glassware")) {
			List<Glass> glassware = searchDataBaseDao.findAllGlassware();
			mav.addObject("glassware", glassware);
		}
		if (entity.equalsIgnoreCase("guilds")) {
			List<Guild> guilds = searchDataBaseDao.findAllGuilds();
			mav.addObject("guilds", guilds);
		}
		if (entity.equalsIgnoreCase("hops")) {
			List<Hop> hops = searchDataBaseDao.findAllHops();
			mav.addObject("hops", hops);
		}
		if (entity.equalsIgnoreCase("ingredients")) {
			List<Ingredient> ingredients = searchDataBaseDao.findAllIngredients();
			mav.addObject("ingredients", ingredients);
		}
		if (entity.equalsIgnoreCase("socialsites")) {
			List<SocialSite> socialSites = searchDataBaseDao.findAllSocialSites();
			mav.addObject("socialSites", socialSites);
		}
		if (entity.equalsIgnoreCase("styles")) {
			List<Style> styles = searchDataBaseDao.findAllStyles();
			mav.addObject("styles", styles);
		}
		if (entity.equalsIgnoreCase("yeasts")) {
			List<Yeast> yeasts = searchDataBaseDao.findAllYeasts();
			mav.addObject("yeasts", yeasts);
		}
		
		return mav;
	}
	
	@RequestMapping("/populate")
	public ModelAndView populate() {
		Map<String,Boolean> entities = new HashMap<>();
		entities.put("adjuncts", !searchDataBaseDao.findAllAdjuncts().isEmpty());
		entities.put("categories", !searchDataBaseDao.findAllCategories().isEmpty());
		entities.put("fermentables", !searchDataBaseDao.findAllFermentables().isEmpty());
		entities.put("glassware", !searchDataBaseDao.findAllGlassware().isEmpty());
		entities.put("guilds", !searchDataBaseDao.findAllGuilds().isEmpty());
		entities.put("hops", !searchDataBaseDao.findAllHops().isEmpty());
		entities.put("ingredients", !searchDataBaseDao.findAllIngredients().isEmpty());
		entities.put("socialsites", !searchDataBaseDao.findAllSocialSites().isEmpty());
		entities.put("styles", !searchDataBaseDao.findAllStyles().isEmpty());
		entities.put("yeasts", !searchDataBaseDao.findAllYeasts().isEmpty());
		return new ModelAndView("prepopulate", "entities", entities);
	}
	
	@RequestMapping("/populate/{name}")
	public ModelAndView populateWith(@PathVariable("name") String name) {
		ModelAndView mav = new ModelAndView("prepopulate");
		
		if(name.equalsIgnoreCase("adjunct")) {
			List<Adjunct> adjuncts = populateTablesApiService.findAllAdjuncts();
			for (Adjunct adjunct : adjuncts) {
				populateTableDao.createAdjunct(adjunct);
			}
		}
		if(name.equalsIgnoreCase("category")) {
			List<Category> categories = populateTablesApiService.findAllCategories();
			for (Category category : categories) {
				populateTableDao.createCategory(category);
			}
		}
		if(name.equalsIgnoreCase("fermentable")) {
			List<Fermentable> fermentables = populateTablesApiService.findAllFermentables();
			for (Fermentable fermentable : fermentables) {
				populateTableDao.createFermentable(fermentable);
			}
		}
		if(name.equalsIgnoreCase("glass")) {
			List<Glass> glassware = populateTablesApiService.findAllGlassware();
			for (Glass glass : glassware) {
				populateTableDao.createGlass(glass);
			}
		}
		if(name.equalsIgnoreCase("guild")) {
			List<Guild> guilds = populateTablesApiService.findAllGuilds();
			for (Guild guild : guilds) {
				populateTableDao.createGuild(guild);
			}
		}
		if(name.equalsIgnoreCase("hop")) {
			List<Hop> hops = populateTablesApiService.findAllHops();
			for (Hop hop : hops) {
				populateTableDao.createHop(hop);
			}
		}
		if(name.equalsIgnoreCase("ingredient")) {
			List<Ingredient> ingredients = populateTablesApiService.findAllIngredients();
			for (Ingredient ingredient : ingredients) {
				populateTableDao.createIngredient(ingredient);
			}
		}
		if(name.equalsIgnoreCase("socialsite")) {
			List<SocialSite> socialSites = populateTablesApiService.findAllSocialSites();
			for (SocialSite socialSite : socialSites) {
				populateTableDao.createSocialSite(socialSite);
			}
		}
		if(name.equalsIgnoreCase("style")) {
			List<Style> styles = populateTablesApiService.findAllStyles();
			for (Style style : styles) {
				populateTableDao.createStyle(style);
			}
		}
		if(name.equalsIgnoreCase("yeast")) {
			List<Yeast> yeasts = populateTablesApiService.findAllYeasts();
			for (Yeast yeast : yeasts) {
				populateTableDao.createYeast(yeast);
			}
		}
		mav.addObject("name", name);
		return mav;
	}
	
}
