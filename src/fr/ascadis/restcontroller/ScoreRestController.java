package fr.ascadis.restcontroller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.ascadis.dao.IDAO;
import fr.ascadis.dao.IUtilisateurDAO;
import fr.ascadis.model.Joueur;
import fr.ascadis.model.Partie;
import fr.ascadis.model.Score;
import fr.ascadis.model.Utilisateur;



@RestController
@RequestMapping("/score")
public class ScoreRestController {
	
	@Autowired
	private IDAO<Score, Integer> scoreDAO;
	
	@Autowired
	private IUtilisateurDAO utilisateurDAO;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Score>> getAll() {
		return new ResponseEntity<List<Score>>(this.scoreDAO.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Score> add(@RequestBody Score score) {
		score = this.scoreDAO.save(score);
		
		return new ResponseEntity<Score>(score, HttpStatus.OK);
	}
	

	
}
