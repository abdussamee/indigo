package book_flight.indigoairlines_2;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ticket_booking 
{
	WebDriver driver;
	@BeforeMethod
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sami\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goindigo.in/");
	}
	
	@Test(priority=0,enabled=true)
  public void ticket_booking() throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='roundWay']/form/div[1]/ul/li[1]/input[1]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='roundWay']/form/div[1]/ul/li[1]/input[1]")).sendKeys("delhi");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='roundWay']/form/div[1]/ul/li[2]/input[1]")).sendKeys("mumbai");
		driver.findElement(By.id("depart-date")).click();
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[5]/a")).click();
		driver.findElement(By.xpath(".//*[@id='return-date']")).click();
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[2]/td[1]/a")).click();
		driver.findElement(By.id("ui-id-1-button")).click();
		driver.findElement(By.xpath("(//button[@class='search-button form-submit-btn btn-indigo'])[1]")).click();
		
    }
	
	@Test(priority=1,enabled=true)
	public void new_tab() throws InterruptedException
	{
		driver.findElement(By.linkText("Careers")).click();
		Set<String>tab=driver.getWindowHandles();
		Iterator<String>itt=tab.iterator();
		String parent_window=itt.next();
		String child_window=itt.next();
		driver.switchTo().window(child_window);
		driver.findElement(By.id("section4")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Engineering")).click();
	}
	
	@Test(priority=2,enabled=true)
	public void radio_button() throws InterruptedException
	{
		driver.findElement(By.xpath("(//div [@class='ios-ui-select-ex'])[5]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div [@class='owl-prev'])[1]")).click();
	}
	
	@Test(priority=3,enabled=true)
	public void footer()
	{
		driver.findElement(By.linkText("Click to Expand")).click();
		driver.findElement(By.linkText("Click to Collapse")).click();
	}
	
	@Test(priority=4)
	public void road_map() throws InterruptedException
	{
		driver.findElement(By.xpath("//img [@title='Flights Route Map - IndiGo Airlines']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ip-rm-from")).clear();
		//Thread.sleep(2000);
		driver.findElement(By.id("ip-rm-from")).sendKeys("Bengaluru");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='ip-rm-to']")).clear();
		driver.findElement(By.xpath(".//*[@id='ip-rm-to']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("html/body/div[2]/div[3]/div[3]/div[2]/div[1]/div/div[3]/div[1]/div/div[7]/button")).click();
	}
	
	@AfterMethod
	public void close() throws InterruptedException
	{
		Thread.sleep(9000);
		driver.close();
	}
}
