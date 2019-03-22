package co.finalfour.beerme.entity.response;

import co.finalfour.beerme.entity.beer.Category;

public class CategorySingleResponse {

	private String message;
	private String errorMessage;
	private String status;
	private Category data;
	
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
	
	public Category getData() {
		return data;
	}
	
	public void setData(Category data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CategorySingleResponse [message=" + message + ", errorMessage=" + errorMessage + ", status=" + status
				+ ", data=" + data + "]";
	}
	
}
