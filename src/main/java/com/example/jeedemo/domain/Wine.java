package com.example.jeedemo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "wine.all", query = "select w from Wine w"),

})
public class Wine {
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min = 2, max = 20)
	private String name;
	private double price;
	
	private String origin;
	
	private String region;

	@OneToMany(mappedBy = "wine")
	private List<Strains> strains;
	
	@OneToMany(mappedBy = "wine")
	private List<WineAssociation> customers;
	
	@OneToOne
	@JoinColumn(name="colour_id")
	private Colour colour;
	
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public long getId() {
		return id;
	}

	public void setId(Long  id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Strains> getStrains() {
		return strains;
	}

	public void setStrains(List<Strains> strains) {
		this.strains = strains;
	}
	
	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
