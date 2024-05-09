package com.reports.tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FluentWaitTest {

	public WebDriver driver;  // creo un objeto driver de tipo WebDriver
	public int TIME_OUT = 10;
	public int TIME_POLLING = 2; //default = 500ms
	

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver(); // instancio tipo firefox
		driver.manage().window().maximize();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
	}

	@Test
	public void verifyLandscape() {
		
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(TIME_OUT))
				.pollingEvery(Duration.ofSeconds(TIME_POLLING))
				.ignoring(NoSuchElementException.class);
		

		WebElement imgLandscape =  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
				
		assertTrue(imgLandscape.getAttribute("src").toString().contains("landscape"));
	}
	
	@AfterMethod
	public void tearDown()  {
		if(driver!=null) {
			driver.quit();
		}

	}

}
