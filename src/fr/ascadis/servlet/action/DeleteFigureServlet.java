package fr.ascadis.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.model.Figure;
import fr.ascadis.model.Tetrimino;
import fr.ascadis.servlet.DataAccessServlet;


@WebServlet("/deleteFigure")
public class DeleteFigureServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try
		{
			int myFigureId = Integer.parseInt(req.getParameter("figure_id"));
			Figure myFigure = this.getFigureDAO().find(myFigureId);
			Tetrimino myTetrimino = myFigure.getTetrimino();
			
			this.getFigureDAO().delete(myFigure);
			resp.sendRedirect("editTetrimino?tetrimino_id=" + myTetrimino.getId());
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}