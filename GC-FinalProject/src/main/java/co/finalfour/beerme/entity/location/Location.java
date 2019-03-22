package co.finalfour.beerme.entity.location;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.finalfour.beerme.entity.apigeneral.Country;

@Entity
public class Location {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@NaturalId
	@Column(unique = true)
	@JsonProperty("id")
	private String locationId;
	private String name;
	private Integer yearOpened;
	private Integer yearClosed;
	private String locationType;
	private String locationTypeDisplay;
	private String streetAddress;
	private String locality;
	private String region;
	private String postalCode;
	private String phone;
	private String website;
	private Double latitude;
	private Double longitude;
	private Character isPrimary;
	private Character inPlanning;
	private Character isClosed;
	private Character openToPublic;
	@Type(type = "text")
	private String hoursOfOperation;
//	@Type(type = "text")
//	private String hoursOfOperationNotes;
//	@ElementCollection
//	private Map<String,Hours> hoursOfOperationExplicit;
//	@Type(type = "text")
//	private String hoursOfOperationExplicitString;
	private String timezoneId;
	private Double distance;
	
	@Transient
	private String status;
	@Transient
	private String statusDisplay;
	@Transient
	private String createDate;
	@Transient
	private String updateDate;
	
	//one to one
	private String breweryId;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "breweryLocations",
            referencedColumnName = "breweryId")
	private Brewery brewery;
	
	@Embedded @Type(type = "Country")
	private Country country;
	@Transient
	private String countryIsoCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYearOpened() {
		return yearOpened;
	}

	public void setYearOpened(Integer yearOpened) {
		this.yearOpened = yearOpened;
	}

	public Integer getYearClosed() {
		return yearClosed;
	}

	public void setYearClosed(Integer yearClosed) {
		this.yearClosed = yearClosed;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getLocationTypeDisplay() {
		return locationTypeDisplay;
	}

	public void setLocationTypeDisplay(String locationTypeDisplay) {
		this.locationTypeDisplay = locationTypeDisplay;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryIsoCode() {
		return countryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Character getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Character isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Character getInPlanning() {
		return inPlanning;
	}

	public void setInPlanning(Character inPlanning) {
		this.inPlanning = inPlanning;
	}

	public Character getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(Character isClosed) {
		this.isClosed = isClosed;
	}

	public Character getOpenToPublic() {
		return openToPublic;
	}

	public void setOpenToPublic(Character openToPublic) {
		this.openToPublic = openToPublic;
	}

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

	public String getHoursOfOperation() {
		return hoursOfOperation;
	}

	public void setHoursOfOperation(String hoursOfOperation) {
		this.hoursOfOperation = hoursOfOperation;
	}

//	public String getHoursOfOperationNotes() {
//		return hoursOfOperationNotes;
//	}
//
//	public void setHoursOfOperationNotes(String hoursOfOperationNotes) {
//		this.hoursOfOperationNotes = hoursOfOperationNotes;
//	}
//
//	public Map<String, Hours> getHoursOfOperationExplicit() {
//		return hoursOfOperationExplicit;
//	}
//
//	public void setHoursOfOperationExplicit(Map<String, Hours> hoursOfOperationExplicit) {
//		this.hoursOfOperationExplicit = hoursOfOperationExplicit;
//	}
//
//	public String getHoursOfOperationExplicitString() {
//		return hoursOfOperationExplicitString;
//	}
//
//	public void setHoursOfOperationExplicitString(String hoursOfOperationExplicitString) {
//		this.hoursOfOperationExplicitString = hoursOfOperationExplicitString;
//	}

	public String getTimezoneId() {
		return timezoneId;
	}

	public void setTimezoneId(String timezoneId) {
		this.timezoneId = timezoneId;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
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
		return  name + (yearOpened == null ? "": " - Established " + yearOpened) + " : "
				+ locality + ", " + region + " " + postalCode + " " + country.getDisplayName()
				+ (inPlanning == 'Y' ? "Coming Soon! ": " ") 
				+ (isClosed == 'Y' ? "Sorry, this location is closed. ": " ")
				+ (isPrimary == 'Y' ? "Primary Location ": " ")
				+ locationTypeDisplay
				+ (openToPublic == 'Y' ? " Open to the public. ": " ");

	}
	
}
