package co.finalfour.beerme.entity.response;

import co.finalfour.beerme.entity.location.Location;

public class LocationSingleResponse {

	private String message;
	private Location data;
	private String status;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Location getData() {
		return data;
	}
	
	public void setData(Location data) {
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "LocationSingleResponse [message=" + message + ", data=" + data + ", status=" + status + "]";
	}
	
}
