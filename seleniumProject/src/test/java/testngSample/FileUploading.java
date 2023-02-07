package testngSample;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class FileUploading 
{
	WebDriver driver;
  @Test(enabled=false)
  public void fileUploadUsingSendkeys()
  {
	  WebElement chooseFile=driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
	 // chooseFile.click();
	  chooseFile.sendKeys("C:\\Users\\salin\\OneDrive\\Desktop\\SALINI\\Selenium\\Selenium Notes-salini.docx");
	  
	  WebElement acceptTerms=driver.findElement(By.xpath("//input[@id='terms']"));
	  acceptTerms.click();
	  WebElement submitBtn=driver.findElement(By.id("submitbutton"));
	  submitBtn.click();
	 // WebElement fileUploadMsg=driver.findElement(By.xpath("//h3[@id='res']//center"));
	  WebElement fileUploadMsg=driver.findElement(By.xpath("//center[text()='has been successfully uploaded.']"));
	  
	  System.out.println(fileUploadMsg.getText());
	  Boolean actual=fileUploadMsg.isDisplayed();
	  SoftAssert soft=new SoftAssert();
	  soft.assertTrue(actual);
	  soft.assertAll();
  }
  
  @Test
  public void fileUploadUsingRobotClass() throws AWTException, InterruptedException
  {
	  driver.navigate().to("https://resume.naukri.com/resume-quality-score");
	  driver.navigate().refresh();
	  WebElement browse=driver.findElement(By.xpath("//*[text()='Browse']"));
	  browse.click();
	  
	  Robot robo=new Robot();  //Instantiating Robot class object
	  
	  StringSelection filePath=new StringSelection("C:\\Users\\salin\\Downloads\\assgn.docx"); //storing filepath to the string 
	  																							//selection class
	  
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath,null);  //copy the above path to clipboard
	  
	  robo.keyPress(KeyEvent.VK_CONTROL);  //pressing ctrl key
	  Thread.sleep(3000);
	  robo.keyPress(KeyEvent.VK_V);        //pressing v key
	  robo.keyRelease(KeyEvent.VK_CONTROL);  // releasing ctrl key
	  Thread.sleep(3000);
	  robo.keyRelease(KeyEvent.VK_V);     // releasing v key
	  robo.keyPress(KeyEvent.VK_ENTER);   // pressing enter key
	  Thread.sleep(3000);
	  robo.keyRelease(KeyEvent.VK_ENTER);  //releasing enter key
	  System.out.println("File Uploaded");
	  

  }
  @BeforeMethod
  public void beforeMethod()
  {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	 // driver.get("https://demo.guru99.com/test/upload/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
  }

  @AfterMethod
  public void afterMethod()
  {
	 // driver.close();
  }

}
