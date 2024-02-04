package com.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPOM {

	
	WebDriver driver;
	By userId=By.id("username");
	By passId=By.id("password");
	By useDomainId=By.id("mydomainLink");
	By useCustomHeaderId=By.xpath("//title[text()='Use Custom Domain | Salesforce']");
	
	public loginPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUserName(String user)
	{
		driver.findElement(userId).sendKeys(user);
	   
	}

	public void enterPass( String pass)
	{
		
	    driver.findElement(passId).sendKeys(pass);
	}
	
	public void clickOnUseDomainLink()
	{
		driver.findElement(useDomainId).click();
	}
	
	public void verifyUseDomainTitle()
	{
	
	if(driver.findElement(useCustomHeaderId).isDisplayed())
	{
		String title=driver.findElement(useCustomHeaderId).getText();
		System.out.println("POM-->Use Custom domain title is "+title);
	}
	}
}
