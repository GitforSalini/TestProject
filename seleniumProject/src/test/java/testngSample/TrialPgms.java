package testngSample;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TrialPgms {
	WebDriver driver;
  @Test
  public void vatifyTheEnterMessage() throws InterruptedException {
	  WebElement inputform=driver.findElement(By.xpath("//a[contains(text(),'Input Form')]"));
	  inputform.click();
	  WebElement enter=driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
	  enter.sendKeys("Hai");
	  WebElement showmsg=driver.findElement(By.xpath("//button[text()='Show Message']"));
	  showmsg.click();
	  WebElement yourmsg=driver.findElement(By.xpath("//div[@id='message-one']"));
	//  System.out.println(yourmsg.isDisplayed());
	  //Thread.sleep(5000);
	  String expectedMsg="Your Message :Hai";
	  String actualMsg=yourmsg.getText();
	 // Assert.assertEquals(actualMsg,expectedMsg);   //HardAssert
	  SoftAssert softassert=new SoftAssert();         //SoftAssert
	  softassert.assertEquals(actualMsg,expectedMsg);
	  softassert.assertAll();
	  	  
  }

  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  
  }

}
