package com.practice.windowhandles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesTwo {

		 static WebDriver driver;
			public static void main(String[] args) throws InterruptedException {
			         driver= new ChromeDriver();
					driver.manage().window().maximize();
					driver.get("https://opensource-demo.orangehrmlive.com/");
					String parentWindowId= driver.getWindowHandle();
					Thread.sleep(3000);
					clickOnLink("twitter");
					clickOnLink("facebook");
					clickOnLink("linkedin");
					clickOnLink("youtube");
					
					Set<String>windows= driver.getWindowHandles();
					Iterator<String> it= windows.iterator();
					while(it.hasNext()) {
						String child= it.next();
						driver.switchTo().window(child);
						String url= driver.getCurrentUrl();
						System.out.println(url);
						if(!child.equals(parentWindowId)) {
							driver.close();
							driver.switchTo().window(parentWindowId);
							System.out.println(driver.getCurrentUrl());
						}
					}

	}
					public static void clickOnLink(String url) {
						driver.findElement(By.xpath("//a[contains(@href, '"+ url +".com')]")).click();
					}

}
