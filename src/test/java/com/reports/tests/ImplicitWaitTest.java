package com.reports.tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWaitTest {

	public WebDriver driver;
	public int TIME_OUT = 10;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
	}

	@Test
	public void verifyCalendar() {
		WebElement imgCalendar = driver.findElement(By.id("calendar"));
		assertTrue(imgCalendar.getAttribute("src").toString().contains("calendar"));
	}
	
	@AfterMethod
	public void tearDown()  {
		if(driver!=null) {
			driver.quit();
		}

	}

}
