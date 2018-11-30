package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import setupfiles.Setup;


public class Chapter2 extends Setup {
	Setup s = new Setup();
	WebDriver driver;
	String URL = "http://book.theautomatedtester.co.uk/chapter4";
	@BeforeTest
	public void start() {

	driver = s.Browser("Chrome");		
	}
	@Test(priority = 1)
	public void Chapter4Click()
{
	System.out.println("driver=" + driver); 
	/*WebElement Chapter1 = driver.findElement(By.xpath("//a[contains(text(),'Chapter1')]")); 
	Chapter1.click();*/
	WebElement Chapterlink =  driver.findElement(Chapter4);
	Chapterlink.click();
	String href = driver.getCurrentUrl();
	System.out.println("Link=" + href);
	Assert.assertEquals(href, URL);	
}
	@Test(priority = 2)
	public void mousehover() throws InterruptedException
	{
		WebElement mousehov = driver.findElement(mouse);
		Actions action = new Actions(driver);
		action.moveToElement(mousehov).build().perform();
		System.out.println("Mouse hover successfully done" );
		Alert alert = driver.switchTo().alert();
		String alertMessage= driver.switchTo().alert().getText();		
		
        // Displaying alert message		
        System.out.println(alertMessage);	
        Thread.sleep(5000);
		alert.accept();	
	}
	
	@Test(priority = 3)
	public void Textpopup() throws InterruptedException
	{
		String text = "How are you..";
		WebElement textbox = driver.findElement(Textbox);
		textbox.sendKeys(text);
		WebElement selectbutton = driver.findElement(selectload);
		selectbutton.click();
		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();		
		
        // Displaying alert message		
        System.out.println(alertMessage);
        Assert.assertEquals(alertMessage, text);
        Thread.sleep(5000);
		alert.accept();			
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
		
	}
	
}
