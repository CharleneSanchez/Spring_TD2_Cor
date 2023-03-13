package com.inti.SpringTest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.SpringTest.model.Magasin;
import com.inti.SpringTest.model.Produit;
import com.inti.SpringTest.service.IMagasinService;
import com.inti.SpringTest.service.IProduitService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	IMagasinService ims;
	
	@Autowired
	IProduitService ips;
	
	@GetMapping("associerProduitsToMagasins")
	public String associerProduitsToMagasins(Model m)
	{
		m.addAttribute("listeM", ims.getMagasins());
		
		m.addAttribute("listeP", ips.getProduits());
		
		return "associerProduitsToMagasins";
	}
	
	@PostMapping("affecterProduitsToMagasins")
	public String affecterProduitsToMagasins(@RequestParam("selectedProduits") List<Integer> listeIdP,
			@RequestParam("selectedMagasins") List<Integer> listeIdM)
	{
		System.out.println("liste Id produit : " + listeIdP);
		System.out.println("liste Id magasin : " + listeIdM);
		
		List<Produit> listeProduit = new ArrayList<>();
		
		for (Integer idP : listeIdP) {
			listeProduit.add(ips.getProduit(idP));
		}
		
		List<Magasin> listeMagasin = new ArrayList<>();
		
		for (Integer idM : listeIdM) {
			listeMagasin.add(ims.getMagasin(idM));
		}
		
		for (Magasin magasin : listeMagasin) {
			// on récupère les anciens produits qu'on ajoute au nouveau, sinon ils sont supprimés !
			for (Produit p : magasin.getListeProduit()) {
				listeProduit.add(p);
			}
			
			magasin.setListeProduit(listeProduit);
			ims.updateMagasin(magasin);
		}
		
		
		return "redirect:/admin/associerProduitsToMagasins";
	}

}
