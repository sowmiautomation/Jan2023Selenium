package com.practice.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;;


public class RelativeLocator{
	
	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		WebElement ele= driver.findElement(By.cssSelector(".agree"));
		driver.findElement(with(By.cssSelector("[type='checkbox']")).toRightOf(ele)).click();
		WebElement ele1= driver.findElement(By.cssSelector("[type='radio'][value='0']"));
		driver.findElement(with(By.cssSelector("[type='radio'][value='1'][name='newsletter']")).toLeftOf(ele1)).click();

	}

}
