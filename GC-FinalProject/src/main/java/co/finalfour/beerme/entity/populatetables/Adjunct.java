package co.finalfour.beerme.entity.populatetables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NaturalId;

@Entity
public class Adjunct {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tableId;
	
	@NaturalId
	@Column(unique = true)
	private Long id;
	private String name;
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

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "Adjunct [id=" + id + ", name=" + name + ", category=" + category + ", categoryDisplay="
				+ categoryDisplay + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
		
}
