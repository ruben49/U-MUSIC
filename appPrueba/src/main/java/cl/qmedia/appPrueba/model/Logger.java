package cl.qmedia.appPrueba.model;

public class Logger {
	
	private String uLogin;
	private String uPassword;
	
	public Logger()
	{
		
	}
	
	public void SetuLogin(String uLogin)
	{
		this.uLogin = uLogin;
	}
	
	public String GetuLogin()
	{
		return this.uLogin;
	}
	
	public void SetuPassword(String uPassword)
	{
		this.uPassword = uPassword;
	}
	
	public String GetuPassword()
	{
		return this.uPassword;
	}
	
}
