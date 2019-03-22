package co.finalfour.beerme.entity.beer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Adjunct {

	@Column(name = "adjunctId")
	private Long id;
	@Column(name = "adjunctName")
	private String name;
	@Column(name = "adjunctCategory")
	private String category;
	@Column(name = "adjunctCategoryDisplay")
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
		this.updateDate = createDate;
	}

	@Override
	public String toString() {
		return "Adjunct [id=" + id + ", name=" + name + ", category=" + category + ", categoryDisplay="
				+ categoryDisplay + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
		
}
