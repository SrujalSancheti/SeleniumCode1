package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SetupNTearDown;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(id="user-name")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button")
	private WebElement submit;
	
	public LoginPage(WebDriver driver){
//		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void enterUsernameAndPassword(String userName, String passWord) {
		username.sendKeys(userName);
		password.sendKeys(passWord);
		submit.click();                                                                                                                                                            
	}
	
	public void assertData() {
		SetupNTearDown.driverKiller(driver);	
	}
}
