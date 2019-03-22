package co.finalfour.beerme.entity.beer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import co.finalfour.beerme.entity.apigeneral.Country;

@Embeddable
public class Hop {
	
	@Column(name = "hopId")
	private Long id;
	@Column(name = "hopName")
	private String name;
	@Type(type = "text")
	@Column(name = "hopDescription")
	private String description;
	@Column(name = "hopOrigin")
	private String countryOfOrigin;
	@Column(name = "hopCategory")
	private String category;
	@Column(name = "hopCategoryDisplay")
	private String categoryDisplay;
	@Column(name = "hopAlphaAcidMin")
	private Double alphaAcidMin;
	@Column(name = "hopAlphaAcidMax")
	private Double alphaAcidMax;
	@Column(name = "hopBetaAcidMin")
	private Double betaAcidMin;
	@Column(name = "hopBetaAcidMax")
	private Double betaAcidMax;
	@Column(name = "hopHumuleneMin")
	private Double humuleneMin;
	@Column(name = "hopHumuleneMax")
	private Double humuleneMax;
	@Column(name = "hopCaryophylleneMin")
	private Double caryophylleneMin;
	@Column(name = "hopCaryophylleneMax")
	private Double caryophylleneMax;
	@Column(name = "hopCohumuloneMin")
	private Double cohumuloneMin;
	@Column(name = "hopCohumuloneMax")
	private Double cohumuloneMax;
	@Column(name = "hopMyrceneMin")
	private Double myrceneMin;
	@Column(name = "hopMyrceneMax")
	private Double myrceneMax;
	@Column(name = "hopFarneseneMin")
	private Double farneseneMin;
	@Column(name = "hopFarneseneMax")
	private Double farneseneMax;
	@Column(name = "hopIsNoble")
	private Character isNoble;
	@Column(name = "hopForBittering")
	private Character forBittering;
	@Column(name = "hopForFlavor")
	private Character forFlavor;
	@Column(name = "hopForAroma")
	private Character forAroma;
	
	@Transient
	private String createDate;
	@Transient
	private String updateDate;
	
	//many to one
	@Embedded @Type(type = "Country")
	@Column(name = "hopCountry")
	private Country country;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategoryDisplay() {
		return categoryDisplay;
	}
	
	public void setCategoryDisplay(String categoryDisplay) {
		this.categoryDisplay = categoryDisplay;
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
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Double getAlphaAcidMin() {
		return alphaAcidMin;
	}
	
	public void setAlphaAcidMin(Double alphaAcidMin) {
		this.alphaAcidMin = alphaAcidMin;
	}
	
	public Double getAlphaAcidMax() {
		return alphaAcidMax;
	}
	
	public void setAlphaAcidMax(Double alphaAcidMax) {
		this.alphaAcidMax = alphaAcidMax;
	}
	
	public Double getBetaAcidMin() {
		return betaAcidMin;
	}
	
	public void setBetaAcidMin(Double betaAcidMin) {
		this.betaAcidMin = betaAcidMin;
	}
	
	public Double getBetaAcidMax() {
		return betaAcidMax;
	}
	
	public void setBetaAcidMax(Double betaAcidMax) {
		this.betaAcidMax = betaAcidMax;
	}
	
	public Double getHumuleneMin() {
		return humuleneMin;
	}
	
	public void setHumuleneMin(Double humuleneMin) {
		this.humuleneMin = humuleneMin;
	}
	
	public Double getHumuleneMax() {
		return humuleneMax;
	}
	
	public void setHumuleneMax(Double humuleneMax) {
		this.humuleneMax = humuleneMax;
	}
	
	public Double getCaryophylleneMin() {
		return caryophylleneMin;
	}
	
	public void setCaryophylleneMin(Double caryophylleneMin) {
		this.caryophylleneMin = caryophylleneMin;
	}
	
	public Double getCaryophylleneMax() {
		return caryophylleneMax;
	}
	
	public void setCaryophylleneMax(Double caryophylleneMax) {
		this.caryophylleneMax = caryophylleneMax;
	}
	
	public Double getCohumuloneMin() {
		return cohumuloneMin;
	}
	
	public void setCohumuloneMin(Double cohumuloneMin) {
		this.cohumuloneMin = cohumuloneMin;
	}
	
	public Double getCohumuloneMax() {
		return cohumuloneMax;
	}
	
	public void setCohumuloneMax(Double cohumuloneMax) {
		this.cohumuloneMax = cohumuloneMax;
	}
	
	public Double getMyrceneMin() {
		return myrceneMin;
	}
	
	public void setMyrceneMin(Double myrceneMin) {
		this.myrceneMin = myrceneMin;
	}
	
	public Double getMyrceneMax() {
		return myrceneMax;
	}
	
	public void setMyrceneMax(Double myrceneMax) {
		this.myrceneMax = myrceneMax;
	}
	
	public Double getFarneseneMin() {
		return farneseneMin;
	}
	
	public void setFarneseneMin(Double farneseneMin) {
		this.farneseneMin = farneseneMin;
	}
	
	public Double getFarneseneMax() {
		return farneseneMax;
	}
	
	public void setFarneseneMax(Double farneseneMax) {
		this.farneseneMax = farneseneMax;
	}
	
	public Character getIsNoble() {
		return isNoble;
	}
	
	public void setIsNoble(Character isNoble) {
		this.isNoble = isNoble;
	}
	
	public Character getForBittering() {
		return forBittering;
	}
	
	public void setForBittering(Character forBittering) {
		this.forBittering = forBittering;
	}
	
	public Character getForFlavor() {
		return forFlavor;
	}
	
	public void setForFlavor(Character forFlavor) {
		this.forFlavor = forFlavor;
	}
	
	public Character getForAroma() {
		return forAroma;
	}
	
	public void setForAroma(Character forAroma) {
		this.forAroma = forAroma;
	}

	@Override
	public String toString() {
		return "Hop [id=" + id + ", name=" + name + ", description=" + description + ", countryOfOrigin="
				+ countryOfOrigin + ", category=" + category + ", categoryDisplay=" + categoryDisplay + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", country=" + country + ", alphaAcidMin=" + alphaAcidMin
				+ ", alphaAcidMax=" + alphaAcidMax + ", betaAcidMin=" + betaAcidMin + ", betaAcidMax=" + betaAcidMax
				+ ", humuleneMin=" + humuleneMin + ", humuleneMax=" + humuleneMax + ", caryophylleneMin="
				+ caryophylleneMin + ", caryophylleneMax=" + caryophylleneMax + ", cohumuloneMin=" + cohumuloneMin
				+ ", cohumuloneMax=" + cohumuloneMax + ", myrceneMin=" + myrceneMin + ", myrceneMax=" + myrceneMax
				+ ", farneseneMin=" + farneseneMin + ", farneseneMax=" + farneseneMax + ", isNoble=" + isNoble
				+ ", forBittering=" + forBittering + ", forFlavor=" + forFlavor + ", forAroma=" + forAroma + "]";
	}	
	
}
