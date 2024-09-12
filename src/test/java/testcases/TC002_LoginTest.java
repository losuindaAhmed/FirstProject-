package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

public class TC002_LoginTest extends BaseTest {
	LoginPage lp;
	HomePage hp;
	MyAccountPage mp;

	@Test(groups = {"Sanity","Master"})

	public void clickLogin() {
		logger.info("*****Start Script*********");
		try {

			hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.ckLogin();
			// 
			lp = new LoginPage(driver);
			lp.setEmail("admin88@gmail.com");
			lp.setPassword("6010");
			lp.clickmainLogin();
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExists();
			if (targetPage==true) {
				Assert.assertTrue(true);
			
			}
				else {
					Assert.fail();
				}
		}
			catch (Exception e) {
				Assert.fail();
			}
			}
}
