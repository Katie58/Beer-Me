package co.finalfour.beerme.entity.response;

import co.finalfour.beerme.entity.beer.Adjunct;

public class AdjunctSingleResponse {

	private String message;
	private String errorMessage;
	private String status;
	private Adjunct data;
	
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
	
	public Adjunct getData() {
		return data;
	}
	
	public void setData(Adjunct data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "AdjunctSingleResponse [message=" + message + ", errorMessage=" + errorMessage + ", status=" + status
				+ ", data=" + data + "]";
	}
	
}
