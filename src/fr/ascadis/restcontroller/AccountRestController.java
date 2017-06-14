package fr.ascadis.restcontroller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ascadis.dao.IUtilisateurDAO;
import fr.ascadis.model.Utilisateur;


@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountRestController
{
	@Autowired
	private IUtilisateurDAO utilisateurDAO;
	
	
	@RequestMapping(value="/auth", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Utilisateur> auth(@RequestBody Utilisateur utilisateur, HttpSession session) {
		try {
			utilisateur = this.utilisateurDAO.auth(utilisateur.getUsername(), utilisateur.getPassword());
			
			if (utilisateur != null) {
				session.setAttribute("utilisateur", utilisateur);
				return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
			}
		}
		
		catch (Exception ex) { }
		
		return new ResponseEntity<Utilisateur>(HttpStatus.FORBIDDEN);
	}
	
	
	@RequestMapping(value="/current", method = RequestMethod.GET)
	public ResponseEntity<Utilisateur> getCurrent(HttpSession session) {
		try {
			Utilisateur myUtilisateur = (Utilisateur)session.getAttribute("utilisateur");
			
			if (myUtilisateur != null) {
				return new ResponseEntity<Utilisateur>(myUtilisateur, HttpStatus.OK);
			}
		}
		
		catch (Exception ex) { }
		
		return new ResponseEntity<Utilisateur>(HttpStatus.FORBIDDEN);
	}
}