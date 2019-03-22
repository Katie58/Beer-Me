package co.finalfour.beerme.entity.populatetables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

@Entity
public class Yeast {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tableId;
	
	@NaturalId
	@Column(unique = true)
    private Long id;
    private String name;
    @Type(type = "text")
    private String description;
    private String yeastType;
    private Integer attenuationMin;
    private Integer attenuationMax;
    private Integer fermentTempMin;
    private Integer fermentTempMax;
    private Integer alcoholToleranceMin;
    private Integer alcoholToleranceMax;
    private String productId;
    private String supplier;
    private String yeastFormat;
    private String category;
    private String categoryDisplay;
    
	//added
	private Double ratio;
    
    @Transient
    private String createDate;
    @Transient
    private String updateDate;

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

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
	
	public String getYeastType() {
		return yeastType;
	}
	
	public void setYeastType(String yeastType) {
		this.yeastType = yeastType;
	}
	
	public Integer getAttenuationMin() {
		return attenuationMin;
	}
	
	public void setAttenuationMin(Integer attenuationMin) {
		this.attenuationMin = attenuationMin;
	}
	
	public Integer getAttenuationMax() {
		return attenuationMax;
	}
	
	public void setAttenuationMax(Integer attenuationMax) {
		this.attenuationMax = attenuationMax;
	}
	
	public Integer getFermentTempMin() {
		return fermentTempMin;
	}
	
	public void setFermentTempMin(Integer fermentTempMin) {
		this.fermentTempMin = fermentTempMin;
	}
	
	public Integer getFermentTempMax() {
		return fermentTempMax;
	}
	
	public void setFermentTempMax(Integer fermentTempMax) {
		this.fermentTempMax = fermentTempMax;
	}
	
	public Integer getAlcoholToleranceMin() {
		return alcoholToleranceMin;
	}
	
	public void setAlcoholToleranceMin(Integer alcoholToleranceMin) {
		this.alcoholToleranceMin = alcoholToleranceMin;
	}
	
	public Integer getAlcoholToleranceMax() {
		return alcoholToleranceMax;
	}
	
	public void setAlcoholToleranceMax(Integer alcoholToleranceMax) {
		this.alcoholToleranceMax = alcoholToleranceMax;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getSupplier() {
		return supplier;
	}
	
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	public String getYeastFormat() {
		return yeastFormat;
	}
	
	public void setYeastFormat(String yeastFormat) {
		this.yeastFormat = yeastFormat;
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

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "Yeast [id=" + id + ", name=" + name + ", description=" + description + ", yeastType=" + yeastType
				+ ", attenuationMin=" + attenuationMin + ", attenuationMax=" + attenuationMax + ", fermentTempMin="
				+ fermentTempMin + ", fermentTempMax=" + fermentTempMax + ", alcoholToleranceMin=" + alcoholToleranceMin
				+ ", alcoholToleranceMax=" + alcoholToleranceMax + ", productId=" + productId + ", supplier=" + supplier
				+ ", yeastFormat=" + yeastFormat + ", category=" + category + ", categoryDisplay=" + categoryDisplay
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
}
