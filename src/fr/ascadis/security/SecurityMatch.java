package fr.ascadis.security;

public class SecurityMatch
{
	private String uri;
	private SecurityType type;
	
	
	
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public SecurityType getType() {
		return type;
	}
	
	public void setType(SecurityType type) {
		this.type = type;
	}
	
	
	
	
	public SecurityMatch(String uri, SecurityType type) {
		this.uri = uri;
		this.type = type;
	}
	
	
	
	public boolean isLogged(String uri, SecurityUser user) {
		if (uri.contains(this.uri))
		{
			if (this.type == SecurityType.Anonyme) {
				return true;
			}
			
			else if (user != null && this.type == SecurityType.Logged) {
				return true;
			}
			
			else if (user != null && this.type == user.getSecurityType()) {
				return true;
			}
		}
		
		return false;
	}
}