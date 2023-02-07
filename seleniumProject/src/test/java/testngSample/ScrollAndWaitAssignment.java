package testngSample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollAndWaitAssignment 
{
	WebDriver driver;
	@Test
	public void varifyingSuccessfullLogin()
	{
		WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement login=driver.findElement(By.xpath("//button[@name='login-button']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
		WebElement carolThomas=driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		String expected="CAROL THOMAS";
		String actual=carolThomas.getText();
		Assert.assertEquals(actual,expected);
	}
	@Test
	public void varifyingUnsuccessfullLogin()
	{
		WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("Charoll");
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement login=driver.findElement(By.xpath("//button[@name='login-button']"));
		login.click();
		WebElement errorMsg=driver.findElement(By.xpath("//*[text()='Incorrect username or password.']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(errorMsg));
		System.out.println(errorMsg.getText());
		String expected="Incorrect username or password.";
		String actual=errorMsg.getText();
		Assert.assertEquals(actual,expected);


	}

	@Test
	public void varifyingDashboardPageisDisplayingAfterLogin()
	{

		WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement login=driver.findElement(By.xpath("//button[@name='login-button']"));
		login.click();
		WebElement dashboardMsg=driver.findElement(By.xpath("//*[text()='Welcome to Payroll Application']"));
		System.out.println(dashboardMsg.getText());
		String expected="Welcome to Payroll Application";
		String actual=dashboardMsg.getText();
		Assert.assertEquals(actual,expected);

	}
	@Test
	public void varifyingCreationOfNewClient()
	{
		WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement login=driver.findElement(By.xpath("//button[@name='login-button']"));
		login.click();
		WebElement clients=driver.findElement(By.xpath("//a[text()='Clients']"));
		clients.click();
		WebElement createClient=driver.findElement(By.xpath("//a[text()='Create Client']"));
		createClient.click();
		WebElement branch=driver.findElement(By.xpath("//select[@id='client-branch_id']"));
		Select selectBranch=new Select(branch);
		selectBranch.selectByVisibleText("Alpha_new");
		WebElement invoiceOrder=driver.findElement(By.xpath("//select[@id='client-invoice_order']"));
		Select selectinvoice=new Select(invoiceOrder);
		selectinvoice.selectByVisibleText("Invoice per worker");
		WebElement division=driver.findElement(By.xpath("//select[@id='client-division_id']"));
		Select selectDivision=new Select(division);
		selectDivision.selectByVisibleText("NewAlpha");
		WebElement invoiceContract=driver.findElement(By.xpath("//input[@id='client-invoice_contact']"));
		invoiceContract.sendKeys("ABC");
		WebElement invoiceDeliveryMethod=driver.findElement(By.xpath("//select[@id='client-invoice_delivery_method']"));
		Select selectDelMethod=new Select(invoiceDeliveryMethod);
		selectDelMethod.selectByIndex(1);
		WebElement clientName=driver.findElement(By.xpath("//input[@id='client-client_name']"));
		clientName.sendKeys("Salini");
		WebElement phone=driver.findElement(By.xpath("//input[@id='client-phone']"));
		phone.sendKeys("9744496651");
		WebElement masterDocument=driver.findElement(By.xpath("//select[@id='client-master_document']"));
		Select selectmasterDoc=new Select(masterDocument);
		selectmasterDoc.selectByIndex(2);
		WebElement address=driver.findElement(By.xpath("//textarea[@id='client-client_address']"));
		address.sendKeys("HouseNo-10,Eroor,Ernakulam");
		WebElement settlementDays=driver.findElement(By.xpath("//input[@id='client-settilement_days']"));
		settlementDays.sendKeys("3");
		WebElement postcode=driver.findElement(By.xpath("//input[@id='client-postcode']"));
		postcode.sendKeys("682306");
		WebElement email=driver.findElement(By.xpath("//input[@id='client-email']"));
		email.sendKeys("salini@gmail.com");
		WebElement companyreg=driver.findElement(By.xpath("//input[@id='client-company_reg']"));
		companyreg.sendKeys("2015");

		WebElement vatRate=driver.findElement(By.xpath("//select[@id='client-vat_rate']"));
		Select selectVatRate=new Select(vatRate);
		selectVatRate.selectByIndex(2);
		WebElement save=driver.findElement(By.xpath("//button[text()='Save']"));
		save.submit();

		WebElement createdClientName=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered detail-view']//tr[3]//td[1]"));
		String expected="Salini";
		String actual=createdClientName.getText();
		Assert.assertEquals(actual,expected);

		WebElement updatedBy=driver.findElement(By.xpath("//table[@id='w0']//tr[26]//th"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();",updatedBy);
		js.executeScript("window.scrollBy(0,1000)");

	}


	@BeforeMethod
	public void beforeMethod() 
	{

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void afterMethod()
	{
		//driver.quit();
	}
}
