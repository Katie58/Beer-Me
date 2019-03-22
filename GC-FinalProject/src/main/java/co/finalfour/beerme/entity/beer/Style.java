package co.finalfour.beerme.entity.beer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Embeddable
public class Style{
	
	@Column(name = "styleId")
	private Long id;
	@Column(name = "styleName")
	private String name;
	@Column(name = "styleShortName")
	private String shortName;
	@Type(type = "text")
	@Column(name = "styleDescription")
	private String description;
	@Column(name = "styleIbuMin")
	private Integer ibuMin;
	@Column(name = "styleIbuMax")
	private Integer ibuMax;
	@Column(name = "styleAbvMin")
	private Double abvMin;
	@Column(name = "styleAbvMax")
	private Double abvMax;
	@Column(name = "styleSrmMin")
	private Integer srmMin;
	@Column(name = "styleSrmMax")
	private Integer srmMax;
	@Column(name = "styleOgMin")
	private Double ogMin;
	@Column(name = "styleOgMax")
	private Double ogMax;
	@Column(name = "styleFgMin")
	private Double fgMin;
	@Column(name = "styleFgMax")
	private Double fgMax;
	
	@Transient
	private String createDate;
	@Transient
	private String updateDate;
	
	//many to one
	@Transient
	private Category category;
	@Transient
	private Long categoryId;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getIbuMin() {
		return ibuMin;
	}
	
	public void setIbuMin(Integer ibuMin) {
		this.ibuMin = ibuMin;
	}
	
	public Integer getIbuMax() {
		return ibuMax;
	}
	
	public void setIbuMax(Integer ibuMax) {
		this.ibuMax = ibuMax;
	}
	
	public Double getAbvMin() {
		return abvMin;
	}
	
	public void setAbvMin(Double abvMin) {
		this.abvMin = abvMin;
	}
	
	public Double getAbvMax() {
		return abvMax;
	}
	
	public void setAbvMax(Double abvMax) {
		this.abvMax = abvMax;
	}
	
	public Integer getSrmMin() {
		return srmMin;
	}
	
	public void setSrmMin(Integer srmMin) {
		this.srmMin = srmMin;
	}
	
	public Integer getSrmMax() {
		return srmMax;
	}
	
	public void setSrmMax(Integer srmMax) {
		this.srmMax = srmMax;
	}
	
	public Double getOgMin() {
		return ogMin;
	}
	
	public void setOgMin(Double ogMin) {
		this.ogMin = ogMin;
	}
	
	public Double getOgMax() {
		return ogMax;
	}
	
	public void setOgMax(Double ogMax) {
		this.ogMax = ogMax;
	}
	
	public Double getFgMin() {
		return fgMin;
	}
	
	public void setFgMin(Double fgMin) {
		this.fgMin = fgMin;
	}
	
	public Double getFgMax() {
		return fgMax;
	}
	
	public void setFgMax(Double fgMax) {
		this.fgMax = fgMax;
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

	@Override
	public String toString() {
		return "Style [id=" + id + ", categoryId=" + categoryId + ", category=" + category + ", name=" + name
				+ ", shortName=" + shortName + ", description=" + description + ", ibuMin=" + ibuMin + ", ibuMax="
				+ ibuMax + ", abvMin=" + abvMin + ", abvMax=" + abvMax + ", srmMin=" + srmMin + ", srmMax=" + srmMax
				+ ", ogMin=" + ogMin + ", ogMax=" + ogMax + ", fgMin=" + fgMin + ", fgMax=" + fgMax + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}
	
}
