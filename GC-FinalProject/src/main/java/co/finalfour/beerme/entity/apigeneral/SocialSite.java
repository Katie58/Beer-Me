package co.finalfour.beerme.entity.apigeneral;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class SocialSite {

	@Column(name = "mediaId")
    private Long id;
	@Column(name = "mediaName")
    private String name;
	@Column(name = "mediaSite")
    private String website;
    
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
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
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
		return "SocialSite [id=" + id + ", name=" + name + ", website=" + website + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
	
}
