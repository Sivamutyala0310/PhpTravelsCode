package com.atmecs.phptravels.validateprofile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.atmecs.phptravels.pageactions.PageActions;
import com.atmecs.phptravels.reports.LogReports;
import com.atmecs.phptravels.testbase.TestBase;
import com.atmecs.phptravels.utils.ExcelFileWriter;
import com.atmecs.phptravels.utils.ReadLocatorsFile;

public class ProfileDateAndTime extends TestBase {
	static LogReports report = new LogReports();
	static Properties properties;
	static String xpath;
	
	public static void getDataAndTime() 
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String dateAndTime = dateFormat.format(date);
		report.info("System Current date and time is " + dateAndTime);
	}

	public static void profileDateAndTime() throws Exception 
	{
	
		properties = ReadLocatorsFile.loadProperty(com.atmecs.phptravels.constants.ConstantFilePaths.LOCATORS_FILE);

		xpath = properties.getProperty("systemTimeXpath");

		String time = PageActions.fetchAttributeText(driver, xpath);
		ExcelFileWriter.test(time);                              // storing  profile creation time in excel file
		report.info("user profile creation  time is: " + time);


		xpath = properties.getProperty("systemDateXpath");
		String date = PageActions.fetchAttributeText(driver, xpath);
		ExcelFileWriter.test(date);                                   // storing profile creation  date in excel file
		report.info("user profile creation date is:" + date);
	}

}
