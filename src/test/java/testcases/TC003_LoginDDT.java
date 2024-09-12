package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import utilities.DataProviders;

//Data is valid ---login success--Test pass--logout

//Data is valid--login failed--Test fail

//Data is invalid --login success--Test fail--logout

//Data is invalid---login failed-- test pass

public class TC003_LoginDDT extends BaseTest {
	LoginPage lp;
	HomePage hp;
	MyAccountPage mp;
	
		@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups = "DataDriven")
		public void verify_loginDDT(String email, String password, String exp)
		{
			logger.info("**** Starting TC_003_LoginDDT *****");
			
			try {
		
			//Home page
				HomePage hp=new HomePage(driver);
				hp.clickMyAccount();
				hp.ckLogin(); //Login link under MyAccount
					
				//Login page
				LoginPage lp=new LoginPage(driver);
				lp.setEmail(email);
				lp.setPassword(password);
				lp.clickmainLogin(); //Login button
					
				//My Account Page
				MyAccountPage macc=new MyAccountPage(driver);
				boolean targetPage=macc.isMyAccountPageExists();
				
				if(exp.equalsIgnoreCase("Valid"))
				{
					if(targetPage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				
				if(exp.equalsIgnoreCase("Invalid"))
				{
					if(targetPage==true)
					{
						macc.clickLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
			}
			catch(Exception e)
			{
				Assert.fail("An exception occurred: " + e.getMessage());
			}
				
			logger.info("**** Finished TC_003_LoginDDT *****");
		}
		
	}

