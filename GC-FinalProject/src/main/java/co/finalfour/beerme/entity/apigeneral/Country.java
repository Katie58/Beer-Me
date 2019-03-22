package co.finalfour.beerme.entity.apigeneral;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Country{
	
   	private String isoCode;
   	private String isoThree;
   	private Integer numberCode;
	@Column(name = "countryName")
   	private String name;
	@Column(name = "countryDisplayName")
   	private String displayName;
	
	@Transient
   	private String createDate;
	@Transient
	private String updateDate;

	public String getIsoCode() {
		return isoCode;
	}
	
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	
	public String getIsoThree() {
		return isoThree;
	}
	
	public void setIsoThree(String isoThree) {
		this.isoThree = isoThree;
	}
	
	public Integer getNumberCode() {
		return numberCode;
	}
	
	public void setNumberCode(Integer numberCode) {
		this.numberCode = numberCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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
		return "Country [isoCode=" + isoCode + ", isoThree=" + isoThree + ", numberCode=" + numberCode + ", name="
				+ name + ", displayName=" + displayName + "]";
	}
	
}
