//Logging into the site
//Goal: Open the website and log-in using the provided credentials.
package Activities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
public class Activity6 {

	WebDriver driver;
	String url="https://alchemy.hguy.co/lms"; //LMS site URL
	String Expected_TileOfthePage="Alchemy LMS – An LMS Application";
//	String Username;
 //   String Password;
	
//Open the browser and navigate to the LMS site
   @BeforeClass
	public void Open_Browser() {
		driver=new FirefoxDriver();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Reporter.log("open the browser");
		driver.get(url);	
		Reporter.log("navigate to site :"+ url);
		String Actual_Tilte_Of_The_Page=driver.getTitle();
		Assert.assertEquals(Actual_Tilte_Of_The_Page, Expected_TileOfthePage);
	}
	
//click on my account and Login to LMS Site
	@Test
	@Parameters({"Username","Password"})
	public void Login_To_LMS_Site(String Username,String Password) throws InterruptedException {
		   String MyAccount_Title="My Account – Alchemy LMS";
		   WebElement MyAccount_Menu=driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
		   Reporter.log("click on my account menu");
		   MyAccount_Menu.click();
		   //Thread.sleep(2000);	   
		   String Title_of_MyAccount_page=driver.getTitle();
		   Assert.assertEquals(Title_of_MyAccount_page, MyAccount_Title);	   		  
		   WebElement Login_Link=driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		   Reporter.log("click on Login Link");
			Login_Link.click();
			//Thread.sleep(2000);		
			WebElement Username_Field=driver.findElement(By.id("user_login"));
			WebElement Password_Field=driver.findElement(By.id("user_pass"));
			WebElement Login_Button=driver.findElement(By.className("login-submit"));
			Reporter.log("Enter username" +Username );
			Username_Field.sendKeys(Username);
			Reporter.log("Enter password" +Password);		
			Password_Field.sendKeys(Password);
			Reporter.log("Click on login button");		
			Login_Button.click();
			//Thread.sleep(3000);
			WebElement TitleOf_LMS_WelcomePage=driver.findElement(By.linkText("Content Marketing"));
			Reporter.log("Title of lms after login" +TitleOf_LMS_WelcomePage.getText());		
	        Assert.assertEquals(TitleOf_LMS_WelcomePage.isDisplayed(),true);
	}
	
	@AfterClass
	public void Close() {
		driver.quit();
	}
	
}
