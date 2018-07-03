	
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
import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class InviteSellerAdminSubcompanyShare {
	public WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() throws IOException, Exception {
		
		System.out.println("----------------Seller Admin Subcompany Share Testing------------------------");
		System.out.println("------------------------------------------------------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		driver = new ChromeDriver(options);Thread.sleep(5000);
		driver.manage().window().maximize();Thread.sleep(5000);	
		System.out.println("Browser opened ");
		System.out.println("Successfully passed!, launchbrowser()");
		InviteSellerAdminSubcompanyShare.captureScreenShot(driver);
	}
	@Test (priority = 0)
	public void homepageSellerAdminSubcompanyShareLogin() throws InterruptedException, Exception {
		
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
		driver.findElement(By.id("email")).sendKeys("ashishqao43@yopmail.com"); Thread.sleep(5000);
		driver.findElement(By.id("password")).sendKeys("Test1234");
		System.out.println("Email and password added to login form"); Thread.sleep(5000);			
		String Actualtext = driver.findElement(By.id("show-sent")).getText();
		Assert.assertNotEquals(Actualtext, "Sign in", "Expected and actual match in assertion_method_1");		
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER); Thread.sleep(4000);	
		InviteSellerAdminSubcompanyShare.captureScreenShot(driver);
		
		System.out.println("Login form submitted"); System.out.println(driver.getCurrentUrl());	Thread.sleep(5000);
		System.out.println("Successfully passed!, HomepageCS()");	
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	@Test (priority=1)
	public void community_InviteSellerAdminSubcompanyShare() throws InterruptedException, IOException { 
		
		System.out.println("Feature Community_invite(): started");
		WebElement community = driver.findElement(By.xpath("//a[@class='community_member_link']"));
		Assert.assertTrue(community.isDisplayed());
		community.click(); Thread.sleep(4000);
		
	    WebElement invitelink = driver.findElement(By.xpath("//a[contains(@class,'invite-icon')]"));
	    Assert.assertTrue(invitelink.isDisplayed()); Thread.sleep(4000);
	    invitelink.click(); Thread.sleep(4000); InviteSellerAdminSubcompanyShare.captureScreenShot(driver); 
	  
	    WebElement invite = driver.findElement(By.xpath("//button[contains(@class,'btn-invite')]"));
	    Assert.assertTrue(invite.isDisplayed()); Thread.sleep(4000); 
	    invite.click(); Thread.sleep(6000); InviteSellerAdminSubcompanyShare.captureScreenShot(driver); 
	 
	    System.out.println("Empty form submitted to CHECK 'This field is required' validation :: WORKING FINE");
	    driver.findElement(By.xpath("//*[@id=\"myModalInvite\"]/div/div[2]/div[1]/button")).click(); Thread.sleep(3000);
	    
	    WebElement InviteLink = driver.findElement(By.xpath("//a[contains(@class,'invite-icon')]"));
	    Assert.assertTrue(InviteLink.isDisplayed()); Thread.sleep(4000);
	    InviteLink.click(); Thread.sleep(5000);	 InviteSellerAdminSubcompanyShare.captureScreenShot(driver);    
	    WebElement invitebuTTon = driver.findElement(By.xpath("//button[contains(@class,'btn-invite')]"));
	    Assert.assertTrue(invitebuTTon.isDisplayed()); Thread.sleep(4000);
	    invitebuTTon.click(); Thread.sleep(6000);
	    
	    WebElement fname = driver.findElement(By.xpath("//input[contains(@name,'first')]"));
	    Assert.assertTrue(fname.isDisplayed()); Thread.sleep(4000);
	    fname.sendKeys("AshishKumarDhimanNirmohiRehan"); Thread.sleep(5000);
	    
	    WebElement lname = driver.findElement(By.xpath("//input[contains(@name,'last')]"));
	    Assert.assertTrue(lname.isDisplayed()); Thread.sleep(4000);
	    lname.sendKeys("NirmohiAshishKumarDhimanNirmohiRehan"); Thread.sleep(5000);
	    invitebuTTon.click(); Thread.sleep(5000); InviteSellerAdminSubcompanyShare.captureScreenShot(driver);
	    
	    System.out.println("Wrong input text to CHECK 'First name cannot be greater than 25 characters' validation :: WORKING FINE");
	 
	    fname.clear();; Thread.sleep(5000);
	    fname.sendKeys("Ashish"); Thread.sleep(5000);
	    lname.clear(); Thread.sleep(5000);	    
	    lname.sendKeys("Nirmohi"); Thread.sleep(5000);
	    WebElement email = driver.findElement(By.xpath("//*[contains(@name,'email')]"));
	    Assert.assertTrue(email.isDisplayed()); Thread.sleep(4000);
	    email.sendKeys("x@yz"); Thread.sleep(5000);
	    Thread.sleep(5000); invitebuTTon.click(); Thread.sleep(5000);
	    InviteSellerAdminSubcompanyShare.captureScreenShot(driver);
	    System.out.println("Wrong email-id to CHECK 'Invalid email address.' validation :: WORKING FINE");
	    
	    email.clear(); Thread.sleep(5000); email.sendKeys("x@y.z"); Thread.sleep(5000);
	    Thread.sleep(5000); invitebuTTon.click(); Thread.sleep(5000);
	    InviteSellerAdminSubcompanyShare.captureScreenShot(driver);
	    System.out.println("Not restricted domian to CHECK 'Invalid Email Domain: your Client Share has been locked down to @GMAIL ... If you wish to add a domain please email an administrator: ADMIN' validation :: WORKING FINE");
	    
	    email.clear();
	    email.sendKeys("ashish.nirmohi@gmail.com");
	    WebElement message = driver.findElement(By.xpath("//textarea[contains(@class,'mail_body')]"));
	    Assert.assertTrue(message.isDisplayed()); Thread.sleep(4000); message.clear();
	    message.sendKeys("GOOD WORK, KEEP IT UP");
	    WebElement invitebutToN = driver.findElement(By.xpath("//button[contains(@class,'btn-invite')]"));
	    Assert.assertTrue(message.isDisplayed()); Thread.sleep(4000);
	    invitebutToN.click(); Thread.sleep(5000); InviteSellerAdminSubcompanyShare.captureScreenShot(driver);
	    System.out.println("Already registered email-id to CHECK 'This user is already a member of this Client Share' validation :: WORKING FINE");
	    
	    email.clear(); email.sendKeys("QualityA3Nirmohi@yopmail.com");
	    invitebutToN.click(); Thread.sleep(5000);
	    WebElement blueMessage = driver.findElement(By.xpath("//span[contains(@class,'white_box_info')]"));
	    Assert.assertTrue(blueMessage.isDisplayed()); Thread.sleep(4000);
	    blueMessage.click();
	    driver.findElement(By.xpath("//*[@id=\"myModalInvite\"]/div/div[2]/div[1]/button")).click(); Thread.sleep(5000);
	    InviteSellerAdminSubcompanyShare.captureScreenShot(driver); 
	    
	    System.out.println("Already invited member email-id to CHECK 'This user already has a pending invite for this Client Share. You can resend the invitation via Pending Invites in Settings' VALIDATION :: WORKING FINE");
	    System.out.println("Successfully passed!, Community_Invite()");
		System.out.println("------------------------------------------------------------------------------------------");
		}
	
	@Test (priority=2)
	public void invite_URL() throws Exception {
		
		WebElement inviteLink = driver.findElement(By.xpath("//a[contains(@class,'invite-icon')]")); Thread.sleep(5000);
	    Assert.assertTrue(inviteLink.isDisplayed()); Thread.sleep(4000);
	    inviteLink.click(); Thread.sleep(4000); InviteSellerMemberNormalShare.captureScreenShot(driver); 
		
		WebElement radioURL = driver.findElement(By.xpath("//*[@id=\"myModalInvite\"]/div/div[2]/div[2]/div[4]/div[2]/label")); Thread.sleep(5000);
		Assert.assertTrue(radioURL.isDisplayed()); Thread.sleep(5000); 
		radioURL.click(); Thread.sleep(5000);
		
		WebElement createURL = driver.findElement(By.xpath("//button[contains(@class,'create_url')]")); Thread.sleep(5000);
		System.out.println("Create URL text is displayed: " +createURL.isDisplayed()); Thread.sleep(5000);
		createURL.click(); Thread.sleep(5000);
		
		WebElement fname = driver.findElement(By.xpath("//input[contains(@name,'first')]")); Thread.sleep(5000);
		Assert.assertTrue(fname.isDisplayed()); Thread.sleep(5000);
		WebElement lname = driver.findElement(By.xpath("//input[contains(@name,'last')]")); Thread.sleep(5000);
		Assert.assertTrue(lname.isDisplayed()); Thread.sleep(5000); 
		WebElement email = driver.findElement(By.xpath("//input[contains(@name,'email')]")); Thread.sleep(5000);
		Assert.assertTrue(email.isDisplayed()); Thread.sleep(5000); 
		InviteSellerMemberNormalShare.captureScreenShot(driver); Thread.sleep(5000);
		
		fname.sendKeys("AshishKumarDhimanNirmohiSinghSharmaChopraChauhan"); Thread.sleep(5000);		
		lname.sendKeys("AshishKumarDhimanNirmohiSinghSharmaChopraChauhan"); Thread.sleep(5000);
		email.sendKeys("x@w"); Thread.sleep(5000);
		createURL.click(); Thread.sleep(5000); InviteSellerMemberNormalShare.captureScreenShot(driver); Thread.sleep(5000);
		
		fname.clear(); fname.sendKeys("Ashish"); Thread.sleep(5000);
		lname.clear(); lname.sendKeys("Kumar"); Thread.sleep(5000);
		email.clear(); email.sendKeys("qaoO1@yopmail.com"); Thread.sleep(5000);
		createURL.click();  Thread.sleep(5000);
		
		WebElement url = driver.findElement(By.xpath("//input[contains(@id,'invite_url')]")); Thread.sleep(5000);
		Assert.assertTrue(url.isDisplayed()); Thread.sleep(5000); 
		System.out.println("Invitation URL created: " +url.getText()); Thread.sleep(5000);	
		
		WebElement copyLink = driver.findElement(By.xpath("//button[contains(@class,'copy-link')]")); Thread.sleep(5000);
		System.out.println("Copy link text is displayed: " +copyLink.isDisplayed()); Thread.sleep(5000);	
		
		WebElement done = driver.findElement(By.xpath("//button[contains(@class,'btn-done')]"));Thread.sleep(5000);
		System.out.println("Done link text is displayed: " +done.isDisplayed()); done.click();
		
		WebElement cLose = driver.findElement(By.xpath("//*[@id=\"myModalInvite\"]/div/div[2]/div[1]/button")); Thread.sleep(5000);
		System.out.println("X-close link is displayed: " +cLose.isDisplayed()); Thread.sleep(5000); 
		
		cLose.click(); Thread.sleep(5000);
		System.out.println("------------------------------------------------------------------------------------------");
		
	}

	@AfterTest
	public void close_browser() throws InterruptedException {	
	 driver.close();	
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
		 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\analytics\\Screenshot.jpg"));	
		 String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		 File dest = new File("C:\\Users\\user\\eclipse-workspace\\NewProject\\capturescreen\\invite\\" + filename);
		 FileUtils.copyFile(screenshot, dest);
	}
}
