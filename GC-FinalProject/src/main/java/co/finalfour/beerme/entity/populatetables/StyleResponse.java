package co.finalfour.beerme.entity.populatetables;

import java.util.List;

public class StyleResponse {

   	private String message;
   	private List<Style> data;
   	private String status;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Style> getData() {
		return data;
	}
	
	public void setData(List<Style> data) {
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
		return "StyleResponse [data=" + data
				+ ", status=" + status + "]";
	}
	
}
