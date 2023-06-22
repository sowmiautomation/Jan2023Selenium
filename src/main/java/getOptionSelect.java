import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class getOptionSelect {
    static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		By coutryOptions = By.id("Form_getForm_Country");
	//	getAllDropDownOptions(coutryOptions);
		doSelectFromDropDown(coutryOptions, "India");
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static int getDropDownValueCount(By locator) {
		return getAllDropDownOptions(locator).size();
	}
	
	public static List<String> getAllDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsValueList = new ArrayList<String>();
		System.out.println("total values : " + optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			optionsValueList.add(text);
		}
		return optionsValueList;
	}
	
	public static void doSelectFromDropDown(By locator, String value) {
		Select select= new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for(WebElement e: optionsList) {
			String text= e.getText();
			if(text.equals(value)){
				e.click();
				break;
			}
		}
	}
	
}
