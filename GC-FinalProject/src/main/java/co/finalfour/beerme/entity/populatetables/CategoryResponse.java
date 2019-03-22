package co.finalfour.beerme.entity.populatetables;

import java.util.List;

public class CategoryResponse {

   	private String message;
   	private List<Category> data;
   	private String status;
   	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<Category> getData() {
		return data;
	}
	
	public void setData(List<Category> data) {
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
		return "CategoryResponse [data=" + data
				+ ", status=" + status + "]";
	}
	
}
