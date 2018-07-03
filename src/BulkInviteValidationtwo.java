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
	
	public class BulkInviteValidationtwo {
	WebDriver driver;

	@BeforeTest
	public void launchbrowser() throws IOException, Exception {

		System.out.println("---------------------------------------------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
		driver = new ChromeDriver(); Thread.sleep(5000); 
		
		driver.manage().window().maximize(); Thread.sleep(5000);
		System.out.println("Successfully passed: launchbrowser()");
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	@Test (priority=0)
	public void accountLogin() throws Exception {
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com"); Thread.sleep(5000);
		driver.findElement(By.id("password")).sendKeys("Test1234"); Thread.sleep(3000);
		Account.captureScreenShot(driver); Thread.sleep(5000);
		driver.findElement(By.id("show-sent")).click();	Thread.sleep(5000);
		Assert.assertEquals("Client Share", driver.getTitle(), "Title is matching");
		
	}	
	

	@Test (priority=4)
	public void bulkInvite_URL_FileTypeValidation() throws Exception {
		Actions bulkURL = new Actions(driver);
		WebElement accountpic = driver.findElement(By.xpath("//span[@class='account-nav']"));
		Thread.sleep(5000); accountpic.click();
		
		WebElement settings = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[6]/ul/li[2]/a"));Thread.sleep(5000);
		settings.click(); Thread.sleep(5000);
		
		WebElement bulkinvitE = driver.findElement(By.xpath("//a[contains(@href,'#bulk-invitation-tab')]")); Thread.sleep(5000);
		Assert.assertTrue(bulkinvitE.isDisplayed()); Thread.sleep(3000);
		bulkinvitE.click(); Thread.sleep(2000);	
		
		WebElement urlinviteBulk = driver.findElement(By.xpath("//label[contains(@for,'bulk-invite-export')]")); Thread.sleep(5000);
		bulkURL.moveToElement(urlinviteBulk).build().perform(); Thread.sleep(4000);
		BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		System.out.println("Generate URL invite link is displayed: " +urlinviteBulk.isDisplayed()); Thread.sleep(4000);
		System.out.println("Generate URL invite link text is: " +urlinviteBulk.getText()); Thread.sleep(4000);
		urlinviteBulk.click(); Thread.sleep(4000);
		
		WebElement uPloadCSV = driver.findElement(By.xpath("//button[contains(@class,'attach-file-btn')]")); Thread.sleep(5000);
		bulkURL.moveToElement(uPloadCSV).build().perform(); Thread.sleep(4000);
		BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		System.out.println("Upload CSV link is displayed: " +uPloadCSV.isDisplayed()); Thread.sleep(4000);
		System.out.println("Upload CSV link text is: " +uPloadCSV.getText()); Thread.sleep(4000);
		uPloadCSV.click(); Thread.sleep(8000);
		Runtime.getRuntime().exec("C:\\Autoit\\bulkupload2008.exe"); Thread.sleep(8000);	
		
		System.out.println("Successfully passed!, bulkInvite_URL_FileTypeValidation()");	
		System.out.println("-----------------------------------------------------------------------------------------------------");
		 		
	}
	
	@AfterTest
	public void close_browser() throws InterruptedException {	
		Thread.sleep(4000); 
		driver.close();
		System.out.println("Browser closed successgully");
		System.out.println("------------------------------------------------------------------------------------------");
	}
}
