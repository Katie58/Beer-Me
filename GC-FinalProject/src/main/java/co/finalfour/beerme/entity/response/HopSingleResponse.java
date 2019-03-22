package co.finalfour.beerme.entity.response;

import co.finalfour.beerme.entity.beer.Hop;

public class HopSingleResponse {

	private String message;
	private String errorMessage;
	private String status;
	private Hop data;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Hop getData() {
		return data;
	}
	
	public void setData(Hop data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "HopSingleResponse [message=" + message + ", errorMessage=" + errorMessage + ", status=" + status
				+ ", data=" + data + "]";
	}

}
