	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.concurrent.TimeUnit;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	public class BulkInviteURL {
	public static WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() throws IOException, Exception {

		System.out.println("---------------------------------------------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		driver = new ChromeDriver(options); Thread.sleep(5000); 
		driver = new ChromeDriver();
		
		driver.manage().window().maximize(); Thread.sleep(5000);
		System.out.println("Successfully passed: launchbrowser()");
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	@Test (priority = 0)
	public void homepageCS() throws InterruptedException, Exception {
		// Home page CS login
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expectedTitle = "Client Share";
        String actualTitle = "";
        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed! - correct page title");
        } else {
            System.out.println("Test Failed - wrong page title");
        }
      
		System.out.println(driver.getCurrentUrl());
		System.out.println("URL added on browser");
		driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com"); Thread.sleep(5000);
		driver.findElement(By.id("password")).sendKeys("Test1234");
		System.out.println("Email and password added to login form"); Thread.sleep(5000);			
		String Actualtext = driver.findElement(By.id("show-sent")).getText();
		Assert.assertNotEquals(Actualtext, "Sign in", "Expected and actual match in assertion_method_1");		
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER); Thread.sleep(5000);			
		BulkInviteURL.captureScreenShot(driver);
		
		System.out.println("Login form submitted"); System.out.println(driver.getCurrentUrl());	Thread.sleep(5000);
		System.out.println("Successfully passed!, HomepageCS()");	
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	@Test (priority=1)
		public void switchShare() throws InterruptedException, IOException {		
		Actions share = new Actions(driver);
	    WebElement sh = driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]")); Thread.sleep(5000);
	    share.moveToElement(sh).build().perform(); Thread.sleep(5000); sh.click(); Thread.sleep(5000);
	    BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[5]/a")).click(); Thread.sleep(5000); 
		
		WebElement sh1 = driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]"));  Thread.sleep(5000);
		share.moveToElement(sh1).build().perform(); Thread.sleep(5000); sh1.click(); Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[3]/a")).click(); Thread.sleep(5000);	
		BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		
		System.out.println("Moved to desired share for testing successfully passed!, SwitchShare()");
		System.out.println("Successfully passed!, switchShare()");	
		System.out.println("-----------------------------------------------------------------------------------------------------");
	}
	
	@Test (priority=2)
	public void bulkInvite_URL() throws Exception {
		Actions bulkURL = new Actions(driver);
		WebElement accountpic = driver.findElement(By.xpath("//span[@class='account-nav']"));
		Thread.sleep(5000); accountpic.click();
		
		WebElement settings = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[6]/ul/li[2]/a"));
		settings.click(); Thread.sleep(5000);

		WebElement bulkinvite = driver.findElement(By.xpath("//a[contains(@href,'#bulk-invitation-tab')]")); Thread.sleep(5000);
		Assert.assertTrue(bulkinvite.isDisplayed()); Thread.sleep(3000);
		System.out.println("Bulk invite settings link is displayed: " +bulkinvite.isDisplayed()); Thread.sleep(4000);
		System.out.println("Bulk invite link text is: " +bulkinvite.getText()); Thread.sleep(4000);
		bulkinvite.click(); Thread.sleep(2000);	
		
		WebElement urlInviteBulk = driver.findElement(By.xpath("//label[contains(@for,'bulk-invite-export')]")); Thread.sleep(4000);
		bulkURL.moveToElement(urlInviteBulk).build().perform(); Thread.sleep(4000);
		BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		System.out.println("Generate URL invite link is displayed: " +urlInviteBulk.isDisplayed()); Thread.sleep(4000);
		System.out.println("Generate URL invite link text is: " +urlInviteBulk.getText()); Thread.sleep(4000);
		urlInviteBulk.click(); Thread.sleep(4000);
		BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		
		WebElement uploadCSV = driver.findElement(By.xpath("//button[contains(@class,'attach-file-btn')]")); Thread.sleep(4000);
		bulkURL.moveToElement(uploadCSV).build().perform(); Thread.sleep(4000);
		BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		System.out.println("Upload CSV link is displayed: " +uploadCSV.isDisplayed()); Thread.sleep(4000);
		System.out.println("Upload CSV link text is: " +uploadCSV.getText()); Thread.sleep(4000);
		uploadCSV.click(); Thread.sleep(4000);
		BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		Runtime.getRuntime().exec("C:\\Autoit\\bulkupload2006.exe"); Thread.sleep(2000);
		
		WebElement ok = driver.findElement(By.xpath("//*[@id=\"bulk-upload-status\"]/div/div/div[3]/button[1]")); Thread.sleep(4000);
		bulkURL.moveToElement(ok).build().perform(); Thread.sleep(4000);
		BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		System.out.println("OK submit CSV link is displayed: " +ok.isDisplayed()); Thread.sleep(4000);
		System.out.println("OK submit CSV link text is: " +ok.getText()); Thread.sleep(4000);
		ok.click(); Thread.sleep(4000); 
		
		WebElement generateInvite = driver.findElement(By.xpath("//button[contains(@class,'bulk-invite-export')]"));Thread.sleep(4000);
		bulkURL.moveToElement(generateInvite).build().perform(); Thread.sleep(4000);
		BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		System.out.println("Generate Invite CSV URL is displayed: " +generateInvite.isDisplayed()); Thread.sleep(4000);
		System.out.println("Generate CSV invite link text is: " +generateInvite.getText()); Thread.sleep(4000);
		generateInvite.click(); Thread.sleep(4000); 
		BulkInviteURL.captureScreenShot(driver); Thread.sleep(4000);
		driver.navigate().refresh();
		
		System.out.println("Successfully passed!, bulkInvite_URL()");	
		System.out.println("-----------------------------------------------------------------------------------------------------");
		 
	}
	
	@AfterTest
	public void close_browser() throws InterruptedException {	
		Thread.sleep(4000); driver.close();
		System.out.println("Browser closed successgully");
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
		 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\analytics\\Screenshot.jpg"));	
		 String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		 File dest = new File("C:\\Users\\user\\eclipse-workspace\\UATcs\\capturescreen\\settings\\" + filename);
		 FileUtils.copyFile(screenshot, dest);
		}

}