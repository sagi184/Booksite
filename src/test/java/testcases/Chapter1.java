package testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import setupfiles.Setup;



public class Chapter1 extends Setup {
     
	Setup s = new Setup();
	WebDriver driver;
	String URL = "http://book.theautomatedtester.co.uk/chapter1";
	@BeforeTest
	public void start() {

	driver = s.Browser("Chrome");
		
	}
	@Test(priority = 1)
public void Chapter1Click()
{
	System.out.println("driver=" + driver); 
	/*WebElement Chapter1 = driver.findElement(By.xpath("//a[contains(text(),'Chapter1')]")); 
	Chapter1.click();*/
	WebElement Chapterlink =  driver.findElement(Chapter);
	Chapterlink.click();
	String href = driver.getCurrentUrl();
	System.out.println("Link=" + href);
	Assert.assertEquals(href, URL);	
}
	@Test(priority = 2)
public void Chapter1dropdownandradio() throws InterruptedException
{
	WebElement Radio =  driver.findElement(radiobutton);
	Radio.click();
	WebElement mySelectElement = driver.findElement(By.id("selecttype"));
	Select dropdown= new Select(mySelectElement);
	//Select course = new Select(driver.findElement(By.id("selecttype")));
	for(int i = 0;i<4;i++)
	{   
		mySelectElement.click();
		
		dropdown.selectByIndex(i);
		
		WebElement option = dropdown.getFirstSelectedOption();
		System.out.println("Value selected is: " +option.getText());
	}
}
	@Test(priority =  3)
public void Chapter1Popup()
{
	WebElement popup1 = driver.findElement(By.id("multiplewindow"));
	popup1.click();
	//String parent=driver.getWindowHandle();
	 String parent= driver.getWindowHandle();
	 System.out.println("parent window=" +parent);
	 Set<String>s1=driver.getWindowHandles();
	 Iterator<String> I1= s1.iterator();
	 while(I1.hasNext())
 {
	  
	    String child_window=I1.next();
	  
	 // Here we will compare if parent window is not equal to child window then we            will close
	  
	 if(!parent.equals(child_window))
	 {
	 driver.switchTo().window(child_window);
	  
	 System.out.println(driver.switchTo().window(child_window).getTitle());
	 //driver.switchTo().window(handle);
	 WebElement popuplink = driver.findElement(By.id("closepopup"));
	 popuplink.click();
	 }
 }
}
	@AfterTest
	public void teardown()
	{
		driver.quit();
		
	}
	
}
