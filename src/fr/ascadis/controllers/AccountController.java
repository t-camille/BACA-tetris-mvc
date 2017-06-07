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
import org.springframework.web.bind.annotation.RequestParam;

import fr.ascadis.model.Joueur;
import fr.ascadis.model.Spectateur;
import fr.ascadis.model.Utilisateur;
import fr.ascadis.model.noentity.InscriptionUtilisateur;

/*Ce contrôleur remplacera les Servlets suivantes :

			-LoginServlet
			-SubscribeServlet
			-LogoutServlet
			*/
@Controller
@RequestMapping("/account")
public class AccountController {
	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
	public String subscribe() {
		return "subscribe";
	}

	@RequestMapping(value="/subscribe", method=RequestMethod.POST)
	public String subscribe(@Valid @ModelAttribute("inscription") InscriptionUtilisateur inscriptionUtilisateur, BindingResult result, Model model) {
		new PasswordCheckValidator().validate(inscriptionUtilisateur, result);

		if (!result.hasErrors()) {
			Utilisateur myUtilisateur = null;

			switch (inscriptionUtilisateur.getType()) {
				case "2": myUtilisateur = new Spectateur(); break;
				default: myUtilisateur = new Joueur(); break;
			}

			inscriptionUtilisateur.setProperties(myUtilisateur);
			this.sqlUtilisateurApplicationData.add(myUtilisateur);

			return "redirect:/home";
		}

		return "subscribe";
	}

	@ModelAttribute("user")
	public Utilisateur initUtilisateur() {
		Utilisateur myUtilisateur = new Utilisateur() {
		};
		return myUtilisateur;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new PasswordCheckValidator());
	}

	@RequestMapping(value = "/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "Login";

	}
}