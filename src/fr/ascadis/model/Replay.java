package fr.ascadis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="replay")
public class Replay implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REPL_ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="REPL_TETRIMINO_ID")
	private Tetrimino tetrimino;
	
	@ManyToOne
	@JoinColumn(name="REPL_JOUEUR_ID")
	private Joueur joueur;
	
	@ManyToOne
	@JoinColumn(name="REPL_PARTIE_ID")
	private Partie partie;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Tetrimino getTetrimino() {
		return tetrimino;
	}
	
	public void setTetrimino(Tetrimino tetrimino) {
		this.tetrimino = tetrimino;
	}
	
	public Joueur getJoueur() {
		return joueur;
	}
	
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
	public Partie getPartie() {
		return partie;
	}
	
	public void setPartie(Partie partie) {
		this.partie = partie;
	}
}