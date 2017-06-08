package fr.ascadis.servlet.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.Rendu;
import fr.ascadis.model.Joueur;
import fr.ascadis.model.Spectateur;
import fr.ascadis.model.Utilisateur;
import fr.ascadis.servlet.DataAccessServlet;


//@WebServlet("/subscribe")
public class SubscribeServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Rendu.pageSubscribe(this.getServletContext(), req, resp, false);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//On r�cup�re les param�tres du formulaire
		String myType = req.getParameter("type");
		String myNom = req.getParameter("nom");
		String myPrenom = req.getParameter("prenom");
		String myUsername = req.getParameter("username");
		String myPassword = req.getParameter("password");
		String myPasswordValidation = req.getParameter("password-validation");
		
		
		if (myUsername != null && !myUsername.isEmpty()) {
			if (myPassword != null && !myPassword.isEmpty() && myPassword.equals(myPasswordValidation)) {
				Utilisateur myUtilisateur = null;
				
				switch (myType) {
					case "2": myUtilisateur = new Spectateur(); break;
					default: myUtilisateur = new Joueur(); break;
				}
				
				myUtilisateur.setNom(myNom);
				myUtilisateur.setPrenom(myPrenom);
				myUtilisateur.setUsername(myUsername);
				myUtilisateur.setPassword(myPassword);
				
				this.getUtilisateurDAO().save(myUtilisateur);
				
				resp.sendRedirect("home");
				return;
			}
		}

		Rendu.pageSubscribe(this.getServletContext(), req, resp, true);
	}
}