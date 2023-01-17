package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SamplePgm {
	
	public static void main(String args[])
	{
		//traditional method
	//	System.setProperty("webdriver.chrome.driver","C:\\Users\\salin\\eclipse-workspace\\seleniumProject\\src\\main\\resources\\chromedriver.exe");
		
		// updated method using webdrivermanager
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().window().maximize();
		//driver.manage().window().minimize()
		//driver.manage().window().fullscreen()
		
		//WebElement home=driver.findElement(By.className("nav-link"));
		//WebElement home1=driver.findElement(By.linkText("Home"));
		//WebElement inputform=driver.findElement(By.className("nav-link"));
	   //WebElement inputform1=driver.findElement(By.cssSelector("a.nav-link"));  // cssselector using classname locator , tagname.value of class atribute 
		//WebElement alert=driver.findElement(By.partialLinkText("Alerts"));
		
	
		//driver.close();
		//driver.quit();
		

		
	}

}
