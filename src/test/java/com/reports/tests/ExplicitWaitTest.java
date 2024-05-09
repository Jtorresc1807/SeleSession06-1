package com.reports.tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitTest {

	public WebDriver driver;  // creo un objeto driver de tipo WebDriver
	public WebDriverWait wait; // creo un objeto wait de tipo WebDriverWait
	public int TIME_OUT = 10;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver(); // instancio tipo firefox
		driver.manage().window().maximize();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
	}

	@Test
	public void verifyAward() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT)); //instanciando el objeto wait
		
		WebElement imgAward =  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("award")));
				
		assertTrue(imgAward.getAttribute("src").toString().contains("award"));
	}
	
	@AfterMethod
	public void tearDown()  {
		if(driver!=null) {
			driver.quit();
		}

	}

}
