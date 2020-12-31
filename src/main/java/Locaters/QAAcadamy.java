package Locaters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QAAcadamy {
	
	By btn = By.cssSelector(".btn.btn-theme.btn-sm.btn-min-block");
	WebDriver driver;
	public static Logger log = LogManager.getLogger(QAAcadamy.class.getClass());
	
	public QAAcadamy(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public WebElement getBtn() {
		log.info("Reading Button text");
		return driver.findElement(btn);
	}

}
