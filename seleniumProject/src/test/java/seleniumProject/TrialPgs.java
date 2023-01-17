package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TrialPgs {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//WebDriver driver1=new ChromeDriver();
		
		/*Program-1
		Open the url : https://groceryapp.uniqassosiates.com/home in any browser. 
		Then maximize the window. Navigate to the url "http://groceryapp.uniqassosiates.com/admin/login". 
		Then maximize , refresh and and close all opened browser windows . */

		
		/*driver.get("https://groceryapp.uniqassosiates.com/home");
		driver.manage().window().maximize();
		driver.navigate().to("http://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.quit();*/
		
		/*Program-2
		Open Url : https://selenium.obsqurazone.com/index.php Q1. Print the title and url of the page in console. 
		Q2. Navigate to Input form page. Click on Checkbook demo. 
		Select the Check box one and Check box three. Verify them selected or not.*/
		
		/*driver1.get("https://selenium.obsqurazone.com/index.php");
		driver1.manage().window().maximize();
		System.out.println(driver1.getTitle());
		System.out.println(driver1.getCurrentUrl());
		driver1.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement checkboxDemo=driver1.findElement(By.xpath("//*[text()=\"Checkbox Demo\"]"));
		checkboxDemo.click();
		WebElement checkboxOne=driver1.findElement(By.xpath("//*[@id='check-box-one']"));
		checkboxOne.click();
		WebElement checkboxThree=driver1.findElement(By.xpath("//*[@id='check-box-three']"));
		checkboxThree.click();
		System.out.println(checkboxOne.isSelected());
		System.out.println(checkboxOne.isSelected());*/
		
		/*Program-3
		Open Url : https://selenium.obsqurazone.com/index.php Q1. 
		Navigate to Input form page. Click on Radio buttons demo. 
		Select gender as female, click on Show selected value, then print the getting message. 
		And also very the female radio button is selected or not. */
		
		/*driver.get("https://selenium.obsqurazone.com/index.php");
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement radionbuttonDemo=driver.findElement(By.xpath("//*[text()='Radio Buttons Demo']"));
		radionbuttonDemo.click();
		WebElement femaleButton=driver.findElement(By.xpath("//*[@id='inlineRadio2']"));
		femaleButton.click();
		System.out.println(femaleButton.isSelected());
		WebElement showselectedvalue=driver.findElement(By.xpath("//*[text()='Show Selected Value']"));
		showselectedvalue.click();
		WebElement femaleisChecked=driver.findElement(By.xpath("//*[@id='message-one']"));
		System.out.println(femaleisChecked.isDisplayed());
		System.out.println(femaleisChecked.getText());*/
		
		/*Program-4
		Open Url : https://selenium.obsqurazone.com/index.php Q1. 
		Get the tagname, attribute, and CSS value of the Home tab. 
		Q2. Get the size of the logo.*/
		
		/*driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
		WebElement home=driver.findElement(By.xpath("//*[text()='Home']"));
		System.out.println(home.getTagName());
		System.out.println(home.getAttribute("Class"));
		System.out.println(home.getCssValue("font-size"));
		WebElement logo=driver.findElement(By.xpath("//img[@alt='logo'][1]"));
		System.out.println(logo.getSize());*/
		
		/*Program-5
		Go to the URL "http://omayo.blogspot.com/".
		Prgm 1 : Select "doc 2" from "Older Newsletters drop down".*/
		
		
		/*driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		WebElement olderNewsPaper=driver.findElement(By.xpath("//*[@id='drop1']"));
		olderNewsPaper.click();
		Select options=new Select(olderNewsPaper);
		options.selectByIndex(2);*/
		
		
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
