package fr.ascadis.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.model.Bloc;
import fr.ascadis.model.Figure;
import fr.ascadis.servlet.DataAccessServlet;


//@WebServlet("/editBloc")
public class EditBlocServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Figure myFigure = this.getFigureDAO().find(Integer.parseInt(req.getParameter("figure_id")));
		Bloc myBloc = null;
		
		if (req.getParameter("bloc_id") != null)
		{
			
		}
		
		else
		{
			myBloc = new Bloc();
			
			myBloc.setFigure(myFigure);
			myBloc.setPositionX(Integer.parseInt(req.getParameter("position_x")));
			myBloc.setPositionY(Integer.parseInt(req.getParameter("position_y")));
			
			this.getBlocDAO().save(myBloc);
		}
		
		resp.sendRedirect("editTetrimino?tetrimino_id=" + myFigure.getTetrimino().getId());
	}
}