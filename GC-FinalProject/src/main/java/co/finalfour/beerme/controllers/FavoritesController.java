package co.finalfour.beerme.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.finalfour.beerme.calc.Calc;
import co.finalfour.beerme.dao.BeerMeDao;
import co.finalfour.beerme.entity.beer.Beer;
import co.finalfour.beerme.entity.location.Brewery;
import co.finalfour.beerme.entity.location.Location;
import co.finalfour.beerme.service.SearchApiService;

@Controller
public class FavoritesController {
	
    @Autowired
    private BeerMeDao beerMeDao;
    
    @Autowired
    private SearchApiService searchApiService;
    
    private static List<Beer> fieldBeers = new ArrayList<>();
    private static List<Beer> fieldBrewBeers = new ArrayList<>();
    private static List<Brewery> fieldBreweries = new ArrayList<>();
    
    @RequestMapping("/favorites")
	public ModelAndView viewFavorites(@ModelAttribute("action") String action,
			@ModelAttribute("name") String name) {
    	
    	ModelAndView mav = new ModelAndView("favorites");
    	
		fieldBeers = beerMeDao.findAllBeers();
		List<Brewery> breweries = beerMeDao.findAllBreweries();
		System.out.println("FIELDBEERS " + fieldBeers.size());
		System.out.println("FIELDBREWBEERS " + fieldBrewBeers.size());
		System.out.println("FIELDBREWERIES " + fieldBreweries.size());
		if (!breweries.isEmpty() && (fieldBrewBeers.isEmpty() || fieldBreweries.isEmpty())) {
			for (Brewery brewery : breweries) {
				List<Beer> brewBeers = searchApiService.findBeersByBreweryId(brewery.getBreweryId());
				if (!brewBeers.isEmpty()) {
					for (int i = brewBeers.size() - 1; i >= 0; i--) {
						if (brewBeers.get(i).getIsRetired() == 'Y') {
							brewBeers.remove(i);
							i--;
						} else {
							fieldBrewBeers.add(brewBeers.get(i));
						}
					}
				}
				brewery.setBeers(brewBeers);
				fieldBreweries.add(brewery);
			}
		}
		if (fieldBeers.isEmpty() && fieldBreweries.isEmpty()) {
			String empty = "YOU DON'T HAVE ANY BEERS SAVED";
			mav.addObject("action", empty);
		} else {
			mav.addObject("beers", fieldBeers);
			mav.addObject("breweries", fieldBreweries);
			mav.addObject("action", action);
			mav.addObject("name", name);
			
			if (beerMeDao.beerTableHasAbv()) {
				Map<String,Double> stats = Calc.getAbvStats(beerMeDao.findAllAbvBeers());
				mav.addObject("abvStats", stats);
			}
			if (beerMeDao.beerTableHasIbu()) {
				mav.addObject("ibuStats", Calc.getIbuStats(beerMeDao.findAllIbuBeers()));
			}
			if (beerMeDao.beerTableHasOriginalGravity()) {
				mav.addObject("originalGravityStats", Calc.getOriginalGravityStats(beerMeDao.findAllOgBeers()));
			}
		}
		return mav;
    }
    
    @RequestMapping("/{fave}/{id}/details") 
    public ModelAndView viewFaveDetails(@PathVariable("id") String id,
			@PathVariable("fave") String fave) {
    	
    	ModelAndView mav = new ModelAndView("beerDetails");
    	Beer beer = new Beer();
    	if (fave.equals("beer")) {    	
        	for (Beer b : fieldBeers) {
        		if (b.getBeerId().equals(id)) {
        			beer = b;
        			break;
        		}
        	}
    	} else if (fave.equals("brewery")) {
        	for (Beer b : fieldBrewBeers) {
        		if (b.getBeerId().equals(id)) {
        			beer = b;
        			break;
        		}
        	}
    	}
    	
    	mav.addObject("fave",fave);
    	mav.addObject("id", id);
    	mav.addObject("beer", beer);
    	return mav;
    }
    
	@RequestMapping("/{fave}/{id}/add")
	public ModelAndView addFavoriteBeer(@PathVariable("id") String id,
			@PathVariable("fave") String fave) {
		
		ModelAndView mav = new ModelAndView("redirect:/favorites");
		String action = "added";
		String name = "";
		
		if (fave.equalsIgnoreCase("beer")) {
			Beer beer = new Beer();
			beer = searchApiService.findBeerById(id);
			if (!beerMeDao.beerHas(id)) {
				beer.setIngredients(searchApiService.findIngredientsByBeerId(id));
				beerMeDao.createBeer(beer);
				System.out.println("CREATED BEER");
			} else {
				action = "already added";
			}
			name = beer.getName();
		} else if (fave.equalsIgnoreCase("brewery")) {
			Brewery brewery = new Brewery();
			brewery = searchApiService.findBreweryById(id);
			if (!beerMeDao.breweryHas(id)) {
				//brewery.setLocations(searchApiService.findLocationsByBreweryId(id));
				beerMeDao.createBrewery(brewery);
				System.out.println("CREATED BREWERY");
			} else {
				action = "already added";
			}
			name = brewery.getBreweryName();			
		} else if (fave.equalsIgnoreCase("location")) {
			Location location = new Location();
			location = searchApiService.findLocationById(id);
			Brewery brewery = new Brewery();
			brewery = searchApiService.findBreweryById(location.getBreweryId());
			location.setBrewery(brewery);
			if (!beerMeDao.locationHas(id)) {
				beerMeDao.createLocation(location);
				System.out.println("CREATED LOCATION");
			} else {
				action = "already added";
			}
			name = brewery.getBreweryName();			
		}
		
		mav.addObject("name", name);
		mav.addObject("action", action);
		return mav;
	}
	
	@RequestMapping("/{fave}/{id}/{rating}/add/")
	public ModelAndView addFavoriteBeerAndRating(@PathVariable("id") String id,
			@PathVariable("fave") String fave,
			@PathVariable("rating") Integer rating) {
		
		ModelAndView mav = new ModelAndView("redirect:/favorites");
		String action = "added";
		String name = "";
		
		if (fave.equalsIgnoreCase("beer")) {
			Beer beer = new Beer();
			beer = searchApiService.findBeerById(id);
			if (!beerMeDao.beerHas(id)) {
				beer.setIngredients(searchApiService.findIngredientsByBeerId(id));
				beer.setRating(rating);
				beerMeDao.createBeer(beer);
			} else {
				action = "already added";
			}
			name = beer.getName();
		} else if (fave.equalsIgnoreCase("brewery")) {
			Brewery brewery = new Brewery();
			brewery = searchApiService.findBreweryById(id);
			if (!beerMeDao.breweryHas(id)) {
				//brewery.setLocations(searchApiService.findLocationsByBreweryId(id));
				brewery.setRating(rating);
				beerMeDao.createBrewery(brewery);
			} else {
				action = "already added";
			}
			name = brewery.getBreweryName();			
		}
		
		mav.addObject("name", name);
		mav.addObject("action", action);
		return mav;
	}
	
	@RequestMapping("/{fave}/{id}/delete")
	public ModelAndView deleteFavoriteBeer(@PathVariable("id") Long id,
			@PathVariable("fave") String fave) {
		
		ModelAndView mav = new ModelAndView("redirect:/favorites");
		String action = "deleted";
		String name = "";
		
		if (fave.equalsIgnoreCase("beer")) {
			Beer beer = new Beer();
			beer = beerMeDao.findBeerById(id);
			beerMeDao.deleteBeer(id);
			for (Beer b : fieldBrewBeers) {
				if (b.getId().equals(id)) {
					fieldBrewBeers.remove(b);
				}
			}
			name = beer.getName();
		} else if (fave.equalsIgnoreCase("brewery")) {
			Brewery brewery = new Brewery();
			brewery = beerMeDao.findBreweryById(id);
			beerMeDao.deleteBrewery(id);
			for (Brewery b : fieldBreweries) {
				if (b.getId().equals(id)) {
					fieldBreweries.remove(b);
				}
			}
			name = brewery.getBreweryName();
		}

		mav.addObject("name", name);
		mav.addObject("action", action);
		return mav;
	}
	
	@RequestMapping("/{fave}/{id}/{rating}/ratingUpdate")
	public ModelAndView updateFavoriteBeerRating(@PathVariable("id") Long id,
			@PathVariable("rating") Integer rating,
			@PathVariable("fave") String fave) {
		
		if (fave.equalsIgnoreCase("beer")) {
			Beer beer = new Beer();
			beer = beerMeDao.findBeerById(id);
			if (rating == 0) {
				beer.setRating(null);
			} else {
				beer.setRating(rating);
			}
			beerMeDao.updateBeer(beer);
		} else if (fave.equalsIgnoreCase("brewery")) {
			Brewery brewery = new Brewery();
			brewery = beerMeDao.findBreweryById(id);
			if (rating == 0) {
				brewery.setRating(null);
			} else {
				brewery.setRating(rating);
			}
			beerMeDao.updateBrewery(brewery);
		}
		return new ModelAndView("redirect:/favorites");
	}

}
