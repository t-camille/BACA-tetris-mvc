package fr.ascadis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import fr.ascadis.security.SecurityType;
import fr.ascadis.security.SecurityUser;


@Entity
@Table(name="utilisateur", uniqueConstraints = { @UniqueConstraint(columnNames = "UTI_USERNAME") })
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="UTI_TYPE", discriminatorType=DiscriminatorType.INTEGER)
public abstract class Utilisateur implements Serializable, SecurityUser
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UTI_ID")
	private int id;
	
	@Column(name="UTI_NOM")
	private String nom;
	
	@Column(name="UTI_PRENOM")
	private String prenom;
	
	@Column(name="UTI_USERNAME")
	private String username;
	
	@Column(name="UTI_PASSWORD")
	private String password;
	
	@Column(name = "UTI_TYPE", insertable = false, updatable = false)
    private int type;
	
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}
	
	
	
	public SecurityType getSecurityType() {
		switch (this.type) {
			case 0:
				return SecurityType.Administrateur;
			case 1:
				return SecurityType.Joueur;
			default:
				return SecurityType.Spectateur;
		}
	}
}