package co.finalfour.beerme.entity.response;

import co.finalfour.beerme.entity.beer.Beer;

public class BeerSingleResponse {

	private String message;
	private String errorMessage;
	private String status;
	private Beer data;
	
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
	
	public Beer getData() {
		return data;
	}
	
	public void setData(Beer data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BeerSingleResponse [message=" + message + ", errorMessage=" + errorMessage + ", status=" + status
				+ ", data=" + data + "]";
	}
	
}
