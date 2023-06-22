package com.practice.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestParty {
	static WebDriver  driver;         
	public static void main(String[] args) throws InterruptedException {
		 driver= new ChromeDriver();
		driver.get("http://po-admin.thestudiohash.com/");
		WebElement ele= getElement(By.name("email"));
		ele.sendKeys("admin@party.one");
		WebElement elePwd= getElement(By.name("password"));
		elePwd.sendKeys("Password!123");
		WebElement elebtn= getElement(By.tagName("button"));
		elebtn.click();
		Thread.sleep(2000);
		WebElement eleClub= getElement(By.xpath("//div[text()='Clubs']"));
		eleClub.click();
		Thread.sleep(3000);
		
				List<WebElement> clubLists=  driver.findElements(By.xpath("//p[text()='Silent Noise Club']"));
				boolean flag= false;
				Thread.sleep(3000);
				 for(WebElement e: clubLists ) {
					String text= e.getText();
					
					 if(text.contains("Silent Noise Club")) {
						 System.out.println("The Club is present");
						flag=  true;
						System.out.println(text);
						break;
					 }else {
					     flag = false;
					     System.out.println(flag);
					 }
					 
				 
				 }
			
				
			   	  
			 
			
		
		
		
	}
	 public static WebElement getElement(By locator) {
          return driver.findElement(locator);
     }

}
