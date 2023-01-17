package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AssertionAssignment {
	WebDriver driver;
  @Test
  public void varifyingTheUrl() 
  {
	  String expectedUrl="https://demo.guru99.com/test/newtours/index.php";
	  String actualUrl=driver.getCurrentUrl();
	  Assert.assertEquals(actualUrl,expectedUrl);	
	  
  }
  @Test
  public void isLogoDisplayedorNot() 
  {
	  WebElement logo=driver.findElement(By.xpath("//img[@alt='Mercury Tours']"));
	  boolean isLogo=logo.isDisplayed();
	  Assert.assertTrue(isLogo);
  }
  @Test
  public void varifyingSuccessfullSignOn() 
  {
	  WebElement signon=driver.findElement(By.xpath("//a[text()='SIGN-ON']"));
	  signon.click();
	  WebElement username=driver.findElement(By.xpath("//input[@name='userName']"));
	  username.sendKeys("anna");
	  WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	  password.sendKeys("1234");
	  WebElement submit=driver.findElement(By.xpath("//input[@name='submit']"));
	  submit.submit();
	  
	  WebElement loginSuccess=driver.findElement(By.xpath("//table[@border='0' and @width='492']//tr[1]//td[1]"));
	  Boolean loginMsg=loginSuccess.isDisplayed();
	  Assert.assertTrue(loginMsg);
  
  }
 @Test
  public void varifyingSignInUsingInvalidDetails() 
  {
	  
	  WebElement username=driver.findElement(By.xpath("//input[@name='userName']"));
	  username.sendKeys("chinnu");
	  WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	  password.sendKeys("1234");
	  WebElement submit=driver.findElement(By.xpath("//input[@name='submit']"));
	  submit.submit();
	  
	  WebElement errorMsg=driver.findElement(By.xpath("(//table[@width='100%'])[2]//tr[3]//td[2]//span"));
	 
	  Boolean invalidMsg=errorMsg.isDisplayed();
	  Assert.assertTrue(invalidMsg);
  }
 @Test
 public void varifyingRegisterLinkIsClickable() 
 {
	  WebElement register=driver.findElement(By.xpath("//a[text()='REGISTER']"));
	  register.click();
	  String expectedRegister="https://demo.guru99.com/test/newtours/register.php";
	  String actualRegister=driver.getCurrentUrl();
	  Assert.assertEquals(actualRegister,expectedRegister);
	  
 }
 @Test
 public void varifyingOneWayButtonIsSelectedByDefault() 
 {
	//  WebElement flight=driver.findElement(By.xpath("//table[@border='2']//tr[2]//td[2]"));
	 // flight.click();
	 driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
	  WebElement oneWay=driver.findElement(By.xpath("(//table[@cellpadding='2'])[2]//tr[2]//td[2]//input[@value='oneway']"));
	  Boolean selected=oneWay.isSelected();
	  Assert.assertFalse(selected);
	  
	  
 }
 
  @BeforeMethod
  public void beforeMethod() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://demo.guru99.com/test/newtours/index.php");
	  driver.manage().window().maximize(); 
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
