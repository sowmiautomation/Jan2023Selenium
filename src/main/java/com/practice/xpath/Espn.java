package com.practice.xpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Espn {

	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.espncricinfo.com/");
		By table= By.xpath("(//span[text()= 'Table'])[1]");
		By scoreBoard= By.xpath("//span[text()= 'Scorecard']");
		doClick(table);
		doClick(scoreBoard);
		playerWktDtail("Sanju Samson");
		
		//span[text()='Devdutt Padikkal']//ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static void playerWktDtail(String playerName) {
		/*List<WebElement>*/ WebElement player= driver.findElement(By.xpath("//a[@title='"+playerName +"']/parent::td/following-sibling::td/span"));
		String playerWkt= player.getText();
		System.out.println(playerWkt);
		
		/*	for(WebElement e: player) {
		String playerWicket= e.getText();
		System.out.println(playerWicket);
		}*/
		
	}

}
