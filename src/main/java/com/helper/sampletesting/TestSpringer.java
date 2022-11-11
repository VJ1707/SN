package com.helper.sampletesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSpringer {

	WebDriver driver;
	String title;
	boolean flag;

	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver","F:\\desktop 7-9-15\\Session 2021-22\\Career Path\\Software Testing\\Selenium\\alldrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.springernature.com/gp");
	}

	@Test(priority=1)
	public void verifyPageTitleTest() {
		title = driver.getTitle();
		System.out.println("The title of the webpage is: "+title);
		Assert.assertEquals(title, "Springer Nature");
	}

	
	@Test(priority=2)
	public void verifyLogo() {
	flag=driver.findElement(By.xpath("//a[@href=\"/gp\" and @title=\"Springer Nature\"]//img[@src=\"/app-sn/public/images/logo-springernature.svg\"]")).isDisplayed();
	Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void verifySearchButtonIsVisisbleTest() {
	flag=driver.findElement(By.xpath("//div[@class='logo-meta']//div[3]//div[contains(text(),'Search') and @class='link-menu-label']")).isDisplayed();
	Assert.assertTrue(flag);
	}

	@Test
	public void verifySearchButtonIsEnabledTest() {
	flag =driver.findElement(By.xpath("//div[@class='logo-meta']//div[3]//div[contains(text(),'Search') and @class='link-menu-label']")).isEnabled();
	Assert.assertFalse(flag);
	}
	
	@Test(priority=4)
	public void verifySearchClickTest() {
		driver.findElement(By.xpath("//div[@class='logo-meta']//div[3]//div[contains(text(),'Search') and @class='link-menu-label']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Automation Testing");
		driver.findElement(By.id("searchButton")).click();
	}

	

	@AfterTest
	public void Closingtest() {
		driver.close();
	}
}
