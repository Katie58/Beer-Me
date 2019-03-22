package co.finalfour.beerme.entity.beer;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Srm {
	
	@Column(name = "srmId", unique = true)
	private Long id;
	@Column(name = "srmName")
	private String name;
	@Column(name = "srmHex")
	private String hex;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHex() {
		return hex;
	}
	
	public void setHex(String hex) {
		this.hex = hex;
	}

	@Override
	public String toString() {
		return "Srm [id=" + id + ", name=" + name + ", hex=" + hex + "]";
	}
	
}
