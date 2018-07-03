
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
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class AddPost {
	public WebDriver driver;

	@BeforeTest
	public void launchbrowser() throws Exception {
		
		System.out.println("---------------------------------------------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
		driver = new ChromeDriver(); Thread.sleep(5000); 
		driver.manage().window().maximize(); Thread.sleep(5000);
		System.out.println("Successfully passed: launchbrowser()");
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	  
	@Test(priority=0)
	public void homepageCS() throws Exception {
		
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("URL added on browser"); Thread.sleep(4000);
		
		// log-In with user on CS
		driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com");Thread.sleep(4000);
		driver.findElement(By.id("password")).sendKeys("Test1234");
		System.out.println("Email and password added to login form");
		System.out.println("Website under testing is: "+driver.getCurrentUrl()); 
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER); Thread.sleep(5000);
		System.out.println("Successfully passed: HomepageCS()");
		System.out.println("---------------------------------------------------------------------------------");
		
	}

	@Test (priority=1)
	public void switchShare() throws InterruptedException, IOException {		
	
		Actions share = new Actions(driver);
	    WebElement sh = driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]")); Thread.sleep(5000);
	    share.moveToElement(sh).build().perform(); Thread.sleep(5000); sh.click(); Thread.sleep(5000);		
		driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul[1]/li/ul/li[4]/a")).click(); Thread.sleep(5000); 
		
		WebElement sh1 = driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]"));  Thread.sleep(5000);
		share.moveToElement(sh1).build().perform(); Thread.sleep(5000); sh1.click(); Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul[1]/li/ul/li[3]/a")).click(); Thread.sleep(5000);	
		AddPost.captureScreenShot(driver);
		System.out.println("Moved to desired share for testing successfully passed!, SwitchShare()");
		System.out.println("------------------------------------------------------------------------------------------");		
	}
		
	@Test (priority=2)
	public void add_New_post_visibilityAlertsAll() throws InterruptedException, IOException {
		Actions ADDPOST = new Actions(driver);
		WebElement addPost = driver.findElement(By.xpath("//button[contains(@class,'post-button')]"));Thread.sleep(5000);
		ADDPOST.moveToElement(addPost).build().perform(); Thread.sleep(5000); 
		System.out.println("Add a post field is displayed: "+addPost.isDisplayed()); Thread.sleep(5000);
		addPost.sendKeys(Keys.ENTER); Thread.sleep(2000);
		
		// Enter subject of post on add post form
		WebElement subject = driver.findElement(By.name("post[subject]")); Thread.sleep(5000);
		System.out.println("Subject field of add post is displayed: " +subject.isDisplayed()); Thread.sleep(5000);
		subject.click(); Thread.sleep(2000);
		subject.sendKeys("Test Subject title for add post feature testing with automation 1st post"); Thread.sleep(5000);
		AddPost.captureScreenShot(driver);
		
		// Enter body of post on add post form
		                           WebElement body = driver.findElement(By.name("space[post]")); Thread.sleep(5000);
		System.out.println("Body field of add post is displayed: " +body.isDisplayed()); Thread.sleep(5000);
		body.click(); Thread.sleep(3000);
		body.sendKeys("Test body Text for add post feature testing with automation, This is quick test for whole add post feature validation. ");
		AddPost.captureScreenShot(driver); Thread.sleep(5000);  
		
		// click link attach files on add post pop-up form
		WebElement attachfiles = driver.findElement(By.xpath("//a[text()='Attach file(s)']")); Thread.sleep(5000);
		System.out.println("Attach Files link of add post is displayed: " +attachfiles.isDisplayed()); Thread.sleep(5000);
		attachfiles.click();  Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Autoit\\bulkupload.exe"); Thread.sleep(2000);
		
		// Publish post
		WebElement publish = driver.findElement(By.xpath("//button[contains(@id,'save_post_btn_new')]")); Thread.sleep(5000);
		System.out.println("Publish button is displayed: " +publish.isDisplayed()); Thread.sleep(5000);
		ADDPOST.moveToElement(publish).build().perform(); Thread.sleep(5000); 
		publish.click(); Thread.sleep(7000);
		
		System.out.println("Successfully passed: add_New_post_visibilityAlertsAll()");
		System.out.println("---------------------------------------------------------------------------------");	
	}
	
	@Test (priority=3)
	public void add_New_post_visibilityNone() throws InterruptedException, IOException {
		
		Actions addPOst = new Actions(driver);
		WebElement addPst = driver.findElement(By.xpath("//button[contains(@class,'post-button')]"));Thread.sleep(5000);
		System.out.println("Add a post field is displayed: "+addPst.isDisplayed()); Thread.sleep(5000);
		addPOst.moveToElement(addPst).build().perform(); Thread.sleep(4000);
		addPst.sendKeys(Keys.ENTER); Thread.sleep(4000);
		
		// Enter subject of post on add post form
		WebElement subJet = driver.findElement(By.name("post[subject]")); Thread.sleep(5000);
		System.out.println("Subject field of add post is displayed: " +subJet.isDisplayed()); Thread.sleep(5000);
		subJet.click(); Thread.sleep(2000);
		subJet.sendKeys("Test Subject title for add post feature testing with automation 1st post"); Thread.sleep(5000);
		AddPost.captureScreenShot(driver); Thread.sleep(2000);
		
		// Enter body of post on add post form
		WebElement bOdy = driver.findElement(By.name("space[post]")); Thread.sleep(5000);
		System.out.println("Body field of add post is displayed: " +bOdy.isDisplayed()); Thread.sleep(5000);
		bOdy.click(); Thread.sleep(3000);
		bOdy.sendKeys("Test body Text for add post feature testing with automation, This is quick test for whole add post feature validation. ");
		AddPost.captureScreenShot(driver); Thread.sleep(5000);
		
		// click link attach files on add post pop-up form
		WebElement attachFils = driver.findElement(By.xpath("//a[text()='Attach file(s)']")); Thread.sleep(5000);
		System.out.println("Attach Files link of add post is displayed: " +attachFils.isDisplayed()); Thread.sleep(5000);
		attachFils.click();  Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Autoit\\bulkupload.exe"); Thread.sleep(2000);	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", bOdy);Thread.sleep(5000);
		
		// Choose category post
		WebElement categRy = driver.findElement(By.xpath("//*[@id=\"native_category-drop form-control\"]/div/button")); Thread.sleep(5000);
		System.out.println("Category dropdown option is displayed: " +categRy.isDisplayed()); Thread.sleep(5000);
		categRy.click(); Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"native_category-drop form-control\"]/div/ul/li[2]/a/label")).click();	Thread.sleep(3000);
		AddPost.captureScreenShot(driver);		
		
		// Select visibility
		WebElement visibty = driver.findElement(By.xpath("//span[contains(@class,'selection_visibility')]")); Thread.sleep(5000);
		System.out.println("Visibility dropdown option is displayed: " +visibty.isDisplayed()); Thread.sleep(5000);
		addPOst.moveToElement(visibty).build().perform(); Thread.sleep(4000);
		visibty.click(); Thread.sleep(5000);
		
		WebElement eryone = driver.findElement(By.xpath("//li[contains(@class,'multiselect-item')]")); Thread.sleep(5000);
		System.out.println("Everyone dropdown option is displayed: " +eryone.isDisplayed()); Thread.sleep(5000);
		addPOst.moveToElement(eryone).build().perform(); Thread.sleep(4000);
		eryone.click(); Thread.sleep(5000);
		
		// Publish post
		WebElement pbliSh = driver.findElement(By.xpath("//button[contains(@id,'save_post_btn_new')]")); Thread.sleep(5000);
		System.out.println("Post button is displayed: "+pbliSh.isDisplayed());  Thread.sleep(5000);
		addPOst.moveToElement(pbliSh).build().perform(); Thread.sleep(6000);
		pbliSh.click(); Thread.sleep(7000);
		
		System.out.println("Successfully passed: add_New_post_visibilityNone");
		System.out.println("---------------------------------------------------------------------------------");
	
	}	
	
	@Test (priority=4)
	public void add_New_post_multiSharePostAlertsNone() throws InterruptedException, IOException {
		Actions addPoSt = new Actions(driver);
		WebElement adPost = driver.findElement(By.xpath("//button[contains(@class,'post-button')]"));Thread.sleep(5000);
		System.out.println("Add a post field is displayed: "+adPost.isDisplayed()); Thread.sleep(5000);
		addPoSt.moveToElement(adPost).build().perform(); Thread.sleep(4000);
		adPost.sendKeys(Keys.ENTER); Thread.sleep(4000);
		
		// Enter subject of post on add post form
		WebElement sbJec = driver.findElement(By.name("post[subject]")); Thread.sleep(5000);		
		System.out.println("Subject field of add post is displayed: " +sbJec.isDisplayed()); Thread.sleep(5000);
		addPoSt.moveToElement(sbJec).build().perform(); Thread.sleep(4000);
		sbJec.sendKeys("Test Subject title for MULTISHARE add post feature testing with automation 1st post"); Thread.sleep(5000);
		AddPost.captureScreenShot(driver);
		
		// Enter body of post on add post form
		WebElement bdY = driver.findElement(By.name("space[post]")); Thread.sleep(5000);
		System.out.println("Body field of add post is displayed: " +bdY.isDisplayed()); Thread.sleep(5000);
		addPoSt.moveToElement(bdY).build().perform(); Thread.sleep(4000);
		bdY.sendKeys("Test body Text for MULTISHARE add post feature testing with automation, This is quick test for whole add post feature validation. ");
		AddPost.captureScreenShot(driver); Thread.sleep(5000);
		
		// click link attach files on add post pop-up form
		WebElement atachFiles = driver.findElement(By.xpath("//a[text()='Attach file(s)']")); Thread.sleep(5000);
		System.out.println("Attach Files link of add post is displayed: " +atachFiles.isDisplayed()); Thread.sleep(5000);
		addPoSt.moveToElement(atachFiles).build().perform(); Thread.sleep(4000);
		atachFiles.click();  Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Autoit\\bulkupload.exe"); Thread.sleep(2000);	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", bdY);Thread.sleep(5000);
		
		// Choose category post
		WebElement catoRy = driver.findElement(By.xpath("//*[@id='native_category-drop form-control']/div/button")); Thread.sleep(5000);
		System.out.println("category dropdown option is displayed: " +catoRy.isDisplayed()); Thread.sleep(5000);
		addPoSt.moveToElement(catoRy).build().perform(); Thread.sleep(4000);
		catoRy.click(); Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='native_category-drop form-control']/div/ul/li[2]/a/label")).click();	Thread.sleep(3000);
		AddPost.captureScreenShot(driver);	 Thread.sleep(5000);	
		
		// Select Multi-Share
		WebElement multiPost = driver.findElement(By.xpath("//label[contains(@class,'post_share')]")); Thread.sleep(5000);
		System.out.println("MultiPost option checkbox is displayed: " +multiPost.isDisplayed()); Thread.sleep(5000);
		addPoSt.moveToElement(multiPost).build().perform(); Thread.sleep(4000);
		multiPost.click(); Thread.sleep(5000);
		
		WebElement chooseShare = driver.findElement(By.xpath("//span[contains(@class,'choose_share')]")); Thread.sleep(5000);
		System.out.println("MultiPost option choose multishare is displayed: " +chooseShare.isDisplayed()); Thread.sleep(5000);
		addPoSt.moveToElement(chooseShare).build().perform(); Thread.sleep(4000);
		chooseShare.click(); Thread.sleep(5000);
		
		WebElement share1 = driver.findElement(By.xpath("//*[@id=\"tour2\"]/div[3]/div/div[4]/div/ul/li[3]/label")); Thread.sleep(5000);
		System.out.println("Share selected option is displayed: " +share1.isDisplayed()); Thread.sleep(5000);
		addPoSt.moveToElement(share1).build().perform(); Thread.sleep(4000);
		System.out.println("Share selected name is: " +share1.getText()); Thread.sleep(5000);
		share1.click(); Thread.sleep(5000);
		
		// Alerts None when multipost multishare
		WebElement alertShr = driver.findElement(By.xpath("//span[contains(@class,'selection_alert_share active')]")); Thread.sleep(4000);
		System.out.println("Alerts Everyone multishare select option is displayed: " +alertShr.isDisplayed()); Thread.sleep(5000);
		addPoSt.moveToElement(alertShr).build().perform(); Thread.sleep(4000);
		alertShr.click(); Thread.sleep(4000);
		
		WebElement alrt = driver.findElement(By.xpath("//*[@id=\"tour2\"]/div[3]/div/div[3]/div[2]/ul/li/label")); Thread.sleep(4000);
		System.out.println("Alerts multishare option is displayed: " +alrt.isDisplayed()); Thread.sleep(5000);
		addPoSt.moveToElement(alrt).build().perform(); Thread.sleep(4000);
		alrt.click(); Thread.sleep(4000);
		
		// Publish post
		WebElement publSh = driver.findElement(By.xpath("//button[contains(@id,'save_post_btn_new')]")); Thread.sleep(5000);
		System.out.println("category dropdown option is displayed: " +publSh.isDisplayed()); Thread.sleep(5000);
		publSh.click(); Thread.sleep(10000);
	
		AddPost.captureScreenShot(driver); Thread.sleep(5000);
		System.out.println("Successfully passed: add_New_post_multiSharePostAlertsNone");
		System.out.println("---------------------------------------------------------------------------------");
	
	}	
	
	@AfterTest
	public void close_Browser() throws InterruptedException {
		Thread.sleep(4000); driver.quit(); 
		System.out.println("Successfully passed: Close_Browser()");
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	public static void captureScreenShot(WebDriver driver) throws IOException{
		 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\Screenshot.jpg"));	
		 String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss'.jpeg'").format(new Date());
		 File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\addpost\\" +filename);
		 FileUtils.copyFile(screenshot, dest);
	}
	
}