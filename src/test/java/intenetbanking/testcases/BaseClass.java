package intenetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import internetanking.utilities.ReadConfig;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();
	
	public String baseurl=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	
	public String password=readconfig.Getpassword();
	public static WebDriver driver;
	public static Logger Logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		Logger  = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.Chromepath());
		driver= new ChromeDriver();
		}
		else if(br.equals("firefox"))
	    {
			System.setProperty("webdriver.gecko.driver",readconfig.Firefox());
			driver= new FirefoxDriver();
	    }
	driver.get(baseurl);
	}

	       @AfterClass
	       public void teardown()
	     {
		driver.quit();
	      }

	       public void Capturescreen( WebDriver driver, String tname) throws IOException
	       {
	    	   
	    	   TakesScreenshot ts=  (TakesScreenshot) driver;
	    	 File source=  ts.getScreenshotAs(OutputType.FILE);
	        File target = new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
	       FileUtils.copyFile(source, target);
	       System.out.println("Screenshot taken");
	       }

}
