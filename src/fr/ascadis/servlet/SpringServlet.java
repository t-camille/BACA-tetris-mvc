package fr.ascadis.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public abstract class SpringServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;


	@Override
	public void init(ServletConfig config) {
		try {
			super.init(config);
		}
		
		catch (ServletException e) {
			e.printStackTrace();
		}

		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
}