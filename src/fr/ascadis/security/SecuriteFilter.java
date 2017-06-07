package fr.ascadis.security;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.Rendu;


@WebFilter("/*")
public class SecuriteFilter implements Filter
{
	private ServletContext context;
	

	@Override
	public void init(FilterConfig fConfig) throws ServletException
	{
		System.out.println("INITIALISATION DU FILTRE");
		this.context = fConfig.getServletContext();
	}
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		String myURI = request.getRequestURI();
		
		Set<SecurityMatch> myAcceptedURIs = new HashSet<>();
		boolean needSecurityCheck = true;
		
		
		//Tout le monde
		myAcceptedURIs.add(new SecurityMatch("js/", SecurityType.Anonyme));
		myAcceptedURIs.add(new SecurityMatch("css/", SecurityType.Anonyme));
		myAcceptedURIs.add(new SecurityMatch("font/", SecurityType.Anonyme));
		myAcceptedURIs.add(new SecurityMatch("fonts/", SecurityType.Anonyme));
		myAcceptedURIs.add(new SecurityMatch("/login", SecurityType.Anonyme));
		myAcceptedURIs.add(new SecurityMatch("/subscribe", SecurityType.Anonyme));

		//Tous les utilisateurs connect�s
		myAcceptedURIs.add(new SecurityMatch("/home", SecurityType.Logged));
		myAcceptedURIs.add(new SecurityMatch("/logout", SecurityType.Logged));
		
		//Seulement les administrateurs
		myAcceptedURIs.add(new SecurityMatch("/tetriminos", SecurityType.Administrateur));
		myAcceptedURIs.add(new SecurityMatch("/changeFiguresOrder", SecurityType.Administrateur));
		myAcceptedURIs.add(new SecurityMatch("/editTetrimino", SecurityType.Administrateur));
		myAcceptedURIs.add(new SecurityMatch("/deleteTetrimino", SecurityType.Administrateur));
		myAcceptedURIs.add(new SecurityMatch("/editFigure", SecurityType.Administrateur));
		myAcceptedURIs.add(new SecurityMatch("/deleteFigure", SecurityType.Administrateur));
		myAcceptedURIs.add(new SecurityMatch("/editBloc", SecurityType.Administrateur));
		myAcceptedURIs.add(new SecurityMatch("/deleteBloc", SecurityType.Administrateur));
		
		//Seulement les joueurs
		myAcceptedURIs.add(new SecurityMatch("/parties", SecurityType.Joueur));
		myAcceptedURIs.add(new SecurityMatch("/addPartie", SecurityType.Joueur));
		myAcceptedURIs.add(new SecurityMatch("/joinPartie", SecurityType.Joueur));
		
		//Seulement les spectateurs
		myAcceptedURIs.add(new SecurityMatch("/parties", SecurityType.Spectateur));
		
		
		
		for (SecurityMatch forAcceptedURI : myAcceptedURIs)
		{
			if (forAcceptedURI.isLogged(myURI, (SecurityUser)request.getSession().getAttribute("utilisateur")))
			{
				needSecurityCheck = false;
				break;
			}
		}
		
		
		if (needSecurityCheck)
		{
			Rendu.pageLogin(this.context, request, response);
			return;
		}
		
		
		chain.doFilter(request, response);
	}
	
	
	@Override
	public void destroy()
	{
		System.out.println("DESTRUCTION DU FILTRE");
	}
}