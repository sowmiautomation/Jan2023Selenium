package com.practice.select;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JquerySingleSelect {
	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		By singleDrop= By.xpath("(//div[@class='comboTreeWrapper'])[3]//button");
		By singleOptList= By.xpath("(//div[@class='comboTreeWrapper'])[3]//li/span");
		// getElement(singleDrop).click();
		// single selection
		//singleSelct(singleOptList, "choice 2");
		//multiselectionwith casecade
		By multiDrop = By.xpath("(//div[@class='comboTreeWrapper'])[2]//button");
		By multiOptList= By.xpath("(//div[@class='comboTreeWrapper'])[2]//div//li//span");
		getElement(multiDrop).click();
		multiWithCascade(multiOptList, "all");
		// MultiSelect
		By multiDropFirst= By.id("justAnInputBox");
		By multiOptFirstList= By.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//li/span");

		//getElement(multiDropFirst).click();
		//multiFirstSelect(multiOptFirstList, "all");
		//deSlectMultiFirst(multiOptFirstList, "all");

	}
	public static void multiFirstSelect(By locator, String...value) {

		List<WebElement> multiList= getElements(locator);
		boolean flag= false;
		if(!value[0].equalsIgnoreCase("all")) {
			for(WebElement e: multiList) {
				String text= e.getText();
				System.out.println(text);
				for(int i=0; i<value.length; i++) {
					if(text.equals(value[i])) {
						flag= true;
						e.click();
						break;

					}
				} 
			}
		}

		else {
			for(WebElement e: multiList) {
				String text= e.getText();
				System.out.println(text);
				if(!text.equals("−")) {
					e.click();
					flag= true;
				}
			}
		}

		if(flag==false) {
			System.out.println(" There is no option");
		}
	}


	public static void singleSelct(By locator, String value) {
		List<WebElement> singleList= driver.findElements(locator);
		for(WebElement e: singleList ) {
			String text= e.getText();
			System.out.println(text);
			if(text.contains(value)) {
				e.click();
				break;
			}
		}
	}

	public static void multiWithCascade(By locator, String...value) {

		List<WebElement> multiList= getElements(locator);
		boolean flag= false;
		if(!value[0].equals("all")) {
			for(WebElement e: multiList) {
				String text= e.getText();
				System.out.println(text);

				for(int i=0; i<value.length; i++) {
					if(text.equals(value[i])) {
						flag= true;
						e.click();
						break;

					}
				} 

			}
		}

		else {
			for(WebElement e: multiList) {
				String text= e.getText();
				System.out.println(text);
				if(!text.equals("−")) {	
					e.click();
					flag= true;		
					
				}

			}
		}

		if(flag= false) {
			System.out.println(" There is no option");
		}
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}

	public static void deSlectMultiFirst(By locator,String...value) {
		multiFirstSelect(locator, value);
		List<WebElement> list= getElements(locator);
		for(WebElement e: list) {
			String txt= e.getText();
			if(!txt.equals("−")) {
				e.click();
			}
		}




	}


}
