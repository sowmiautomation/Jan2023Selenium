package com.practice.naveenapp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.practice.selenium.MyException;

public class ElemUtill {
	private WebDriver driver;
	public ElemUtill(WebDriver driver) {
		this.driver= driver;
	}
	
	public void doSendKeys(By locator, String value) {
		if(value== null) {
			throw new MyException("NULLVALUEEXCEPTION");
		}
		doClear(locator);
		getElement(locator).sendKeys(value);
	}
	
	public  WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public void doClear(By locator) {
		getElement(locator).clear();
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doGetTxt(By locator) {
		return getElement(locator).getText();
	}
	
	public void doClicklinklist(By locator, String linkName) {
		List<WebElement> link= getElements(locator);
		for(WebElement e: link) {
			String text= e.getText();
			if(text.equals(linkName)) {
				e.click();
				break;
			}
		}	
	}
	
	public List<String> selectLinkFromSection(By locator) {
		List<WebElement> links= getElements(locator);
		List<String> text= new ArrayList<String>();
		for(WebElement e: links) {
			String txt= e.getText();
			text.add(txt);
		}
		return text;
	}
	
	public String getAttributeValue(By locator, String attrValue) {
		return getElement(locator).getAttribute(attrValue);
	}
	

}
