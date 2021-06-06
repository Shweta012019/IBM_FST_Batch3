package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_2 {
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver =new FirefoxDriver();
        driver.get("https://www.training-support.net ");
        Thread.sleep(1000);
        String titleofthepage=driver.getTitle();
		System.out.println("Title of the page is =" +titleofthepage);
		WebElement aboutus_id=driver.findElement(By.id("about-link"));
        System.out.println("Text in element: " + aboutus_id.getText());
        WebElement classNameLocator = driver.findElement(By.className("green"));    	
        System.out.println("Text in element: " + classNameLocator.getText());
        WebElement abousus_linktext=driver.findElement(By.linkText("About Us"));
        WebElement cssLocator = driver.findElement(By.cssSelector(".green"));    	
        System.out.println("Text in element: " + cssLocator.getText());
        //Find the About Us link using linkText()    	
        WebElement linkTextLocator = driver.findElement(By.linkText("About Us"));	
        System.out.println("Text in element: " + linkTextLocator.getText());       
        //Close the browser
        driver.close();
        }
}
