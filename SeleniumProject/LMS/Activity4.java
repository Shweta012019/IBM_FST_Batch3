
//Verify the title of the second most popular course
//Goal: Read the title of the second most popular course
package Activities;

import java.util.List;
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

public class Activity4 {
	WebDriver driver;
	String url="https://alchemy.hguy.co/lms";
	String Expected_Second_PopularCource="Email Marketing Strategies";
@BeforeClass
	public void Firefox_Driver_Configuration() throws InterruptedException
	{
	   driver=new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   Reporter.log("Open the browser");
	   driver.get(url);
	//   Thread.sleep(10000);	   
	   Reporter.log("Navigate to Site "+url);
	}
@Test
   public void Verify_Tilte_Of_First_Info_Box()
   {
	   List<WebElement> PopularCources=driver.findElements(By.xpath("//div[@class='ld-course-list-items row']//h3[@class='entry-title']"));
	   String Actual_Second_PopularCource=PopularCources.get(1).getText();
	   Reporter.log("Title of second popular course is :" +Actual_Second_PopularCource);
	   Assert.assertEquals(Actual_Second_PopularCource, Expected_Second_PopularCource);	   
   }

@AfterClass
public void Close() {
	driver.quit();
}
}
