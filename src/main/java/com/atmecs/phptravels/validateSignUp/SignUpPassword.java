package com.atmecs.phptravels.validateSignUp;

import com.atmecs.phptravels.helpers.Waits;
import com.atmecs.phptravels.pageactions.PageActions;
import com.atmecs.phptravels.utils.ReadLocatorsFile;
import com.atmecs.phptravels.validateprofile.ValidateResult;

public class SignUpPassword extends SignUp 
{
	static String expectedPasswordError="Password not matching with confirm password.";
	static String actualPasswordError;
	
	public  static void validatePasswordField() throws Exception
	{
	properties = ReadLocatorsFile.loadProperty(com.atmecs.phptravels.constants.ConstantFilePaths.ValidationTESTDATA_FILE);
	SignUp.validate();
	value = properties.getProperty("firtsName");
	PageActions.sendKeys(driver, data.getFirstNameXpath(), value);
	
	value = properties.getProperty("lastName");
	PageActions.sendKeys(driver, data.getLastNameXpath(), value);
	
	value = properties.getProperty("mobileNumber");
	PageActions.sendKeys(driver, data.getMobileNumberXpath(), value);
	
	value = properties.getProperty("email");
	PageActions.sendKeys(driver,data.getEmailXpath(), value);        // validating password  and confirm password fields
	
	value = properties.getProperty("password");
	PageActions.sendKeys(driver,data.getPasswordXpath(), value);
	
	value = properties.getProperty("wrongConfirmPassword");
	PageActions.sendKeys(driver,data.getConfirmPasswordXpath(), value);
	
	Waits.explicitWaitClick(driver, data.getSignUpXpath());
	
	actualPasswordError= PageActions.fetchAttributeText(driver, data.getEmptySignUpXpath());
	
	log.info("Asserting password and confirm password fields");
	ValidateResult.validateData(actualPasswordError, expectedPasswordError, "validating SignUp password field");
	}
	

}
