package End2End;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import Locaters.LandingPage;
import Locaters.QAAcadamy;
import Resources.Base;
import junit.framework.Assert;

public class MyTest extends Base{
	
	WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getClass());
	
	
	@Test
	public void clickConfirm() throws IOException, InterruptedException {
		driver = initialize();
		test=extent.createTest("Click Confirm");
		launchApp();
		
		log.info("Application Launched");
		test.log(Status.PASS, "Application Launched");
		
		LandingPage l = new LandingPage(driver);
		
		l.getConfirm().click();
		log.info("Clicked confirm");
		test.log(Status.PASS, "Clicked confirm");
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void selectExample() throws IOException, InterruptedException {
		driver = initialize();
		test=extent.createTest("Select Example");
		launchApp();
		log.info("Application Launched");
		test.log(Status.PASS, "Application Launched");
		
		
		LandingPage l = new LandingPage(driver);
		Select s = new Select(l.getSelect());
		
		s.selectByIndex(1);
		log.info("Value Selected");
		test.log(Status.PASS, "Value Selected");
		System.out.println(s.getFirstSelectedOption().getText());
		
		Thread.sleep(2000);
		
		AssertJUnit.assertEquals("Option1", s.getFirstSelectedOption().getText());
	}
	
	@Test
	public void qaClickAcadamy() throws IOException, InterruptedException {
		
		driver = initialize();
		test=extent.createTest("QA ClickAcadamy");
		launchApp();
		log.info("Application Launched");
		test.log(Status.PASS, "Application Launched");
		
		LandingPage l = new LandingPage(driver);
		l.getOpenTab().click();
		test.log(Status.PASS, "New tab opened");
		
		Set<String> s = driver.getWindowHandles();
		
		Iterator i = s.iterator();
		
		String parentWindow  = (String)i.next();
		String childWindow = (String) i.next();
		
		Thread.sleep(2000);
		
		driver.switchTo().window(childWindow);
		
		Thread.sleep(2000);
		
		QAAcadamy qa = new QAAcadamy(driver);
		Assert.assertEquals("JOIN NOW", qa.getBtn().getText());
		
		
	}
	

}
