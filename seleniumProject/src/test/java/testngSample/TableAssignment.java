package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TableAssignment 
{
	WebDriver driver;

	@Test
	public void displayingTheDetailsofTigerNixon()
	{
		WebElement tableLink=driver.findElement(By.xpath("(//a[@class='nav-link'])[4]"));
		tableLink.click();
		WebElement tigerNixon=driver.findElement(By.xpath("//table[@id='dtBasicExample']//tr[@class='odd'][1]"));
		System.out.println(tigerNixon.getText());
		boolean actual=tigerNixon.isDisplayed();
		Assert.assertTrue(actual); 


	}
	@Test
	public void searchingDaiRose()
	{
		WebElement tableLink=driver.findElement(By.xpath("(//a[@class='nav-link'])[4]"));
		tableLink.click();
		WebElement tableSortSearch=driver.findElement(By.xpath("//a[text()='Table Sort And Search']"));
		tableSortSearch.click();
		WebElement search=driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("Dai Rios");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(search));
		WebElement searchResult=driver.findElement(By.xpath("//table[@id='dtBasicExample']//tr[@class='odd']"));
		System.out.println(searchResult.getText());
		Boolean actual=searchResult.isDisplayed();
		Assert.assertTrue(actual);

	}
	@Test
	public void homeTabIsVisibleorNot()
	{
		WebElement home=driver.findElement(By.xpath("//a[text()='Home']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Home']")));
		Boolean actual=home.isDisplayed();
		Assert.assertTrue(actual);

	}

	@BeforeMethod
	public void beforeMethod()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}

}
