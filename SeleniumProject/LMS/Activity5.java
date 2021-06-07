//Navigate to another page
//Goal: Navigate to the “My Account” page on the site.
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

public class Activity5 {
	WebDriver driver;
	String url="https://alchemy.hguy.co/lms";
	String MyAccount_Title="My Account – Alchemy LMS";
	
@BeforeClass
	public void Firefox_Driver_Configuration() throws InterruptedException
	{
	   driver=new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   Reporter.log("open the browser");
	   driver.get(url);
	   Reporter.log("naviagte to site :" +url);
	  // Thread.sleep(10000);	   
	}
@Test
   public void Click_On_MyAccount_Menu() throws InterruptedException
   {
	   WebElement MyAccount_Menu=driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
	   MyAccount_Menu.click();
	   String Title_of_MyAccount_page=driver.getTitle();
	   Reporter.log("Title of the page my account page is :"+Title_of_MyAccount_page);
	   Assert.assertEquals(Title_of_MyAccount_page, MyAccount_Title);	   
   }

@AfterClass
public void Close() {
	driver.quit();
}
}
