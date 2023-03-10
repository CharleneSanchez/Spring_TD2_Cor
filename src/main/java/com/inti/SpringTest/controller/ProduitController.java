package com.inti.SpringTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("produit")
public class ProduitController {
	
	@GetMapping("affichage")
	public String affichageNomProduit(@RequestParam(value = "nom", required = true, defaultValue = "Samsung S23") String nom, Model m)
	{
		m.addAttribute("nom", nom);
		
		return "afficherNomProduit";
	}
	
	@GetMapping("prix")
	public String affichagePrixProduit(@RequestParam(value = "prix", required = true, defaultValue = "1099") double prix, Model m)
	{
		m.addAttribute("prix", prix);
		
		return "afficherPrixProduit";
	}

}
