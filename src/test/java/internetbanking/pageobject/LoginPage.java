package internetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

@FindBy(name="uid")
@CacheLookup
WebElement txtusername;


@FindBy(name="password")
@CacheLookup
WebElement password;



@FindBy(name="btnLogin")
@CacheLookup
 WebElement buttonlogin;

@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
@CacheLookup
 WebElement logout;

public void setusername(String uname)
{
	txtusername.sendKeys(uname);
}

public void setpassword(String pass)
{
	password.sendKeys(pass);
}



public void clicklogin()
{
	buttonlogin.click();
}
public void clickLogout()
{
	logout.click();
}


}
