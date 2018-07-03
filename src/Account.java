
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
		import org.testng.Assert;
		import org.testng.annotations.AfterTest;
		import org.testng.annotations.BeforeTest;
		import org.testng.annotations.Test;
		
		public class Account {
		WebDriver driver;
		
		@BeforeTest	
		public void Lauchbrowser() throws Exception{

			System.out.println("---------------------------------------------------------------------------------");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("window-size=1400,800");
			options.addArguments("headless");
			driver = new ChromeDriver(options); Thread.sleep(5000); 
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
		
		@Test(priority=1) 
		public void accountPassword() throws InterruptedException, IOException { 
			WebElement accountpic = driver.findElement(By.xpath("//span[@class='account-nav']"));
			Thread.sleep(5000); accountpic.click();
			
			WebElement settings = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[6]/ul/li[2]/a"));
			settings.click(); Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div[1]/div/ul/li[6]/a")).click(); //account tab link
			driver.findElement(By.xpath("//*[@id=\"password-tab\"]/div[2]/form/div/div[1]/input")).sendKeys("Test1234");
			driver.findElement(By.xpath("//*[@id=\"password-tab\"]/div[2]/form/div/div[2]/input")).sendKeys("@Test1234");
			driver.findElement(By.name("new_confirm_password")).click();  Thread.sleep(4000); 	
			driver.findElement(By.xpath("//*[@id=\"password-tab\"]/div[2]/form/div/div[3]/input")).sendKeys("@Test1234");
			Account.captureScreenShot(driver);
			driver.findElement(By.xpath("//*[@id='password-tab']/div[2]/form/button")).click(); Thread.sleep(4000); 	
			System.out.println(driver.getCurrentUrl());
			driver.navigate().refresh();
			Account.captureScreenShot(driver);
		
		}
		
		@Test (priority=3)
		public void resetPassword() throws InterruptedException, IOException {
			WebElement accountpic1 = driver.findElement(By.xpath("//span[@class='account-nav']"));
			Thread.sleep(5000); accountpic1.click();
			
			driver.findElement(By.linkText("Account")).click();	
			driver.findElement(By.name("current_password")).sendKeys("@Test1234");
			driver.findElement(By.name("new_password")).sendKeys("Test1234");
			driver.findElement(By.name("new_confirm_password")).click();  Thread.sleep(4000); 	
			driver.findElement(By.name("new_confirm_password")).sendKeys("Test1234");
			Account.captureScreenShot(driver);
			driver.findElement(By.xpath("//*[@id='password-tab']/div[2]/form/button")).click(); Thread.sleep(4000); 	
			System.out.println(driver.getCurrentUrl());
			driver.navigate().refresh();
			Account.captureScreenShot(driver);
		
		}
		
		@Test(priority=4)
		public void disable_MyAccount() throws Exception {
			
			Actions DisableAccount = new Actions(driver);
			WebElement dma = driver.findElement(By.xpath("//*[@id=\"password-tab\"]/div[2]/span/a")); Thread.sleep(4000);
			System.out.println("disable my account link is displayed: " +dma.isDisplayed()); Thread.sleep(4000);
			DisableAccount.moveToElement(dma).build().perform(); Thread.sleep(4000);
			System.out.println("Disable account link text is: " +dma.getText()); Thread.sleep(4000);
			dma.click(); Thread.sleep(4000);
			Account.captureScreenShot(driver); Thread.sleep(4000);
			
			WebElement confm = driver.findElement(By.xpath("//button[contains(@class,'confirm')]")); Thread.sleep(4000);
			System.out.println("disable my account link is displayed: " +confm.isDisplayed()); Thread.sleep(4000);
			DisableAccount.moveToElement(confm).build().perform(); Thread.sleep(4000);
			System.out.println("Disable account link text is: " +confm.getText()); Thread.sleep(4000);
			Account.captureScreenShot(driver); Thread.sleep(4000);
				
		}
		
		public static void captureScreenShot(WebDriver driver) throws IOException{
			 java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 //FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\analytics\\Screenshot.jpg"));	
			 String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
			 File dest = new File("C:\\Users\\user\\eclipse-workspace\\NewProject\\capturescreen\\settings\\" + filename);
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
