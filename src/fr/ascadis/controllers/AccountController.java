package fr.ascadis.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.ascadis.model.Joueur;
import fr.ascadis.model.Spectateur;
import fr.ascadis.model.Utilisateur;
import fr.ascadis.model.noentity.InscriptionUtilisateur;
import fr.ascadis.validator.PasswordCheckValidator;

/*Ce contrôleur remplacera les Servlets suivantes :

			-LoginServlet (ok)
			-SubscribeServlet (ok)
			-LogoutServlet (ok)
			*/
@Controller
public class AccountController extends DataAccess {
	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
	public String subscribe() {
		return "subscribe";
	}

	@RequestMapping(value="/subscribe", method=RequestMethod.POST)
	public String subscribe(@Valid @ModelAttribute("user") InscriptionUtilisateur inscriptionUtilisateur,
			BindingResult result, Model model) {
		

		new PasswordCheckValidator().validate(inscriptionUtilisateur, result);
		
		
		if (!result.hasErrors()) {
			Utilisateur myUtilisateur = null;
			
			
			
			switch (inscriptionUtilisateur.getType()) {
				case 2 : myUtilisateur = new Spectateur(); break;
				default: myUtilisateur = new Joueur(); break;
			}

			inscriptionUtilisateur.setProperties(myUtilisateur);
			this.getUtilisateurDAO().save(myUtilisateur);

			return "redirect:/login";
		}

		return "subscribe";
	}

	@ModelAttribute("user")
	public Utilisateur initUtilisateur() {
		return new InscriptionUtilisateur();
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new PasswordCheckValidator());
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";

	}
	
	@RequestMapping(value = "/login")
	public String login() {
		
		return "home";

	}
}