package fr.ascadis.model.noentity;

import fr.ascadis.model.Utilisateur;


public class InscriptionUtilisateur extends Utilisateur
{
	private static final long serialVersionUID = 1L;
	
	
	private String passwordCheck;
	
	
	public String getPasswordCheck() {
		return passwordCheck;
	}
	
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	
	
	public void setProperties(Utilisateur utilisateur) {
		utilisateur.setNom(this.getNom());
		utilisateur.setPrenom(this.getPrenom());
		utilisateur.setUsername(this.getUsername());
		utilisateur.setPassword(this.getPassword());
	}
}
