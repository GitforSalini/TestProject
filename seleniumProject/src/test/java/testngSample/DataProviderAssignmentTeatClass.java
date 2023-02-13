package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DataProviderAssignmentTeatClass 
{
	WebDriver driver;
	
  @Test(dataProvider="SuccessfulLogin",dataProviderClass=DataProviderAssignment.class)
  public void varifySuccessfulLogin(String uname,String pwd)
  {
	  WebElement userName=driver.findElement(By.id("loginform-username"));
	  userName.sendKeys(uname);
	  WebElement password=driver.findElement(By.id("loginform-password"));
	  password.sendKeys(pwd);
	  WebElement loginBtn=driver.findElement(By.name("login-button"));
	  loginBtn.click();
	  
	  WebElement userNameDisplayed=driver.findElement(By.xpath("//a[text()='Carol Thomas']"));
	  Boolean actual=userNameDisplayed.isDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @Test(dataProvider="UnSuccessfulLogin",dataProviderClass=DataProviderAssignment.class)
  public void varifyUnSuccessfulLogin(String uname,String pwd)
  {
	  WebElement userName=driver.findElement(By.id("loginform-username"));
	  userName.sendKeys(uname);
	  WebElement password=driver.findElement(By.id("loginform-password"));
	  password.sendKeys(pwd);
	  WebElement loginBtn=driver.findElement(By.name("login-button"));
	  loginBtn.click();
	  
	  WebElement invalidMsg=driver.findElement(By.xpath("//p[text()='Incorrect username or password.']"));
	  Boolean actual=invalidMsg.isDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @BeforeMethod
  public void beforeMethod()
  {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://qabible.in/payrollapp/site/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
