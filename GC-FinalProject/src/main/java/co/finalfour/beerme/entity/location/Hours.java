package co.finalfour.beerme.entity.location;

import javax.persistence.Embeddable;

@Embeddable
public class Hours {
	
	private String startTime;
	private String endTime;

	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	@Override
	public String toString() {
		return "Hours [startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
}
