package com.atmecs.phptravels.tests;

import com.atmecs.phptravels.reports.LogReports;
import com.atmecs.phptravels.validateprofile.Profile;
import com.atmecs.phptravels.validateprofile.ValidateResult;

public class PhpTravels_profile extends PhpTravels_signUp 
{
	static String expectedProfile;
	static String actualProfile;
	
	static LogReports log = new LogReports();

	public static void fetchingProfileData() throws Exception 
	{

		log.info("fetching data from profile");

		actualProfile = Profile.fetchingProfileData();           // fetching user credentials from profile

		log.info("fetched data from profile successfully");
	}

	
	public static void validateProfile() throws Exception 
	{ 
		fetchingProfileData();                         // calling fetching profile data()
		
		expectedProfile = Profile.expectedProfile();    // validating user created successfully or not
		log.info("Asserting profile");

		ValidateResult.validateData(actualProfile, expectedProfile, " user profile not matched");
		
		log.info("user profile creation validated successfully");
		

	}
}
