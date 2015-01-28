package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.*;

@Stateless
public class WineManager {

		@PersistenceContext
		EntityManager em;
		
		public void addWine(Wine wine){
			wine.setId(null);
			em.persist(wine);
		}
		
		
		public void deleteWine(Wine wine){
			wine = em.find(Wine.class, wine.getId());
			em.remove(wine);
		}
		
		@SuppressWarnings("unchecked")
		public List<Wine> getAllWines(){
			return em.createNamedQuery("wine.all").getResultList();
		}
}
