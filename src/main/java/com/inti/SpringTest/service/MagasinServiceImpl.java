package com.inti.SpringTest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.SpringTest.model.Magasin;
import com.inti.SpringTest.util.FonctionnalitesUtiles;

@Service
public class MagasinServiceImpl implements IMagasinService {
	
	@Override
	public List<Magasin> getMagasins() {
		List<Magasin> listeMagasins = null;
		
		try
		{
			FonctionnalitesUtiles.session.beginTransaction();
			
			listeMagasins = FonctionnalitesUtiles.session.createQuery("from Magasin", Magasin.class).list();
			
			FonctionnalitesUtiles.session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			FonctionnalitesUtiles.session.getTransaction().rollback();
		}
		
		return listeMagasins;
	}

	@Override
	public void saveMagasin(Magasin m) {
		try
		{
			FonctionnalitesUtiles.session.beginTransaction();
			
			
			FonctionnalitesUtiles.session.save(m);
			
			FonctionnalitesUtiles.session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			FonctionnalitesUtiles.session.getTransaction().rollback();
		}
		
	}

	@Override
	public Magasin getMagasin(int id) {
		Magasin prod = null;
		try
		{
			FonctionnalitesUtiles.session.beginTransaction();
			
			prod = FonctionnalitesUtiles.session.get(Magasin.class, id);
			
			FonctionnalitesUtiles.session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			FonctionnalitesUtiles.session.getTransaction().rollback();
		}
		return prod;
	}

	@Override
	public void deleteMagasin(int id) {
		try
		{
			FonctionnalitesUtiles.session.beginTransaction();
			
			FonctionnalitesUtiles.session.delete(FonctionnalitesUtiles.session.get(Magasin.class, id));
			
			FonctionnalitesUtiles.session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			FonctionnalitesUtiles.session.getTransaction().rollback();
		}
		
	}

	@Override
	public Magasin updateMagasin(Magasin m) {
		try
		{
			FonctionnalitesUtiles.session.beginTransaction();
			
			FonctionnalitesUtiles.session.update(m);
			
			FonctionnalitesUtiles.session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			FonctionnalitesUtiles.session.getTransaction().rollback();
		}
		
		return m;
	}

}
