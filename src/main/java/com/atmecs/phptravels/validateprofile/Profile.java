package com.atmecs.phptravels.validateprofile;

import com.atmecs.phptravels.helpers.ProfilePageData;
import com.atmecs.phptravels.pageactions.PageActions;
import com.atmecs.phptravels.reports.LogReports;
import com.atmecs.phptravels.testbase.TestBase;
import com.atmecs.phptravels.utils.ExcelFileWriter;

public class Profile extends TestBase
{
	static String actualFirstName;
	static String actualLastName;
	static String actualMobileNumber;
	static String actualEmail;
	static String actualProfile;
	
	static LogReports log = new LogReports();
	
	static ProfilePageData data = new ProfilePageData();

	public static String fetchingProfileData() throws Exception 
	{
		data.getData();
		
		PageActions.clickElement(driver, data.getProfileXpath());
		
		ProfileDateAndTime.getDataAndTime();                       //getting System date and time
		
		ProfileDateAndTime.profileDateAndTime();                  //getting date and time of the  user  when he created his account.
		
		actualFirstName = PageActions.fetchAttributeValue(driver, data.getProfileFirstNameXpath());
		log.info("fetching actual firstname value from profile :" + actualFirstName);            // fetching user details from  profile page
		
		ExcelFileWriter.test(actualFirstName);                                        // storing actual firstname to excelfile 
		
		actualLastName = PageActions.fetchAttributeValue(driver, data.getProfileLastNameXpath());
		log.info("fetching actual Lastname value from profile :" + actualLastName);
		
		actualMobileNumber = PageActions.fetchAttributeValue(driver, data.getProfileMobileNumberXpath());
		log.info("fetching actual mobile number value from profile :" + actualMobileNumber);
		
		actualEmail = PageActions.fetchAttributeValue(driver, data.getProfileEmailXpath());
		log.info("fetching actual email value from profile :" + actualEmail);
		
		actualProfile = PageActions.fetchHtmlAttributeValue(driver, data.getValidateProfileXpath());
		log.info("actual profile is:"+actualProfile);
		return actualProfile;                                                           // returning actualProfile  to validate at validateResult
	}

	public static String expectedProfile() 
	{
		String expectedProfile = "H"+","+" " + actualFirstName +" "+ actualLastName;
		return expectedProfile;                                                                //returning expectedProfile to validate.
										
	}
	
			  
	
}

 
 