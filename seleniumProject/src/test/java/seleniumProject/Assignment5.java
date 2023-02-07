package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*Program-5
		Go to the URL "http://omayo.blogspot.com/".
		Prgm 1 : Select "doc 2" from "Older Newsletters drop down".*/
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		WebElement olderNewsPaper=driver.findElement(By.xpath("//*[@id='drop1']"));
		olderNewsPaper.click();
		Select options=new Select(olderNewsPaper);
		options.selectByIndex(2);
		
		
		/*Prgm 2 : Select values Swift, Hyundai, and Audi from "Multi Selection box drop down". 
		then deselect all selected values by using deselectAll(). 
		(Note : pls use all 3 selection methods to take values.)*/
		
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		WebElement multiSelectionBox=driver.findElement(By.xpath("//select[@id='multiselect1']"));
		Select select=new Select(multiSelectionBox);
		select.selectByIndex(1);
		select.selectByValue("Hyundaix");
		select.selectByVisibleText("Audi");
		Thread.sleep(2000);
		
		select.deselectAll();
		driver.close();

	}

}
