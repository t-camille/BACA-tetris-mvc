package fr.ascadis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.ascadis.dao.IDAO;
import fr.ascadis.model.Bloc;
import fr.ascadis.model.Figure;
import fr.ascadis.model.Tetrimino;

@Controller
@RequestMapping("/tetrimino")
public class TetriminoController
{
	@Autowired
	private IDAO<Tetrimino, String> tetriminoDAO;
	
	@Autowired
	private IDAO<Figure, Integer> figureDAO;
	
	@Autowired
	private IDAO<Bloc, Integer> blocDAO;
	
	
	
	@RequestMapping("")
	public String getAll(Model model) {
		model.addAttribute("tetriminos", this.tetriminoDAO.findAll());
		
		return "tetriminos";
	}
	
	
	
	@RequestMapping(value={ "/edit", "/edit/{id}" }, method=RequestMethod.GET)
	public String edit(@PathVariable(value="id", required=false) String tetriminoId, Model model) {
		if (tetriminoId != null) {
			model.addAttribute("tetrimino", this.tetriminoDAO.find(tetriminoId));
		}
		
		return (tetriminoId != null) ? "editTetrimino" : "addTetrimino";
	}
	
	
	@RequestMapping(value={ "/edit", "/edit/{id}" }, method=RequestMethod.POST)
	public String edit(@PathVariable(value="id", required=false) String tetriminoId, @Valid @ModelAttribute("tetrimino") Tetrimino tetrimino, BindingResult result) {
		tetrimino = this.tetriminoDAO.save(tetrimino);
		return "redirect:/tetrimino/edit/" + tetrimino.getId();
	}
	
	
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") String tetriminoId) {
		this.tetriminoDAO.delete(this.tetriminoDAO.find(tetriminoId));
		return "redirect:/tetrimino";
	}
	
	
	
	@RequestMapping("/{id}/figure/add")
	public String addFigure(@PathVariable("id") String tetriminoId) {
		Figure myFigure = new Figure();
		Tetrimino myTetrimino = this.tetriminoDAO.find(tetriminoId);

		myFigure.setTetrimino(myTetrimino);
		myFigure.setOrdre(myTetrimino.getFigures().size());
		this.figureDAO.save(myFigure);
		
		return "redirect:/tetrimino/edit/{id}";
	}
	
	
	
	@RequestMapping("/{id}/figure/{idFigure}/delete")
	public String deleteFigure(@PathVariable("id") String tetriminoId, @PathVariable("idFigure") int figureId) {
		this.figureDAO.delete(this.figureDAO.find(figureId));
		
		return "redirect:/tetrimino/edit/{id}";
	}
	
	
	
	@RequestMapping("/{id}/figure/{idFigure}/order/forward")
	public String forwardFigure(@PathVariable("id") String tetriminoId, @PathVariable("idFigure") int figureId) {
		Figure myFigure = this.figureDAO.find(figureId);
		int myNewOrder = myFigure.getOrdre() + 1;

		if (myNewOrder < myFigure.getTetrimino().getFigures().size()) {
			for (Figure forFigure : myFigure.getTetrimino().getFigures()) {
				if (forFigure.getOrdre() == myNewOrder) {
					forFigure.setOrdre(myNewOrder - 1);
					this.figureDAO.save(forFigure);
				}
			}
			
			myFigure.setOrdre(myNewOrder);
			this.figureDAO.save(myFigure);
		}
		
		return "redirect:/tetrimino/edit/{id}";
	}
	
	
	
	@RequestMapping("/{id}/figure/{idFigure}/order/backward")
	public String backwardFigure(@PathVariable("id") String tetriminoId, @PathVariable("idFigure") int figureId) {
		Figure myFigure = this.figureDAO.find(figureId);
		int myNewOrder = myFigure.getOrdre() - 1;
		
		if (myNewOrder >= 0) {
			for (Figure forFigure : myFigure.getTetrimino().getFigures()) {
				if (forFigure.getOrdre() == myNewOrder) {
					forFigure.setOrdre(myNewOrder + 1);
					this.figureDAO.save(forFigure);
				}
			}
			
			myFigure.setOrdre(myNewOrder);
			this.figureDAO.save(myFigure);
		}
		
		return "redirect:/tetrimino/edit/{id}";
	}
	
	
	
	@RequestMapping(value="/figure/{idFigure}/bloc/edit/{position_x}-{position_y}", method=RequestMethod.GET)
	public String addBloc(@PathVariable("idFigure") int figureId,
			@PathVariable("position_x") int positionX,
			@PathVariable("position_y") int positionY) {
		Bloc myBloc = new Bloc();
		Figure myFigure = this.figureDAO.find(figureId);

		myBloc.setPositionX(positionX);
		myBloc.setPositionY(positionY);
		myBloc.setFigure(myFigure);
		
		this.blocDAO.save(myBloc);
		
		return "redirect:/tetrimino/edit/" + myFigure.getTetrimino().getId();
	}
	
	
	
	@RequestMapping(value="/figure/{idFigure}/bloc/{idBloc}/delete", method=RequestMethod.GET)
	public String editBloc(@PathVariable("idFigure") int figureId, @PathVariable("idBloc") int blocId) {
		Figure myFigure = this.figureDAO.find(figureId);
		this.blocDAO.delete(this.blocDAO.find(blocId));
		
		return "redirect:/tetrimino/edit/" + myFigure.getTetrimino().getId();
	}
}