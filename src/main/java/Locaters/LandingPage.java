package Locaters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private By confirm = By.cssSelector("#confirmbtn");
	private By openTab = By.cssSelector(".btn-style.class1.class2");
	private By select = By.cssSelector("#dropdown-class-example");
	
	private By mouseHover = By.cssSelector("#mousehover");
	private By mouseHoverText = By.cssSelector(".mouse-hover div a:nth-child(1)");
	
	
	public static Logger log = LogManager.getLogger(LandingPage.class.getClass());
	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getConfirm() {
		log.info("Trying to click on Confirm");
		return driver.findElement(confirm);
		 
	}

	public WebElement getOpenTab() {
		log.info("Trying to open new tab..");
		return driver.findElement(openTab);
	}

	public WebElement getSelect() {
		log.info("Trying to Select Value from Select dropdown..");
		return driver.findElement(select);
	}

	public WebElement getMouseHover() {
		return driver.findElement(mouseHover);
	}

	public WebElement getMouseHoverText() {
		return driver.findElement(mouseHoverText);
	}

}
