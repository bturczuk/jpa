package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Customer;
import com.example.jeedemo.domain.Wine;
import com.example.jeedemo.domain.WineAssociation;

@Stateless
public class BuyingManager {

	@PersistenceContext
	EntityManager em;
	
	public void buyWine(Long customerId, Long wineId) {
		Customer customer = em.find(Customer.class, customerId);
		Wine wine = em.find(Wine.class, wineId);
		WineAssociation wa = new WineAssociation();
		wa.setStatus("Sold");
	}
	
	@SuppressWarnings("unchecked")
	public List<Wine> getSoldWines() {
		return em.createNamedQuery("wine.sold").getResultList();
	}
	
	public void disposeWine(Customer customer, Wine wine) {
		customer = em.find(Customer.class, customer.getId());
		wine = em.find(Wine.class, wine.getId());
		
		Wine toRemove = null;
	} 
}
