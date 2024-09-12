package pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement txPassword;

	@FindBy(xpath = "//input[@id='input-newsletter']")
	private WebElement checkSubscribe;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement checkPrivcyPolicy;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	private WebElement submite;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	// Action method
	public void setTxtFirstName(String firstname) {
		txtFirstName.sendKeys(firstname);
	}

	public void setlastName(String lastname) {
		txtLastName.sendKeys(lastname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		txPassword.sendKeys(password);
	}

	public void clickSubscribe() {
		checkSubscribe.click();
	}

	public void clickPrivcyPolicy() {
		Actions act = new Actions(driver);
		act.moveToElement(checkPrivcyPolicy).click().perform();
		// checkPrivcyPolicy.click();
	}

	public void clickonsubmite() {
		submite.click();
	}
	/*
	 * public void displayConfirmationMessage() { confirmationMessage.isDisplayed();
	 * }
	 * 
	 */

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(5);
		return generatedNumber;
	}
}
