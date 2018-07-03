import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class QuickLinks {
	WebDriver driver;

	@BeforeTest	
	public void Lauchbrowser() throws Exception{

		System.out.println("---------------------------------------------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		driver = new ChromeDriver(options);Thread.sleep(5000);
		driver.manage().window().maximize(); Thread.sleep(5000);
		System.out.println("Successfully passed: launchbrowser()");
		System.out.println("---------------------------------------------------------------------------------");
	}
		
	@Test (priority=1)
	public void loginAdmin() throws Exception {
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com"); Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("Test1234"); Thread.sleep(3000);
		driver.findElement(By.id("show-sent")).click();	Thread.sleep(6000);
		Assert.assertEquals("Client Share", driver.getTitle(), "Title is matching");
		
	}	
	@Test (priority=2)
	public void quickLinks() throws InterruptedException {
	
	driver.findElement(By.xpath("//*[@id=\"left-content\"]/div[1]/div[3]/span[2]/a/img")).click();
	WebElement ql1 =  driver.findElement(By.xpath("//*[@id=\"quick_links_form\"]/div[1]/div/div[1]/input"));
	WebElement ql2 =  driver.findElement(By.xpath("//*[@id=\"quick_links_form\"]/div[1]/div/div[2]/input"));
	WebElement ql3 =  driver.findElement(By.xpath("//*[@id=\"quick_links_form\"]/div[1]/div/div[3]/input"));
	WebElement ql4 =  driver.findElement(By.xpath("//*[@id=\"quick_links_form\"]/div[1]/div/div[4]/input"));
	WebElement ql5 =  driver.findElement(By.xpath("//*[@id=\"quick_links_form\"]/div[1]/div/div[5]/input"));
	WebElement ql6 =  driver.findElement(By.xpath("//*[@id=\"quick_links_form\"]/div[1]/div/div[6]/input"));
	WebElement ql7 =  driver.findElement(By.xpath("//*[@id=\"quick_links_form\"]/div[1]/div/div[7]/input"));
	WebElement ql8 =  driver.findElement(By.xpath("//*[@id=\"quick_links_form\"]/div[1]/div/div[8]/input"));
	ql1.click(); Thread.sleep(4000); ql1.clear(); ql1.sendKeys("https://www.google.com/");
	ql2.click(); Thread.sleep(4000); ql2.clear(); ql2.sendKeys("Google");
	ql3.click(); Thread.sleep(4000); ql3.clear(); ql3.sendKeys("https://thehindu.com");
	ql4.click(); Thread.sleep(4000); ql4.clear(); ql4.sendKeys("The Hindu");
	ql5.click(); Thread.sleep(4000); ql5.clear(); ql5.sendKeys("http://indianexpress.com/");
	ql6.click(); Thread.sleep(4000); ql6.clear(); ql6.sendKeys("The Indian Express");
	ql7.click(); Thread.sleep(4000); ql7.clear(); ql7.sendKeys("https://hindustantimes.com");
	ql8.click(); Thread.sleep(4000); ql8.clear(); ql8.sendKeys("The hindustantimes");
	
	driver.findElement(By.xpath("//*[@id=\"quick_links_form\"]/div[2]/button[1]")).click();
	}
	
	@AfterTest
	public void close_Browser() throws InterruptedException {
		Thread.sleep(4000); driver.close(); 
		System.out.println("Successfully passed: Close_Browser()");
		System.out.println("---------------------------------------------------------------------------------");
	}
}
