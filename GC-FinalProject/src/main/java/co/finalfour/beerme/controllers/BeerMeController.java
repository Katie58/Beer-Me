package co.finalfour.beerme.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.finalfour.beerme.dao.BeerMeDao;
import co.finalfour.beerme.dao.SearchDataBaseDao;
import co.finalfour.beerme.entity.beer.Beer;
import co.finalfour.beerme.entity.location.Brewery;
import co.finalfour.beerme.entity.location.Location;
import co.finalfour.beerme.entity.populatetables.Style;
import co.finalfour.beerme.model.UserLocation;
import co.finalfour.beerme.service.SearchApiService;

@Controller
public class BeerMeController
{
    
	@Autowired
	private BeerMeDao beerMeDao;
	
	@Autowired
	private SearchDataBaseDao searchDataBaseDao;
	
	@Autowired
	private SearchApiService searchApiService;
	
	private static boolean newUser;
	private static UserLocation currentUserLocation;
	
	private static boolean reset;
	private static boolean local;
    private static List<Beer> fieldBeers = new ArrayList<>();
    private static List<Beer> fieldBrewBeers = new ArrayList<>();
    private static List<Brewery> fieldBreweries = new ArrayList<>();
    private static List<Location> fieldLocations = new ArrayList<>();
	
    @RequestMapping("/")
    public ModelAndView index() {
    	if (!beerMeDao.findAllUserLocations().isEmpty()) {
    		currentUserLocation = beerMeDao.findMainUserLocation();
    		newUser = false;
    	}
    	return new ModelAndView("redirect:/beerme");
    }
    
    @RequestMapping("/beerme")
    public ModelAndView beerMe(@ModelAttribute("message") String message) {
    	ModelAndView mav = new ModelAndView("beerMe");
    	if (!message.isEmpty()) {
    		mav.addObject("message", message);
    	}
    	List<UserLocation> userLocations = beerMeDao.findAllUserLocations();
    	if (!newUser) {
    		mav.addObject("currentUserLocation", currentUserLocation);
    	}
    	if (currentUserLocation == null) {
    		currentUserLocation = beerMeDao.findMainUserLocation();
    	}
    	mav.addObject("userLocations", userLocations);
    	return mav;
    }
    
    @RequestMapping("/beerme/mood")
    public ModelAndView beerMeMood(@RequestParam("mood") String mood) {
    	ModelAndView mav = new ModelAndView("beerMe");
    	
    	local = true;
    	
    	if (newUser && !beerMeDao.userLocationHasMain()) {
    		return new ModelAndView("redirect:/beerme", "message", "Please Enter A Location...");
    	}
    	
    	System.out.println("RESET = " + reset);
    	
    	if (reset) {
    		
    		if (currentUserLocation == null) {
    			currentUserLocation = beerMeDao.findMainUserLocation();
    		}
    		
    		fieldLocations.clear();
    		fieldLocations = searchApiService.findLocationsByBasicSearchFree(
    				(currentUserLocation.getLocality() == null ? null:currentUserLocation.getLocality()),
    				(currentUserLocation.getRegion() == null ? null:currentUserLocation.getRegion()),
    				(currentUserLocation.getPostalCode() == null ? null:Integer.toString(currentUserLocation.getPostalCode())));
    		
    		if (fieldLocations == null || fieldLocations.isEmpty()) {
    			return new ModelAndView("redirect:/beerme", "message", "The Location You Entered Hasn't Any Breweries Nearby...");
    		}
    		
    		fieldBreweries.clear();
    		int size = 10;
    		if (fieldLocations.size() < 10) {
    			size = fieldLocations.size();
    		}
    		for(int i = 0; i < size; i++) {
        		for(Location location : fieldLocations) {
        			fieldBreweries.add(location.getBrewery());
        		}
    		}
    		
    		fieldBrewBeers.clear();
    		for(Brewery brewery : fieldBreweries) {
    			List<Beer> brewBeers = searchApiService.findBeersByBreweryId(brewery.getBreweryId());
    			for(Beer brewBeer : brewBeers) {
    				fieldBrewBeers.add(brewBeer);
    			}
    		}
    		
    		reset = false;
    	}
    	
    	System.out.println("RESET = " + reset);
    	
    	List<Beer> beers = new ArrayList<>();
    	if (mood.equals("hoppy")) {
    		beers = getMoodBeers("India Pale Ale");
		} else if (mood.equals("energetic")) {
			beers = getMoodBeers("Lager");
		} else if (mood.equals("sunny")) {
			beers = getMoodBeers("Wheat");
		} else if (mood.equals("social")) {
			beers = getMoodBeersAbvMin(5.0);
		} else if (mood.equals("bitter")) {
			beers = getMoodBeersIbuMin(50.0);
		} else if (mood.equals("fruity")) {
			beers = getMoodBeers("Fruit");
		} else if (mood.equals("stout")) {
			beers = getMoodBeers("Stout");
		}
    	
    	Random r = new Random();
    	int index =  r.nextInt(beers.size());
    	Beer beer = beers.get(index);
    	
    	System.out.println("PASSED RANDOM");
		
    	mav.addObject("currentUserLocation", currentUserLocation);
    	mav.addObject("local", local);
    	mav.addObject("beer", beer);
		return mav;
    }
    
    @RequestMapping("/location/add")
    public ModelAndView addUserLocation(UserLocation userLocation) {
    	if (userLocation.getMain()) {
    		for (UserLocation location : beerMeDao.findAllUserLocations()) {
    			if (location.getMain()) {
    				location.setMain(false);
    				beerMeDao.updateUserLocation(location.getId());
    			}
    		}
    	}
    	beerMeDao.createUserLocation(userLocation);
    	newUser = false;
    	return new ModelAndView("redirect:/beerme");
    }    
    
    @RequestMapping("/location/{id}/set")
    public ModelAndView setCurrentLocation(@PathVariable("id") Long id) {
    	reset = true;
    	currentUserLocation = beerMeDao.findUserLocation(id);
    	return new ModelAndView("redirect:/beerme");
    }
    
    @RequestMapping("/location/{id}/delete")
    public ModelAndView deleteUserLocation(@PathVariable("id") Long id) {
    	beerMeDao.deleteUserLocation(id);
    	if (beerMeDao.findAllUserLocations().isEmpty()) {
    		newUser = true;
    	}
    	return new ModelAndView("redirect:/beerme");
    }
    
    @RequestMapping("/location/{id}/main")
    public ModelAndView setMainUserLocation(@PathVariable("id") Long id) {
    	List<UserLocation> userLocations = beerMeDao.findAllUserLocations();
    	for (UserLocation userLocation : userLocations) {
    		if (userLocation.getId() == id) {
    			userLocation.setMain(true);
    		} else {
    			userLocation.setMain(false);
    		}
    		beerMeDao.updateUserLocation(userLocation.getId());
    	}
    	return new ModelAndView("redirect:/beerme");
    }
    
    ///////////////////////////////////////////////////////////////
    
    public List<Beer> getMoodBeers(String styleSearch) {
    	List<Beer> beers = new ArrayList<>();
		for(Beer beer : fieldBrewBeers) {
			if (beer.getStyle().getName().contains(styleSearch)) {
				beers.add(beer);
			}
		}
		if (beers.isEmpty()) {
			beers = fieldBrewBeers;
		}
		if (beers.isEmpty()) {
			local = false;
			List<Style> styles = searchDataBaseDao.findAllStyles();
			for (int i = 0; i < styles.size(); i++) {
				if (styles.get(i).getName().contains(styleSearch)) {
					List<Beer> styledBeers = searchApiService.findBeersByStyleId(styles.get(i).getId());
					if (styledBeers != null && !styledBeers.isEmpty()) {
						for (Beer b : styledBeers) {
							fieldBeers.add(b);
						}
					}
				}
			}
			beers = fieldBeers;
		}
		return beers;
    }
    
    public List<Beer> getMoodBeersAbvMin(Double abvMin) {
    	List<Beer> beers = new ArrayList<>();
		for(Beer beer : fieldBrewBeers) {
			if (beer.getStyle().getAbvMin() > abvMin) {
				beers.add(beer);
			}
		}	
		if (beers.isEmpty()) {
			beers = fieldBrewBeers;
		}
		if (beers.isEmpty()) {
			local = false;
			List<Style> styles = searchDataBaseDao.findAllStyles();
			for (int i = 0; i < styles.size(); i++) {
				if (styles.get(i).getAbvMin() != null) {
					if (styles.get(i).getAbvMin() > abvMin) {
						List<Beer> styledBeers = searchApiService.findBeersByStyleId(styles.get(i).getId());
						if (styledBeers != null && !styledBeers.isEmpty()) {
							for (Beer b : styledBeers) {
								fieldBeers.add(b);
							}
						}
					}
				}
			}
			beers = fieldBeers;
		}
		return beers;
    }
    
    public List<Beer> getMoodBeersIbuMin(Double ibuMin) {
    	List<Beer> beers = new ArrayList<>();
		for(Beer beer : fieldBrewBeers) {
			if (beer.getStyle().getAbvMin() > ibuMin) {
				beers.add(beer);
			}
		}	
		if (beers.isEmpty()) {
			beers = fieldBrewBeers;
		}
		if (beers.isEmpty()) {
			List<Style> styles = searchDataBaseDao.findAllStyles();
			for (int i = 0; i < styles.size(); i++) {
				if (styles.get(i).getAbvMin() != null) {
					if (styles.get(i).getAbvMin() > ibuMin) {
						List<Beer> styledBeers = searchApiService.findBeersByStyleId(styles.get(i).getId());
						if (styledBeers != null && !styledBeers.isEmpty()) {
							for (Beer b : styledBeers) {
								fieldBeers.add(b);
							}
						}
					}
				}
			}
			beers = fieldBeers;
		}
		return beers;
    }

}