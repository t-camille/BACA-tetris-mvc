package fr.ascadis.servlet;


import org.springframework.beans.factory.annotation.Autowired;

import fr.ascadis.dao.IDAO;
import fr.ascadis.dao.IUtilisateurDAO;
import fr.ascadis.model.Bloc;
import fr.ascadis.model.Figure;
import fr.ascadis.model.Partie;
import fr.ascadis.model.Score;
import fr.ascadis.model.Tetrimino;


public abstract class DataAccessServlet extends SpringServlet
{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IDAO<Tetrimino, String> tetriminoDAO;
	
	@Autowired
	private IUtilisateurDAO utilisateurDAO;
	
	@Autowired
	private IDAO<Partie, Integer> partieDAO;
	
	@Autowired
	private IDAO<Score, Integer> scoreDAO;
	
	@Autowired
	private IDAO<Figure, Integer> figureDAO;
	
	@Autowired
	private IDAO<Bloc, Integer> blocDAO;
	
	
	
	protected IDAO<Tetrimino, String> getTetriminoDAO()
	{
		return this.tetriminoDAO;
	}
	
	protected IUtilisateurDAO getUtilisateurDAO()
	{
		return this.utilisateurDAO;
	}
	
	protected IDAO<Partie, Integer> getPartieDAO()
	{
		return this.partieDAO;
	}
	
	protected IDAO<Score, Integer> getScoreDAO()
	{
		return this.scoreDAO;
	}
	
	protected IDAO<Figure, Integer> getFigureDAO()
	{
		return this.figureDAO;
	}
	
	protected IDAO<Bloc, Integer> getBlocDAO()
	{
		return this.blocDAO;
	}
}