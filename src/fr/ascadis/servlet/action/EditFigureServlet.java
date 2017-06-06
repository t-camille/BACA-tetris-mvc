package fr.ascadis.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.model.Figure;
import fr.ascadis.model.Tetrimino;
import fr.ascadis.servlet.DataAccessServlet;


@WebServlet("/editFigure")
public class EditFigureServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		Tetrimino myTetrimino = this.getTetriminoDAO().find(req.getParameter("tetrimino_id"));
		Figure myFigure = new Figure();
		
		myFigure.setTetrimino(myTetrimino);
		this.getFigureDAO().save(myFigure);
		
		resp.sendRedirect("editTetrimino?tetrimino_id=" + myFigure.getTetrimino().getId());
	}
}