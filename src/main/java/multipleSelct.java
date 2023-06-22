import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class multipleSelct {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  {
		 driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		By firstName= By.name("RESULT_TextField-1");
		By lastName= By.name("RESULT_TextField-2");
		By phoneNumber= By.name("RESULT_TextField-3");
		By countryField= By.name("RESULT_TextField-4");
		By cityField= By.name("RESULT_TextField-5");
		By emailField= By.name("RESULT_TextField-6");
	    By gender= By.xpath("//div[@id='q26']//td//label");
	    By week= By.xpath("//div[@id='q15']//td//label");
	    By timeContact= By.id("RESULT_RadioButton-9");
	    By submit= By.name("Submit");
	    By fieldOne= By.id("field1");
	   // getElement(fieldOne).sendKeys("world");
	    getElement(firstName).sendKeys("Sowmiya");
	    getElement(lastName).sendKeys("Chinnasamy");
	    getElement(phoneNumber).sendKeys("99999999");
	    getElement(countryField).sendKeys("TamilNadu");
	    getElement(cityField).sendKeys("Tiruchy");
	    getElement(emailField).sendKeys("so@gmail.com");
	    Thread.sleep(1000);
	    genderSelect(gender, "female");
	    Thread.sleep(3000);
	    selectDayWeek(week, "Sunday","Tuesday","Friday");
	    selectByText(timeContact, "Evening");
	    getElement(submit).click();
	    
	    
	 
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static void switchToFrame(int i) {
		driver.switchTo().frame(i);
	}
	
	public static String getText(By locator) {
		return getElement(locator).getText();
	}
	
	public static void genderSelect(By locator, String value) {
		List<WebElement> genderList= getElements(locator);
	    for(WebElement e: genderList) {
	    	String text= e.getText();
	    	if(text.equalsIgnoreCase(value)) {
	    		e.click();
	    		break;
	    	}
	    }
	}
	
	public static void selectDayWeek(By locator, String...value) throws InterruptedException {
		List<WebElement> weekDays= getElements(locator);
		for(WebElement e: weekDays) {
			String text= e.getText();
			System.out.println(text);
			Thread.sleep(1000);
			 for(int i=0; i<value.length;i++) {
				 if(text.equals(value[i])){
					 e.click();
					 
				 }
			 }
		}
	}
	
	public static void selectByText(By locator, String value) {
		Select select= new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

}
