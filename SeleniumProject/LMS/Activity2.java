//Verify the website heading
package Activities;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
	
public class Activity2 {
		WebDriver driver;
		String url="https://alchemy.hguy.co/lms"; //LMS site URL
		String Expected_HeaderText="Learn from Industry Experts";

		
	//Open the browser and navigate to the LMS site
	@BeforeClass
		public void Open_Browser() throws InterruptedException {
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Reporter.log("Open the browser");
			driver.get(url);	
		    //Thread.sleep(1000);
		    Reporter.log("navigate to site" + url);
			String Actual_Tilte_Of_The_Page=driver.getTitle();
			Assert.assertEquals(Actual_Tilte_Of_The_Page, "Alchemy LMS – An LMS Application");
		}
			
	//Verify Header text of  LMS Site
	@Test
		public void Verify_Header_Text() throws InterruptedException {
		String Actual_HeaderText=driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();
		Reporter.log("Header of the page :"+Actual_HeaderText);
		Assert.assertEquals(Actual_HeaderText, Expected_HeaderText);
		}
		
	//Quit the driver
	@AfterClass
		public void Close() {
			driver.quit();
		}
		
	}

