package com.practice.xpath;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.practice.selenium.Verify;

public class HTMLTable {
	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		By header= By.xpath("//table[@id='customers']//th");
	  
		//row==//table[@id='customers']//tr
		System.out.println(getElements(header));
		List<String> list= personDetail();
		Verify.containsValues(list, "Sowmi Chang");
	
		
		
	}
	
	public static int RowCount() {
	    return driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
	   
	}
	
	public static List<String> getElements(By locator) {
		List<WebElement> headers= driver.findElements(locator);
		List<String> headersList= new ArrayList<String>();
		for(WebElement e: headers) {
			String header= e.getText();
			headersList.add(header);
		}
		return headersList;
	}
	
	public static List<String> personDetail() {
		 String  beforeXpath= "//table[@id='customers']//tr[";
	 	 String afterXpath= "]/td";
		 List<String> lists= new ArrayList<String>();
		for(int i=2; i<=RowCount(); i++) {
			String path= beforeXpath+ i + afterXpath;
			 List<WebElement>list= driver.findElements(By.xpath("" +path+" "));
			  for(WebElement e: list) {
				  String text= e.getText();
				   lists.add(text);
			  }		
		}
		 return lists;
		
	}
	 
	

	

}
