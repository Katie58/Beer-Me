package co.finalfour.beerme.entity.location;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.finalfour.beerme.entity.apigeneral.Images;
import co.finalfour.beerme.entity.apigeneral.SocialAccount;
import co.finalfour.beerme.entity.beer.Beer;

@Entity
public class Brewery implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@NaturalId
	@JsonProperty("id")
	private String breweryId;
	@JsonProperty("name")
	private String breweryName;
	@JsonProperty("nameShortDisplay")
	private String breweryNameShortDisplay;
	@Type(type = "text")
	@JsonProperty("description")
	private String breweryDescription;
	@JsonProperty("website")
	private String breweryWebsite;
	@JsonProperty("brandClassification")
	private String breweryBrandClassification;
	@JsonProperty("established")
	private Integer breweryEstablished;
	@JsonProperty("isOrganic")
	private Character breweryIsOrganic;
	@JsonProperty("isMassOwned")
	private Character breweryIsMassOwned;
	@JsonProperty("isInBusiness")
	private Character breweryIsInBusiness;
	@JsonProperty("isVerified")
	private Character breweryIsVerified;
	
	@Transient
	private String status;
	@Transient
	private String statusDisplay;
	@Transient
	private String createDate;
	@Transient
	private String updateDate;
	
	//one to one, owner
	@Embedded @Type(type = "Images")
	@JsonProperty("images")
	private Images breweryImages;
    
	@Embedded @Type(type = "Guild")
	private Guild brewersAssociation;
	@Transient
	private String brewersAssociationId;
	
	//one to many
	@OneToMany(cascade = CascadeType.ALL, 
			orphanRemoval = true)
	@JoinColumn(
            name = "breweryLocations",
            referencedColumnName = "breweryId")
	private List<Location> locations;
	private Character withLocations;
	
	@ElementCollection
	private List<Guild> guilds;
	private Character withGuilds;
	
	@ElementCollection
	private List<SocialAccount> socialAccounts;
	private Character withSocialAccounts;
	
	@ElementCollection
	private List<AlternateName> alternateNames;
	private Character withAlternateNames;
	
	//added
	private Integer rating;

	//added
    @ManyToMany(mappedBy="breweries",
	cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Beer> beers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBreweryId() {
		return breweryId;
	}

	public void setBreweryId(String breweryId) {
		this.breweryId = breweryId;
	}

	public String getBreweryName() {
		return breweryName;
	}

	public void setBreweryName(String breweryName) {
		this.breweryName = breweryName;
	}

	public String getBreweryNameShortDisplay() {
		return breweryNameShortDisplay;
	}

	public void setBreweryNameShortDisplay(String breweryNameShortDisplay) {
		this.breweryNameShortDisplay = breweryNameShortDisplay;
	}

	public String getBreweryDescription() {
		return breweryDescription;
	}

	public void setBreweryDescription(String breweryDescription) {
		this.breweryDescription = breweryDescription;
	}

	public String getBreweryWebsite() {
		return breweryWebsite;
	}

	public void setBreweryWebsite(String breweryWebsite) {
		this.breweryWebsite = breweryWebsite;
	}

	public String getBreweryBrandClassification() {
		return breweryBrandClassification;
	}

	public void setBreweryBrandClassification(String breweryBrandClassification) {
		this.breweryBrandClassification = breweryBrandClassification;
	}

	public Integer getBreweryEstablished() {
		return breweryEstablished;
	}

	public void setBreweryEstablished(Integer breweryEstablished) {
		this.breweryEstablished = breweryEstablished;
	}

	public Character getBreweryIsOrganic() {
		return breweryIsOrganic;
	}

	public void setBreweryIsOrganic(Character breweryIsOrganic) {
		this.breweryIsOrganic = breweryIsOrganic;
	}

	public Character getBreweryIsMassOwned() {
		return breweryIsMassOwned;
	}

	public void setBreweryIsMassOwned(Character breweryIsMassOwned) {
		this.breweryIsMassOwned = breweryIsMassOwned;
	}

	public Character getBreweryIsInBusiness() {
		return breweryIsInBusiness;
	}

	public void setBreweryIsInBusiness(Character breweryIsInBusiness) {
		this.breweryIsInBusiness = breweryIsInBusiness;
	}

	public Character getBreweryIsVerified() {
		return breweryIsVerified;
	}

	public void setBreweryIsVerified(Character breweryIsVerified) {
		this.breweryIsVerified = breweryIsVerified;
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

	public Images getBreweryImages() {
		return breweryImages;
	}

	public void setBreweryImages(Images breweryImages) {
		this.breweryImages = breweryImages;
	}

	public Guild getBrewersAssociation() {
		return brewersAssociation;
	}

	public void setBrewersAssociation(Guild brewersAssociation) {
		this.brewersAssociation = brewersAssociation;
	}

	public String getBrewersAssociationId() {
		return brewersAssociationId;
	}

	public void setBrewersAssociationId(String brewersAssociationId) {
		this.brewersAssociationId = brewersAssociationId;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Character getWithLocations() {
		return withLocations;
	}

	public void setWithLocations(Character withLocations) {
		this.withLocations = withLocations;
	}

	public List<Guild> getGuilds() {
		return guilds;
	}

	public void setGuilds(List<Guild> guilds) {
		this.guilds = guilds;
	}

	public Character getWithGuilds() {
		return withGuilds;
	}

	public void setWithGuilds(Character withGuilds) {
		this.withGuilds = withGuilds;
	}

	public List<SocialAccount> getSocialAccounts() {
		return socialAccounts;
	}

	public void setSocialAccounts(List<SocialAccount> socialAccounts) {
		this.socialAccounts = socialAccounts;
	}

	public Character getWithSocialAccounts() {
		return withSocialAccounts;
	}

	public void setWithSocialAccounts(Character withSocialAccounts) {
		this.withSocialAccounts = withSocialAccounts;
	}

	public List<AlternateName> getAlternateNames() {
		return alternateNames;
	}

	public void setAlternateNames(List<AlternateName> alternateNames) {
		this.alternateNames = alternateNames;
	}

	public Character getWithAlternateNames() {
		return withAlternateNames;
	}

	public void setWithAlternateNames(Character withAlternateNames) {
		this.withAlternateNames = withAlternateNames;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public List<Beer> getBeers() {
		return beers;
	}

	public void setBeers(List<Beer> beers) {
		this.beers = beers;
	}

	@Override
	public String toString() {
		return "Brewery [id=" + id + ", breweryId=" + breweryId + ", breweryName=" + breweryName
				+ ", breweryNameShortDisplay=" + breweryNameShortDisplay + ", breweryDescription=" + breweryDescription
				+ ", breweryWebsite=" + breweryWebsite + ", breweryBrandClassification=" + breweryBrandClassification
				+ ", breweryEstablished=" + breweryEstablished + ", breweryIsOrganic=" + breweryIsOrganic
				+ ", breweryIsMassOwned=" + breweryIsMassOwned + ", breweryIsInBusiness=" + breweryIsInBusiness
				+ ", breweryIsVerified=" + breweryIsVerified + ", status=" + status + ", statusDisplay=" + statusDisplay
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", breweryImages=" + breweryImages
				+ ", brewersAssociation=" + brewersAssociation + ", brewersAssociationId=" + brewersAssociationId
				+ ", locations=" + locations + ", withLocations=" + withLocations + ", guilds=" + guilds
				+ ", withGuilds=" + withGuilds + ", socialAccounts=" + socialAccounts + ", withSocialAccounts="
				+ withSocialAccounts + ", alternateNames=" + alternateNames + ", withAlternateNames="
				+ withAlternateNames + ", rating=" + rating + ", beers=" + beers + "]";
	}
	
}
