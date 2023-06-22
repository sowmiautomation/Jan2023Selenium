package com.practice.select;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelect {
	static WebDriver driver;
	public static void main(String[] args) {

		driver= new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		By multiDrop = By.xpath("(//div[@class='comboTreeWrapper'])[2]//button");
		By multiOptList= By.xpath("(//div[@class='comboTreeDropDownContainer'])[2]//li/span");
		By multiOptList1= By.xpath("(//div[@class='comboTreeDropDownContainer'])[2]//li/span/input");
		getElement(multiDrop).click();
		deSlectMultiCasCade(multiOptList, multiOptList1, "all");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}

	public static void multiWithCascade(By locator,By locatorTwo, String...value) {
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
			List<WebElement> multiListCheckbx= getElements(locatorTwo);	
			for(WebElement e:multiListCheckbx ) {
				String text= e.getText();
				if(!e.isSelected()) {
					if(!text.equals("−")) {		
						e.click();
						flag = true;
					}
				}


			}
		}
		if(flag==false) {
			System.out.println("No option");
		}
	}

	public static void deSlectMultiCasCade(By locator, By locator2, String...value) {
		multiWithCascade(locator, locator2,  value);
		List<WebElement> list= getElements(locator2);
		for(WebElement e: list) {
			String txt= e.getText();
			if(e.isSelected()) {
				if(!txt.equals("−")) {
					e.click();
				}
			}


		}

	}


}
