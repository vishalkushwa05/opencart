package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	

	@Test(groups = {"regression", "master"})
	public void verify_account_registration()
	{
	
	logger.info("**** starting TC_001_AccountRegistrationTest  *****");
	
	logger.debug("application logs started......");
	
	try
	{
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	logger.info("Clicked on MyAccount link");
	
	hp.clickRegister();
	logger.info("Clicked on registration link");
	
	
	logger.info("Entering customer details.. ");
	
	Thread.sleep(7000);
	AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
	
	regpage.setFirstName(randomeString().toUpperCase());
	regpage.setLastName(randomeString().toUpperCase());
	regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
	//regpage.setTelephone(randomeNumber());
	
	String password=randomAlphaNumeric();
	
	regpage.setPassword(password);
	//regpage.setConfirmPassword(password);
	Thread.sleep(3000);
	regpage.setPrivacyPolicy();
	
	Thread.sleep(3000);
	regpage.clickContinue();
	logger.info("clicked on continue..");
	
	
	Thread.sleep(3000);
	String confmsg=regpage.getConfirmationMsg();
	
	logger.info("Validating expected message..");
	
	Assert.assertEquals(confmsg, "Register Account");		
			
	}
	catch(Exception e)
	{
		logger.error("test failed..");
		logger.debug("debug logs....");
		Assert.fail();
	}
	
	logger.debug("application logs end.......");
	logger.info("**** finished TC_001_AccountRegistrationTest  *****");
	
}
	
}

