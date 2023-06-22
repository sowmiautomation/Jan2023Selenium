package com.practice.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowRoot {
	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page//");
		
		
		Thread.sleep(3000);
		String js_Path= "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement ele= (WebElement) js.executeScript(js_Path);
		ele.sendKeys("Chicken Pizza");
		
	}

}
