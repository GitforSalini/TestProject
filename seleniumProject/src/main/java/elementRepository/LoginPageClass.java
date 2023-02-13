package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass 

{
	WebDriver driver;

	@FindBy(name="username")
	WebElement userName;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signInBtn;

	@FindBy(xpath="//b[text()='7rmart supermarket']")
	WebElement title7rmartsupermarket;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	WebElement adminName;
	
	@FindBy(xpath="//h5[text()=' Alert!']")
	WebElement alertMsg;
	
	@FindBy(name="remember_me")
	WebElement rememberMeCheckBox;

	public LoginPageClass(WebDriver driver)
	{
		this.driver=driver;     //local driver is inializing using test class driver
		PageFactory.initElements(driver,this);  //test class driver is passed as parameter
		//pagefactory is a static class and initelements is a static method inside this class and it is used to initialize webelements
	}

	public void enteruserName(String uname)
	{
		userName.sendKeys(uname);
	}
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickOnSignIn()
	{
		signInBtn.click();
	}
	
	public boolean is7rmartsupermarketDisplayed()
	{
		return(title7rmartsupermarket.isDisplayed());
	}
	
	public String getTextOf7rmartsupermarket()
	{
		return title7rmartsupermarket.getText();
	}
	
	public boolean isadminNameDisplayed()
	{
		return(adminName.isDisplayed());
	}
	
	public boolean isAlertMsgDisplayed()
	{
		return(alertMsg.isDisplayed());
	}
	public boolean isRememberMeCheckBoxSelected()
	{
		return(rememberMeCheckBox.isSelected());
	}
}
