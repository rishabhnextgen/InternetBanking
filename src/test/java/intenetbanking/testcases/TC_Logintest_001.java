package intenetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import internetbanking.pageobject.LoginPage;


public class TC_Logintest_001 extends BaseClass
{

	@Test
	public void logintest() throws IOException
	{
		
		driver.get(baseurl);
		Logger.info("open the url");
		LoginPage lp= new LoginPage(driver);
		
		lp.setusername(username);
		Logger.info("enter username");
		lp.setpassword(password);
		Logger.info("Entered password");
		lp.clicklogin();
		Logger.info("click on the loggin button");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			Logger.info("Login test passed");
		}
		
		else
		{
			Capturescreen(driver, "logintest");
			Assert.assertTrue(false);
			Logger.info("Login test failed");
		}
		
		
		
		
		
	}
	
	
}
