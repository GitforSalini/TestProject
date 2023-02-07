package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Program-3
		Open Url : https://selenium.obsqurazone.com/index.php Q1. 
		Navigate to Input form page. Click on Radio buttons demo. 
		Select gender as female, click on Show selected value, then print the getting message. 
		And also very the female radio button is selected or not. */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://selenium.obsqurazone.com/index.php");
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
		System.out.println(femaleisChecked.getText());
	}

}
