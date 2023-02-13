package executeClass;

import org.testng.annotations.Test;

import elementRepository.LoginPageClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import testngSample.DataProviderForLogin;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTestClass 
{
	WebDriver driver;
	LoginPageClass lpc;
	
  @Test
  public void varifyTheLoginPageIsDisplayedByHittingTheUrl() 
  {
	  lpc=new LoginPageClass(driver);
	  
	 // Boolean actual=lpc.is7rmartsupermarketDisplayed();
	  //Assert.assertTrue(actual);                          // varification using assertTrue
	  
	  String actual=lpc.getTextOf7rmartsupermarket();
	  String expected="7rmart supermarket";
	  Assert.assertEquals(actual,expected);                //varification using assertEquals
	  
  }
  @Test
  public void varifySuccessfulLogin() 
  {
	  lpc=new LoginPageClass(driver);
	  lpc.enteruserName("admin");
	  lpc.enterPassword("admin");
	  lpc.clickOnSignIn();
	  
	  Boolean actual=lpc.isadminNameDisplayed();
	  Assert.assertTrue(actual);
	  
  }
@Test(dataProvider="UnSuccessfulLogin",dataProviderClass=DataProviderForLogin.class)
  public void varifyUnSuccessfulLogin(String uname,String pwd) 
  {
	  lpc=new LoginPageClass(driver);
	  lpc.enteruserName(uname);
	  lpc.enterPassword(pwd);
	  lpc.clickOnSignIn();
	  
	  Boolean actual=lpc.isAlertMsgDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  
@Test
public void varifyRememberMeCheckBoxIsSelectByDefault() 
{

	 lpc=new LoginPageClass(driver);
	 Boolean actual=lpc.isRememberMeCheckBoxSelected();
	 Assert.assertFalse(actual);
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
	 // driver.quit();
  }

}
