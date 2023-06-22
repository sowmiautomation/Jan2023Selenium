package com.practice.selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
	WebDriver driver;

	public WebDriver intiDriver(String browser) {
		if(browser==null) {
			System.out.println("please pass the browser");
			throw new MyException("NullException");
		}
		
	
        switch (browser.toLowerCase().trim()) {
		case "chrome":	
			driver= new ChromeDriver();
			break;
		case "firefox":
			driver= new FirefoxDriver();
			break;
		case "edge":
			driver= new EdgeDriver();
			break;
		default:
			System.out.println("Please pass the valid browser:"+ browser);
			throw new MyException("ValidBrowserException");
		}
        return driver;
	}
      
	public void launchUrl(String url) {
		
		if(url==null) {
			System.out.println("please enter thr URL: blank url will not be accepted");
			throw new MyException("BlankException");
		}
		
		if(url.contains("http")) {
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.get(url);
		}else {
			System.out.println("http(s) is missing: please pass valid url");
			throw new MyException("TypoErrorException");
		}
    }
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void tearDown() {
		driver.close();
	}
	
}
