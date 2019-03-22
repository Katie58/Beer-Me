package co.finalfour.beerme.entity.response;

import co.finalfour.beerme.entity.location.AlternateName;

public class AlternateNameResponse {

	private String message;
	private String status;
	private AlternateName data;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public AlternateName getData() {
		return data;
	}
	
	public void setData(AlternateName data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "AlternateNameResponse [message=" + message + ", status=" + status + ", data=" + data + "]";
	}
	
}
