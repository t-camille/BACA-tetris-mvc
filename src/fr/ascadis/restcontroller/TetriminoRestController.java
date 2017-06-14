package fr.ascadis.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ascadis.dao.IDAO;
import fr.ascadis.model.Tetrimino;


@CrossOrigin
@RestController
@RequestMapping("/tetrimino")
public class TetriminoRestController
{
	@Autowired
	private IDAO<Tetrimino, String> tetriminoDAO;
	
	
	@RequestMapping(value="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Tetrimino>> getAll() {
		return new ResponseEntity<List<Tetrimino>>(this.tetriminoDAO.findAll(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Tetrimino> get(@PathVariable String id) {
		return new ResponseEntity<Tetrimino>(this.tetriminoDAO.find(id), HttpStatus.OK);
	}
}