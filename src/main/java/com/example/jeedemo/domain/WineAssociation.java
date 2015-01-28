package com.example.jeedemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "wine.boughtByCast", query = "select w from Wine w")
@Table(name= "WINE_CUSTOMER")
@IdClass(WineAssociationId.class)
public class WineAssociation {
	
	@Id
	private Long customerId;
	@Id
	private Long wineId;
	@Column(name = "STATUS")
	private String status;
	
	public String getStatus(){
		return status;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="WINEID", referencedColumnName="ID")
	
	private Wine wine;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="CUSTOMERID", referencedColumnName="ID")

	private Customer customer;
}
