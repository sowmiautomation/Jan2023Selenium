import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectTest {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		By selctCoun= By.id("Form_getForm_Country");
		By selctContryPath= By.xpath("//select[@id='Form_getForm_Country']/option");
		SelectUtil selectUtil= new  SelectUtil(driver);
		//selectUtil.selctDropDownSelctVal(selctCoun, "India");
		 //selectUtil.selctDropDownGetOpt(selctCoun, "seattle");
		selectUtil.selctFromDropDownWoSelct(selctContryPath, "seattle");

	}

}
