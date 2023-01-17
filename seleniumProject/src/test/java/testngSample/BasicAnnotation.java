package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BasicAnnotation
{
	WebDriver driver;
	@Test
	public void isLogoDisplayedOrNot() 
	{
		WebElement logo=driver.findElement(By.xpath("//*[@src='images/logo.png'][1]"));
		System.out.println(logo.isDisplayed());
	}
	@Test
	public void verifyTheTitleOfPage()
	{
		System.out.println(driver.getTitle());
	}


	@BeforeTest
	public void beforeTest() 
	{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://selenium.obsqurazone.com/index.php");

	}

	@AfterTest
	public void afterTest() 
	{
	driver.quit();

	}
}




