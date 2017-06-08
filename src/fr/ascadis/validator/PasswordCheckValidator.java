package fr.ascadis.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.ascadis.model.Utilisateur;
import fr.ascadis.model.noentity.InscriptionUtilisateur;

public class PasswordCheckValidator implements Validator
{
	@Override
	public boolean supports(Class<?> cls) {
		return InscriptionUtilisateur.class.equals(cls);
	}


	@Override
	public void validate(Object obj, Errors e) {
		InscriptionUtilisateur myInscriptionUtilisateur = (InscriptionUtilisateur)obj;
		
		if (!myInscriptionUtilisateur.getPassword().equals(myInscriptionUtilisateur.getPasswordCheck())) {
			e.rejectValue("password", "pwdcheck", "Les mots de passe ne correspondent pas.");
		}
	}
	
	
	
	
	
	public void validate(Utilisateur utilisateur, String passwordCheck, Errors e) {
		if (!utilisateur.getPassword().equals(passwordCheck)) {
			e.rejectValue("password", "pwd.check");
		}
	}
}
