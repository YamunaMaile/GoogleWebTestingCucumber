package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPF {

	WebDriver driver;
	@FindBy(xpath="//title[text()='Login | Salesforce']") WebElement SFLoginPageTitle;
	@FindBy(id="username") WebElement userId;
	@FindBy(id="password") WebElement passId;
	@FindBy(xpath="//a[@id='mydomainLink']") WebElement useDomainId;
	@FindBy(id="forgot_password_link") WebElement forgotPassId;
	@FindBy(xpath="//title[text()='Forgot Your Password | Salesforce']") WebElement forgotPassPageTitle;
	@FindBy(xpath="//title[text()='Use Custom Domain | Salesforce']")WebElement useCustomHeaderId;
		
public loginPF(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void SFLoginPageTitleVerify()
{
	if(SFLoginPageTitle.isDisplayed())
	{
		System.out.println("Sales Force Login page title is "+SFLoginPageTitle.getText());
	}
}

public void enterUserName(String user)
{
	userId.sendKeys(user);
   
}

public void enterPass( String pass)
{
	
    passId.sendKeys(pass);
}

public void clickOnForgotPasswordLink()
{
	forgotPassId.click();
}

public void verifyForgotPasswordTitle()
{

if(forgotPassPageTitle.isDisplayed())
{
	String title=forgotPassPageTitle.getText();
	System.out.println("Page factory-->Forgot password page title is "+title);
}
}

public void clickOnUseDomainLink() throws InterruptedException
{
	Thread.sleep(2000);
	useDomainId.click();
}

public void verifyUseDomainTitle()
{

if(useCustomHeaderId.isDisplayed())
{
	String title=useCustomHeaderId.getText();
	System.out.println("POM-->Use Custom domain title is "+title);
}
}

}
