package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//locators
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement buttonLogin;

	// Action method
	public void setEmail(String Email) {
		txtEmail.sendKeys(Email);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickmainLogin() {
		Actions act = new Actions(driver);
		act.moveToElement(buttonLogin).click().perform();
	}

}
