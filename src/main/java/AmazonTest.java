import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonTest {
	
	public static void main(String[] args)  {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver;
		String browser= "Chrome";
		switch (browser) {
		case "Chrome":
			driver= new ChromeDriver(options);	
			break;
		case "Firefox":
			driver= new FirefoxDriver();	
			break;
		case "Edge":
			driver= new EdgeDriver();	
			break;
		default:
			System.out.println("Please pass valid browser");
			 throw new MyException("NullPointerException");
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.amazon.com");
		String title= driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Books");
		driver.findElement(By.xpath("//*[@id=\"nav-search-bar-form\"]/div[3]/div")).click();
		//driver.close();
	}

}
