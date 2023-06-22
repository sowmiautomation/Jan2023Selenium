package com.practice.xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(3000);
		WebElement next= driver.findElement(By.linkText("Next"));
		//WebElement next= driver.findElement(By.xpath("//a[text()='Next']"));
		boolean check = false;
		String country = "Greece";

		do {
			Thread.sleep(3000);
			if(driver.findElements(By.xpath("//td[text()='"+country+"']")).size()>0) {
				List<WebElement>list= driver.findElements(By.xpath("//td[text()='"+country+"']/preceding-sibling::td/input[@type='checkbox']"));
				for(WebElement e: list ) {
					e.click();
					check = true;
				}	
			}
			next.click();
			next= driver.findElement(By.xpath("//a[text()='Next']"));
			Thread.sleep(3000);
		}while(!next.getAttribute("class").contains("disable"));

		if (!check) {
			System.out.println("NOT FOUND");
		}

	}/*else {
		System.out.println("pagination is over...country is not found...");
	}
	/*public static void selectCountry(String CountryName) {
		driver.findElement(By.xpath("//td[text()='"+CountryName+"']/preceding-sibling::td/input[@type='checkbox']")).click();
	}*/

	//}
}
