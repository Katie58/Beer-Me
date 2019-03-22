package co.finalfour.beerme.entity.beer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Embeddable
public class Ingredient {
	
	@Column(name = "ingredientId")
	private Long id;
	@Column(name = "ingredientName")
	private String name;
	@Type(type = "text")
	@Column(name = "ingredientDescription")
	private String description;
	@Column(name = "ingredientCategory")
	private String category;
	@Column(name = "ingredientCategoryDisplay")
	private String categoryDisplay;
	
	@Transient
	private String createDate;
	@Transient
	private String updateDate;

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

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", categoryDisplay=" + categoryDisplay + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ "]";
	}

}
