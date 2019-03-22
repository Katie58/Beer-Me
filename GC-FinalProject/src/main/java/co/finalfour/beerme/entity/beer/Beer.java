package co.finalfour.beerme.entity.beer;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.finalfour.beerme.entity.apigeneral.Images;
import co.finalfour.beerme.entity.apigeneral.SocialAccount;
import co.finalfour.beerme.entity.location.Brewery;

@Entity
public class Beer implements Serializable {


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@NaturalId
	@JsonProperty("id")
	private String beerId;
	private String code;//upc
	private String name;
	private String nameDisplay;
	@Type(type = "text")
	private String description;
	private String type;
	private String foodPairings;
	private Integer year;
	private Double abv;
	private Double ibu;
	private Double originalGravity;
	private Character isOrganic;
	private Character isRetired;
	private String servingTemperature;
	private String servingTemperatureDisplay;
	
	@Transient
	private String createDate;
	@Transient
	private String updateDate;
	@Transient
	private String status;
	@Transient
	private String statusDisplay;

	//one to one, owner
	@Embedded @Type(type = "Images")
	private Images labels;
	private Character hasLabels;
	
	//one to one
//	private Beer beerVariation;
//	private String beerVariationId;
    
	@Embedded @Type(type = "Available")
	private Available available;
	@Transient
	private Long availableId;
    
	@Embedded @Type(type = "Category")
	private Category category;
	@Transient
    private Long categoryId;
    
	@Embedded @Type(type = "Glass")
	private Glass glass;
    @Transient
	private Long glasswareId;
    
    @Embedded @Type(type = "Srm")
	private Srm srm;
	@Transient
	private Long srmId;
    
	@Embedded @Type(type = "Style")
	private Style style;
	@Transient
    private Long styleId;
	
	//one to many
//	private char withEvents;
//	@OneToMany(
//	    mappedBy = "beerId",
//	    cascade = CascadeType.ALL,
//	    orphanRemoval = true)
//	private List<Event> events;
	
    @ElementCollection
	private List<Adjunct> adjuncts;
	private Character withAdjuncts;
	
	@ElementCollection
	private List<Fermentable> fermentables;
	private Character withFermentables;
	
    @ElementCollection
    @Column(name = "fermentCharacteristics")
    private List<Characteristic> characteristics;
	private Character withCharacteristics;
	
	@ElementCollection
	private List<FluidSize> fluidSizes;//from upc
	private Character withFluidSizes;
	
	@ElementCollection
	private List<Hop> hops;
	private Character withHops;
	
	@ElementCollection
	private List<Ingredient> ingredients;
	private Character withIngredients;
	
	@ElementCollection
	private List<Yeast> yeasts;
	private Character withYeasts;
	
	@ElementCollection
	private List<SocialAccount> socialAccounts;
	private Character withSocialAccounts;
	
	//many to many
	@ManyToMany(cascade =
        {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "beer_brewery",
        joinColumns = {
            @JoinColumn(
                name = "beerId",
                referencedColumnName = "beerId")},
        inverseJoinColumns = {
            @JoinColumn(
                name = "breweryId",
                referencedColumnName = "breweryId")})
	private List<Brewery> breweries;
	private Character withBreweries;
	
	//added
	private Integer rating;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBeerId() {
		return beerId;
	}

	public void setBeerId(String beerId) {
		this.beerId = beerId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameDisplay() {
		return nameDisplay;
	}

	public void setNameDisplay(String nameDisplay) {
		this.nameDisplay = nameDisplay;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFoodPairings() {
		return foodPairings;
	}

	public void setFoodPairings(String foodPairings) {
		this.foodPairings = foodPairings;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getAbv() {
		return abv;
	}

	public void setAbv(Double abv) {
		this.abv = abv;
	}

	public Double getIbu() {
		return ibu;
	}

	public void setIbu(Double ibu) {
		this.ibu = ibu;
	}

	public Double getOriginalGravity() {
		return originalGravity;
	}

	public void setOriginalGravity(Double originalGravity) {
		this.originalGravity = originalGravity;
	}

	public Character getIsOrganic() {
		return isOrganic;
	}

	public void setIsOrganic(Character isOrganic) {
		this.isOrganic = isOrganic;
	}

	public Character getIsRetired() {
		return isRetired;
	}

	public void setIsRetired(Character isRetired) {
		this.isRetired = isRetired;
	}

	public String getServingTemperature() {
		return servingTemperature;
	}

	public void setServingTemperature(String servingTemperature) {
		this.servingTemperature = servingTemperature;
	}

	public String getServingTemperatureDisplay() {
		return servingTemperatureDisplay;
	}

	public void setServingTemperatureDisplay(String servingTemperatureDisplay) {
		this.servingTemperatureDisplay = servingTemperatureDisplay;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDisplay() {
		return statusDisplay;
	}

	public void setStatusDisplay(String statusDisplay) {
		this.statusDisplay = statusDisplay;
	}

	public Character getHasLabels() {
		return hasLabels;
	}

	public void setHasLabels(Character hasLabels) {
		this.hasLabels = hasLabels;
	}

	public Images getLabels() {
		return labels;
	}

	public void setLabels(Images labels) {
		this.labels = labels;
	}

//	public String getBeerVariationId() {
//		return beerVariationId;
//	}
//
//	public void setBeerVariationId(String beerVariationId) {
//		this.beerVariationId = beerVariationId;
//	}
//
//	public Beer getBeerVariation() {
//		return beerVariation;
//	}
//
//	public void setBeerVariation(Beer beerVariation) {
//		this.beerVariation = beerVariation;
//	}

	public Long getAvailableId() {
		return availableId;
	}

	public void setAvailableId(Long availableId) {
		this.availableId = availableId;
	}

	public Available getAvailable() {
		return available;
	}

	public void setAvailable(Available available) {
		this.available = available;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getGlasswareId() {
		return glasswareId;
	}

	public void setGlasswareId(Long glasswareId) {
		this.glasswareId = glasswareId;
	}

	public Glass getGlass() {
		return glass;
	}

	public void setGlass(Glass glass) {
		this.glass = glass;
	}

	public Long getSrmId() {
		return srmId;
	}

	public void setSrmId(Long srmId) {
		this.srmId = srmId;
	}

	public Srm getSrm() {
		return srm;
	}

	public void setSrm(Srm srm) {
		this.srm = srm;
	}

	public Long getStyleId() {
		return styleId;
	}

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Character getWithBreweries() {
		return withBreweries;
	}

	public void setWithBreweries(Character withBreweries) {
		this.withBreweries = withBreweries;
	}

	public List<Brewery> getBreweries() {
		return breweries;
	}

	public void setBreweries(List<Brewery> breweries) {
		this.breweries = breweries;
	}

//	public char getWithEvents() {
//		return withEvents;
//	}
//
//	public void setWithEvents(char withEvents) {
//		this.withEvents = withEvents;
//	}
//
//	public List<Event> getEvents() {
//		return events;
//	}
//
//	public void setEvents(List<Event> events) {
//		this.events = events;
//	}

	public Character getWithAdjuncts() {
		return withAdjuncts;
	}

	public void setWithAdjuncts(Character withAdjuncts) {
		this.withAdjuncts = withAdjuncts;
	}

	public List<Adjunct> getAdjuncts() {
		return adjuncts;
	}

	public void setAdjuncts(List<Adjunct> adjuncts) {
		this.adjuncts = adjuncts;
	}

	public Character getWithFermentables() {
		return withFermentables;
	}

	public void setWithFermentables(Character withFermentables) {
		this.withFermentables = withFermentables;
	}

	public List<Fermentable> getFermentables() {
		return fermentables;
	}

	public void setFermentables(List<Fermentable> fermentables) {
		this.fermentables = fermentables;
	}

	public List<Characteristic> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<Characteristic> characteristics) {
		this.characteristics = characteristics;
	}

	public Character getWithCharacteristics() {
		return withCharacteristics;
	}

	public void setWithCharacteristics(Character withCharacteristics) {
		this.withCharacteristics = withCharacteristics;
	}

	public Character getWithFluidSizes() {
		return withFluidSizes;
	}

	public void setWithFluidSizes(Character withFluidSizes) {
		this.withFluidSizes = withFluidSizes;
	}

	public List<FluidSize> getFluidSizes() {
		return fluidSizes;
	}

	public void setFluidSizes(List<FluidSize> fluidSizes) {
		this.fluidSizes = fluidSizes;
	}

	public Character getWithHops() {
		return withHops;
	}

	public void setWithHops(Character withHops) {
		this.withHops = withHops;
	}

	public List<Hop> getHops() {
		return hops;
	}

	public void setHops(List<Hop> hops) {
		this.hops = hops;
	}

	public Character getWithIngredients() {
		return withIngredients;
	}

	public void setWithIngredients(Character withIngredients) {
		this.withIngredients = withIngredients;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Character getWithYeasts() {
		return withYeasts;
	}

	public void setWithYeasts(Character withYeasts) {
		this.withYeasts = withYeasts;
	}

	public List<Yeast> getYeasts() {
		return yeasts;
	}

	public void setYeasts(List<Yeast> yeasts) {
		this.yeasts = yeasts;
	}

	public Character getWithSocialAccounts() {
		return withSocialAccounts;
	}

	public void setWithSocialAccounts(Character withSocialAccounts) {
		this.withSocialAccounts = withSocialAccounts;
	}

	public List<SocialAccount> getSocialAccounts() {
		return socialAccounts;
	}

	public void setSocialAccounts(List<SocialAccount> socialAccounts) {
		this.socialAccounts = socialAccounts;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Beer [id=" + id + ", name=" + name + ", nameDisplay=" + nameDisplay + ", description=" + description
				+ ", type=" + type + ", foodPairings=" + foodPairings + ", year=" + year + ", abv=" + abv + ", ibu="
				+ ibu + ", originalGravity=" + originalGravity + ", isOrganic=" + isOrganic + ", isRetired=" + isRetired
				+ ", servingTemperature=" + servingTemperature + ", servingTemperatureDisplay="
				+ servingTemperatureDisplay + ", createDate=" + createDate + ", updateDate=" + updateDate + ", status="
				+ status + ", statusDisplay=" + statusDisplay + ", hasLabels=" + hasLabels + ", labels=" + labels
				+ ", availableId="
				+ availableId + ", available=" + available + ", categoryId=" + categoryId + ", category=" + category
				+ ", glasswareId=" + glasswareId + ", glass=" + glass + ", srmId=" + srmId + ", srm=" + srm
				+ ", styleId=" + styleId + ", style=" + style
				+ ", withAdjuncts=" + withAdjuncts
				+ ", adjuncts=" + adjuncts + ", withFermentables=" + withFermentables
				+ ", withFluidSizes=" + withFluidSizes + ", fluidSizes=" + fluidSizes + ", withHops=" + withHops
				+ ", hops=" + hops + ", withIngredients=" + withIngredients + ", ingredients=" + ingredients
				+ ", withYeasts=" + withYeasts + ", yeasts=" + yeasts + ", withSocialAccounts=" + withSocialAccounts
				+ ", socialAccounts=" + socialAccounts + ", rating=" + rating + "]";
	}
	
}
