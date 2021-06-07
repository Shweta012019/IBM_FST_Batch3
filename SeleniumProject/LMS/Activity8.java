//Contact the admin
//Goal: Navigate to the “Contact Us” page and complete the form.
package Activities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {
	WebDriver driver;
	String url="https://alchemy.hguy.co/lms";
	String MyAccount_Title="My Account – Alchemy LMS";
	String FullName="Shweta";
	String EmailField="cnshweta@gmail.com";
	String SubjectField="LMS project activity";
	String CommentField="Submitting the form for LMS project";
@BeforeClass
	public void Firefox_Driver_Configuration() throws InterruptedException
	{
	   driver=new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   Reporter.log("Open the browser");
	   driver.get(url);
	 //  Thread.sleep(10000);	 
	   Reporter.log("Navigate to site"+url);

	}
@Test
   public void FillTheForm() throws InterruptedException
   {
	   WebElement Contact_Menu=driver.findElement(By.xpath("//a[contains(text(),'Contact')]"));
	   Reporter.log("Click on Contact menu");
	   Contact_Menu.click();
	 //  Thread.sleep(2000);	   
	   String Title_of_Contact_page=driver.getTitle();
	   Reporter.log("Title of allContact page "+Title_of_Contact_page);
	   Assert.assertEquals(Title_of_Contact_page,"Contact – Alchemy LMS");
	   List<WebElement> Text_Fields=driver.findElements(By.xpath("//div[@class='wpforms-field-container']//input"));
	   WebElement Comment_Field=driver.findElement(By.xpath("//textarea[@id=\"wpforms-8-field_2\"]"));
       WebElement SendMessage=driver.findElement(By.xpath("//button[contains(text(),'Send Message')]"));
       JavascriptExecutor  jsExecutor=(JavascriptExecutor)driver;
       jsExecutor.executeScript("window.scrollBy(674, 860)"); 
       Reporter.log("Enter full name :"+FullName);
       Text_Fields.get(0).sendKeys(FullName);
       Reporter.log("Enter Email id :"+EmailField);
       Text_Fields.get(1).sendKeys(EmailField);
       Reporter.log("Enter Subject :"+SubjectField);
       Text_Fields.get(2).sendKeys(SubjectField);
       Reporter.log("Enter Comment :"+CommentField);
        Comment_Field.sendKeys(CommentField);
        Reporter.log("Click on submit");
        SendMessage.click();
	//	Thread.sleep(2000);
		WebElement Expected_ConfirmationMessage=driver.findElement(By.xpath("//p[text()=\"Thanks for contacting us! We will be in touch with you shortly.\"]"));
        Reporter.log("Verify Confirmation text-Thanks for contacting us! We will be in touch with you shortly");
		Assert.assertEquals(Expected_ConfirmationMessage.isDisplayed(),true);
   }

@AfterClass
public void Close() {
	driver.quit();
}
}
