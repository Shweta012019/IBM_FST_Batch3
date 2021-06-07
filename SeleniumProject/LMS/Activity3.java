//Verify the title of the first info box
//Goal: Read the title of the first info box
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

public class Activity3 {
	WebDriver driver;
	String url="https://alchemy.hguy.co/lms";
	String Title_Of_Info_Box="Actionable Training";
	
@BeforeClass
	public void Initial_Configuration() throws InterruptedException
	{
	   driver=new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   Reporter.log("open the browser");
	   driver.get(url);	   
	  // Thread.sleep(10000);	
	   Reporter.log("navigate to site"+url);

	}

//Get all the info boxes and verify the title of first info box
@Test
   public void Verify_Tilte_Of_First_Info_Box()
   {
	  
	   List<WebElement> InfoBoxes=driver.findElements(By.xpath("//div[@class='uagb-ifb-title-wrap']/h3"));
	   String Actual_First_Info_Box_text=InfoBoxes.get(0).getText();
	   Reporter.log("Title of the first infor box is " +Actual_First_Info_Box_text);
	   Assert.assertEquals(Actual_First_Info_Box_text, Title_Of_Info_Box);	   
   }


@AfterClass
public void Close() {
	driver.quit();
}
}
