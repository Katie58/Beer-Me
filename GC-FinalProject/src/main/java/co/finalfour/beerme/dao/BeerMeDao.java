package co.finalfour.beerme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.finalfour.beerme.entity.beer.Beer;
import co.finalfour.beerme.entity.location.Brewery;
import co.finalfour.beerme.entity.location.Location;
import co.finalfour.beerme.model.UserLocation;

@Repository
@Transactional
public class BeerMeDao
{
    @PersistenceContext
    private EntityManager em;
    
    ///////////////////////// USER LOCATIONS ////////////////////////////////////
    
    public List<UserLocation> findAllUserLocations() {
    	List<UserLocation> userLocations = em.createQuery("FROM UserLocation", UserLocation.class).getResultList();
    	return userLocations;
    }
    
    public UserLocation findUserLocation(Long id) {
    	return em.find(UserLocation.class, id);
    }
    
    public UserLocation findMainUserLocation() {
    	UserLocation userLocation = em.createQuery("FROM UserLocation WHERE main = true", UserLocation.class).getSingleResult();
    	return userLocation;
    }
    
	public void createUserLocation(UserLocation userLocation) {
		em.persist(userLocation);
	}
	
	public void updateUserLocation(Long id) {
		UserLocation userLocation = new UserLocation();
		userLocation = em.find(UserLocation.class, id);
		em.merge(userLocation);
	}

	public void deleteUserLocation(Long id) {
		UserLocation userLocation = em.getReference(UserLocation.class, id);
		em.remove(userLocation);
	}
	
	public boolean userLocationHasMain() {
		return !em.createQuery("FROM UserLocation WHERE main = true", UserLocation.class)
		.getResultList().isEmpty();
	}
    
    //////////////////////////// LOCATIONS /////////////////////////////////////////
	public List<Location> findAllLocations() {
		System.out.println("FINDING ALL LOCATIONS");
		List<Location> locations = em.createQuery("FROM Location", Location.class).getResultList();
		System.out.println("LOCATIONS SIZE: " + locations.size());
		return locations;
	}
	
	public List<Location> findLocationByName(String locationName) {
		return em.createQuery("FROM Location WHERE name LIKE :locationName", Location.class)
				.setParameter("name", "%" + locationName + "%").getResultList();
	}
	
	public List<Location> findLocationsByBeer(Beer beer) {
		return em.createQuery("from Location where beer = :beer order by name", Location.class)
				.setParameter("beer", beer)
				.getResultList();
	}
	
	public List<Location> findLocationsByBeerId(String beerId) {
		return em.createQuery("FROM Location WHERE beer_id = :beerId", Location.class)
				.setParameter("beerId", beerId)
				.getResultList();
	}

	public void createLocation(Location location) {
		em.persist(location);
	}

	public Location findLocationById(String id) {
		return em.find(Location.class, id);
	}

	public void updateLocation(Location location) {
		em.merge(location);
	}
	
	public void updateLocation(Long locationId) {
		Location location = new Location();
		location = em.find(Location.class, locationId);
		em.merge(location);
	}

	public void deleteLocation(Long id) {
		Location location = em.getReference(Location.class, id);
		em.remove(location);
	}
	
	public void delete(Location location) {
		em.remove(em.contains(location) ? location : em.merge(location));
	}
	
	public boolean locationHas(String locationId) {
		return !em.createQuery("FROM Location WHERE location_id = :locationId", Location.class)
		.setParameter("locationId", locationId)
		.getResultList().isEmpty();
	}

	public boolean locationContains(Location location) {
		return em.contains(location);
	}
	
    //////////////////////////// BREWERIES /////////////////////////////////////////
	public List<Brewery> findAllBreweries() {
		System.out.println("FINDING ALL BREWERIES");
		return em.createQuery("FROM Brewery", Brewery.class).getResultList();
	}
	
	public List<Brewery> findBreweryByName(String breweryName) {
		return em.createQuery("FROM Brewery WHERE name LIKE :breweryName", Brewery.class)
				.setParameter("name", "%" + breweryName + "%").getResultList();
	}
	
	public List<Brewery> findBreweriesByBeer(Beer beer) {
		return em.createQuery("from Brewery where beer = :beer order by name", Brewery.class)
				.setParameter("beer", beer)
				.getResultList();
	}
	
	public List<Brewery> findBreweriesByBeerId(Long beerId) {
		return em.createQuery("FROM Brewery WHERE beer_id = :beerId", Brewery.class)
				.setParameter("beerId", beerId)
				.getResultList();
	}

	public void createBrewery(Brewery brewery) {
		em.persist(brewery);
	}

	public Brewery findBreweryById(String breweryId) {
		return em.find(Brewery.class, breweryId);
	}
	
	public Brewery findBreweryById(Long id) {
		return em.find(Brewery.class, id);
	}

	public void updateBrewery(Brewery brewery) {
		em.merge(brewery);
	}
	
	public void updateBrewery(Long id) {
		Brewery brewery = new Brewery();
		brewery = em.find(Brewery.class, id);
		em.merge(brewery);
	}
	
	public void updateBrewery(String breweryId) {
		Brewery brewery = new Brewery();
		brewery = em.find(Brewery.class, breweryId);
		em.merge(brewery);
	}

	public void deleteBrewery(Long id) {
		Brewery brewery = em.getReference(Brewery.class, id);
		em.remove(brewery);
	}
	
	public void deleteBrewery(String breweryId) {
		Brewery brewery = em.getReference(Brewery.class, breweryId);
		em.remove(brewery);
	}
	
	public void delete(Brewery brewery) {
		em.remove(em.contains(brewery) ? brewery : em.merge(brewery));
	}
	
	public boolean breweryHas(String breweryId) {
		return !em.createQuery("FROM Brewery WHERE brewery_id = :breweryId", Brewery.class)
		.setParameter("breweryId", breweryId)
		.getResultList().isEmpty();
	}

	public boolean breweryContains(Brewery brewery) {
		return em.contains(brewery);
	}
	///////////////////////////////// BEER //////////////////////////////////////////////
	public List<Beer> findAllBeers() {
		System.out.println("FINDING ALL BEERS");
		return em.createQuery("FROM Beer", Beer.class).getResultList();
	}
	
	public List<Beer> findBeerByName(String beerName) {
		return em.createQuery("FROM Beer WHERE name LIKE :beerName", Beer.class)
				.setParameter("name", "%" + beerName + "%")
				.getResultList();
	}
	
	public List<Beer> findBeerByBrewery(Brewery brewery) {
		return em.createQuery("FROM Beer WHERE brewery = :brewery order by name", Beer.class)
				.setParameter("brewery", brewery)
				.getResultList();
	}
	
	public List<Beer> findBeerByBreweryId(String breweryId) {
		return em.createQuery("FROM Beer WHERE brewery_id = :breweryId", Beer.class)
				.setParameter("breweryId", breweryId)
				.getResultList();
	}

	public void createBeer(Beer beer) {
		em.persist(beer);
	}

	public Beer findBeerById(String beerId) {
		return em.find(Beer.class, beerId);
	}
	
	public Beer findBeerById(Long id) {
		return em.find(Beer.class, id);
	}

	public void updateBeer(Beer beer) {
		em.merge(beer);
	}
	
	public void updateBeer(Long id) {
		Beer beer = new Beer();
		beer = em.find(Beer.class, id);
		em.merge(beer);
	}

	public void deleteBeer(Long id) {
		Beer beer = em.getReference(Beer.class, id);
		em.remove(beer);
	}
	
	public void deleteBeer(Beer beer) {
		em.remove(em.contains(beer) ? beer : em.merge(beer));
	}
	
	public boolean beerHas(String beerId) {
		return !em.createQuery("FROM Beer WHERE beerId = :beerId", Beer.class)
		.setParameter("beerId", beerId)
		.getResultList().isEmpty();
	}
	
	public boolean beerTableHasAbv() {
		return !em.createQuery("FROM Beer WHERE abv IS NOT NULL", Beer.class)
		.getResultList().isEmpty();
	}
	
	public List<Beer> findAllAbvBeers() {
		return em.createQuery("FROM Beer WHERE abv IS NOT NULL", Beer.class).getResultList();
	}
	
	public boolean beerTableHasIbu() {
		return !em.createQuery("FROM Beer WHERE ibu IS NOT NULL", Beer.class)
		.getResultList().isEmpty();
	}
	
	public List<Beer> findAllIbuBeers() {
		return em.createQuery("FROM Beer WHERE ibu IS NOT NULL", Beer.class).getResultList();
	}
	
	public boolean beerTableHasOriginalGravity() {
		return !em.createQuery("FROM Beer WHERE originalGravity IS NOT NULL", Beer.class)
		.getResultList().isEmpty();
	}
	
	public List<Beer> findAllOgBeers() {
		return em.createQuery("FROM Beer WHERE originalGravity IS NOT NULL", Beer.class).getResultList();
	}

}
