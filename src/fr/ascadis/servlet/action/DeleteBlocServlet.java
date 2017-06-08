package fr.ascadis.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.model.Bloc;
import fr.ascadis.model.Figure;
import fr.ascadis.servlet.DataAccessServlet;


//@WebServlet("/deleteBloc")
public class DeleteBlocServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try
		{
			int myBlocId = Integer.parseInt(req.getParameter("bloc_id"));
			Bloc myBloc = this.getBlocDAO().find(myBlocId);
			Figure myFigure = myBloc.getFigure();
			
			this.getBlocDAO().delete(myBloc);
			resp.sendRedirect("editTetrimino?tetrimino_id=" + myFigure.getTetrimino().getId());
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}