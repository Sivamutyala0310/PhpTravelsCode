package com.atmecs.phptravels.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.phptravels.pageactions.PageActions;

public class Waits {
	
	static WebElement element;

	public static void explicitWaitClick(WebDriver driver,String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 20);                           // explicit wait and click()
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));    
		PageActions.performActionEnter(driver);
	}

	public  static void explicitWait(WebDriver driver,String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 20);                    // explicit wait 
		 element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	/*
	 * public void fluentWait(WebDriver driver) {
	 * 
	 * @SuppressWarnings("deprecation") Wait<WebDriver> wait = new
	 * FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
	 * .pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class); }
	 */
}
