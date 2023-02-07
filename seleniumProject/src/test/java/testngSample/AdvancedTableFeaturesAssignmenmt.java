package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AdvancedTableFeaturesAssignmenmt
{
	WebDriver driver;
	 
  @Test
  public void varifyingAddedProductIsDisplayingOrNot()
  {
	  WebElement userName=driver.findElement(By.name("username"));
	  userName.sendKeys("admin");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("password");
	  WebElement submit=driver.findElement(By.name("submit"));
	  submit.click();
	  
	  WebElement productTab=driver.findElement(By.xpath("//i[@class='fa fa-archive']/following-sibling::span"));
	  productTab.click();
	  WebElement addBtn=driver.findElement(By.xpath("//button[text()='Add Product']"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView();",addBtn);
	  addBtn.click();
	  
	  WebElement type=driver.findElement(By.id("Type"));
	  Select select=new Select(type);
	  select.selectByIndex(2);
	  
	  WebElement code=driver.findElement(By.id("ProductCode"));
	  code.sendKeys("127451425");
	  
	  WebElement name=driver.findElement(By.id("ProductName"));
	  name.sendKeys("Avacado");
	  
	  WebElement category=driver.findElement(By.id("Category"));
	  Select selectCat=new Select(category);
	  selectCat.selectByVisibleText("fruits");
	  
	  WebElement supplier=driver.findElement(By.id("Supplier"));
	  Select selectSup=new Select(supplier);
	  selectSup.selectByIndex(5);
	  
	  WebElement tax=driver.findElement(By.id("Tax"));
	  tax.sendKeys("2");
	  
	  WebElement taxMethod=driver.findElement(By.id("taxType"));
	  Select selectTax=new Select(taxMethod);
	  selectTax.selectByIndex(1);
	  
	  WebElement price=driver.findElement(By.xpath("//label[text()='Price (abc)']/following-sibling::input"));
	  price.sendKeys("10");
	  
	  WebElement submitBtn=driver.findElement(By.xpath("//*[text()='Submit']"));
	  js.executeScript("arguments[0].scrollIntoView();",submitBtn);
	  submitBtn.click();
	  
	  WebElement addProduct=driver.findElement(By.id("add_item"));
	  addProduct.sendKeys("Avacado Juice");
	  WebElement submitButton=driver.findElement(By.xpath("//*[text()='submit'][1]"));
	  submitButton.click();
	  
	  driver.navigate().refresh();
	  WebElement search=driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
	  search.sendKeys("Avacado");
	  
	  WebElement tableDisplay=driver.findElement(By.xpath("//table[@id='Table']//tr[1]//td[2]"));
	  String actual=tableDisplay.getText();
	  String expected="Avacado";
	  Assert.assertEquals(actual,expected);
	  		
	  
  }
  @Test
  public void varifyingEditbutton()
  {
	  WebElement userName=driver.findElement(By.name("username"));
	  userName.sendKeys("admin");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("password");
	  WebElement submit=driver.findElement(By.name("submit"));
	  submit.click();
	  
	  WebElement productTab=driver.findElement(By.xpath("//i[@class='fa fa-archive']/following-sibling::span"));
	  productTab.click();
	  WebElement search=driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
	  search.sendKeys("Avacado");
	
	  
	  WebElement edit=driver.findElement(By.xpath("//a[@class='btn btn-default'][3]//i[@class='fa fa-pencil']"));
	  edit.click();

	  WebElement tax=driver.findElement(By.id("Tax"));
	  tax.clear();
	  tax.sendKeys("2.5");

	  WebElement editSubmit=driver.findElement(By.xpath("//button[text()='Submit']"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView();",editSubmit);
	  editSubmit.submit();


	  WebElement Editsearch=driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
	  Editsearch.sendKeys("Avacado");

	  WebElement tableDisplay=driver.findElement(By.xpath("//table[@id='Table']//tbody//tr[1]"));
	  System.out.println(tableDisplay.getText());
	  /*  String actual=tableDisplay.getText();
	  String expected="123456487 Avacado fruits 2.5 10.000 abc";
	  Assert.assertEquals(actual,expected);*/        //varification using complete row

	  WebElement editedTax=driver.findElement(By.xpath("//table[@id='Table']//tbody//tr[1]//td[5]"));
	  String expectedTax="2.5";
	  String actualTax=editedTax.getText();
	  Assert.assertEquals(actualTax,expectedTax);     //varification using Tax column
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://qalegend.com/restaurant/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  //driver.quit();
  }

}
