//7. Count the number of courses
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

public class Activity7 {
	WebDriver driver;
	String url="https://alchemy.hguy.co/lms";
	String MyAccount_Title="My Account – Alchemy LMS";
@BeforeClass
	public void Firefox_Driver_Configuration() throws InterruptedException
	{
	   driver=new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   Reporter.log("Open the browser");
	   driver.get(url);
	 //  Thread.sleep(10000);	
	   Reporter.log("Navigate to site" +url);
	}
@Test
   public void Click_On_MyCourses_Menu() throws InterruptedException
   {
	   WebElement AllCourses_Menu=driver.findElement(By.xpath("//a[contains(text(),'All Courses')]"));
	   Reporter.log("Click on All couses Menu");
	   AllCourses_Menu.click();
	  // Thread.sleep(2000);	   
	   String Title_of_AllCources_page=driver.getTitle();
	   Reporter.log("Title of all courses "+Title_of_AllCources_page);
	   Assert.assertEquals(Title_of_AllCources_page, "All Courses – Alchemy LMS");
	   List<WebElement> WebElementCourses=driver.findElements(By.xpath("//div[@id=\"ld_course_list\"]//article"));
	   Reporter.log("number of courses :=" +WebElementCourses.size());
	   System.out.println("number of cources=" +WebElementCourses.size());
   }

@AfterClass
public void Close() {
	driver.quit();
}
}
