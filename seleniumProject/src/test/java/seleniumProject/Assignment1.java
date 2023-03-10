package seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Program-1
		Open the url : https://groceryapp.uniqassosiates.com/home in any browser. 
		Then maximize the window. Navigate to the url "http://groceryapp.uniqassosiates.com/admin/login". 
		Then maximize , refresh and and close all opened browser windows . */

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/home");
		driver.manage().window().maximize();
		driver.navigate().to("http://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.quit();

	}

}
