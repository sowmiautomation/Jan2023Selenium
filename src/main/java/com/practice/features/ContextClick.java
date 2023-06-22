package com.practice.features;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {

	public static void main(String[] args) throws Exception {

		WebDriver driver= new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		By line= By.xpath("//li[contains(@class,'context-menu-not-selectable')]");
		WebElement Notselect= driver.findElement(line);

		for(int i=1; i<=6; i++) {
			Actions action= new Actions(driver);
			WebElement ele= driver.findElement(By.cssSelector("span.context-menu-one "));	
			action.contextClick(ele).build().perform();
			Thread.sleep(1000);
			//WebElement eleTwo= driver.findElement(By.cssSelector("li.context-menu-icon:nth-child("+i+")"));
			WebElement eleTwo= driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon')]["+i+"]/span[1]"));
			//if(!eleTwo.getAttribute("class").contains("separator")) {
			eleTwo.click();
			Alert alert=  driver.switchTo().alert();
			String text= alert.getText();
			alert.accept();
			System.out.println(text);

			//}



		}



	}

}
