package com.practice.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowFrame {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(5000);
		/*String fieldOne= "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#kils\")";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement name = (WebElement)js.executeScript(fieldOne);
		name.sendKeys("Sowmiya");

		/*String  frame= "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#pact1\")";
		JavascriptExecutor js_frame = (JavascriptExecutor)driver;
		WebElement frameWeb = (WebElement)js_frame.executeScript(frame);
		js_frame.*/


		/*String destiny= "document.querySelector(\"#glaf\")";
		JavascriptExecutor js_des = (JavascriptExecutor)driver;
		WebElement destWeb = (WebElement)js_des.executeScript(destiny);
		destWeb.sendKeys("Tirupur");*/

		//driver.switchTo().frame("pact1");
		//driver.findElement(By.id("glaf")).sendKeys("Tirupur");

		//WebElement shadowDomHostElement2 = driver.findElement(By.cssSelector("#app2"));
		//SearchContext last2 = (SearchContext)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", shadowDomHostElement2);
		//Thread.sleep(1000);
		//WebElement iFrame = last2.findElement(By.cssSelector("#pact1"));		
		//driver.switchTo().frame(iFrame);
		//WebElement pizza = last2.findElement(By.cssSelector("#pizza"));
		//last2.findElement(By.cssSelector("#pizza")).sendKeys("pizza");
		//driver.findElement(By.id("glaf")).sendKeys("pizza");

		//Working - Naveen Solution
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		String frameOne= "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#pact1\")";
		WebElement frame = (WebElement)js.executeScript(frameOne);
		driver.switchTo().frame(frame);
		driver.findElement(By.id("glaf")).sendKeys("Tirupur");*/

		//Working - Manoj Solution
		WebElement shadowDomHostElement = driver.findElement(By.cssSelector("#userName"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		SearchContext last = (SearchContext)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", shadowDomHostElement);
		Thread.sleep(1000);
		WebElement iFrame = last.findElement(By.cssSelector("#pact1"));		
		driver.switchTo().frame(iFrame);
		driver.findElement(By.id("glaf")).sendKeys("Tirupur");
		System.out.println(driver.findElement(By.id("close")).getText());
		driver.switchTo().defaultContent();
		
		WebElement app2 = last.findElement(By.cssSelector("#app2"));	
		SearchContext last2 = (SearchContext)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", app2);
		Thread.sleep(1000);
		last2.findElement(By.cssSelector("#pizza")).sendKeys("pizza");
		
		

		
		

	}

}
