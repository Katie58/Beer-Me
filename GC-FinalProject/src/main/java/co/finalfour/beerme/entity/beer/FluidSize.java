package co.finalfour.beerme.entity.beer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class FluidSize {
	
	@Column(name = "fluidSizeId")
    private Long id;
    private String volume;
    private String volumeDisplay;
    private String quantity;
    
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
	
	public String getVolume() {
		return volume;
	}
	
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	public String getVolumeDisplay() {
		return volumeDisplay;
	}
	
	public void setVolumeDisplay(String volumeDisplay) {
		this.volumeDisplay = volumeDisplay;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
		return "FluidSize [id=" + id + ", volume=" + volume + ", volumeDisplay=" + volumeDisplay + ", quantity="
				+ quantity + "]";
	}
	
}
