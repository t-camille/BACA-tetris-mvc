package fr.ascadis.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Null;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.loader.custom.Return;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.ascadis.model.Joueur;
import fr.ascadis.model.Partie;
import fr.ascadis.model.Utilisateur;
import fr.ascadis.model.noentity.InscriptionUtilisateur;
import fr.ascadis.validator.PasswordCheckValidator;

/*Ce contrôleur remplacera les Servlets suivantes :
-PartieServlet
-AddPartieServlet
-JointPartieServlet
*/

@Controller
public class PartieController extends DataAccess {

	@RequestMapping(value = "/parties", method = RequestMethod.GET)
	public String afficherParties(Model model) {
		model.addAttribute("listeParties", getPartieDAO().findAll());
		return "Parties";
	}
	
	@RequestMapping(value="/addPartie", method=RequestMethod.GET)
	public String addPartie(HttpSession session){
		Partie myPartie = new Partie(); 
		
		myPartie.setDate(new Date());
		myPartie.setJoueurA((Joueur)session.getAttribute("utilisateur"));

		this.getPartieDAO().save(myPartie);
		return "redirect:/parties";
}
	
	@RequestMapping(value="/joinPartie", method= RequestMethod.GET)
	public String joinPartie(@RequestParam(value="partie_id") Integer partie_id, HttpSession session){
	
		Partie myPartie = this.getPartieDAO().find(partie_id);
		
		if (myPartie != null){
			myPartie.setJoueurB((Joueur)session.getAttribute("utilisateur"));
		}
		
		return "redirect:/parties";
	
	
	
	}
	
}
