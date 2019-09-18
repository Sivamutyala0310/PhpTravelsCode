package com.atmecs.phptravels.helpers;

import java.io.IOException;
import java.util.Properties;
import com.atmecs.phptravels.utils.ReadLocatorsFile;

public class LoginPageData {

	String clickOnMyAccountXpath;
	String signUpDropDown;
	String firstNameXpath;
	String lastNameXpath;
	String mobileNumberXpath;
	String emailXpath;
	String passwordXpath;
	String confirmPasswordXpath;
	String signUpXpath;
	String emptySignUpXpath;
	

	Properties properties;

	public void getData() throws IOException {
		properties = ReadLocatorsFile.loadProperty(com.atmecs.phptravels.constants.ConstantFilePaths.LOCATORS_FILE);
		setClickOnMyAccountXpath();
		setFirstNameXpath();
		setLastNameXpath();
		setMobileNumberXpath();
		setEmailXpath();
		setPasswordXpath();
		setConfirmPasswordXpath();
		setSignUpXpath();
		setSignUpDropDown();
		setEmptySignUpXpath();
	}

	public String getclickOnMyAccountXpath() {
		return clickOnMyAccountXpath;
	}

	public void setClickOnMyAccountXpath() {
		clickOnMyAccountXpath = properties.getProperty("clickingMyAccountXpath");
	}

	public String getSignUpDropDown() {
		return signUpDropDown;
	}

	public void setSignUpDropDown() {
		signUpDropDown = properties.getProperty("signUpDropDownXpath");
	}

	public String getFirstNameXpath() {
		return firstNameXpath;
	}

	public void setFirstNameXpath() {
		firstNameXpath = properties.getProperty("firstNameXpath");
	}

	public String getLastNameXpath() {
		return lastNameXpath;
	}

	public void setLastNameXpath() {
		lastNameXpath = properties.getProperty("lastNameXpath");
	}

	public String getMobileNumberXpath() {
		return mobileNumberXpath;
	}

	public void setMobileNumberXpath() {
		mobileNumberXpath = properties.getProperty("mobileNumberXpath");
	}

	public String getEmailXpath() {
		return emailXpath;
	}

	public void setEmailXpath() {
		emailXpath = properties.getProperty("emailXpath");
	}

	public String getPasswordXpath() {
		return passwordXpath;
	}

	public void setPasswordXpath() {
		passwordXpath = properties.getProperty("passwordXpath");
	}

	public String getConfirmPasswordXpath() {
		return confirmPasswordXpath;
	}

	public void setConfirmPasswordXpath() {
		confirmPasswordXpath = properties.getProperty("confirmPasswordXpath");
	}

	public String getSignUpXpath() {
		return signUpXpath;
	}

	public void setSignUpXpath() {
		signUpXpath = properties.getProperty("signUpXpath");
	}
	public String getEmptySignUpXpath() {
		return emptySignUpXpath;
	}

	public void setEmptySignUpXpath() {
		emptySignUpXpath =properties.getProperty("clickingEmptySignUp") ;
	}

	public static void main(String[] args) throws IOException {

		LoginPageData keys = new LoginPageData();
		keys.getData();
	}

}
