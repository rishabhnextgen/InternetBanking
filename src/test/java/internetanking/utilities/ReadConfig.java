package internetanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() 
	{
		File src= new File("./configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} 
		catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		
		String baseurl=pro.getProperty("baseurl");
		return baseurl;
		}
    
	public String getUsername()
     {
	String username=pro.getProperty("username");
    return username;
     }
     public String Getpassword()
     {
	String password=pro.getProperty("password");
    return password;
     }
    public String Chromepath()
    {
	String chromepath=pro.getProperty("chromepath");
   return chromepath;
 }
    public String Firefox()
    {
	String Firefoxpath=pro.getProperty("firefoxpath");
   return Firefoxpath;  
}
}