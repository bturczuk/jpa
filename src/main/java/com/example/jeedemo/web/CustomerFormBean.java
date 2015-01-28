package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Customer;
import com.example.jeedemo.domain.Wine;
import com.example.jeedemo.service.BuyingManager;
import com.example.jeedemo.service.CustomerManager;

@SessionScoped
@Named("customerBean")
public class CustomerFormBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Customer customer = new Customer();
	private ListDataModel<Customer> customers = new ListDataModel<Customer>();
	
	private Customer customerToShow = new Customer();
	private ListDataModel<Wine> boughtWines = new ListDataModel<Wine>();
	
	
	@Inject
	private CustomerManager cm;
	
	@Inject
	private BuyingManager bm;

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public ListDataModel<Customer> getAllCustomers(){
		customers.setWrappedData(cm.getAllCustomers());
		return customers;
	}
	
	public ListDataModel<Wine> getBoughtWines(){
		boughtWines.setWrappedData(cm.getBoughtWines(customerToShow));
		return boughtWines;
	}
	
	public String addCustomer(){
		cm.addCustomer(customer);
		return "showCustomers";
	}
	
	public String deleteCustomer(){
		Customer customerToDelete = customers.getRowData();
		cm.deleteCustomer(customerToDelete);
		return null;
	}
	
	public String showDetails(){
		customerToShow = customers.getRowData();
		return "details";
	}
	
	public String disposeWine(){
		Wine wineToDispose = boughtWines.getRowData();
		bm.disposeWine(customerToShow, wineToDispose);
		return null;
	}
}
