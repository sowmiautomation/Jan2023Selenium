package com.practice.naveenapp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.practice.selenium.BrowserUtil;
import com.practice.selenium.Verify;

public class TestNaveenApp {

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil browsrUtil= new BrowserUtil(); 
		WebDriver driver= browsrUtil.intiDriver("chrome");
		browsrUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		//browsrUtil.tearDown();
		ElemUtill element= new ElemUtill(driver);
		By firstName= By.id("input-firstname");
		By lastName= By.id("input-lastname");
		By email= By.id("input-email");
		By phone= By.id("input-telephone");
		By passwrd= By.id("input-password");
		By confrmPasswrd= By.id("input-confirm");
		By chckBox= By.name("agree");
		By contBtn= By.xpath("//input[@type='submit']");
		By accCreate= By.tagName("h1");
		By accNotCreate= By.cssSelector("#account-register > div.alert.alert-danger.alert-dismissible");
		By footerLink= By.xpath("//footer//a");
		By giftCertHeader= By.xpath("//h1");
		By rifghtHandLink= By.cssSelector("a.list-group-item");
				
		// SignUP Page Validation
	/*	element.doSendKeys(firstName, "Sowmiya");
		element.doSendKeys(lastName, "Chinnasamy");
		element.doSendKeys(email, "sowmi5@gmail.com");
		element.doSendKeys(phone, "890990799");
		element.doSendKeys(passwrd, "sowmi@123");
		element.doSendKeys(confrmPasswrd, "sowmi@123");
		element.doSendKeys(firstName, "Sowmi");
		element.doClick(chckBox);
		element.doClick(contBtn);
		String text= element.doGetTxt(accCreate);
		boolean verify= Verify.equalValues(text, "Your Account Has Been Created!");
		if(verify==false) {
			String errorMsg= element.doGetTxt(accNotCreate);
			System.out.println(errorMsg);
		}
		//Footer links validation
		element.doClicklinklist(footerLink, "Gift Certificates");
		String textGiftHeader= element.doGetTxt(giftCertHeader);
	    boolean VeifyGiftHeader= Verify.containsValues(textGiftHeader, "Certificate");
	    if(VeifyGiftHeader== true) {
	    	System.out.println("Validation is Passed");
	    }*/
	    List<String> linkList= element.selectLinkFromSection(rifghtHandLink);
	    System.out.println(linkList);
	    
	    String fnplaceHolder= element.getAttributeValue(firstName, "placeholder");
	    Verify.equalValues(fnplaceHolder, "First Name");
	    String lnplaceholder= element.getAttributeValue(lastName, "placeholder");
	    Verify.equalValues(lnplaceholder, "Last Name");
	    
		
		
			
		//Thread.sleep(3000);
		//browsrUtil.tearDown();
		
		
		
		
		

	}

}
