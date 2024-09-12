package testcases;

import org.testng.annotations.Test;

import org.testng.Assert;

import pageobjects.HomePage;
import pageobjects.RegisterPage;

public class TC001_AccountRegisterTest extends BaseTest {

	HomePage hp;
	RegisterPage rg;

	@Test(priority = 1,groups = {"Regresstion","Master"})
	public void verifyHomePage() {
		logger.info("****** Strating HomePage****** ");
		try {
			
		
		hp = new HomePage(driver);
		logger.info("****** MyAccount******");
		hp.clickMyAccount();
		logger.info("****** Register******");
		hp.clickRegister();
		logger.info("******Sucesss Acess ******");
		//Assert.assertEquals(driver.getTitle(), "Register Account");
	

			logger.info("@@@@@@@@@Straring Regitser");
			rg = new RegisterPage(driver);
			logger.info("$$$providing all Detais&&&&");
			rg.setTxtFirstName(rg.randomString().toUpperCase());
			rg.setlastName(rg.randomString().toUpperCase());
			rg.setEmail(rg.randomString() + "@gmail.com");
			rg.setPassword(rg.randomNumber());
			// rg.clickSubscribe();
			rg.clickPrivcyPolicy();
			logger.info("**** Submite ******");
			rg.clickonsubmite();
			logger.info("As valided expected message ");
		
			
			String confmsg=rg.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");

		logger.info("finished");
		}
	}

}
}
