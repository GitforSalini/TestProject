package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Program-4
		Open Url : https://selenium.obsqurazone.com/index.php Q1. 
		Get the tagname, attribute, and CSS value of the Home tab. 
		Q2. Get the size of the logo.*/
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
		WebElement home=driver.findElement(By.xpath("//*[text()='Home']"));
		System.out.println(home.getTagName());
		System.out.println(home.getAttribute("Class"));
		System.out.println(home.getCssValue("font-size"));
		WebElement logo=driver.findElement(By.xpath("//img[@alt='logo'][1]"));
		System.out.println(logo.getSize());
	}

}
