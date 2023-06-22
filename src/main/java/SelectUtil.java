import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtil {
     private WebDriver driver;
    
	public SelectUtil(WebDriver driver) {
		this.driver= driver;
	}


	public void selctDropDownSelctVal(By locator, String selctValue) {
		Select select= new Select(getElement(locator));
		select.selectByValue(selctValue);
	}
	
	public void selctDropDownGetOpt(By locator, String value) {
		Select select= new Select(getElement(locator));
		List<WebElement>optionList= select.getOptions();
		for(WebElement e: optionList ) {
			String text= e.getText();
			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public boolean selctFromDropDownWoSelct(By locator, String value) {
		boolean flag= false;
		List<WebElement> selctOptionList= getElements(locator);
		for(WebElement e: selctOptionList) {
			String text= e.getText();
			if(text.equals(value)) {
				flag= true;
				e.click();
				break;
			}
		}
		if(flag==false) {
			System.out.println(value+ " is not present in the option");
		}
		return flag;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
}
