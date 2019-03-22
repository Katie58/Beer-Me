package co.finalfour.beerme.entity.response;

import co.finalfour.beerme.entity.beer.Style;

public class StyleSingleResponse {

	private String message;
	private String errorMessage;
	private String status;
	private Style data;
	
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
	
	public Style getData() {
		return data;
	}
	
	public void setData(Style data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "StyleSingleResponse [message=" + message + ", errorMessage=" + errorMessage + ", status=" + status
				+ ", data=" + data + "]";
	}
	
}
