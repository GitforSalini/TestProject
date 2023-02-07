package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class KeyboardAndMouseHandling 
{
	WebDriver driver;
	
  @Test
  public void varifyingShowMessage() 
  {
	  WebElement enterMsg=driver.findElement(By.id("single-input-field"));
	  Actions action=new Actions(driver);
	  action.keyDown(Keys.SHIFT).build().perform();
	  enterMsg.sendKeys("hai");
	  action.keyUp(Keys.SHIFT).build().perform();
	  
	  action.keyDown(Keys.TAB).build().perform();
	  action.keyUp(Keys.TAB).build().perform();         //using keysDown and keysUp
	 // action.sendKeys(Keys.TAB).build().perform();    // using sendkeys 
	  
	  action.keyDown(Keys.ENTER).build().perform();
	  action.keyUp(Keys.ENTER).build().perform();        //using keysDown and keysUp
	//  action.sendKeys(Keys.ENTER).build().perform();     // using sendkey
	  
	//  WebElement showMsg=driver.findElement(By.id("button-one"));
	//  action.sendKeys(showMsg, Keys.ENTER).build().perform();    // clicking an element using sendkeys
	  
	  WebElement yourMsg=driver.findElement(By.id("message-one"));
	  System.out.println(yourMsg.getText());
	  Boolean actual= yourMsg.isDisplayed();
	  Assert.assertTrue(actual);
	  
	 
  }
  @Test
  public void mousehandling() 
  {
	  WebElement home=driver.findElement(By.xpath("//a[text()='Home']"));
	  Actions action=new Actions(driver);
	  action.moveToElement(home).build().perform();
	 //action.contextClick(home).build().perform();
	  action.doubleClick(home).build().perform();
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod()
  {
	 // driver.quit();
  }

}
