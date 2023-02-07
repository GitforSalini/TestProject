package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TableXpath 
{
	WebDriver driver;

	@Test(priority = 0)
	public void varifySearchFunctionalityByUsingClientName()
	{
		WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement login=driver.findElement(By.xpath("//button[@name='login-button']"));
		login.click();
		WebElement clients=driver.findElement(By.xpath("//a[text()='Clients']"));
		clients.click();
		WebElement clientName=driver.findElement(By.cssSelector("input#clientsearch-client_name"));
		clientName.sendKeys("Sam");
		WebElement search=driver.findElement(By.xpath("//button[text()='Search']"));
		search.click();
		WebElement sam=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[3]//td[2]"));
		//System.out.println(sam.getText());

		String expectedName="Sam";
		String actualname=sam.getText();
		Assert.assertEquals(actualname,expectedName);
	}
	
	@Test(priority = 2)
	public void displayingClientDetailsofTom()
	{
		WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement login=driver.findElement(By.xpath("//button[@name='login-button']"));
		login.click();
		WebElement clients=driver.findElement(By.xpath("//a[text()='Clients']"));
		//clients.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",clients);
		WebElement tom=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[12]"));
		
		js.executeScript("arguments[0].scrollIntoView();",tom);
		System.out.println(tom.getText());
		Boolean actual=tom.isDisplayed();
		Assert.assertTrue(actual);
		
		
	}
	
	
	@Test(priority = 1)
	public void displayingClientDetails()
	{
		WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement login=driver.findElement(By.xpath("//button[@name='login-button']"));
		login.click();
		WebElement clients=driver.findElement(By.xpath("//a[text()='Clients']"));
		clients.click();
		WebElement clientId=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[4]//td[1]"));
		System.out.println(clientId.getText());
		WebElement clientName=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[4]//td[2]"));
		System.out.println(clientName.getText());
		WebElement clientRef=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[4]//td[3]"));
		System.out.println(clientRef.getText());	  
		WebElement clientAddress=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[4]//td[4]"));
		System.out.println(clientAddress.getText());
		WebElement clientPostcode=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[4]//td[5]"));
		System.out.println(clientPostcode.getText());

	}
	@BeforeMethod
	public void beforeMethod() 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://qabible.in/payrollapp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}

}
