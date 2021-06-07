//Verify the website title
package Activities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	public class Activity1 {
		WebDriver driver;
		String url="https://alchemy.hguy.co/lms"; //LMS site URL
		String Expected_TileOfthePage="Alchemy LMS – An LMS Application";
		
	//Open the browser 
	   @BeforeClass
		public void Open_Browser() throws InterruptedException {
			driver=new FirefoxDriver();	
			Reporter.log("open the browser");
		}
			
	//Navigate to LMS Site and verify the title
		@Test
		public void Verify_Title() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get(url);	
		    //Thread.sleep(1000);
			Reporter.log("Navigate to site "+ url);
			String Actual_Tilte_Of_The_Page=driver.getTitle();//Get the title
			Reporter.log("Title of the site is "+Actual_Tilte_Of_The_Page);
			Assert.assertEquals(Actual_Tilte_Of_The_Page, Expected_TileOfthePage);
		}
		
	//Quit the driver	
		@AfterClass
		public void Close() {
			driver.quit();
		}
		
	}

