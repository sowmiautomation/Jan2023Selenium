package com.practice.xpath;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.practice.selenium.Verify;

public class CssSelect {
	static WebDriver driver;
	
	public static void main(String[] args) {
		
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
			By email= By.cssSelector("[type= 'text'][name='email']");
			By passwrd= By.cssSelector("[type= 'password']");
			By submit= By.cssSelector("[value='Login']");
			By warnTxt= By.xpath("//div[contains(text(),'Warning')]");
			By evenLink= By.cssSelector(".list-group>a:nth-child(even)");
			By footrFirst= By.cssSelector("footer .row>.col-sm-3:first-child li");
			doSendKey(email, "sowmi3535@gmail.com");
			doSendKey(passwrd, "yaj321990");
			doClick(submit);
			String warnText= getTxt(warnTxt);
			Verify.containsValues(warnText, "Warning:");
		    List<String> lists= getTxts(evenLink);
			Verify.containsValues(lists, "Downloads");
			List<String> ftrLists= getTxts(footrFirst);
			System.out.println(ftrLists);
			Verify.containsValues(ftrLists, "Privacy Policy"); 
			
			
			
	}
   
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKey(By locator, String value) {
		 driver.findElement(locator).clear();
		 driver.findElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		 driver.findElement(locator).click();
	}
	
	public static String getTxt(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public static List<String> getTxts(By locator) {
		List<WebElement> lnkList=  driver.findElements(locator);
		List<String> lnkLists= new ArrayList<String>();
		
		for(WebElement e:lnkList) {
			String txt= e.getText();
			lnkLists.add(txt);
		}
		
	
		return lnkLists;
}
}
