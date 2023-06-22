package com.practice.xpath;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class ShadowDomIframe {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		
		
		//WebElement root1 = driver.findElement(By.id("userName"));
		
		//WebElement root2 = driver.findElement(By.xpath("//div[@id='userName' and @class='jackPart']"));

		/*SearchContext shadowRoot1 = getShadowRootElement(root1);
		WebElement shadowElement = shadowRoot1.findElement(By.cssSelector("#kils"));
		shadowElement.sendKeys("Test");*/

		
		/*WebElement shadowRoot2 = getShadowRootElementTry(root2);

		WebElement shadowElement = shadowRoot2.findElement(By.id("kils"));
		shadowElement.sendKeys("Test");*/

		//String pizza_JsPath = "return document.querySelector(\"#userName\")";
		
		Thread.sleep(3000);
		String pizza_JsPath = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#kils\")";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement tea = (WebElement)js.executeScript(pizza_JsPath);
		//tea.sendKeys("Masala Tea");
		js.executeScript("arguments[0].value='enter the value here';", tea);

		
		/*WebElement ele= (WebElement) js.executeScript(pizza_JsPath);
		driver.findElement(By.id("kils")).sendKeys("test");
		driver.switchTo().frame("pact1");
		driver.findElement(By.id("glaf")).sendKeys("text");*/
	}

	public static SearchContext getShadowRootElement(WebElement element) throws InterruptedException {
		SearchContext ele = (SearchContext) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
		Thread.sleep(3000);
		return ele;
	}
	
	public static WebElement getShadowRootElementTry(WebElement shadowHost) {
	    WebElement returnObj = null;
	    Object shadowRoot = ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowHost);
	    if (shadowRoot instanceof WebElement) {
	        // ChromeDriver 95
	        returnObj = (WebElement) shadowRoot;
	    } else if (shadowRoot instanceof Map) {
	        // ChromeDriver 96+
	        Map<String, Object> shadowRootMap = (Map<String, Object>) shadowRoot;
	        String shadowRootKey = (String) shadowRootMap.keySet().toArray()[0];
	        String id = (String) shadowRootMap.get(shadowRootKey);
	        RemoteWebElement remoteWebElement = new RemoteWebElement();
	        remoteWebElement.setParent((RemoteWebDriver) driver);
	        remoteWebElement.setId(id);
	        returnObj = remoteWebElement;
	    } else {
	        System.out.println("Unexpected return type for shadowRoot in getShadowRootElement()");
	    }
	    return returnObj;
	}
	
	
}

