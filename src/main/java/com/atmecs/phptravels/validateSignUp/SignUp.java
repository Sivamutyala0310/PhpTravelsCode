package com.atmecs.phptravels.validateSignUp;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.phptravels.helpers.LoginPageData;
import com.atmecs.phptravels.helpers.Waits;
import com.atmecs.phptravels.pageactions.PageActions;
import com.atmecs.phptravels.reports.LogReports;
import com.atmecs.phptravels.testbase.TestBase;
import com.atmecs.phptravels.utils.ReadLocatorsFile;
import com.atmecs.phptravels.validateprofile.ValidateResult;

public class SignUp extends TestBase {

	static LoginPageData data = new LoginPageData();
	static LogReports log = new LogReports();
	static Properties properties;
	static String value;

	static String actualRequiredFieldsValues;

	static String expectedRequiredFields = "The Email field is required." + "\n" + "The Password field is required."
			+ "\n" + "The Password field is required." + "\n" + "The First name field is required." + "\n"
			+ "The Last Name field is required.";

	static String actuallEmailError;

	static String expectedEmailError = "The Email field must contain a valid email address.";

	public static void validateSignUp() 
	{
		log.info("validating SignUp field");
		validate();                                  // calling validate method
		PageActions.clickElement(driver, data.getSignUpXpath());
		log.info("without filling any required fields directly clicking on signUp function");
		actualRequiredFieldsValues = PageActions.fetchAttributeText(driver, data.getEmptySignUpXpath());   // actualresult
		log.info("Asseting SignUp field");
		ValidateResult.validateData(actualRequiredFieldsValues, expectedRequiredFields, "validatingSignUpFunction");
	                                                  // validating signup function without filling any required fields
	}
	public static void validateSignUpEmail() throws Exception {
		properties = ReadLocatorsFile.loadProperty(com.atmecs.phptravels.constants.ConstantFilePaths.ValidationTESTDATA_FILE);
		log.info("validating SignUp Email field");
		validate();
		value = properties.getProperty("firtsName");
		PageActions.sendKeys(driver, data.getFirstNameXpath(), value);

		value = properties.getProperty("lastName");
		PageActions.sendKeys(driver, data.getLastNameXpath(), value);

		value = properties.getProperty("mobileNumber");
		PageActions.sendKeys(driver, data.getMobileNumberXpath(), value);

		value = properties.getProperty("wrongEmail");
		PageActions.sendKeys(driver, data.getEmailXpath(), value); // validating mail without @domain syntax

		value = properties.getProperty("password");
		PageActions.sendKeys(driver, data.getPasswordXpath(), value);

		value = properties.getProperty("confirmPassword");
		PageActions.sendKeys(driver, data.getConfirmPasswordXpath(), value);

		Waits.explicitWaitClick(driver, data.getSignUpXpath());

		actuallEmailError = PageActions.fetchAttributeText(driver, data.getEmptySignUpXpath());

		log.info(" Asserting SignUpEmail field");
		ValidateResult.validateData(actuallEmailError, expectedEmailError, "validating SignUp Email field");	
	}
	
	public static void validate() {
		try {

			data.getData();
			PageActions.clickElement(driver, data.getclickOnMyAccountXpath());
			log.info("clicking my accunt");

			PageActions.clickElement(driver, data.getSignUpDropDown());
			log.info("selecting sign up dropdown");
		} catch (IOException e) {

			e.printStackTrace();
			log.info("exception raised in selecting SignUp");
		}
	}

}
