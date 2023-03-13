package com.inti.SpringTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.SpringTest.model.Magasin;
import com.inti.SpringTest.service.IMagasinService;

@Controller
@RequestMapping("Magasin")
public class MagasinController {
	
	@Autowired
	IMagasinService ims;
	
	@GetMapping("ajout")
	public String ajoutMagasin()
	{
		return "ajoutMagasin";
	}
	
	@PostMapping("saveMagasin")
	public String enregistrerMagasin(@ModelAttribute("mag") Magasin m)
	{
		ims.saveMagasin(m);
		
		return "redirect:/Magasin/afficherMagasins";
	}
	
	@GetMapping("afficherMagasins")
	public String afficherMagasins(Model m)
	{
		m.addAttribute("listeM", ims.getMagasins());
		
		return "afficherMagasins";
	}
	
	@GetMapping("deleteMagasin/{id}")
	public String deleteMagasin(@PathVariable int id)
	{
		ims.deleteMagasin(id);
		return "redirect:/Magasin/afficherMagasins";
	}
	
	@GetMapping("getMagasin/{id}")
	public String getMagasin(@PathVariable int id, Model m)
	{
		m.addAttribute("Magasin", ims.getMagasin(id));
		
		return "updateMagasin";
	}

}
