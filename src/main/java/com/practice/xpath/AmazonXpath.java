package com.practice.xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonXpath {
	static WebDriver driver;
	public static void main(String[] args) {
	    driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		By amznFirstFooter= By.xpath("(//td[contains(@class,'DescItem')])[last()-(last()-1)]");
		By amznLastFooter= By.xpath("(//td[contains(@class,'DescItem')])[last()]");
	    String firstText= getText(amznFirstFooter);
	    System.out.println(firstText);
	    String lastText= getText(amznLastFooter);
	    System.out.println(lastText);
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	public static String getText(By locator) {
		return getElement(locator).getText();
	}


}
