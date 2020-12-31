package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/*
 * Assignment as below :
 * Write few testNG test cases
 * * Listners 
 *  Logger
 * Properties file
 * Run from Maven
 * Jenkins
 * Extent Reports
 * 
 */


public class Base {
	
	WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getClass());
	
	public ExtentHtmlReporter reporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	
	@BeforeSuite()
	public void suiteInitialization() {
		
		
		// Below can also be loaded via a configuration..
		System.out.println("In Before Suite...");
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReports/report.html");
		reporter.config().setDocumentTitle("End to End test");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setTimeStampFormat("MM DD YYYY hh:mm:ss");
		reporter.config().setReportName("My First Extent report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@AfterSuite()
	public void suiteTermination() {
		extent.flush();
	}
	
	public WebDriver initialize() throws IOException {
		
		FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/user.properties");
		
		Properties p = new Properties();
		p.load(f);
		
		String browser = p.getProperty("browser");
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/onkar/Downloads/chromedriver_87.0.4280.88");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browser.equals("IE")) {
			driver = new InternetExplorerDriver();
			
		}
		
		return driver;
	}
	
	
	
	public void launchApp() throws IOException {
		
		Properties p = new Properties();
		FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/user.properties");
		
		p.load(f);
		
	
		System.out.println("Project Dir is " + System.getProperty("user.dir"));
		
		driver.get(p.getProperty("url"));
	}
	
	
	public void takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		
		File out = new File(System.getProperty("user.dir") + "/images/file.png");
		
		FileUtils.copyFile(fs, out);
		
		
	}
	
	
	@AfterMethod()
	public void quitDriver() {
		System.out.println("In After Code...");
		driver.quit();
	}

}
