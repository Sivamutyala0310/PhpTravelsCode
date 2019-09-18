package com.atmecs.phptravels.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.atmecs.phptravels.constants.ConstantFilePaths;
import com.atmecs.phptravels.reports.LogReports;
import com.atmecs.phptravels.utils.ReadLocatorsFile;

public class TestBaseXml {
		LogReports log = new LogReports();
		Properties baseProperty;
		String url;
		public WebDriver driver;

		@BeforeMethod
		@Parameters("selectBrowser")
		public void initializeBrowser(String selectBrowser ) throws Exception {

			baseProperty = ReadLocatorsFile.loadProperty(ConstantFilePaths.CONFIG_FILE);

			url = baseProperty.getProperty("url");

			if (selectBrowser.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", ConstantFilePaths.CHROME_FILE);
				driver = new ChromeDriver();
				log.info("Chrome browser  started");
			}
				
			 else if (selectBrowser.equalsIgnoreCase("firefox")) 
			 {
				System.setProperty("webdriver.gecko.driver", ConstantFilePaths.FIREFOX_FILE);
				driver = new FirefoxDriver();
				log.info("Firefox browser  started");
			}
				
			 else if (selectBrowser.equalsIgnoreCase("IE")) 
			 {
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


