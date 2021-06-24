package demoLog;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Log4Demo {
	
	String url = "https://www.google.com";
	String driverPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
	
	WebDriver driver;
	
	
	@Test
	public void LoggerDemo() throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		
		
		Logger log = Logger.getLogger(Log4Demo.class); //can give any name probably inside parenthesis 
		
		
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src/test/java\\demoLog\\log4j.properties");
		
		
		driver.get(url);
		log.info("URL Accessed");
		
		driver.manage().window().maximize();
		log.info("Browser Maximized");
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.info("Implicit Wait has been set");
		
		
		Thread.sleep(1000);
		log.info("Thread sleeping");
		
		
		
		log.debug("Closing browser");
		driver.close();
	}


}
