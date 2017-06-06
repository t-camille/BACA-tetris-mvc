package fr.ascadis.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.model.Joueur;
import fr.ascadis.model.Partie;
import fr.ascadis.servlet.DataAccessServlet;


@WebServlet("/joinPartie")
public class JoinPartieServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Partie myPartie = this.getPartieDAO().find(Integer.parseInt(req.getParameter("partie_id")));
		
		if (myPartie != null) {
			myPartie.setJoueurB((Joueur)req.getSession().getAttribute("utilisateur"));
		}
		
		this.getPartieDAO().save(myPartie);
		
		resp.sendRedirect("parties");
	}
}