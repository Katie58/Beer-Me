package co.finalfour.beerme.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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
public class PopulateTableDao {

	@PersistenceContext
	private EntityManager em;
	
	public void createAdjunct(Adjunct adjunct) {
		em.persist(adjunct);
	}
	
	public void createCategory(Category category) {
		em.persist(category);
	}
	
	public void createFermentable(Fermentable fermentable) {
		em.persist(fermentable);
	}
	
	public void createGlass(Glass glass) {
		em.persist(glass);
	}
	
	public void createGuild(Guild guild) {
		em.persist(guild);
	}
	
	public void createHop(Hop hop) {
		em.persist(hop);
	}
	
	public void createIngredient(Ingredient ingredient) {
		em.persist(ingredient);
	}
	
	public void createSocialSite(SocialSite socialSite) {
		em.persist(socialSite);
	}
	
	public void createStyle(Style style) {
		em.persist(style);
	}
	
	public void createYeast(Yeast yeast) {
		em.persist(yeast);
	}
	
}
