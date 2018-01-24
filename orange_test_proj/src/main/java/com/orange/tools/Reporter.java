package com.orange.tools;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener2;
import com.orange.tools.AppTest;


public class Reporter implements IResultListener2{

	@Override
	public void onTestFailure(ITestResult result) {
		Object testObject = result.getInstance();
		if (testObject instanceof AppTest) {
			((AppTest) testObject).getTestedApp().takeScreenshot();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Object testObject = result.getInstance();
		if (testObject instanceof AppTest) {
			((AppTest) testObject).getTestedApp().takeScreenshot();
		}
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		try {
			System.out.println("Start: " + result.getName());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Object testObject = result.getInstance();
		if (testObject instanceof AppTest) {
			((AppTest) testObject).getTestedApp().takeScreenshot();
		}
		
	}

	public static void createSreenshot(){
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeConfiguration(ITestResult tr) {
		// TODO Auto-generated method stub
		
	}

}
