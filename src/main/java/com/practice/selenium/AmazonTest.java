package com.practice.selenium;

public class AmazonTest {
	public static void main(String[] args)  {
	BrowserUtil browserUtil= new BrowserUtil();
	browserUtil.intiDriver("chrome");
	browserUtil.launchUrl("http://www.amazon.com");
	String title= browserUtil.getPageTitle();
	System.out.println(title);
	Verify.equalValues("Amazon.com. Spend less. Smile more.", title);
	String url= browserUtil.getPageUrl();
	Verify.containsValues(url, "amazon");
	browserUtil.tearDown();
	}

}
