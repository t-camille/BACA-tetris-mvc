package fr.ascadis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Ce contrôleur remplacera la Servlet HomeServlet
@Controller
public class HomeController {
	@RequestMapping(value = "/home/{username}", method = RequestMethod.GET)
	public String home(@PathVariable("username") String usernames, Model model) {

		model.addAttribute("utilisateur", usernames);

		return "home";
	}
}