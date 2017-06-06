package fr.ascadis.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="tetrimino")
public class Tetrimino implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@Column(name="TETR_ID")
	private String id;
	

	@Column(name="TETR_NOM")
	private String nom;
	
	
	@Column(name="TETR_COULEUR")
	private String couleur;
	
	@OneToMany(mappedBy="tetrimino")
	private List<Figure> figures;
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCouleur() {
		return couleur;
	}
	
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public List<Figure> getFigures() {
		return figures;
	}
	
	public void setFigures(List<Figure> figures) {
		this.figures = figures;
	}
	
	
	
	
	public Tetrimino() { }
	
	public Tetrimino(String nom, String couleur) {
		this.nom = nom;
		this.couleur = couleur;
	}
}