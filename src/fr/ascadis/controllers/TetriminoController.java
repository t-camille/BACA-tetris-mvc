package fr.ascadis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.ascadis.model.Bloc;
import fr.ascadis.model.Figure;
import fr.ascadis.model.Tetrimino;

@Controller
public class TetriminoController extends DataAccess
{

	// TetriminosServlet
	@RequestMapping(value = "/tetriminos",method = RequestMethod.GET)
	public String tetriminos(Model model)
	{
		model.addAttribute("tetriminos", this.getTetriminoDAO().findAll());
		System.err.println("je passe bien par le controleur");

		return "tetriminos";
	}

	// EditTetriminoServlet
	@RequestMapping(value = "/editTetrimino", method = RequestMethod.GET)
	public String editTetrimino(@RequestParam(value = "tetrimino_id", required=false) String tetriminoId, Model model)
	{
		System.err.println("je passe bien par le controleur");
		Tetrimino myTetrimino = null;

		if (tetriminoId != null)
		{
			myTetrimino = this.getTetriminoDAO().find(tetriminoId);

			if (myTetrimino == null)
			{
				return "redirect:home";
			}			
			
			model.addAttribute("tetrimino", myTetrimino);
			return "editTetrimino";
		}

		else
		{
			myTetrimino = new Tetrimino("Pas de nom", "000");
		}

		model.addAttribute("tetrimino", myTetrimino);
		return "newTetrimino";
	}

	@RequestMapping(value = "/editTetrimino", method = RequestMethod.POST)
	public String editTetrimino(@RequestParam(value = "tetrimino_id") String tetriminoId,
			@RequestParam(value = "tetrimino_nom") String tetriminoNom,
			@RequestParam(value = "tetrimino_couleur") String tetriminoCouleur)
	{
		System.err.println("je passe bien par le controleur");
		Tetrimino myTetrimino = this.getTetriminoDAO().find(tetriminoId);

		// Si on ne trouve pas le Tetrimino, c'est que l'on est en train de
		// l'ajouter !
		if (myTetrimino == null)
		{
			System.out.println("pourquoi tu passe par la??!!");
			myTetrimino = new Tetrimino();
		}
		
		myTetrimino.setNom(tetriminoNom);
		myTetrimino.setCouleur(tetriminoCouleur);
		
		this.getTetriminoDAO().save(myTetrimino);

		return "redirect:tetriminos";
	}

	// DeleteTetriminoServlet
	@RequestMapping(value = "/deleteTetrimino", method = RequestMethod.GET)
	public String deleteTetrimino(@RequestParam(value = "tetrimino_id") String tetriminoId)
	{
		System.err.println("je passe bien par le controleur");

		try
		{
			// String myTetriminoId = req.getParameter("tetrimino_id");
			this.getTetriminoDAO().delete(this.getTetriminoDAO().find(tetriminoId));
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}

		return "redirect:tetriminos";
	}
	
	// EditFigureServlet
	@RequestMapping(value = "/editFigure", method = RequestMethod.GET)
	public String editFigure(@RequestParam(value = "tetrimino_id") String tetriminoId)
	{
		Tetrimino myTetrimino = this.getTetriminoDAO().find(tetriminoId);
		Figure myFigure = new Figure();
		System.err.println("je passe bien par le controleur");

		myFigure.setOrdre(myTetrimino.getFigures().size());
		
		myFigure.setTetrimino(myTetrimino);
		this.getFigureDAO().save(myFigure);
				
		return "redirect:editTetrimino?tetrimino_id=" + myFigure.getTetrimino().getId();
	}
	
	// ChangeFiguresOderServlet
	@RequestMapping(value="/changeFiguresOrder", method=RequestMethod.GET)
	public String changeFiguresOrder(@RequestParam(value = "order") String reqID)
	{
		int order = 0;
		System.err.println("je passe bien par le controleur");

		for ( String s : reqID.split(",") )
		{
			Figure f = this.getFigureDAO().find(Integer.parseInt(s));
			f.setOrdre(order);
			this.getFigureDAO().save(f);
			order++;
		}
		return "editTetrimino";
	}
	
	// DeleteFigureServlet
	@RequestMapping(value="/deleteFigure", method=RequestMethod.GET)
	public String deleteFigure(@RequestParam(value = "figure_id") Integer figureId)
	{
		System.err.println("je passe bien par le controleur");

		try
		{
			Figure myFigure = this.getFigureDAO().find(figureId);
			Tetrimino myTetrimino = myFigure.getTetrimino();
			
			this.getFigureDAO().delete(myFigure);
			return "redirect:editTetrimino?tetrimino_id=" + myTetrimino.getId();
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return "editTetrimino";
	}

	// EditBlocServlet
	@RequestMapping(value = "/editBloc", method = RequestMethod.GET)
	public String editBloc(@RequestParam(value = "figure_id") Integer figureId,
			@RequestParam(value = "bloc_id", required = false) Integer blocId, 
			@RequestParam(value = "position_x") Integer positionX,
			@RequestParam(value = "position_y") Integer positionY)
	{		
		System.err.println("je passe bien par le controleur");

		Figure myFigure = this.getFigureDAO().find(figureId);
		Bloc myBloc = null;

		if (blocId != null)
		{

		}

		else
		{
			myBloc = new Bloc();

			myBloc.setFigure(myFigure);
			myBloc.setPositionX(positionX);
			myBloc.setPositionY(positionY);

			this.getBlocDAO().save(myBloc);
		}

		return "redirect:editTetrimino?tetrimino_id=" + myFigure.getTetrimino().getId();
	}

	// DeleteBlocServlet
	@RequestMapping(value = "/deleteBloc", method = RequestMethod.GET)
	public String deletBloc(@RequestParam(value = "bloc_id") Integer blocId)
	{		
		System.err.println("je passe bien par le controleur");

		try
		{
			Bloc myBloc = this.getBlocDAO().find(blocId);
			Figure myFigure = myBloc.getFigure();

			this.getBlocDAO().delete(myBloc);
			return "redirect:editTetrimino?tetrimino_id=" + myFigure.getTetrimino().getId();
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return "tetriminos";
	}
}
