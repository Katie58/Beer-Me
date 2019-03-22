package co.finalfour.beerme.entity.location;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Embeddable
public class Guild {
	
	@Column(name = "guildId")
	private String id;
	@Column(name = "guildName")
	private String name;
	@Type(type = "text")
	@Column(name = "guildDescription")
	private String description;
	@Column(name = "guildEstablished")
	private Integer established;
	@Column(name = "guildWebsite")
	private String website;
	
	@Transient
	private String status;
	@Transient
	private String statusDisplay;
	@Transient
	private String createDate;
	@Transient
	private String updateDate;
	
	//one to one
//	@Embedded @Type(type = "images")
//	@Column(name = "guildImages")
//	private Images images;

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

	@Override
	public String toString() {
		return "Guild [id=" + id + ", name=" + name + ", description=" + description + ", established=" + established
				+ ", website=" + website + ", status=" + status + ", statusDisplay="
				+ statusDisplay + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
}
