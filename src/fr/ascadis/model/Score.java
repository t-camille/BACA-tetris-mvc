package fr.ascadis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="score")
public class Score implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SCO_ID")
	private int id;
	
	@Column(name="SCO_DATE")
	private Date date;
	
	@Column(name="SCO_POINTS")
	private int points;
	
	@Column(name="SCO_LIGNES")
	private int lignes;
	
	@Column(name="SCO_NIVEAU")
	private int niveau;
	
	@ManyToOne
	@JoinColumn(name="SCO_JOUEUR_ID")
	private Joueur joueur;
	
	@ManyToOne
	@JoinColumn(name="SCO_PARTIE_ID")
	private Partie partie;
	
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getLignes() {
		return lignes;
	}
	
	public void setLignes(int lignes) {
		this.lignes = lignes;
	}
	
	public int getNiveau() {
		return niveau;
	}
	
	public void setNiveau(int niveau) {
		this.niveau = niveau;
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