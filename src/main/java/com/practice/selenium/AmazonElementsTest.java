package com.practice.selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonElementsTest {
      static WebDriver  driver;         
	
      public static void main(String[] args) {
		BrowserUtil eleUtil= new BrowserUtil();
	    driver= eleUtil.intiDriver("chrome");
		eleUtil.launchUrl("http:\\www.amazon.com");
		By amazImg= By.tagName("img");
		By aLink= By.tagName("a");
		List<WebElement> linkList= getElements(aLink);
		int linkSize= getElementCounts(aLink);
		System.out.println(linkSize);
		
		for(WebElement e: linkList) {	
			String linkText= e.getText();
			if(linkText.length()>0) {
				System.out.println(linkText);
			}
			
		}
		/*int count= getElementCounts(amazImg);
		System.out.println(count);
		List <String> list= getElementsAttribute(amazImg, "src");
		System.out.println(list);*/
		
	}
      
      public static int getElementCounts(By locator) {
    	return  getElements(locator).size();
    	
      }
      
      public static List<String> getElementsAttribute(By locator, String attriValue) {
    	  List<WebElement> eleList= getElements(locator);
    	  List<String> list= new ArrayList();
    	  for(WebElement e: eleList) {
    		 String alt= e.getAttribute(attriValue); 
    		 list.add(alt); 
    	  }
    	  return list;
      }
      
     public static List<WebElement> getElements(By locator) {
    	 return driver.findElements(locator);
     }
     
}
