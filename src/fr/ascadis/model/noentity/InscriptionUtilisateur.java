package fr.ascadis.model.noentity;

import org.hibernate.validator.constraints.NotEmpty;

import fr.ascadis.model.Utilisateur;

public class InscriptionUtilisateur	 extends Utilisateur {
	
	@NotEmpty
	private String passwordCheck;
	
	
	public String getPasswordCheck() {
		return passwordCheck;
	}
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	
	
}
