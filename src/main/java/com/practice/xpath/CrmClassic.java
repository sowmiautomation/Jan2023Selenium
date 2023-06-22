package com.practice.xpath;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrmClassic {
      static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.get("https://classic.crmpro.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		By userName= By.xpath("//input[@placeholder='Username']");
		By passWord= By.xpath("//input[@placeholder='Password']"); 
		By submit= By.xpath("//input[@type='submit']"); 
		By contacts= By.linkText("CONTACTS");
		doSendValue(userName, "Sowmiya");
		doSendValue(passWord, "yaj321990");
		getElement(submit).click();
		switchFrame("mainpanel");
		getElement(contacts).click();
		checkSelctName("Alex Griffin");
		System.out.println(getCompanyName("Peter Kroll"));
		System.out.println(getContactName("Amazon"));
		System.out.println(persnDetail("Den Herder Sara"));
		
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static void doSendValue(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void switchFrame(String value) {
		driver.switchTo().frame(value);
	}
	
	public static void checkSelctName(String ContactName) {
		
		List<WebElement> check= getElements(By.xpath("//a[text()='"+ ContactName +"']/parent::td/preceding-sibling::td/input[@type='checkbox']"));
	    for(WebElement e: check) {
	    	e.click();
	    }
	}
	
	public static List<String> getCompanyName(String ContactName) {
		List<WebElement> companyName= getElements(By.xpath("//a[text()='"+ ContactName +"']/parent::td/following-sibling::td/a[@context='company']"));
	    List<String> compnyName= new ArrayList<String>();
		for(WebElement e: companyName) {
	    	String name= e.getText();
	    	compnyName.add(name);
	    }
		return compnyName;
		
	}
	
	public static List<String> getContactName(String compnyName) {
		List<WebElement> contactName= getElements(By.xpath("//a[text()='"+compnyName+"']/parent::td/preceding-sibling::td/a"));
		List<String> contctName= new ArrayList();
		for(WebElement e:contactName) {
	    	String name= e.getText();
	    	contctName.add(name);
	    }
		return contctName;

}
	public static List<String> persnDetail(String ContactName) {
		List<WebElement> personDetail= getElements(By.xpath("//a[text()='"+ContactName+"']/parent::td/following-sibling::td"));
	    List<String> persnDetil= new ArrayList<String>();
		 for(int i=0; i<personDetail.size()-1; i++){
			WebElement detail= personDetail.get(i);
			String details= detail.getText();
			persnDetil.add(details);
			
	    }
		return persnDetil;
	}
}
