package com.example.jeedemo.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.example.jeedemo.domain.Customer;
import com.example.jeedemo.domain.Wine;
import com.example.jeedemo.domain.WineAssociation;

@Stateless
public class CustomerManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void addCustomer(Customer customer){
		customer.setId(null);
		em.persist(customer);
	}
	
	public void deleteCustomer(Customer customer){
		customer = em.find(Customer.class, customer.getId());
		em.remove(customer);
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers(){
		return em.createNamedQuery("customer.all").getResultList();
	}
	
	public List<Wine> getBoughtWines(Customer customer) {
		WineAssociation wa = new WineAssociation();
		customer = em.find(Customer.class, customer.getId());
		//List<Wine> wines = new ArrayList<Wine>(wa.getWines(customer.getId()));
		return null;
	}
}
