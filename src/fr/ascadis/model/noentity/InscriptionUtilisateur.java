package fr.ascadis.model.noentity;

import org.hibernate.validator.constraints.NotEmpty;

import fr.ascadis.model.Utilisateur;

public class InscriptionUtilisateur	 extends Utilisateur {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String passwordCheck;
	
	@NotEmpty
	private Utilisateur utilisateur;
	
	
	public String getPasswordCheck() {
		return passwordCheck;
	}
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	
	public void setProperties(Utilisateur utilisateur)
	{
		utilisateur.setNom(this.getNom());
		utilisateur.setPrenom(this.getPrenom());
		utilisateur.setUsername(this.getUsername());
		utilisateur.setPassword(this.getPassword());
	}	
}
