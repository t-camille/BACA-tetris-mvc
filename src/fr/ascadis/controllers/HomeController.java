package fr.ascadis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Ce contrôleur remplacera la Servlet HomeServlet
@Controller
public class HomeController extends DataAccess{
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
}