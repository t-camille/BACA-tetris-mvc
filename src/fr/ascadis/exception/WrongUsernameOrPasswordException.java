package fr.ascadis.exception;


public class WrongUsernameOrPasswordException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	
	public WrongUsernameOrPasswordException() {
		super("Le nom d'utilisateur ou le mot de passe est incorrect.");
		this.code = "wrongUsernameOrPassword";
	}
}