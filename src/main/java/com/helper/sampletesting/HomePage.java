package com.helper.sampletesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;

	String title;

	public HomePage(WebDriver d) {
		driver = d;
	}

	By tabMyAccount = By.xpath("//span[contains(text(),'My Account')]");
	By tabLogin = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
	By textemailAddress = By.xpath("//*[@id=\"input-email\"]");
	By textpassword = By.xpath("//*[@id=\"input-password\"]");
	By buttonLogin = By.xpath("//input[@value='Login' and @type='submit']");
	By buttonHome= By.xpath("//*[@id=\"account-account\"]/ul/li[1]/a");
	By listProduct = By.xpath("//*[@id=\"content\"]//a");
	By tabLaptopAndNotebook = By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/a");
	By showLaptopAndNotebook =By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a");
	By sortByPrice = By.xpath("//*[@id=\"input-sort\"]");
	By selectMacBookPro = By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[1]/a/img");
	By addQuantity=By.xpath("//*[@id=\"input-quantity\"]");
	By buttonAddToCart = By.xpath("//*[@id=\"button-cart\"]");
	By buttonShoppinCart = By.xpath("//*[@id=\"cart\"]/button");
	
	
	
	
	

	public void clickMyAccount() {
		driver.findElement(tabMyAccount).click();
	}

	public void clickTabLogin() {
		driver.findElement(tabLogin).click();
	}

	public void enterEmail() {
		driver.findElement(textemailAddress).sendKeys("sctestqa@gr.la");
	}

	public void enterPassword() {
		driver.findElement(textpassword).sendKeys("Sct@123");
	}

	public void clickLoginButton() {
		driver.findElement(buttonLogin).click();
	}

	public void clickHomeButton() {
		driver.findElement(buttonHome).click();
	}
	
	
	public void clickLaptopAndNotebookTab() {
		driver.findElement(tabLaptopAndNotebook).click();
	}
	
	public void clickShowLaptopAndNotebook() {
		driver.findElement(showLaptopAndNotebook).click();
	}
	
	public void sortByPriceHigh() {
	WebElement sl=(WebElement) driver.findElements(sortByPrice);
	Select sel=new Select(sl);
	sel.selectByVisibleText("Price (High > Low)");
	
	}
	
	public void clickMacBookPro() {
		//WebElement el= new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeSelected(selectMacBookPro));
		driver.findElement(selectMacBookPro).click();
	}
	
	public void enterQuantity() {
		driver.findElement(addQuantity).sendKeys("2");
	}
	
	public void clearAddQunatity() {
		driver.findElement(addQuantity).clear();
	}
	
	public void clickAddToCart() {
		driver.findElement(buttonAddToCart).click();
	}
	
	public void clickShoppinCart() {
		driver.findElement(buttonShoppinCart).click();
	}
			


	public void getLabelAndPrice() {
		List<WebElement> el=driver.findElements(listProduct);
		for (WebElement Each :el)
		{
			System.out.println(el.iterator());
		}
		
		
		
		
		
		}
}
