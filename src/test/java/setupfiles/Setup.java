package setupfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Setup {
 static public WebDriver driver=null;
	
	public WebDriver Browser(String Browser)
	{
	
		if(Browser.equals("Firefox"))
		{
	 System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Drivers\\geckodriver.exe");
	 driver = new FirefoxDriver();
		}
	 else if(Browser.equals("Chrome"))
	 {
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
	 }
	
		String url = "http://book.theautomatedtester.co.uk/";
        driver.get(url);
		return driver;
		
	}
	
	//Element Paths for links
	
	 public By Chapter = By.xpath("//a[contains(text(), 'Chapter1')]");
	 public By Chapter4 = By.xpath("//a[contains(text(), 'Chapter4')]");
 
	 //Element for dropdown and radio
	 
	 public By radiobutton = By.id("radiobutton");
	
	 
	//Element Chapter4 mouse hover
	 
	 public By mouse = By.xpath("//*[@id=\"hoverOver\"]");
	 public By Textbox = By.id("blurry");
	 public By selectload = By.id("selectLoad");
	 

}
