package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Colour;

@Stateless
public class ColourManager {
	
	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Colour> getAllColours(){
		return em.createNamedQuery("colour.all").getResultList();
	}
}
