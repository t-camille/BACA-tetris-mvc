package fr.ascadis;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.model.Partie;
import fr.ascadis.model.Tetrimino;


public class Rendu
{
	public static void pageBienvenue(ServletContext context, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		pagePrincipale("Bienvenue", "/WEB-INF/views/accueil.jsp", context, req, resp);
	}
	
	
	public static void pageLogin(ServletContext context, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		pagePrincipale("Bienvenue", "/WEB-INF/views/jsp/account/login.jsp", context, req, resp);
	}
	
	
	public static void pageSubscribe(ServletContext context, HttpServletRequest req, HttpServletResponse resp, boolean failureSubcribe) throws ServletException, IOException
	{
		if (failureSubcribe) {
			req.setAttribute("failure", true);
		}
		
		pagePrincipale("S'inscrire", "/WEB-INF/views/subscribe.jsp", context, req, resp);
	}
	
	
	public static void listeTetriminos(String titrePage, List<Tetrimino> tetriminos, boolean montrerActions, ServletContext context, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setAttribute("tetriminos", tetriminos);
		req.setAttribute("montrerActions", montrerActions);
		
		pagePrincipale(titrePage, "/WEB-INF/views/jsp/tetrimino/tetriminos.jsp", context, req, resp);
	}
	
	
	public static void listeParties(String titrePage, List<Partie> parties, ServletContext context, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setAttribute("parties", parties);
		pagePrincipale(titrePage, "/WEB-INF/views/parties.jsp", context, req, resp);
	}
	
	
	public static void pagePrincipale(String title, String contentJsp, ServletContext context, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		if (title == null)
			title = "D�faut";
		
		req.setAttribute("pageTitle", title);
		req.setAttribute("contentJsp", contentJsp);
		
		
		RequestDispatcher dispatcher = context.getRequestDispatcher("/WEB-INF/views/structure.jsp");
		dispatcher.forward(req, resp);
	}
}
