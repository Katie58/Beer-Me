package co.finalfour.beerme.entity.response;

import co.finalfour.beerme.entity.beer.Ingredient;

public class IngredientSingleResponse {

	private String message;
	private String errorMessage;
	private String status;
	private Ingredient data;
	
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
	
	public Ingredient getData() {
		return data;
	}
	
	public void setData(Ingredient data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "IngredientSingleResponse [message=" + message + ", errorMessage=" + errorMessage + ", status=" + status
				+ ", data=" + data + "]";
	}

}
