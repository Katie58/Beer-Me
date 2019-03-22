package co.finalfour.beerme.entity.populatetables;

import java.util.List;

public class HopResponse {

   	private Integer currentPage;
   	private List<Hop> data;
   	private Integer numberOfPages;
   	private String status;
   	private Integer totalResults;
   	
	public Integer getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public List<Hop> getData() {
		return data;
	}
	
	public void setData(List<Hop> data) {
		this.data = data;
	}
	
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getTotalResults() {
		return totalResults;
	}
	
	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	@Override
	public String toString() {
		return "HopResponse [currentPage=" + currentPage + ", data=" + data + ", numberOfPages=" + numberOfPages
				+ ", status=" + status + ", totalResults=" + totalResults + "]";
	}
	
}
