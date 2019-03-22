package co.finalfour.beerme.entity.beer;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class Available{

	@Column(name = "availableId")
   	private String id;
	@Column(name = "availableName")
   	private String name;
	@Column(name = "availableDescription")
   	@Type(type = "text")
   	private String description;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Available [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
}
