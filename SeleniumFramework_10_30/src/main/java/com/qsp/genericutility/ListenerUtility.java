package com.qsp.genericutility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerUtility extends BaseClass implements ITestListener
{
	public WebDriverUtility TakeScreenShot;
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test Scrips is failed",true);

		String MethodName = result.getName();
		TakeScreenShot = new WebDriverUtility(driver);
		try {
			TakeScreenShot.takeScreenshot(driver, MethodName);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Scrips is Passed",true);

		String methodName = result.getName();
		TakeScreenShot = new WebDriverUtility(driver);
		try {
			TakeScreenShot.takeScreenshot(driver, methodName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
