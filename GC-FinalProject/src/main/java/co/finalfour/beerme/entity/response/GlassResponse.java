package co.finalfour.beerme.entity.response;

import java.util.List;

import co.finalfour.beerme.entity.beer.Glass;

public class GlassResponse {

   	private String message;
   	private List<Glass> data;
   	private String status;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Glass> getData() {
		return data;
	}
	
	public void setData(List<Glass> data) {
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
		return "GlassResponse [data=" + data
				+ ", status=" + status + "]";
	}
		
}
