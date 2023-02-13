package testngSample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClassForLogin 
{
WebDriver driver;

  @Test(dataProvider="SuccessfulLogin",dataProviderClass=DataProviderForLogin.class)
  public void varifySuccessfulLogin(String uname,String pwd) 
  {
	  WebElement userName=driver.findElement(By.name("username"));
	  userName.sendKeys(uname);
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys(pwd);
	  WebElement signIn=driver.findElement(By.xpath("//button[text()='Sign In']"));
	  signIn.click();
	  
	  WebElement adminName=driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
	  Boolean actual=adminName.isDisplayed();
	  Assert.assertTrue(actual);
			  
	  
  }
  @Test(dataProvider="UnSuccessfulLogin",dataProviderClass=DataProviderForLogin.class)
  public void varifyUnsuccessfulLogin(String uname,String pwd) 
  {
	  WebElement userName=driver.findElement(By.name("username"));
	  userName.sendKeys(uname);
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys(pwd);
	  WebElement signIn=driver.findElement(By.xpath("//button[text()='Sign In']"));
	  signIn.click();
	  
	  WebElement alertMsg=driver.findElement(By.xpath("//h5[text()=' Alert!']"));
	  Boolean actual=alertMsg.isDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("http://groceryapp.uniqassosiates.com/admin/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }
}
