package com.nemo.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nemo.qa.base.TestBase;
import com.nemo.qa.pages.LoginPage;


public class LoginTest extends TestBase 
{
	LoginPage loginpage;
	
	LoginTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void setup()
	{
		initialization();
		 loginpage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void validatelogintitle()
	{
		String title = loginpage.validatePageTitle();
		Assert.assertEquals(title,"Springer Medizin – das Fachportal für Ärzte | springermedizin.de");
	}
	
	@Test(priority=2)
	public void login()
	{
		loginpage.login();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
