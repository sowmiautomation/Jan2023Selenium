import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.practice.selenium.BrowserUtil;

public class SelectOption {
       static WebDriver driver;
	public static void main(String[] args) {
//		driver= new ChromeDriver();
//		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
//		By countryCode= By.xpath("//select[@id='country_code']/option");
//		By countryState= By.xpath("//select[@id='Form_getForm_Country']/option");
//		
//		
//		doSelectFromDropdown(countryState,"Belarus");
//		
//	}
//	
//	public  static boolean doSelectFromDropdown(By locator, String value) {
//		boolean flag= false;
//		List<WebElement>codeList= getElements(locator);
//		for(WebElement e: codeList) {
//			String text= e.getText();
//			System.out.println(text);
//			if(text.equals(value)){
//				flag= true;
//				e.click();
//				break;
//			}
//		}
//		if(flag== false) {
//			System.out.println(value + "is not present in the dropdown" + locator);
//		}
//		return flag;
//	}
//	public static List<WebElement> getElements(By locator) {
//		return driver.findElements(locator);
//	
//	}
       driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By coutryOptions = By.xpath("//select[@id='Form_getForm_Country']/option");
		
		DoSelectValueFromDropDownWithoutSelect(coutryOptions, "India");

	}
	
	public static boolean DoSelectValueFromDropDownWithoutSelect(By locator, String value) {
		boolean flag = false;
		List<WebElement> optionsList = driver.findElements(locator);
		for(WebElement e : optionsList) {
			String text = e.getText();
				if(text.equals(value)) {
					flag = true;
					e.click();
					break;
				}
		}
		
		if(flag == false) {
			System.out.println(value + " is not present in the drop down " + locator);	
		}
		
		return flag;
		
	}
}
