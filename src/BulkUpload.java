
		import java.io.File;
		import java.io.IOException;
		import java.text.SimpleDateFormat;
		import java.util.Date;
		import org.apache.commons.io.FileUtils;
		import org.openqa.selenium.By;
		import org.openqa.selenium.OutputType;
		import org.openqa.selenium.TakesScreenshot;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.testng.Assert;
		import org.testng.annotations.AfterTest;
		import org.testng.annotations.BeforeTest;
		import org.testng.annotations.Test;
		
		public class BulkUpload {
		WebDriver driver;
		
		@BeforeTest	
		public void Lauchbrowser(){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			}
		
			@Test (priority=0)
			public void bulkUploadLogin() throws Exception {
			driver.navigate().to("https://uat-clientspace.herokuapp.com");
			driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com"); Thread.sleep(3000);
			driver.findElement(By.id("password")).sendKeys("Test1234"); Thread.sleep(3000);
			driver.findElement(By.id("show-sent")).click();	Thread.sleep(2000);
			Assert.assertEquals("Client Share", driver.getTitle(), "Title is matching");
			
			System.out.println("Successfully passed!, bulkUploadLogin()");	
			System.out.println("------------------------------------------------------------------------------------------");
			
		}	
		
		@Test(priority=8)
		public void bulkInvite_settings() throws IOException, InterruptedException {
			WebElement accountpic = driver.findElement(By.xpath("//span[@class='account-nav']"));
			Assert.assertTrue(accountpic.isDisplayed());
			Thread.sleep(5000); accountpic.click();
			
			WebElement settings = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[6]/ul/li[2]/a"));
			Assert.assertTrue(settings.isDisplayed());
			settings.click(); Thread.sleep(5000);
			
			WebElement bu = driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div[1]/div/ul/li[8]/a")); Thread.sleep(3000);
			Assert.assertTrue(bu.isDisplayed());
			bu.click(); Thread.sleep(2000);	
			
			driver.findElement(By.xpath("//*[@id='bulk-invitation-tab']/div[2]/form/div[1]/button")).click(); Thread.sleep(2000);//upload CSV	
			Runtime.getRuntime().exec("C:\\Autoit\\bulkupload2006.exe"); Thread.sleep(2000);
			BulkUpload.captureScreenShot(driver); Thread.sleep(2000);	
			
			driver.findElement(By.xpath("//*[@id=\"bulk-upload-status\"]/div/div/div[3]/button[1]")).click(); Thread.sleep(2000);//OK click
			driver.findElement(By.xpath("//*[@id=\"bulk-invitation-tab\"]/div[2]/form/button")).click(); Thread.sleep(3000);
			BulkUpload.captureScreenShot(driver); Thread.sleep(2000);
			
			System.out.println("Successfully passed!, bulkInvite_settings()");	
			System.out.println("------------------------------------------------------------------------------------------");
		}
		
		public static void captureScreenShot(WebDriver driver) throws IOException{
			java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
			File dest = new File("C:\\Users\\user\\eclipse-workspace\\UATcs\\capturescreen\\settings\\" + filename);
			FileUtils.copyFile(screenshot, dest);		 
		}
			
		@AfterTest
		public void close_browser() throws Exception {	
			Thread.sleep(3000);
			driver.close();
			System.out.println("Browser closed successgully");
			System.out.println("------------------------------------------------------------------------------------------");
		}
	}
