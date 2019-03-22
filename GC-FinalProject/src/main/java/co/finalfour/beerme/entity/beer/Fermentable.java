package co.finalfour.beerme.entity.beer;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import co.finalfour.beerme.entity.apigeneral.Country;

@Embeddable
public class Fermentable {
	
	@Column(name = "fermentId")
    private Long id;
	@Column(name = "fermentName")
    private String name;
    @Type(type = "text")
    @Column(name = "fermentDescription")
    private String description;
    @Column(name = "fermentOrigin")
    private String countryOfOrigin;
    @Column(name = "fermentSrmId")
    private Long srmId;
    @Column(name = "fermentSrmPrecise")
    private Integer srmPrecise;
    @Column(name = "fermentMoistureContent")
    private Integer moistureContent;
    @Column(name = "fermentDryYield")
    private Double dryYield;
    @Column(name = "fermentPotential")
    private Double potential;
    @Column(name = "fermentProtein")
    private Integer protein;
    @Column(name = "fermentMaxInBatch")
    private Integer maxInBatch;
    @Column(name = "fermentRequiresMashing")
    private Character requiresMashing;
    @Column(name = "fermentCategory")
    private String category;
    @Column(name = "fermentCategoryDisplay")
    private String categoryDisplay;
    
    @Transient
    private String createDate;
    @Transient
    private String updateDate;
    
    //one to one
    @Transient
    private Srm srm;
    
    //many to one
    @Transient
    private Country country;
    
    //one to many
    @Transient
    private List<Characteristic> characteristics;

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
	
	public Long getSrmId() {
		return srmId;
	}
	
	public void setSrmId(Long srmId) {
		this.srmId = srmId;
	}
	
	public Integer getSrmPrecise() {
		return srmPrecise;
	}
	
	public void setSrmPrecise(Integer srmPrecise) {
		this.srmPrecise = srmPrecise;
	}
	
	public Integer getMoistureContent() {
		return moistureContent;
	}
	
	public void setMoistureContent(Integer moistureContent) {
		this.moistureContent = moistureContent;
	}
	
	public Double getDryYield() {
		return dryYield;
	}
	
	public void setDryYield(Double dryYield) {
		this.dryYield = dryYield;
	}
	
	public Double getPotential() {
		return potential;
	}
	
	public void setPotential(Double potential) {
		this.potential = potential;
	}
	
	public Integer getProtein() {
		return protein;
	}
	
	public void setProtein(Integer protein) {
		this.protein = protein;
	}
	
	public Integer getMaxInBatch() {
		return maxInBatch;
	}
	
	public void setMaxInBatch(Integer maxInBatch) {
		this.maxInBatch = maxInBatch;
	}
	
	public Character getRequiresMashing() {
		return requiresMashing;
	}
	
	public void setRequiresMashing(Character requiresMashing) {
		this.requiresMashing = requiresMashing;
	}
	
	public List<Characteristic> getCharacteristics() {
		return characteristics;
	}
	
	public void setCharacteristics(List<Characteristic> characteristics) {
		this.characteristics = characteristics;
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
	
	public Srm getSrm() {
		return srm;
	}
	
	public void setSrm(Srm srm) {
		this.srm = srm;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Fermentable [id=" + id + ", name=" + name + ", description=" + description + ", countryOfOrigin="
				+ countryOfOrigin + ", srmId=" + srmId + ", srmPrecise=" + srmPrecise + ", moistureContent="
				+ moistureContent + ", dryYield=" + dryYield + ", potential=" + potential + ", protein=" + protein
				+ ", maxInBatch=" + maxInBatch + ", requiresMashing=" + requiresMashing + ", characteristics="
				+ characteristics + ", category=" + category + ", categoryDisplay=" + categoryDisplay + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", srm=" + srm + ", country=" + country + "]";
	}
	
}
