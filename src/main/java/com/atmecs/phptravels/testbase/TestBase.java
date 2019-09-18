package com.atmecs.phptravels.testbase;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;

import com.atmecs.phptravels.constants.ConstantFilePaths;
import com.atmecs.phptravels.reports.ExtentReport;
import com.atmecs.phptravels.reports.LogReports;
import com.atmecs.phptravels.utils.ReadLocatorsFile;

public class TestBase extends ExtentReport {
	LogReports log = new LogReports();
	Properties baseProperty;
	String url;
	String browser;
	

	@BeforeMethod
	public void initializeBrowser() throws Exception {

		baseProperty = ReadLocatorsFile.loadProperty(ConstantFilePaths.CONFIG_FILE);

		url = baseProperty.getProperty("url");
		browser = baseProperty.getProperty("browserType");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ConstantFilePaths.CHROME_FILE);
			driver = new ChromeDriver();
			log.info("Chrome browser  started");
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ConstantFilePaths.FIREFOX_FILE);
			driver = new FirefoxDriver();
			log.info("Firefox browser  started");
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ConstantFilePaths.IE_FILE);
			driver = new InternetExplorerDriver();
			log.info("IE browser  started");
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}

