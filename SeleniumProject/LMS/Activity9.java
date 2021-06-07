//Complete a simple lesson
//Goal: Navigate to a particular lesson and complete it.

package Activities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9{

	WebDriver driver;
	String url="https://alchemy.hguy.co/lms"; //LMS site URL
	String Expected_TileOfthePage="Alchemy LMS – An LMS Application";
	String MyAccount_Title="My Account – Alchemy LMS";
	String Username="root";
	String Password="pa$$w0rd";
	
//Open the browser and navigate to the LMS site
   @BeforeClass
	public void Open_Browser() {
		driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,20);
		Reporter.log("Open the browser");
		driver.get(url);	
		Reporter.log("Navigate to Site" +url);
		String Actual_Tilte_Of_The_Page=driver.getTitle();
		Assert.assertEquals(Actual_Tilte_Of_The_Page, Expected_TileOfthePage);
	}
	

   public void Click_On_MyAccount_Menu() throws InterruptedException
   {
	  String MyAccount_Title="My Account – Alchemy LMS";
	   WebElement MyAccount_Menu=driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
	   Reporter.log("Click on My account Menu");
	   MyAccount_Menu.click();
	 //  Thread.sleep(2000);	   
	   String Title_of_MyAccount_page=driver.getTitle();
	   Assert.assertEquals(Title_of_MyAccount_page, MyAccount_Title);	   
   }

//Login to LMS Site
	@Test
	public void Login_To_LMS_Site() throws InterruptedException {
		Click_On_MyAccount_Menu();
		Reporter.log("Login to LMS site");
		WebElement Login_Link=driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		Login_Link.click();
		//Thread.sleep(2000);		
		WebElement Username_Field=driver.findElement(By.id("user_login"));
		WebElement Password_Field=driver.findElement(By.id("user_pass"));
		WebElement Login_Button=driver.findElement(By.className("login-submit"));
		Username_Field.sendKeys(Username);
		Password_Field.sendKeys(Password);
		Login_Button.click();
		//Thread.sleep(3000);
		WebElement TileOf_LMS_WelcomePage=driver.findElement(By.linkText("Content Marketing"));
        Assert.assertEquals(TileOf_LMS_WelcomePage.isDisplayed(),true);
		Reporter.log("Click on All courses");
        WebElement AllCourses_Menu=driver.findElement(By.xpath("//a[contains(text(),'All Courses')]"));
        AllCourses_Menu.click();
     	//Thread.sleep(2000);	   
        String Title_of_AllCources_page=driver.getTitle();
     	Assert.assertEquals(Title_of_AllCources_page, "All Courses – Alchemy LMS");
     	List<WebElement> WebElementCourses=driver.findElements(By.xpath("//div[@id=\"ld_course_list\"]//article"));
		Reporter.log("Click on First Course");
     	WebElementCourses.get(0).click();
     //	Thread.sleep(2000);
     	List<WebElement> cources=driver.findElements(By.xpath("//div[@class=\"ld-item-title\"]"));
		Reporter.log("Click on First topic");
     	cources.get(0).click();
     //	Thread.sleep(2000);
     	String Title_Of_The_Course=driver.getTitle();
     	Reporter.log("Title of the course : " +Title_Of_The_Course);
       	if(driver.findElement(By.className("ld-lesson-list-progress")).isDisplayed())
     	{  
        Reporter.log("Check if course is already completed");
     	String Progreesbar=driver.findElement(By.className("ld-lesson-list-progress")).getText();
     	Assert.assertEquals(Progreesbar.contentEquals("100% COMPLETE"),true,"Course is already completed");     	
     	}
     	}	
	@AfterClass
	public void Close() {
		driver.quit();
	}
	
}
