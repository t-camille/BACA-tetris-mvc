package fr.ascadis.servlet.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.model.Joueur;
import fr.ascadis.model.Partie;
import fr.ascadis.servlet.DataAccessServlet;


@WebServlet("/addPartie")
public class AddPartieServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Partie myPartie = new Partie();
		
		myPartie.setDate(new Date());
		myPartie.setJoueurA((Joueur)req.getSession().getAttribute("utilisateur"));
		
		this.getPartieDAO().save(myPartie);
		
		resp.sendRedirect("parties");
	}
}