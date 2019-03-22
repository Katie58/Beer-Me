package co.finalfour.beerme.entity.response;

import java.util.List;

import co.finalfour.beerme.entity.beer.FluidSize;

public class FluidSizeResponse {

	private Integer currentPage;
	private Integer numberOfPages;
	private Integer totalResults;
	private List<FluidSize> data;
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
	
	public List<FluidSize> getData() {
		return data;
	}
	
	public void setData(List<FluidSize> data) {
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
		return "FluidSizeResponse [currentPage=" + currentPage + ", numberOfPages=" + numberOfPages + ", totalResults="
				+ totalResults + ", data=" + data + ", status=" + status + "]";
	}
	
}
