package fr.ascadis.servlet.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.model.Utilisateur;
import fr.ascadis.servlet.DataAccessServlet;




@WebServlet("/login")
public class LoginServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Utilisateur myUtilisateur = this.getUtilisateurDAO().auth(req.getParameter("username"), req.getParameter("password"));
		
		if (myUtilisateur != null) {
			req.getSession().setAttribute("utilisateur", myUtilisateur);
		}
		
		resp.sendRedirect("home");
	}
}