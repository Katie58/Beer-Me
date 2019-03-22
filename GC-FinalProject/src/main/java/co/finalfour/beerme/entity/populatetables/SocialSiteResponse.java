package co.finalfour.beerme.entity.populatetables;

import java.util.List;

public class SocialSiteResponse {

	private String message;
	private List<SocialSite> data;
	private String status;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<SocialSite> getData() {
		return data;
	}
	
	public void setData(List<SocialSite> data) {
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
		return "SocialSiteResponse ["
				+ ", data=" + data + ", status=" + status + "]";
	}
	
}
