package fr.ascadis.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.servlet.DataAccessServlet;


@WebServlet("/deleteTetrimino")
public class DeleteTetriminoServlet extends DataAccessServlet
{
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try
		{
			String myTetriminoId = req.getParameter("tetrimino_id");
			this.getTetriminoDAO().delete(this.getTetriminoDAO().find(myTetriminoId));
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		resp.sendRedirect("tetriminos");
	}
}