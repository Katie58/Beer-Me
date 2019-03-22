package co.finalfour.beerme.entity.populatetables;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

@Entity
public class Guild {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tableId;
	
	@NaturalId
	@Column(unique = true)
	private String id;
	private String name;
	@Type(type = "text")
	private String description;
	private Integer established;
	private String website;
	
	//added
	private Double ratio;
	
	@Transient
	private String status;
	@Transient
	private String statusDisplay;
	@Transient
	private String createDate;
	@Transient
	private String updateDate;
	
	@Embedded @Type(type = "Images")
	private Images images;

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public Images getImages() {
		return images;
	}

	public void setImages(Images images) {
		this.images = images;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
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
	
	public Integer getEstablished() {
		return established;
	}
	
	public void setEstablished(Integer established) {
		this.established = established;
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
//	
//	public Images getImages() {
//		return images;
//	}
//	
//	public void setImages(Images images) {
//		this.images = images;
//	}
	
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
		return "Guild [id=" + id + ", name=" + name + ", description=" + description + ", established=" + established
				+ ", website=" + website + ", status=" + status + ", statusDisplay="
				+ statusDisplay + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
}
