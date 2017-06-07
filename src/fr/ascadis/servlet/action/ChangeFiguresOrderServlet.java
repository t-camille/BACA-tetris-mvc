package fr.ascadis.servlet.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ascadis.model.Figure;
import fr.ascadis.servlet.DataAccessServlet;

@WebServlet("/changeFiguresOrder")
public class ChangeFiguresOrderServlet extends DataAccessServlet
{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String reqID = req.getParameter("order");
		int order = 0;
		
		for ( String s : reqID.split(",") )
		{
			Figure f = this.getFigureDAO().find(Integer.parseInt(s));
			f.setOrdre(order);
			this.getFigureDAO().save(f);
			order++;
		}
	}

}
