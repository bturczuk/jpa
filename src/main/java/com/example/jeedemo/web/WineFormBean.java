package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Colour;
import com.example.jeedemo.domain.Wine;
import com.example.jeedemo.service.BuyingManager;
import com.example.jeedemo.service.ColourManager;
import com.example.jeedemo.service.WineManager;

@SessionScoped
@Named("wineBean")
public class WineFormBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Wine wine = new Wine();
	private ListDataModel<Wine> wines = new ListDataModel<Wine>();
	
	private Colour colour = new Colour();
	private ListDataModel<Colour> colours = new ListDataModel<Colour>();
	
	private Wine wineToShow = new Wine();
	private ListDataModel<Wine> boughtWines = new ListDataModel<Wine>();
	
	@Inject
	private WineManager wm;
	
	@Inject
	private BuyingManager bm;
	
	@Inject
	private ColourManager cm;

	public Wine getWine() {
		return wine;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
	}
	
	public ListDataModel<Wine> getAllWines(){
		wines.setWrappedData(wm.getAllWines());
		return wines;
	}
	
	public String addWine(){
		wm.addWine(wine);
		return "showWines";
	}
	
	public String deleteWine(){
		Wine wineToDelete = wines.getRowData();
		wm.deleteWine(wineToDelete);
		return null;
	}
	
	public String showDetails(){
		wineToShow = wines.getRowData();
		return "details";
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}
	
	public ListDataModel<Colour> getAllColours(){
		colours.setWrappedData(cm.getAllColours());
		System.out.println(colours.getRowData().getNameOfColour());
		return colours;
	}
}

