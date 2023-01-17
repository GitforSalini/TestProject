package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstPgm {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();

		WebElement inputForm=driver.findElement(By.xpath("//li[@class='nav-item']//a[contains(text(),'Input Form')]"));
		inputForm.click();

		WebElement msgTextBox=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		msgTextBox.sendKeys("Hai");

		WebElement showmsgButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		showmsgButton.click();
		//showmsgButton.submit();  // button type should be submit

		msgTextBox.clear();
		
		WebElement yourmsgText=driver.findElement(By.xpath("//div[@id='message-one']"));
		System.out.println(yourmsgText.getText());
		
		WebElement checkBoxDemo=driver.findElement(By.xpath("//a[text()='Checkbox Demo']"));
		checkBoxDemo.click();
		
		WebElement checkBox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
	//	checkBox.click();
		System.out.println(checkBox.isSelected());
		
		//driver.close();


	}

}
