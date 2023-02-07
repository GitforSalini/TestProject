package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class MultipleWindowHandlingAssignment 
{
	WebDriver driver;
	
  @Test
  public void varifyingOpenNewWindowButton() throws InterruptedException 
  {
	  String parentHandle=driver.getWindowHandle();
	  System.out.println("Parent Window Handle : "+parentHandle);
	  
	  WebElement openNewWindowBtn=driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
	  
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(openNewWindowBtn));
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView();",openNewWindowBtn);
	  
	  openNewWindowBtn.click();
	  
	  Set<String> childWindows=driver.getWindowHandles();
	  System.out.println("Child Windlow Handles : "+childWindows);
	  
	  Iterator<String> iterator=childWindows.iterator();
	  while(iterator.hasNext())
	  {
		  String child=iterator.next();
		  if(!parentHandle.equalsIgnoreCase(child))
		  {
			  driver.switchTo().window(child);
			  driver.manage().window().maximize();
			  WebElement basicControlText=driver.findElement(By.xpath("//div[@class='post-head']//h1[contains(text(),'Basic Controls')]"));
			  System.out.println(basicControlText.getText());
			  Boolean actual=basicControlText.isDisplayed();
			  Assert.assertTrue(actual);
			  driver.close();
			  
		  }
		  
	  }
	  
	 driver.switchTo().window(parentHandle);
	 Thread.sleep(2000);
		  
  }
  @Test
  public void varifyingRegistraion() throws InterruptedException 
  {
	  String parentHandle=driver.getWindowHandle();
	  System.out.println("Parent Window Handle : "+parentHandle);
	  
	  WebElement openNewWindowBtn=driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
	  
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(openNewWindowBtn));
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView();",openNewWindowBtn);
	  
	  openNewWindowBtn.click();
	  
	  Set<String> childWindows=driver.getWindowHandles();
	  System.out.println("Child Windlow Handles : "+childWindows);
	  
	  Iterator<String> iterator=childWindows.iterator();
	  while(iterator.hasNext())
	  {
		  String child=iterator.next();
		  if(!parentHandle.equalsIgnoreCase(child))
		  {
			  driver.switchTo().window(child);
			  driver.manage().window().maximize();
			  WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
			  firstName.sendKeys("SALINI");
			  WebElement lastName=driver.findElement(By.id("lastName"));
			  lastName.sendKeys("Mohan");
			  WebElement gender=driver.findElement(By.id("femalerb"));
			  gender.click();
			  WebElement language=driver.findElement(By.id("englishchbx"));
			  language.click();
			  WebElement email=driver.findElement(By.name("email"));
			  email.sendKeys("salini@gmail.com");
			  WebElement password=driver.findElement(By.id("password"));
			  password.sendKeys("1234");
			  WebElement registration=driver.findElement(By.id("registerbtn"));
			  registration.click();
			  WebElement registrationMsg=driver.findElement(By.xpath("//label[text()='Registration is Successful']"));
			  System.out.println(registrationMsg.getText());
			  String expected="Registration is Successful";
			  String actual=registrationMsg.getText();
			  Assert.assertEquals(actual,expected);
			  
			 driver.close();
			  
		  }
		  
	  }
	  
	  driver.switchTo().window(parentHandle);
	  Thread.sleep(2000);
		  
  }
  @Test
  public void varifyingOpenNewTabButton() throws InterruptedException 
  {
	  String parentHandle=driver.getWindowHandle();
	  System.out.println("Parent Window Handle : "+parentHandle);
	  
	  WebElement openNewTabBtn=driver.findElement(By.id("newTabBtn"));
	  
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(openNewTabBtn));
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView();",openNewTabBtn);
	  
	  openNewTabBtn.click();
	  
	  Set<String> childWindows=driver.getWindowHandles();
	  System.out.println("Child Windlow Handles : "+childWindows);
	  
	  Iterator<String> iterator=childWindows.iterator();
	  while(iterator.hasNext())
	  {
		  String child=iterator.next();
		  if(!parentHandle.equalsIgnoreCase(child))
		  {
			  driver.switchTo().window(child);
			  driver.manage().window().maximize();
			  WebElement assertDemoMsg=driver.findElement(By.xpath("//div[@class='post-head']//h1[contains(text(),'AlertsDemo')]"));
			  System.out.println(assertDemoMsg.getText());
			  String expected="AlertsDemo";
			  String actual=assertDemoMsg.getText();
			  Assert.assertEquals(actual,expected);
			  driver.close();
		  }
	  }
	  driver.switchTo().window(parentHandle);
	  Thread.sleep(3000);
  }
  
  @Test
  public void varifyingSimpleAlertIsAcceptedorNot() throws InterruptedException 
  {
	  String parentHandle=driver.getWindowHandle();
	  System.out.println("Parent Window Handle : "+parentHandle);
	  
	  WebElement openNewTabBtn=driver.findElement(By.id("newTabBtn"));
	  
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(openNewTabBtn));
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView();",openNewTabBtn);
	  
	  openNewTabBtn.click();
	  
	  Set<String> childWindows=driver.getWindowHandles();
	  System.out.println("Child Windlow Handles : "+childWindows);
	  
	  Iterator<String> iterator=childWindows.iterator();
	  while(iterator.hasNext())
	  {
		  String child=iterator.next();
		  if(!parentHandle.equalsIgnoreCase(child))
		  {
			  driver.switchTo().window(child);
			  driver.manage().window().maximize();
			  WebElement firstClickme=driver.findElement(By.id("alertBox"));
			  firstClickme.click();
			  System.out.println(driver.switchTo().alert().getText());
			  driver.switchTo().alert().accept();
			  WebElement popUpOutput=driver.findElement(By.xpath("//div[text()='You selected alert popup']"));
			  System.out.println(popUpOutput.getText());
			  String expected="You selected alert popup";
			  String actual=popUpOutput.getText();
			  Assert.assertEquals(actual,expected);
			  		  
			  driver.close();
			  
		  }
	  }
	  driver.switchTo().window(parentHandle);
	  Thread.sleep(3000);
  }
  
  @Test
  public void varifyingPromptAlertIsAcceptedorNot() throws InterruptedException 
  {
	  String parentHandle=driver.getWindowHandle();
	  System.out.println("Parent Window Handle : "+parentHandle);
	  
	  WebElement openNewTabBtn=driver.findElement(By.id("newTabBtn"));
	  
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.elementToBeClickable(openNewTabBtn));
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView();",openNewTabBtn);
	  
	  openNewTabBtn.click();
	  
	  Set<String> childWindows=driver.getWindowHandles();
	  System.out.println("Child Windlow Handles : "+childWindows);
	  
	  Iterator<String> iterator=childWindows.iterator();
	  while(iterator.hasNext())
	  {
		  String child=iterator.next();
		  if(!parentHandle.equalsIgnoreCase(child))
		  {
			  driver.switchTo().window(child);
			  driver.manage().window().maximize();
			  WebElement thirdClickme=driver.findElement(By.id("promptBox"));
			  js.executeScript("arguments[0].scrollIntoView();",thirdClickme);
			  thirdClickme.click();
			  driver.switchTo().alert().sendKeys("Salini");
			  driver.switchTo().alert().accept();
			  WebElement popupOutput=driver.findElement(By.xpath("//div[text()='You entered text Salini in propmt popup']"));
			  System.out.println(popupOutput.getText());
			  String expected="You entered text Salini in propmt popup";
			  String actual=popupOutput.getText();
			  Assert.assertEquals(actual,expected);	  
			   			  
			 driver.close();
			  
		  }
	  }
	  	driver.switchTo().window(parentHandle);
	  	Thread.sleep(3000);
	  
  }
  
  @BeforeMethod
  public void beforeMethod()
  {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
	  
  }

}
