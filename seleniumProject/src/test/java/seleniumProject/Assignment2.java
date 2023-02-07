package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*Program-2
		Open Url : https://selenium.obsqurazone.com/index.php Q1. Print the title and url of the page in console. 
		Q2. Navigate to Input form page. Click on Checkbook demo. 
		Select the Check box one and Check box three. Verify them selected or not.*/
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver1=new ChromeDriver();
		
		driver1.get("https://selenium.obsqurazone.com/index.php");
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
		System.out.println(checkboxOne.isSelected());

	}

}
