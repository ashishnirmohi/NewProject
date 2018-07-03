
	import org.testng.annotations.Test;
	import org.testng.AssertJUnit;
	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.concurrent.TimeUnit;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import org.openqa.selenium.interactions.Actions;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	
	
	public class CommunityCS {
	public WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() throws IOException, InterruptedException {
		System.out.println("------------------------------------------------------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
		driver = new ChromeDriver();Thread.sleep(5000);
		driver.manage().window().maximize();Thread.sleep(5000);
		System.out.println("Successfully passed!, launchbrowser()"); Thread.sleep(5000);
		CommunityCS.captureScreenShot(driver); 	
		System.out.println("------------------------------------------------------------------------------------------");
		
	}
			
	@Test (priority = 0)
	public void Homepage() throws InterruptedException, IOException {
		
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
       
		driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test1234");		
		System.out.println("Email and password added to login form"); Thread.sleep(4000);				
		String Actualtext = driver.findElement(By.id("show-sent")).getText(); Thread.sleep(7000);
		CommunityCS.captureScreenShot(driver);
		
		Assert.assertNotEquals(Actualtext, "Sign in", "Expected and actual match in assertion_method_1");		
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER); System.out.println("Login form submitted");
		System.out.println(driver.getCurrentUrl()); Thread.sleep(5000);
		System.out.println("Homepage opened successfully, Successfully passed!, Homepage()"); 
		System.out.println("------------------------------------------------------------------------------------------");
		
		}
	
	@Test (priority = 1)
	public void switchShare() throws InterruptedException, IOException {		
			
		Actions share = new Actions(driver);
	    WebElement sh = driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]")); Thread.sleep(5000);
	    share.moveToElement(sh).build().perform(); Thread.sleep(5000); sh.click(); Thread.sleep(5000);		
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[12]/a")).click(); Thread.sleep(5000); 
		
		WebElement sh1 = driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]"));  Thread.sleep(5000);
		share.moveToElement(sh1).build().perform(); Thread.sleep(5000); sh1.click(); Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[3]/a")).click(); Thread.sleep(5000);	
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
		
		System.out.println("Moved to desired share for testing successfully passed!, SwitchShare()");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		}
	
	
	@Test (priority = 2)
	public void community_landing_Page() throws InterruptedException, Exception {
		System.out.println("Feature Community_landing_Page(): started ");
		Actions community = new Actions(driver);
	    WebElement comm = driver.findElement(By.xpath("//a[@class='community_member_link']")); Thread.sleep(5000);
	    
	    System.out.println("link under test is: " +comm.getText());
	    System.out.println("Link isDisplayed yes/no: " +comm.isDisplayed());
	    System.out.println("link is enabled true/false: " +comm.isEnabled());
	    System.out.println("Link attribute type is: " +comm.getAttribute("type"));
	    System.out.println("Link attribute value is: "+comm.getAttribute("value"));
	    community.moveToElement(comm).build().perform(); Thread.sleep(7000);
	    CommunityCS.captureScreenShot(driver);
	    
		driver.findElement(By.xpath("//a[@class='community_member_link']")).click(); Thread.sleep(5000); // community	
		System.out.println("Community page opened & URL is below");
		CommunityCS.captureScreenShot(driver);
		System.out.println(driver.getCurrentUrl()); 
	   
		/*
		WebElement Community1 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[3]")); Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community1); Thread.sleep(5000); // scroll here
		CommunityCS.captureScreenShot(driver);
		
		WebElement Community2 = driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[1]/div[1]/h4")); Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Community2); Thread.sleep(5000);
		CommunityCS.captureScreenShot(driver); 
		*/

		System.out.println("Successfully passed!, Community_landing_Page()");
		System.out.println("------------------------------------------------------------------------------------------");
			
		}
	
	@Test (priority=3)
	public void community_Search() throws InterruptedException, IOException{
		
		System.out.println("Feature Community_Search(): started ");
		driver.findElement(By.xpath("//a[@class='community_member_link']")).click();
		driver.findElement(By.xpath("//img[@src='https://uat-clientspace.herokuapp.com/images/ic_search_blue.png')]")).click();  Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys(""); Thread.sleep(4000);
		
		driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys(Keys.ENTER); Thread.sleep(4000);
		System.out.println("Empty text search done to CHECK 'Search field can not be empty' validation :: WORKING FINE");
		
		System.out.println("Searching by name: Aamirpal Sehmi");
		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[2]/a")).click(); Thread.sleep(5000); //click search icon
		driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/a/img")).click();  Thread.sleep(5000);
		
	    driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys("Aamirpal Sehmi"); Thread.sleep(4000);
	    driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys(Keys.ENTER); Thread.sleep(4000);
	    CommunityCS.captureScreenShot(driver);
			
		System.out.println("Searching by job-profile: Delivery manager");
		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[2]/a")).click(); Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/a/img")).click(); Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys("Delivery manager"); Thread.sleep(4000);
		driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys(Keys.ENTER); Thread.sleep(4000);
		System.out.println("Searching by job-profile: Passed");
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000);
		
	    System.out.println("Successfully passed!, Community_Search()");
		System.out.println("------------------------------------------------------------------------------------------");
		
		}	
	
	@Test (priority=4)
	public void community_Invite() throws InterruptedException, IOException { 
		
		System.out.println("Feature Community_invite(): started");
		WebElement community = driver.findElement(By.xpath("//a[@class='community_member_link']")); Thread.sleep(5000);
		Assert.assertTrue(community.isDisplayed()); Thread.sleep(5000);
		community.click(); Thread.sleep(4000);
		
	    WebElement invitelink = driver.findElement(By.xpath("//a[contains(@class,'invite-icon')]")); Thread.sleep(5000);
	    Assert.assertTrue(invitelink.isDisplayed()); Thread.sleep(4000);
	    invitelink.click(); Thread.sleep(4000); CommunityCS.captureScreenShot(driver); 
	  
	    WebElement invite = driver.findElement(By.xpath("//button[contains(@class,'btn-invite')]")); Thread.sleep(5000);
	    Assert.assertTrue(invite.isDisplayed()); Thread.sleep(4000); 
	    invite.click(); Thread.sleep(6000); CommunityCS.captureScreenShot(driver); 
	 
	    System.out.println("Empty form submitted to CHECK 'This field is required' validation :: WORKING FINE");
	    driver.findElement(By.xpath("//*[@id=\"myModalInvite\"]/div/div[2]/div[1]/button")).click(); Thread.sleep(3000);
	    
	    WebElement InviteLink = driver.findElement(By.xpath("//a[contains(@class,'invite-icon')]")); Thread.sleep(5000);
	    Assert.assertTrue(InviteLink.isDisplayed()); Thread.sleep(4000);
	    InviteLink.click(); Thread.sleep(5000);	 CommunityCS.captureScreenShot(driver);    
	    WebElement invitebuTTon = driver.findElement(By.xpath("//button[contains(@class,'btn-invite')]")); Thread.sleep(5000);
	    Assert.assertTrue(invitebuTTon.isDisplayed()); Thread.sleep(4000);
	    invitebuTTon.click(); Thread.sleep(6000);
	    
	    WebElement fname = driver.findElement(By.xpath("//input[contains(@name,'first')]")); Thread.sleep(5000);
	    Assert.assertTrue(fname.isDisplayed()); Thread.sleep(4000);
	    fname.sendKeys("AshishKumarDhimanNirmohiRehan"); Thread.sleep(5000);
	    
	    WebElement lname = driver.findElement(By.xpath("//input[contains(@name,'last')]")); Thread.sleep(5000);
	    Assert.assertTrue(lname.isDisplayed()); Thread.sleep(4000);
	    lname.sendKeys("NirmohiAshishKumarDhimanNirmohiRehan"); Thread.sleep(5000);
	    invitebuTTon.click(); Thread.sleep(5000); CommunityCS.captureScreenShot(driver);
	    
	    System.out.println("Wrong input text to CHECK 'First name cannot be greater than 25 characters' validation :: WORKING FINE");
	 
	    fname.clear();; Thread.sleep(5000);
	    fname.sendKeys("Ashish"); Thread.sleep(5000);
	    lname.clear(); Thread.sleep(5000);	    
	    lname.sendKeys("Nirmohi"); Thread.sleep(5000);
	    WebElement email = driver.findElement(By.xpath("//*[contains(@name,'email')]")); Thread.sleep(5000);
	    Assert.assertTrue(email.isDisplayed()); Thread.sleep(4000);
	    email.sendKeys("x@yz"); Thread.sleep(5000);
	    Thread.sleep(5000); invitebuTTon.click(); Thread.sleep(5000);
	    CommunityCS.captureScreenShot(driver);
	    System.out.println("Wrong email-id to CHECK 'Invalid email address.' validation :: WORKING FINE");
	    
	    email.clear(); Thread.sleep(5000); email.sendKeys("x@y.z"); Thread.sleep(5000);
	    Thread.sleep(5000); invitebuTTon.click(); Thread.sleep(5000);
	    CommunityCS.captureScreenShot(driver);
	    System.out.println("Not restricted domian to CHECK 'Invalid Email Domain: your Client Share has been locked down to @GMAIL ... If you wish to add a domain please email an administrator: ADMIN' validation :: WORKING FINE");
	    
	    email.clear(); email.sendKeys("ashish.nirmohi@gmail.com");
	    WebElement message = driver.findElement(By.xpath("//textarea[contains(@class,'mail_body')]")); Thread.sleep(5000);
	    Assert.assertTrue(message.isDisplayed()); Thread.sleep(4000); message.clear();
	    message.sendKeys("GOOD WORK, KEEP IT UP");
	    WebElement invitebutToN = driver.findElement(By.xpath("//button[contains(@class,'btn-invite')]")); Thread.sleep(5000);
	    Assert.assertTrue(message.isDisplayed()); Thread.sleep(4000);
	    invitebutToN.click(); Thread.sleep(5000); CommunityCS.captureScreenShot(driver);
	    System.out.println("Already registered email-id to CHECK 'This user is already a member of this Client Share' validation :: WORKING FINE");
	    
	    email.clear(); email.sendKeys("QualityA3Nirmohi@yopmail.com");
	    invitebutToN.click(); Thread.sleep(5000);
	    WebElement blueMessage = driver.findElement(By.xpath("//span[contains(@class,'white_box_info')]")); Thread.sleep(5000);
	    Assert.assertTrue(blueMessage.isDisplayed()); Thread.sleep(4000);
	    blueMessage.click();
	    driver.findElement(By.xpath("//*[@id=\"myModalInvite\"]/div/div[2]/div[1]/button")).click(); Thread.sleep(5000);
	    CommunityCS.captureScreenShot(driver); 
	    
	    System.out.println("Already invited member email-id to CHECK 'This user already has a pending invite for this Client Share. You can resend the invitation via Pending Invites in Settings' VALIDATION :: WORKING FINE");
	    System.out.println("Successfully passed!, Community_Invite()");
		System.out.println("------------------------------------------------------------------------------------------");
		
		}
	
	@Test (priority = 5)
	public void community_Filter_Seller() throws InterruptedException, IOException{
		
		System.out.println("Feature Community_Filter_Seller(): started");
		WebElement communiTy = driver.findElement(By.xpath("//a[@class='community_member_link']")); Thread.sleep(5000);
		Assert.assertTrue(communiTy.isDisplayed()); Thread.sleep(5000);
		communiTy.click(); Thread.sleep(4000);
		
		Actions seller = new Actions(driver);   
	    WebElement se = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[1]/div[3]/ul/li[2]/a")); Thread.sleep(5000);
	    seller.moveToElement(se).build().perform(); Thread.sleep(5000);
	    se.click(); Thread.sleep(7000); 
	    CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
	    System.out.println(driver.getCurrentUrl()); Thread.sleep(5000);
	    
	    WebElement seller1 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", seller1); Thread.sleep(5000); 
		CommunityCS.captureScreenShot(driver);
		
		WebElement seller2 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[2]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", seller2); Thread.sleep(5000); 
		CommunityCS.captureScreenShot(driver);
		
		WebElement seller3 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[3]/div[8]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", seller3); Thread.sleep(5000);
		System.out.println("Seller filtered result is scrolled to bottom");	
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
	    
		WebElement seller4 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[2]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", seller4); Thread.sleep(5000); 
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
		
		WebElement seller5 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", seller5); Thread.sleep(5000); 
		System.out.println("Seller filtered result is again scrolled to top");
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
		
		System.out.println("Successfully passed!, Community_Filter_Seller()");
		System.out.println("------------------------------------------------------------------------------------------");
			
		}
	
	
	@Test (priority = 6)
	public void community_Filter_Buyer() throws InterruptedException, IOException{
		
		System.out.println("Feature Community_Filter_Buyer(): started");
		WebElement coMmuniTy = driver.findElement(By.xpath("//a[@class='community_member_link']")); Thread.sleep(5000);
		Assert.assertTrue(coMmuniTy.isDisplayed()); Thread.sleep(5000);
		coMmuniTy.click(); Thread.sleep(4000);
		
		Actions buyer = new Actions(driver); 
		WebElement buy = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[1]/div[3]/ul/li[3]/a")); Thread.sleep(5000); // Buyer community link 
		buyer.moveToElement(buy).build().perform(); Thread.sleep(5000); 
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
		buy.click(); Thread.sleep(5000);
		
	    WebElement buyer1 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer1); Thread.sleep(5000); 
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
		
	    WebElement buyer2 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[2]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer2); Thread.sleep(5000); 
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
			 
	    WebElement buyer3 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[3]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer3); Thread.sleep(5000); 
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
		 
	    WebElement buyer4 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[4]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer4); Thread.sleep(5000); 
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
		
	    WebElement buyer5 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[5]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer5); Thread.sleep(5000); 
		System.out.println("Buyers filtered result is scrolled to bottom");
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
		
		WebElement buyer05 = driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[6]/div[5]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer05); Thread.sleep(5000); 
		System.out.println("Buyers filtered result is scrolled to bottom");
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
		
		WebElement buyer6 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[5]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer6); Thread.sleep(5000); 
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
		
	    WebElement buyer7 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[4]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer7); Thread.sleep(5000); 
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
		
	    WebElement buyer8 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[3]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer8); Thread.sleep(5000); 
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
		
	    WebElement buyer9 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[2]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer9); Thread.sleep(5000); 	
		CommunityCS.captureScreenShot(driver); Thread.sleep(5000); 
		
		WebElement buyer10 = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[15]")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buyer10); Thread.sleep(5000); 
		CommunityCS.captureScreenShot(driver);Thread.sleep(5000); 
		
		System.out.println("Buyers filtered result is scrolled to top"); System.out.println("Successfully passed!, Community_Filter_Buyer()");	
		System.out.println("------------------------------------------------------------------------------------------");

		}
	
	@Test (priority = 7)
	public void community_Email_linkedIn() throws InterruptedException, IOException {
		
		System.out.println("Feature Community_Email_linkedIn(): started ");
		WebElement coMmuniTy = driver.findElement(By.xpath("//li[contains(@class,'community-btn')]/a")); Thread.sleep(5000);
		Assert.assertTrue(coMmuniTy.isDisplayed()); Thread.sleep(5000);
		coMmuniTy.click(); Thread.sleep(4000);
		
		WebElement search = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/a/img"));
		AssertJUnit.assertTrue(search.isDisplayed()); Thread.sleep(5000);
		search.click(); Thread.sleep(5000);		
		WebElement text = driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[3]/div/div/div/div[2]/span[1]/a/img"));
		AssertJUnit.assertTrue(text.isDisplayed()); Thread.sleep(4000);
		text.sendKeys("Jonathan"); Thread.sleep(4000);
		driver.findElement(By.xpath("html/body/section/div[2]/div[1]/div/div/div[1]/div[2]/div/form/input[2]")).sendKeys(Keys.ENTER); Thread.sleep(4000);	
		System.out.println("Member Jonathan Davis is searched from community");
		CommunityCS.captureScreenShot(driver);	
		driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div/div/div/div[1]/div[2]/span[1]")).click(); Thread.sleep(4000);   
		driver.findElement(By.xpath("//*[@id=\"member_info_modal\"]/div/div/div[1]/button/img")).click(); Thread.sleep(5000);
		CommunityCS.captureScreenShot(driver);
		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[2]/a")).click(); // Community
		System.out.println("For searched member, personal email shooted");
		System.out.println("------------------------------------------------------------------------------------------");
		
		}

	@Test (priority = 8)
	public void signout() throws InterruptedException, IOException {

		driver.findElement(By.xpath("//li[contains(@class,'pro-file')]/a")).click(); Thread.sleep(4000);
		Actions actionLogout = new Actions(driver);
		WebElement logout = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[7]/ul/li[2]/a")); Thread.sleep(5000);
	    actionLogout.moveToElement(logout).build().perform(); Thread.sleep(4000);
	    CommunityCS.captureScreenShot(driver);
		logout.click(); Thread.sleep(5000); //sign-out
		
		System.out.println("Signout done successfully");
		System.out.println("------------------------------------------------------------------------------------------");
		
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
		 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\community\\Screenshot.jpg"));	
		 String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
		 File dest = new File("C:\\Users\\user\\eclipse-workspace\\UATcs\\capturescreen\\community\\" + filename);
		 FileUtils.copyFile(screenshot, dest);
		 
		}
	
	@AfterTest
	public void close_browser() throws Exception {	
		Thread.sleep(5000);
		driver.close();
		System.out.println("Browser closed successgully");
		System.out.println("------------------------------------------------------------------------------------------");
		
		}	
}