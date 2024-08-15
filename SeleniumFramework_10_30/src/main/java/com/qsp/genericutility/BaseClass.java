package com.qsp.genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import com.qsp.objectrepository.HomePage;
import com.qsp.objectrepository.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	public FileUtility fileUtility;
	public HomePage homepage;
	public LoginPage loginpage;
	public JavaUtility SystemTime;
	public ExcelUtility excelutility;

	@BeforeClass
	public void LaunchBrowser(@Optional("chrome")String browserName) throws IOException
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		fileUtility = new FileUtility();
		String url = fileUtility.getDataFromProperty("url");
		driver.get(url);
	}
	@BeforeMethod
	public void LoginPages() throws IOException 
	{
		String email = fileUtility.getDataFromProperty("email");
		String pwd = fileUtility.getDataFromProperty("pwd");
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		
		homepage.getLoginLink().click();
		loginpage.getEmailTextField().sendKeys(email);
		loginpage.getPasswordTextField().sendKeys(pwd);
		loginpage.getLoginButton().click();
	}
	@AfterMethod
	public void LogoutPage()
	{
		homepage.getLoginOutLink();
	}
	@AfterClass
	public void ClosePage()
	{
		driver.quit();
	}


}
