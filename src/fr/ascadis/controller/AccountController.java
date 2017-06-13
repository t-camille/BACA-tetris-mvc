package fr.ascadis.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.ascadis.dao.IUtilisateurDAO;
import fr.ascadis.exception.WrongUsernameOrPasswordException;
import fr.ascadis.model.Joueur;
import fr.ascadis.model.Spectateur;
import fr.ascadis.model.Utilisateur;
import fr.ascadis.model.noentity.InscriptionUtilisateur;
import fr.ascadis.validator.PasswordCheckValidator;

@Controller
@RequestMapping("/account")
public class AccountController
{
	@Autowired
	private IUtilisateurDAO utilisateurDAO;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("user") Utilisateur utilisateur, BindingResult result, Model model, HttpSession session) {
		if ((!result.hasErrors()) || (result.getErrorCount() == 2)) {
			try {
				utilisateur = this.utilisateurDAO.auth(utilisateur.getUsername(), utilisateur.getPassword());
				
				if (utilisateur != null) {
					session.setAttribute("utilisateur", utilisateur);
					session.setAttribute("username", utilisateur.getUsername());
					return "redirect:/home";
				}
			}
			
			catch (WrongUsernameOrPasswordException ex) {
				result.rejectValue("password", ex.getCode(), ex.getMessage());
			}
		}
		
		return "login";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:login";
	}
	
	
	
	@RequestMapping(value="subscribe", method=RequestMethod.GET)
	public String subscribe() {
		return "subscribe";
	}
	
	
	@RequestMapping(value="/subscribe", method=RequestMethod.POST)
	public String subscribe(@Valid @ModelAttribute("inscription") InscriptionUtilisateur inscriptionUtilisateur, BindingResult result, Model model, HttpSession session) {
		new PasswordCheckValidator().validate(inscriptionUtilisateur, result);
		
		if (!result.hasErrors()) {
			Utilisateur myUtilisateur = null;
			
			switch (inscriptionUtilisateur.getType()) {
				case 2: myUtilisateur = new Spectateur(); break;
				default: myUtilisateur = new Joueur(); break;
			}
			
			inscriptionUtilisateur.setProperties(myUtilisateur);
			this.utilisateurDAO.save(myUtilisateur);
			
			return "redirect:/home";
		}
		
		return "subscribe";
	}
	
	
	
	@ModelAttribute("user")
	public Utilisateur initUtilisateur() {
		return new Utilisateur();
	}
	
	
	
	@ModelAttribute("inscription")
	public InscriptionUtilisateur initInscriptionUtilisateur() {
		return new InscriptionUtilisateur();
	}
}