package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "colour.all", query = "Select k from Colour k")
})

public class Colour {
	@Id
	@GeneratedValue
	private Long id;
	
	private String nameOfColour;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameOfColour() {
		return nameOfColour;
	}

	public void setNameOfColour(String nameOfColour) {
		this.nameOfColour = nameOfColour;
	}
}
