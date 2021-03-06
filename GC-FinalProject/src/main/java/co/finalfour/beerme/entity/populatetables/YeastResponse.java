package co.finalfour.beerme.entity.populatetables;

import java.util.List;

public class YeastResponse {

	private Integer currentPage;
	private Integer numberOfPages;
	private Integer totalResults;
	private List<Yeast> data;
	private String status;
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	public Integer getTotalResults() {
		return totalResults;
	}
	
	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}
	
	public List<Yeast> getData() {
		return data;
	}
	
	public void setData(List<Yeast> data) {
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
		return "YeastResponse [currentPage=" + currentPage + ", numberOfPages=" + numberOfPages + ", totalResults="
				+ totalResults + ", data=" + data + ", status=" + status + "]";
	}
	
}
