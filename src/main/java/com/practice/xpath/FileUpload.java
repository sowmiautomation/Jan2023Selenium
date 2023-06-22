package com.practice.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
		static WebDriver driver;
		public static void main(String[] args) {
			driver= new ChromeDriver();
			driver.get("https://ps.uci.edu/~franklin/doc/file_upload.html");
			By file= By.cssSelector("[name='userfile']");
			
			doSendKey(file,"C:\\Users\\gokul\\Downloads\\sow.docx");
			
			
	}
		public static WebElement getElement(By locator) {
			return  driver.findElement(locator);
		}
		
		public static void doSendKey(By locator, String value) {
			getElement(locator).sendKeys(value);
		}

}
