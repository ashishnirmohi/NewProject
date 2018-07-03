
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class AnalyticsCS {
	public WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() throws IOException, Exception {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		driver = new ChromeDriver(options);Thread.sleep(5000);
		driver.manage().window().maximize();Thread.sleep(5000);
		System.out.println("Browser opened ");
		System.out.println("Successfully passed!, launchbrowser()");
		AnalyticsCS.captureScreenShot(driver);
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
		driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER);		
		AnalyticsCS.captureScreenShot(driver);
		
		System.out.println("Login form submitted"); System.out.println(driver.getCurrentUrl());	Thread.sleep(5000);
		System.out.println("Successfully passed!, HomepageCS()");	
		System.out.println("------------------------------------------------------------------------------------------");
	}

	@Test (priority=1)
		public void switchShare() throws InterruptedException, IOException {		
		
		Actions share = new Actions(driver);
	    WebElement sh = driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]")); Thread.sleep(5000);
	    share.moveToElement(sh).build().perform(); Thread.sleep(5000); sh.click(); Thread.sleep(5000);		
		driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul[1]/li/ul/li[7]/a")).click(); Thread.sleep(5000); 
		
		WebElement sh1 = driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]"));  Thread.sleep(5000);
		share.moveToElement(sh1).build().perform(); Thread.sleep(5000); sh1.click(); Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul[1]/li/ul/li[3]/a")).click(); Thread.sleep(5000);	
		AnalyticsCS.captureScreenShot(driver); Thread.sleep(5000); 
		
		System.out.println("Moved to desired share for testing successfully passed!, SwitchShare()");
		System.out.println("-----------------------------------------------------------------------------------------------------");
	}
	
	
	@Test (priority=2)
		public void analytics_landing_Page() throws InterruptedException, IOException{
			
		Actions analytic = new Actions(driver);
		WebElement aLytics = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[2]/a/span[2]")); Thread.sleep(5000);
	    analytic.moveToElement(aLytics).build().perform();	AnalyticsCS.captureScreenShot(driver);	
	    System.out.println("Link analytics is displayed: " +aLytics.isDisplayed()); Thread.sleep(5000);
		System.out.println("Link text for analytics is: " +aLytics.getText());
		Thread.sleep(5000); aLytics.click(); Thread.sleep(4000);//analytics
		
		System.out.println("Analytic page opened"); AnalyticsCS.captureScreenShot(driver);
		System.out.println(driver.getCurrentUrl());
		
		WebElement csi = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[1]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", csi); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement post = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", post);Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver); 
		
		WebElement postint = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", postint); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
	    WebElement community = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[3]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", community); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement nps = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[4]/div[1]/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", nps); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement community1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[3]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", community1); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement postint1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", postint1); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement post1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", post1);Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver); 
		
		WebElement csi1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[1]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", csi1); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		System.out.println("");    
		System.out.println("Analytic page scrolled, successfully passed!: Analytics_landing_Page()");
		System.out.println("----------------------------------------------------------------------------------------------------------");
	}	

	@Test(priority=3)
	public void analytics_Filter_MonthYear() throws InterruptedException, IOException {
		
		Actions analytic = new Actions(driver);
	    WebElement aLyics = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[2]/a/span[2]")); Thread.sleep(5000);
	    analytic.moveToElement(aLyics).build().perform(); Thread.sleep(5000); AnalyticsCS.captureScreenShot(driver);	
	    System.out.println("Link analytics is displayed: " +aLyics.isDisplayed()); Thread.sleep(5000);
		System.out.println("Link to download analytics text is: " +aLyics.getText()); Thread.sleep(5000); 
		aLyics.click(); Thread.sleep(4000);  //analytics	
		 
		WebElement month = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[1]/div[2]/button")); Thread.sleep(5000); 
		System.out.println("Select box month analytics is displayed: " +month.isDisplayed()); Thread.sleep(5000); 	
		analytic.moveToElement(month).build().perform(); Thread.sleep(5000); 
		System.out.println("Select box month to download analytics text is: " +month.getText()); Thread.sleep(5000); 
		month.click();  Thread.sleep(25000); // Click month drop-down
		
		WebElement mon = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[1]/div[2]/div/ul/li[1]/a"));
		analytic.moveToElement(mon).build().perform(); Thread.sleep(5000); 
		mon.click(); Thread.sleep(50000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement csI = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[1]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", csI); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement posT = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", posT); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement postI = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", postI);  Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement communitY = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[3]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", communitY); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement npS = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[4]/div[1]/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", npS);  Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement communitY1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[3]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", communitY1); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement postI1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", postI1);  Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement posT1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", posT1); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement csI1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[1]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", csI1); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		System.out.println("Analytic page scrolled after applying filter months, successfully passed!: Analytics_Filter_MonthYear()");		
		System.out.println("---------------------------------------------------------------------------------------------------------------");
	}
	

	@Test(priority=4)
	public void analytics_SelectAllShare_Graphs() throws InterruptedException, IOException {
		
		Actions analytic = new Actions(driver);
	    WebElement aLyics = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[2]/a/span[2]")); Thread.sleep(5000);
	    analytic.moveToElement(aLyics).build().perform(); Thread.sleep(5000); AnalyticsCS.captureScreenShot(driver);	
	    System.out.println("Link analytics is displayed: " +aLyics.isDisplayed()); Thread.sleep(5000);
		System.out.println("Link to download analytics text is: " +aLyics.getText()); Thread.sleep(5000); 
		aLyics.click(); Thread.sleep(4000);  //analytics	
		
		WebElement selectAll = driver.findElement(By.xpath("/html/body/section/form/div/div[1]/div/ul/li[2]/div/div[1]/h4/label"));Thread.sleep(5000);
		System.out.println("Link analytics selectAll is displayed: " +selectAll.isDisplayed()); Thread.sleep(5000);
		System.out.println("Link to download analytics selectAll is: " +selectAll.getText()); Thread.sleep(5000);
		selectAll.click(); Thread.sleep(47000);
		driver.findElement(By.xpath("/html/body/div[5]/div/div[10]/button[1]")).click();
		
		WebElement AcsI = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[1]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AcsI); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement AposT = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AposT); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement ApostI = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ApostI);  Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement AcommunitY = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[3]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AcommunitY); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement AnpS = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[4]/div[1]/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AnpS);  Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement AcommunitY1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[3]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AcommunitY1); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement ApostI1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ApostI1);  Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement AposT1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[2]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AposT1); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		WebElement AcsI1 = driver.findElement(By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[1]/div/div[2]/p"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", AcsI1); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver);
		
		driver.navigate().refresh(); Thread.sleep(7000);
		System.out.println("successfully passed!: Analytics_SelectAllShare_Graphs()");
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
	}

	
	@Test(priority=5)
	public void analytics_DownloadXSLX() throws InterruptedException, IOException {
		Actions analtic = new Actions(driver);
	    WebElement ANALYTIC = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[2]/a/span[2]")); Thread.sleep(5000);
	    analtic.moveToElement(ANALYTIC).build().perform(); Thread.sleep(4000);
	    AnalyticsCS.captureScreenShot(driver); ANALYTIC.click(); Thread.sleep(4000);
		WebElement downloadReport = driver.findElement(By.xpath("//button[contains(@id,'analytics-download-dropdown')]")); Thread.sleep(5000);
		System.out.println("Link to download analytics reposts is displayed: " +downloadReport.isDisplayed()); Thread.sleep(5000);
		downloadReport.click(); Thread.sleep(5000);
		
		WebElement XLSXLink = driver.findElement(By.xpath("//a[contains(@class,'excel_download_all')]")); Thread.sleep(5000);
		System.out.println("Link to download analytics XSLX is displayed: " +XLSXLink.isDisplayed()); Thread.sleep(5000);
		System.out.println("Link to download analytics XSLX is: " +XLSXLink.getText()); Thread.sleep(5000);
		analtic.moveToElement(XLSXLink).build().perform(); Thread.sleep(4000);
		XLSXLink.click(); Thread.sleep(5000); AnalyticsCS.captureScreenShot(driver);
		
		driver.findElement(By.xpath("//*[@id='analytics_email_popup']/div/div/div[3]/button")).click(); Thread.sleep(5000);
		AnalyticsCS.captureScreenShot(driver); Thread.sleep(5000);
		System.out.println("passed: Analytics_DownloadXSLX()");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		
	}
		
	@Test(priority=6)
	public void analytics_DownloadPDF() throws Exception {
		Actions analyTic = new Actions(driver);
		WebElement downloadReports = driver.findElement(By.xpath("//button[contains(@id,'analytics-download-dropdown')]")); Thread.sleep(5000);
		analyTic.moveToElement(downloadReports).build().perform(); Thread.sleep(4000);
		System.out.println("Link to download analytics reposts is displayed: " +downloadReports.isDisplayed()); Thread.sleep(5000);
		downloadReports.click(); Thread.sleep(5000);
		
		WebElement pdfLink = driver.findElement(By.xpath("//a[contains(@class,'download_pdf_trigger')]")); Thread.sleep(5000);
		System.out.println("Link to download analytics PDF is displayed: " +pdfLink.isDisplayed()); Thread.sleep(5000);
		System.out.println("Link to download analytics PDF is: " +pdfLink.getText()); Thread.sleep(5000);
		analyTic.moveToElement(pdfLink).build().perform(); Thread.sleep(4000);
		pdfLink.click(); Thread.sleep(5000);
		
		System.out.println("passed: Analytics_DownloadPDF()");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
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
		 File dest = new File("C:\\Users\\user\\eclipse-workspace\\NewProject\\capturescreen\\analytics\\" + filename);
		 FileUtils.copyFile(screenshot, dest);
		}

}
