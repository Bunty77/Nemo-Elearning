package com.nemo.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nemo.qa.utils.TestUtil;

public class TestBase 
{

	public static WebDriver driver;
	public static Properties  prop = new Properties();
	
	public TestBase()
	{
		
		try
		{
		File f1 = new File("../NemoElearningTest/src/main/java/com/nemo/qa/config/config.properties");
		FileInputStream fileInput = null;

		fileInput = new FileInputStream(f1);

		prop.load(fileInput);
		
		System.out.println(prop.getProperty("URL"));
		System.out.println(prop.getProperty("Username"));
		System.out.println(prop.getProperty("Password"));
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void initialization()
	{
		String browsername = prop.getProperty("Browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new FirefoxDriver();
			
		}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	
	}
	
	
	
	
}
