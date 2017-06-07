package fr.ascadis.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.Rendu;
import fr.ascadis.model.Tetrimino;
import fr.ascadis.servlet.DataAccessServlet;


@WebServlet("/editTetrimino")
public class EditTetriminoServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Tetrimino myTetrimino = null;
		String myTitre;
		
		
		if (req.getParameter("tetrimino_id") != null)
		{
			String myTetriminoId = req.getParameter("tetrimino_id");
			myTetrimino = this.getTetriminoDAO().find(myTetriminoId);
			
			if (myTetrimino == null)
			{
				resp.sendRedirect("home");
				return;
			}
			
			myTitre = "Edition Tetrimino";
		}
		
		else
		{
			myTetrimino = new Tetrimino("Pas de nom", "000");
			myTitre = "Nouveau tetrimino";
		}
		
		req.setAttribute("tetrimino", myTetrimino);
		Rendu.pagePrincipale(myTitre, "/WEB-INF/views/jsp/tetrimino/editTetrimino.jsp", getServletContext(), req, resp);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Tetrimino myTetrimino = this.getTetriminoDAO().find(req.getParameter("tetrimino_id"));
		
		// Si on ne trouve pas le Tetrimino, c'est que l'on est en train de l'ajouter !
		if (myTetrimino == null)
		{
			myTetrimino = new Tetrimino();
		}
		
		
		myTetrimino.setNom(req.getParameter("tetrimino_nom"));
		myTetrimino.setCouleur(req.getParameter("tetrimino_couleur"));
		
		this.getTetriminoDAO().save(myTetrimino);
		resp.sendRedirect("tetriminos");
	}
}