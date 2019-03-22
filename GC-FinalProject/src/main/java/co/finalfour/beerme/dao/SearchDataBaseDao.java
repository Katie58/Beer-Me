package co.finalfour.beerme.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.finalfour.beerme.entity.beer.Beer;
import co.finalfour.beerme.entity.location.Brewery;
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

@Repository
@Transactional
public class SearchDataBaseDao {

    @PersistenceContext
    private EntityManager em;
    
    ///////////////////// find all //////////////////////////
    
	public List<Adjunct> findAllAdjuncts() {
		return em.createQuery("FROM Adjunct", Adjunct.class).getResultList();
	}
	
	public List<Category> findAllCategories() {
		return em.createQuery("FROM Category", Category.class).getResultList();
	}
	
	public List<Fermentable> findAllFermentables() {
		return em.createQuery("FROM Fermentable", Fermentable.class).getResultList();
	}
	
	public List<Glass> findAllGlassware() {
		return em.createQuery("FROM Glass", Glass.class).getResultList();
	}
	
	public List<Guild> findAllGuilds() {
		return em.createQuery("FROM Guild", Guild.class).getResultList();
	}
	
	public List<Hop> findAllHops() {
		return em.createQuery("FROM Hop", Hop.class).getResultList();
	}
	
	public List<Ingredient> findAllIngredients() {
		return em.createQuery("FROM Ingredient", Ingredient.class).getResultList();
	}
	
	public List<SocialSite> findAllSocialSites() {
		return em.createQuery("FROM SocialSite", SocialSite.class).getResultList();
	}
	
	public List<Style> findAllStyles() {
		return em.createQuery("FROM Style", Style.class).getResultList();
	}
	
	public List<Yeast> findAllYeasts() {
		return em.createQuery("FROM Yeast", Yeast.class).getResultList();
	}
	
	/////////////////// find by id //////////////////////
	
	public Brewery findBreweryById(Long tableId) {
		return em.find(Brewery.class, tableId);
	}
	
	public Beer findBeerById(Long tableId) {
		return em.find(Beer.class, tableId);
	}
	
	
	public Adjunct findAdjunctById(Long tableId) {
		return em.find(Adjunct.class, tableId);
	}
	
	public Category findCategoryById(Long tableId) {
		return em.find(Category.class, tableId);
	}
	
	public Fermentable findFermentableById(Long tableId) {
		return em.find(Fermentable.class, tableId);
	}
	
	public Glass findGlassById(Long tableId) {
		return em.find(Glass.class, tableId);
	}
	
	public Guild findGuildById(Long tableId) {
		return em.find(Guild.class, tableId);
	}
	
	public Hop findHopById(Long tableId) {
		return em.find(Hop.class, tableId);
	}
	
	public Ingredient findIngredientById(Long tableId) {
		return em.find(Ingredient.class, tableId);
	}
	
	public SocialSite findSocialSiteById(Long tableId) {
		return em.find(SocialSite.class, tableId);
	}
	
	public Style findStyleById(Long tableId) {
		return em.find(Style.class, tableId);
	}
	
	public Yeast findYeastById(Long tableId) {
		return em.find(Yeast.class, tableId);
	}
    
}
