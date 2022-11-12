package testpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.helper.sampletesting.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePageTest {
	
	WebDriver driver;
	
	HomePage homePage;
	
	static ExtentReports report;
	static ExtentTest test;
	
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\desktop 7-9-15\\Session 2021-22\\Career Path\\Software Testing\\Selenium\\alldrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		homePage=new HomePage(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		report = new ExtentReports(
				"C:\\Users\\VJ\\eclipse-workspace\\SN\\src\\main\\resources\\DetailedReport\\ExtentReport.html", true);
		test = report.startTest("Generate Extent Report");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://tutorialsninja.com/demo/index.php");
		
	}


	@AfterClass
	public void closingTest() {
		
	}

	@AfterSuite
	public void closereport() {
		report.endTest(test);
		report.flush();
		driver.close();
	}
	
	@Test(priority=0)
	public void VerifyLoginTest() {
		homePage.clickMyAccount();
		homePage.clickTabLogin();
		homePage.enterEmail();
		homePage.enterPassword();
		homePage.clickLoginButton();
		
	}
		
	@Test(priority=1)
	public void verifyScrollDown() throws InterruptedException
	{
		
		homePage.clickHomeButton();
		
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,700)");
		Assert.assertTrue(true);
	}
	
	@Test(priority=2)
	public void verifyScrollUp() {
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("scroll(700,0)");
		homePage.clickLaptopAndNotebookTab();
		homePage.clickShowLaptopAndNotebook();
		Assert.assertTrue(true);
	}
	
	@Test(priority=3)
	public void sortByHighPrice() {
		
		homePage.sortByPriceHigh();
		Assert.assertTrue(true);
	}
	
	
	@Test(priority=4)
	public void verifyListofProducts() {
		homePage.getLabelAndPrice();
		
	}
	
	@Test(priority=5)
	public void clickMacBookProImage() throws InterruptedException {
		
		Thread.sleep(5000);
		homePage.clickMacBookPro();
		
	}
	
	@Test(priority=6)
	public void verifyAddQuantity() throws InterruptedException {
		homePage.clearAddQunatity();
		Thread.sleep(3000);
		homePage.enterQuantity();
	}
	
	@Test(priority=7)
	public void verifyAddToCart() {
		homePage.clickAddToCart();
	}
	
	@Test(priority=8)
	public void verifyShoppingCart() {
		homePage.clickShoppinCart();
	}
	}


