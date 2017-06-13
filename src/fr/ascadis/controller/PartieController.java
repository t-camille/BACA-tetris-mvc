package fr.ascadis.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ascadis.dao.IDAO;
import fr.ascadis.model.Joueur;
import fr.ascadis.model.Partie;

@Controller
@RequestMapping("/partie")
public class PartieController
{
	@Autowired
	private IDAO<Partie, Integer> partieDAO;
	
	
	@RequestMapping("")
	public String getAll(Model model) {
		model.addAttribute("parties", this.partieDAO.findAll());
		
		return "parties";
	}
	
	
	@RequestMapping("/add")
	public String add(HttpSession session) {
		Partie myPartie = new Partie();
		
		try {
			myPartie.setDate(new Date());
			myPartie.setJoueurA((Joueur)session.getAttribute("utilisateur"));
			this.partieDAO.save(myPartie);
		}
		
		catch (Exception ex) { ; }
		
		return "redirect:/partie";
	}
	
	
	
	@RequestMapping("/join/{id}")
	public String join(@PathVariable("id") int partieId, HttpSession session) {
		Partie myPartie = this.partieDAO.find(partieId);
		
		if (myPartie != null) {
			myPartie.setJoueurB((Joueur)session.getAttribute("utilisateur"));
			this.partieDAO.save(myPartie);
		}
		
		return "redirect:/partie";
	}
}