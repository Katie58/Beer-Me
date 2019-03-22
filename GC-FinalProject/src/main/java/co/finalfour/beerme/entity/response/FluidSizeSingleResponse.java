package co.finalfour.beerme.entity.response;

import co.finalfour.beerme.entity.beer.FluidSize;

public class FluidSizeSingleResponse {

	private String message;
	private String errorMessage;
	private String status;
	private FluidSize data;
	
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
	
	public FluidSize getData() {
		return data;
	}
	
	public void setData(FluidSize data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "FluidSizeSingleResponse [message=" + message + ", errorMessage=" + errorMessage + ", status=" + status
				+ ", data=" + data + "]";
	}

}
