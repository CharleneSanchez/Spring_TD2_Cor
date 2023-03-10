package com.inti.SpringTest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.SpringTest.model.Produit;
import com.inti.SpringTest.util.FonctionnalitesUtiles;

@Service
public class ProduitServiceImpl implements IProduitService {

	@Override
	public List<Produit> getProduits() {
		List<Produit> listeProduits = null;
		
		try
		{
			FonctionnalitesUtiles.session.beginTransaction();
			
			listeProduits = FonctionnalitesUtiles.session.createQuery("from Produit", Produit.class).list();
			
			FonctionnalitesUtiles.session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			FonctionnalitesUtiles.session.getTransaction().rollback();
		}
		
		return listeProduits;
	}

	@Override
	public void saveProduit(Produit p) {
		try
		{
			FonctionnalitesUtiles.session.beginTransaction();
			
			FonctionnalitesUtiles.session.save(p);
			
			FonctionnalitesUtiles.session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			FonctionnalitesUtiles.session.getTransaction().rollback();
		}
		
	}

	@Override
	public Produit getProduit(int id) {
		Produit prod = null;
		try
		{
			FonctionnalitesUtiles.session.beginTransaction();
			
			prod = FonctionnalitesUtiles.session.get(Produit.class, id);
			
			FonctionnalitesUtiles.session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			FonctionnalitesUtiles.session.getTransaction().rollback();
		}
		return prod;
	}

	@Override
	public void deleteProduit(int id) {
		try
		{
			FonctionnalitesUtiles.session.beginTransaction();
			
			FonctionnalitesUtiles.session.delete(FonctionnalitesUtiles.session.get(Produit.class, id));
			
			FonctionnalitesUtiles.session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			FonctionnalitesUtiles.session.getTransaction().rollback();
		}
		
	}
	
	

}
