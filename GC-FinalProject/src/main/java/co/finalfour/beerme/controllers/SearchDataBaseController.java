package co.finalfour.beerme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

@Controller
public class SearchDataBaseController {
	
	@Autowired
	private SearchDataBaseDao searchDataBaseDao;
    
    @RequestMapping("/search/{search}/{longId}/details") 
    public ModelAndView viewSearchDetails(@PathVariable("longId") Long id,
			@PathVariable("search") String search) {
    	
    	ModelAndView mav = new ModelAndView("searchResults");
    	String name = "";
    	Guild guild = new Guild();
    	Adjunct adjunct = new Adjunct();
    	Category category = new Category();
    	Fermentable fermentable = new Fermentable();
    	Glass glass = new Glass();
    	Hop hop = new Hop();
    	Ingredient ingredient = new Ingredient();
    	SocialSite socialSite = new SocialSite();
    	Style style = new Style();
    	Yeast yeast = new Yeast();

    	if (search.equals("adjunct")) {
    		adjunct = searchDataBaseDao.findAdjunctById(id);
    		name = adjunct.getName();
    	} else if (search.equals("category")) {
    		category = searchDataBaseDao.findCategoryById(id);
    		name = category.getName();
    	} else if (search.equals("fermentable")) {
    		fermentable = searchDataBaseDao.findFermentableById(id);
    		name = fermentable.getName();
    	} else if (search.equals("glass")) {
    		glass = searchDataBaseDao.findGlassById(id);
    		name = glass.getName();
    	} else if (search.equals("hop")) {
    		hop = searchDataBaseDao.findHopById(id);
    		name = hop.getName();
    	} else if (search.equals("ingredient")) {
    		ingredient = searchDataBaseDao.findIngredientById(id);
    		name = ingredient.getName();
    	} else if (search.equals("socialSite")) {
    		socialSite = searchDataBaseDao.findSocialSiteById(id);
    		name = socialSite.getName();
    	} else if (search.equals("style")) {
    		style = searchDataBaseDao.findStyleById(id);
    		name = style.getShortName();
    	} else if (search.equals("yeast")) {
    		yeast = searchDataBaseDao.findYeastById(id);
    		name = yeast.getName();
    	} else if (search.equals("guild")) {
    		guild = searchDataBaseDao.findGuildById(id);
    		name = guild.getName();
    	}    	
    	
    	mav.addObject("search",search);
    	mav.addObject("name", name);
    	mav.addObject("guild", guild);
    	mav.addObject("adjunct", adjunct);
    	mav.addObject("category", category);
    	mav.addObject("fermentable", fermentable);
    	mav.addObject("glass", glass);
    	mav.addObject("hop", hop);
    	mav.addObject("ingredient", ingredient);
    	mav.addObject("socialSite", socialSite);
    	mav.addObject("style", style);
    	mav.addObject("yeast", yeast);
    	return mav;
    }
	
}
