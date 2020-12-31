package Resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Resources.Base;

public class Listeners extends Base implements ITestListener{
	
	//WebDriver driver;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("test Failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WebDriver initialize() throws IOException {
		// TODO Auto-generated method stub
		return super.initialize();
	}

	@Override
	public void launchApp() throws IOException {
		// TODO Auto-generated method stub
		super.launchApp();
	}

	@Override
	public void quitDriver() {
		// TODO Auto-generated method stub
		super.quitDriver();
	}
	
	

}
