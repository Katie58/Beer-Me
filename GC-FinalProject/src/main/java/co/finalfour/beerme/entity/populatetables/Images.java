package co.finalfour.beerme.entity.populatetables;

import javax.persistence.Embeddable;

@Embeddable
public class Images{
	
	private String icon;//brewery,beer,guild
	private String medium;//brewery,beer,guild
	private String large;//brewery,beer,guild
	private String squareMedium;//brewery,guild
	private String squareLarge;//brewery,guild
	private String contentAwareIcon;//beer
	private String contentAwareMedium;//beer
	private String contentAwareLarge;//beer

	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getMedium() {
		return medium;
	}
	
	public void setMedium(String medium) {
		this.medium = medium;
	}
	
	public String getLarge() {
		return large;
	}
	
	public void setLarge(String large) {
		this.large = large;
	}
	
	public String getSquareMedium() {
		return squareMedium;
	}
	
	public void setSquareMedium(String squareMedium) {
		this.squareMedium = squareMedium;
	}
	
	public String getSquareLarge() {
		return squareLarge;
	}
	
	public void setSquareLarge(String squareLarge) {
		this.squareLarge = squareLarge;
	}
	
	public String getContentAwareIcon() {
		return contentAwareIcon;
	}
	
	public void setContentAwareIcon(String contentAwareIcon) {
		this.contentAwareIcon = contentAwareIcon;
	}
	
	public String getContentAwareMedium() {
		return contentAwareMedium;
	}
	
	public void setContentAwareMedium(String contentAwareMedium) {
		this.contentAwareMedium = contentAwareMedium;
	}
	
	public String getContentAwareLarge() {
		return contentAwareLarge;
	}
	
	public void setContentAwareLarge(String contentAwareLarge) {
		this.contentAwareLarge = contentAwareLarge;
	}

	@Override
	public String toString() {
		return "Images [icon=" + icon + ", medium=" + medium + ", large=" + large + ", squareMedium=" + squareMedium
				+ ", squareLarge=" + squareLarge + ", contentAwareIcon=" + contentAwareIcon + ", contentAwareMedium="
				+ contentAwareMedium + ", contentAwareLarge=" + contentAwareLarge + "]";
	}
	
}
