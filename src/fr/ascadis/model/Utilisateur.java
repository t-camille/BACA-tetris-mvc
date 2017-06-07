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

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

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
	@NotEmpty
	private int id;
	
	@NotEmpty
	@Column(name="UTI_NOM")
	@NotEmpty
	private String nom;
	
	@NotBlank
	@Column(name="UTI_PRENOM")
	@NotEmpty
	private String prenom;
	
	@NotEmpty
	@Column(name="UTI_USERNAME")
	@NotEmpty
	private String username;
	
	@NotEmpty
	@Column(name="UTI_PASSWORD")
	@NotEmpty
	private String password;
	
	@Column(name = "UTI_TYPE", insertable = false, updatable = false)
	@NotEmpty
	private int type;
	
	private String passwordCheck;
	
	
	
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
	
	
	
	
	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
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