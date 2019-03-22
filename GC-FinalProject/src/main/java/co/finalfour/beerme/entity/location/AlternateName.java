package co.finalfour.beerme.entity.location;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class AlternateName {
	
	@Column(name = "altNameId")
	private Long id;
	private String altName;
	
	@Transient
	private String createDate;
	@Transient
	private String updateDate;
	
	//many to one
	@Transient
	private Brewery brewery;
	@Transient
	private String breweryId;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAltName() {
		return altName;
	}
	
	public void setAltName(String altName) {
		this.altName = altName;
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
		return "AlternateName [id=" + id + ", altName=" + altName
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
}
