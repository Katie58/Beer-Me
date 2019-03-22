package co.finalfour.beerme.entity.beer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Embeddable
public class Category{
	
	@Column(name = "categoryId", unique = true)
	private Long id;
	@Column(name = "categoryName")
	private String name;
	@Type(type = "text")
	@Column(name = "categoryDescription")
	private String description;
	
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
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
	
}
