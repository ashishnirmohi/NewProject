	import java.io.IOException;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	//import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	public class BulkUploadValidationOne {
	WebDriver driver;
	
	@BeforeTest
	public void launchbrowser() throws IOException, Exception {

	System.out.println("---------------------------------------------------------------------------------");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
	/*
	ChromeOptions options = new ChromeOptions();
	options.addArguments("window-size=1400,800");
	options.addArguments("headless");*/
	driver = new ChromeDriver(); Thread.sleep(5000); 
	
	driver.manage().window().maximize(); Thread.sleep(5000);
	System.out.println("Successfully passed: launchbrowser()");
	System.out.println("---------------------------------------------------------------------------------");
}
	@Test (priority=0)
	public void Login() throws Exception {
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com"); Thread.sleep(5000);
		driver.findElement(By.id("password")).sendKeys("Test1234"); Thread.sleep(3000);
		Account.captureScreenShot(driver); Thread.sleep(5000);
		driver.findElement(By.id("show-sent")).click();	Thread.sleep(5000);
		Assert.assertEquals("Client Share", driver.getTitle(), "Title is matching");
		
	}	
	
	
	@Test (priority=3)
	public void bulkInvite_URL2000Validation() throws Exception {
		Actions BulkURL = new Actions(driver);
		WebElement accountpic = driver.findElement(By.xpath("//span[@class='account-nav']"));
		Thread.sleep(5000); accountpic.click(); Thread.sleep(5000);
		
		WebElement settings = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[6]/ul/li[2]/a"));
		settings.click(); Thread.sleep(5000);
		
		WebElement bulkinvite = driver.findElement(By.xpath("//a[contains(@href,'#bulk-invitation-tab')]")); Thread.sleep(5000);
		Assert.assertTrue(bulkinvite.isDisplayed()); Thread.sleep(3000);
		System.out.println("Bulk invite settings link is displayed: " +bulkinvite.isDisplayed()); Thread.sleep(4000);
		System.out.println("Bulk invite link text is: " +bulkinvite.getText()); Thread.sleep(4000);
		bulkinvite.click(); Thread.sleep(2000);	
		
		WebElement UrlInviteBulk = driver.findElement(By.xpath("//label[contains(@for,'bulk-invite-export')]")); Thread.sleep(5000);
		BulkURL.moveToElement(UrlInviteBulk).build().perform(); Thread.sleep(4000);
		BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		System.out.println("Generate URL invite link is displayed: " +UrlInviteBulk.isDisplayed()); Thread.sleep(4000);
		System.out.println("Generate URL invite link text is: " +UrlInviteBulk.getText()); Thread.sleep(4000);
		UrlInviteBulk.click(); Thread.sleep(4000);
		
		WebElement UploadCSV = driver.findElement(By.xpath("//button[contains(@class,'attach-file-btn')]")); Thread.sleep(5000);
		BulkURL.moveToElement(UploadCSV).build().perform(); Thread.sleep(4000);
		BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		System.out.println("Upload CSV link is displayed: " +UploadCSV.isDisplayed()); Thread.sleep(4000);
		System.out.println("Upload CSV link text is: " +UploadCSV.getText()); Thread.sleep(4000);
		UploadCSV.click(); Thread.sleep(4000);
		BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		Runtime.getRuntime().exec("C:\\Autoit\\bulkupload2010.exe"); Thread.sleep(8000);	
		
		System.out.println("Successfully passed!, bulkInvite_URL2000Validation()");	
		System.out.println("-----------------------------------------------------------------------------------------------------");	
		
	}
	
	@AfterTest
	public void close_browser() throws InterruptedException {	
		Thread.sleep(4000); driver.close();
		System.out.println("Browser closed successgully");
		System.out.println("------------------------------------------------------------------------------------------");
	}
}
