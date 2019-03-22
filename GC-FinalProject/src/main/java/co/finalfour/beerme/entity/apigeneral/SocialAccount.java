package co.finalfour.beerme.entity.apigeneral;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import co.finalfour.beerme.entity.beer.Beer;
import co.finalfour.beerme.entity.location.Brewery;

@Embeddable
public class SocialAccount {

	@Column(name = "socialId")
	private Long id;
	private String handle;
	private String link;
	
	@Transient
	private String createDate;
	@Transient
	private String updateDate;
	
	//many to one
	@Embedded @Type(type = "SocialSite")
	private SocialSite socialMedia;
	private Long socialMediaId;
	
	@Transient
	private Beer beer;/////////////////////////////////////
	@Transient
	private String beerId;
	
	@Transient
	private Brewery brewery;///////////////////////////////
	@Transient
	private String breweryId;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getSocialMediaId() {
		return socialMediaId;
	}
	
	public void setSocialMediaId(Long socialMediaId) {
		this.socialMediaId = socialMediaId;
	}
	
	public SocialSite getSocialMedia() {
		return socialMedia;
	}
	
	public void setSocialMedia(SocialSite socialMedia) {
		this.socialMedia = socialMedia;
	}
	
	public String getHandle() {
		return handle;
	}
	
	public void setHandle(String handle) {
		this.handle = handle;
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
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getBeerId() {
		return beerId;
	}
	
	public void setBeerId(String beerId) {
		this.beerId = beerId;
	}
	
	public Beer getBeer() {
		return beer;
	}
	
	public void setBeer(Beer beer) {
		this.beer = beer;
	}
	
	public String getBreweryId() {
		return breweryId;
	}
	
	public void setBreweryId(String breweryId) {
		this.breweryId = breweryId;
	}
	
	public Brewery getBrewery() {
		return brewery;
	}
	
	public void setBrewery(Brewery brewery) {
		this.brewery = brewery;
	}
	
	@Override
	public String toString() {
		return "SocialAccount [id=" + id + ", socialMediaId=" + socialMediaId + ", socialMedia=" + socialMedia
				+ ", handle=" + handle + ", createDate=" + createDate + ", updateDate=" + updateDate + ", link=" + link + ", beerId=" + beerId
				+ ", beer=" + beer + ", breweryId=" + breweryId + ", brewery=" + brewery + "]";
	}
	
}
