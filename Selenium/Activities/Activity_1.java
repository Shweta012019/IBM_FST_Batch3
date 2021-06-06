package Activities;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class Activity_1 {
	public static void main(String args[]) throws InterruptedException
	{
		//Create an instance of Fire fox driver
		WebDriver driver=new FirefoxDriver();
		//Open the site using driver object and get method
		driver.get("https://www.training-support.net");
		Thread.sleep(1000);
		driver.close();
	}
	}
