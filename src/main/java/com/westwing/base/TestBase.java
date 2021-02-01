package com.westwing.base;

/*
 * 
 * By Rahul Tandur
 * TestBase Class is used to 
 * 		Load the configuration file properties to read user credentials and browser details.
 * 		Initialize driver and instantiate defined browser to run the test suite.
 * 
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.westwing.util.TestUtil;
import com.westwing.util.WebEventListener;

public class TestBase {

	public static WebDriver driver = null;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static DesiredCapabilities dCap = null;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\westwing\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() throws MalformedURLException{
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			dCap = DesiredCapabilities.chrome();
			dCap.setBrowserName("chrome");
			dCap.setPlatform(Platform.ANY);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\browserExeExecutables\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			dCap = DesiredCapabilities.firefox();
			dCap.setBrowserName("firefox");
			dCap.setPlatform(Platform.ANY);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\browserExeExecutables\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("internetExplorer")){
			dCap = DesiredCapabilities.internetExplorer();
			dCap.setBrowserName("iexplore");
			dCap.setPlatform(Platform.ANY);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\browserExeExecutables\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"),dCap);
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	


}
