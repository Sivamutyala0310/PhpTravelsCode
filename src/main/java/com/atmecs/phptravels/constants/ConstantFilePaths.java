package com.atmecs.phptravels.constants;

import java.io.File;

public class ConstantFilePaths 
{
	public final static String homeDir = System.getProperty("user.dir") + File.separator;

	public final static String chrome_Home = homeDir + "lib" + File.separator;
	public final static String CHROME_FILE = chrome_Home + "chromedriver.exe";

	public final static String fireFox_Home = homeDir + "lib" + File.separator;
	public final static String FIREFOX_FILE = fireFox_Home + "geckodriver.exe";

	public final static String IE_Home = homeDir + "lib" + File.separator;
	public final static String IE_FILE = IE_Home + "IEDriverServer.exe";

	public final static String config_Home = homeDir +  File.separator;
	public final static String CONFIG_FILE = config_Home + "config.properties";

	public final static String locators_Home = homeDir + "resources" + File.separator + "locators" + File.separator;
	public final static String LOCATORS_FILE = locators_Home + "phptravels_locators.properties";

	public final static String log4j_Home = homeDir + "resources" + File.separator + "log4j" + File.separator;
	public final static String LOG4J_FILE = log4j_Home + "log4j.properties";

	public final static String testData_Home = homeDir + "resources" + File.separator + "testdata" + File.separator;
	public final static String TESTDATA_FILE = testData_Home + "phptravels.xlsx";

	public final static String userTestData_Home = homeDir + "resources" + File.separator + "testdata" + File.separator;
	public final static String USERTESTDATA_FILE = testData_Home + "phpTravelsUserData.xlsx";

	public final static String validation_testData = homeDir + "resources" + File.separator + "testdata"
			+ File.separator;
	public final static String ValidationTESTDATA_FILE = validation_testData + "validation_testdata.properties";

}
