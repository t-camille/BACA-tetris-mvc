package fr.ascadis.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="partie")
public class Partie implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAR_ID")
	private int id;
	
	@Column(name="PAR_DATE")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="PAR_JOUEUR_A_ID")
	private Joueur joueurA;
	
	@ManyToOne
	@JoinColumn(name="PAR_JOUEUR_B_ID")
	private Joueur joueurB;
	
	@ManyToOne
	@JoinColumn(name="PAR_JOUEUR_GAGNANT_ID")
	private Joueur joueurGagnant;
	
	@ManyToMany
	@JoinTable(
		name="assistance",
		uniqueConstraints=@UniqueConstraint(columnNames = { "AST_PARTIE_ID", "AST_SPECTATEUR_ID" }),
		joinColumns=@JoinColumn(name="AST_PARTIE_ID", referencedColumnName="PAR_ID"),
		inverseJoinColumns=@JoinColumn(name="AST_SPECTATEUR_ID", referencedColumnName="UTI_ID"))
	private List<Spectateur> spectateurs;
	
	
	
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
	
	public Joueur getJoueurA() {
		return joueurA;
	}
	
	public void setJoueurA(Joueur joueurA) {
		this.joueurA = joueurA;
	}
	
	public Joueur getJoueurB() {
		return joueurB;
	}
	
	public void setJoueurB(Joueur joueurB) {
		this.joueurB = joueurB;
	}
	
	public Joueur getJoueurGagnant() {
		return joueurGagnant;
	}
	
	public void setJoueurGagnant(Joueur joueurGagnant) {
		this.joueurGagnant = joueurGagnant;
	}
	
	public List<Spectateur> getSpectateurs() {
		return spectateurs;
	}
	
	public void setSpectateurs(List<Spectateur> spectateurs) {
		this.spectateurs = spectateurs;
	}
}