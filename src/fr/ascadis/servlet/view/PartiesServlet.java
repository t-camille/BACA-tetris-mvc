package fr.ascadis.servlet.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.Rendu;
import fr.ascadis.servlet.DataAccessServlet;


@WebServlet("/parties")
public class PartiesServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Rendu.listeParties("Liste des parties", this.getPartieDAO().findAll(), this.getServletContext(), req, resp);
	}
}