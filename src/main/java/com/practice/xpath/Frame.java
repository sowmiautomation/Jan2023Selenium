package com.practice.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {
	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-scenario/");
		//FrameOne
		By frameOne= By.cssSelector("[placeholder='First Crush']");
		By frameOneLoctr= By.cssSelector("[id='pact1']");
		By frameOneBtn= By.xpath("//button[@id='lost']");
		
		//FrameTwo
		By frameTwo= By.cssSelector("[id='jex']");
		By frameTwoLoctr= By.cssSelector("#pact2");
		By frameTwoBtn= By.cssSelector("#connect");
		
		//FrameThree
		By frameThree= By.cssSelector("[id='glaf']");
		By frameThreeLoctr= By.cssSelector("#pact3");
		By frameThreeBtn= By.cssSelector("#close");
				
		// FrameOne Action		
		switchFrame(frameOneLoctr);
		doSendKey(frameOne, "Sowmiya");
		doClick(frameOneBtn);
		
		//FrameTwoAction
		switchFrame(frameTwoLoctr);
		doSendKey(frameTwo, "Sowmiya");
		doClick(frameTwoBtn);
		
		//FrameThreeAction
		switchFrame(frameThreeLoctr);
		doSendKey(frameThree, "Sowmiya");
		doClick(frameThreeBtn);
		
		driver.switchTo().parentFrame();
		
		doSendKey(frameTwo, "Manoj");
		doClick(frameTwoBtn);



	}
	public static WebElement getElement(By locator) {
		return  driver.findElement(locator);
	}

	public static void doSendKey(By locator, String value) {	
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static void switchFrame(By locator) {
		WebElement ele= getElement(locator);
		driver.switchTo().frame(ele);
	}


}
