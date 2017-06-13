package fr.ascadis.security;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*")
public class SecurityFilter implements Filter
{
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("INITIALISATION DU FILTRE");
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
		myAcceptedURIs.add(new SecurityMatch("/api", SecurityType.Anonyme));
		myAcceptedURIs.add(new SecurityMatch("/account/login", SecurityType.Anonyme));
		myAcceptedURIs.add(new SecurityMatch("/account/auth", SecurityType.Anonyme));
		myAcceptedURIs.add(new SecurityMatch("/account/subscribe", SecurityType.Anonyme));

		//Tous les utilisateurs connectés
		myAcceptedURIs.add(new SecurityMatch("/home", SecurityType.Logged));
		myAcceptedURIs.add(new SecurityMatch("/logout", SecurityType.Logged));
		
		//Seulement les administrateurs
		myAcceptedURIs.add(new SecurityMatch("/tetrimino", SecurityType.Administrateur));
		myAcceptedURIs.add(new SecurityMatch("/tetrimino/", SecurityType.Administrateur));
		
		//Seulement les joueurs
		myAcceptedURIs.add(new SecurityMatch("/partie", SecurityType.Joueur));
		myAcceptedURIs.add(new SecurityMatch("/partie/add", SecurityType.Joueur));
		myAcceptedURIs.add(new SecurityMatch("/partie/join", SecurityType.Joueur));
		
		myAcceptedURIs.add(new SecurityMatch("/api/tetrimino", SecurityType.Joueur));
		
		//Seulement les spectateurs
		myAcceptedURIs.add(new SecurityMatch("/partie", SecurityType.Spectateur));
		
		
		
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
			response.sendRedirect(String.format("%s/account/login", request.getContextPath()));
			return;
		}
		
		
		chain.doFilter(request, response);
	}
	
	
	@Override
	public void destroy() {
		System.out.println("DESTRUCTION DU FILTRE");
	}
}