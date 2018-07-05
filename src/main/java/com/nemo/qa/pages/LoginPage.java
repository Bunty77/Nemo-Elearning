package com.nemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nemo.qa.base.TestBase;

public class LoginPage extends TestBase
{
	
	@FindBy(className="personalisation__login")
	WebElement personalisation__login;
	
	
	@FindBy(id="username")
	WebElement username;
	
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(name="submit")
	WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	
	public void login()
	{
		personalisation__login.click();
		username.sendKeys(prop.getProperty("Username"));
		password.sendKeys(prop.getProperty("Password"));
		loginBtn.click();
	}
	
	

}
