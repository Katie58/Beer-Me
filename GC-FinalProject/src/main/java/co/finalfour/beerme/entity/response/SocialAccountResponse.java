package co.finalfour.beerme.entity.response;

import java.util.List;

import co.finalfour.beerme.entity.apigeneral.SocialAccount;

public class SocialAccountResponse {

	private String message;
	private List<SocialAccount> data;
	private String status;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<SocialAccount> getData() {
		return data;
	}
	
	public void setData(List<SocialAccount> data) {
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
		return "SocialAccountResponse [message=" + message + ", data=" + data + ", status=" + status + "]";
	}
	
}
