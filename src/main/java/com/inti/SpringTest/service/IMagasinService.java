package com.inti.SpringTest.service;

import java.util.List;

import com.inti.SpringTest.model.Magasin;

public interface IMagasinService {
	
	public List<Magasin> getMagasins();
	public void saveMagasin(Magasin m);
	public Magasin getMagasin(int id);
	public void deleteMagasin(int id);
	public Magasin updateMagasin(Magasin m);

}
