package com.atmecs.phptravels.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.atmecs.phptravels.helpers.LoginPageData;
import com.atmecs.phptravels.helpers.ProfilePageData;
import com.atmecs.phptravels.helpers.Waits;
import com.atmecs.phptravels.pageactions.PageActions;
import com.atmecs.phptravels.reports.ExtentReport;
import com.atmecs.phptravels.reports.LogReports;
import com.atmecs.phptravels.testbase.TestBase;
import com.atmecs.phptravels.utils.TestDataProvider;
import com.atmecs.phptravels.validateSignUp.SignUp;
import com.atmecs.phptravels.validateSignUp.SignUpPassword;

public class PhpTravels_signUp extends TestBase
{
	LogReports log = new LogReports();
	LoginPageData data = new LoginPageData();
	ProfilePageData profileData = new ProfilePageData();
	ExtentReport report = new ExtentReport();

	@BeforeTest
	public void startReports() 
	{                     
		report.startReport();                                // ExtentReports
	}

	@Test(dataProvider = "testdata", dataProviderClass = TestDataProvider.class)       // providing data from excelfile to dataprovider

	public void signUp(String firstName, String lastName, String mobileNumber, String email, String password,
			String confirmPassword) throws Exception 
	{
		ExtentReport.logger = extent.startTest("signUp");
		data.getData();
		profileData.getData();

		PageActions.clickElement(driver, data.getclickOnMyAccountXpath());
		log.info("navigating to Php travels website");
		log.info("clicking on  my accunt");

		PageActions.clickElement(driver, data.getSignUpDropDown());
		log.info("selecting sign up dropdown");

		PageActions.sendKeys(driver, data.getFirstNameXpath(), firstName);
		log.info("sending first name to signUp field");
                                                                             // sending required details to the signup field
		PageActions.sendKeys(driver, data.getLastNameXpath(), lastName);
		log.info("sending lastname to signUp field ");

		PageActions.sendKeys(driver, data.getMobileNumberXpath(), mobileNumber);
		log.info("sending mobile nbr to signUp field");

		PageActions.sendKeys(driver, data.getEmailXpath(), email);
		log.info("sending email to signUp field");

		PageActions.sendKeys(driver, data.getPasswordXpath(), password);
		log.info("sending password to signUp field");

		PageActions.sendKeys(driver, data.getConfirmPasswordXpath(), confirmPassword);
		log.info("sending confirm password to signUp field");

		Waits.explicitWaitClick(driver, data.getSignUpXpath());
		log.info(" User  able to signUp successfully");

		PhpTravels_profile.validateProfile();                   // validating profile

		PageActions.clickElement(driver, profileData.getProfileAccount());                // clicking on logout profile
		PageActions.clickElement(driver, profileData.getProfileLogout());

		SignUp.validateSignUpEmail();                   // validating SignUp Email field giving value without domain

		SignUp.validateSignUp();                        // validating SignUp field giving any values to the fields

		SignUpPassword.validatePasswordField();                 // validating password field

	}
}
