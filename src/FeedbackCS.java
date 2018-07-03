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
		import org.testng.annotations.Test;
		
		public class FeedbackCS {
		public WebDriver driver;
			 
		@BeforeTest
		public void launchbrowser() throws IOException, InterruptedException {
			System.out.println("------------------------------------------------------------------------------------------");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
			driver = new ChromeDriver();Thread.sleep(5000);
			driver.manage().window().maximize();Thread.sleep(5000);
			System.out.println("Browser opened Successfully passed!, launchbrowser()");
			
		}
		
		@Test (priority = 0)
		public void homepageLogin() throws InterruptedException, IOException {
			
			// Home page CS login	
			Thread.sleep(5000);	driver.navigate().to("https://uat-clientspace.herokuapp.com");
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
			driver.findElement(By.id("email")).sendKeys("ashishkumar@ucreate.co.in");
			driver.findElement(By.id("password")).sendKeys("Test1234");
			System.out.println("Email and password added to login form"); Thread.sleep(5000);		
			String Actualtext = driver.findElement(By.id("show-sent")).getText();
			FeedbackCS.captureScreenShot(driver);
			
			Assert.assertNotEquals(Actualtext, "Sign in", "Expected and actual match in assertion_method_1");		
			driver.findElement(By.id("show-sent")).sendKeys(Keys.ENTER);
			System.out.println("Login form submitted, moved to homepage CS, Homepage opened successfully");
			System.out.println("Successfully passed!, homepageLogin()");
			System.out.println("---------------------------------------------------------------------------------------");
			
		}
		
		@Test (priority = 1)
		public void switchShare() throws InterruptedException, IOException {				
			// Switch share functionality tests	
			Actions share = new Actions(driver);
		    WebElement sh = driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]")); Thread.sleep(5000);
		    share.moveToElement(sh).build().perform(); FeedbackCS.captureScreenShot(driver);    
			sh.click(); driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[4]/a")).click(); 
			
			driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]")).click(); Thread.sleep(5000);
			WebElement share1 = driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[8]/a")); Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", share1); Thread.sleep(5000); 		
			share.moveToElement(share1).build().perform(); Thread.sleep(5000);	share1.click(); Thread.sleep(5000);
			
			driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]")).click(); Thread.sleep(5000);
			WebElement share2 = driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul[1]/li/ul/li[12]/a")); Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", share2); Thread.sleep(5000); 		
			share.moveToElement(share2).build().perform(); Thread.sleep(5000); share2.click(); Thread.sleep(5000);
			
			System.out.println("Successfully moved to desired share, passed: SwitchShare()");				
			FeedbackCS.captureScreenShot(driver); Thread.sleep(5000);	
			System.out.println("Successfully passed!, switchShare()");
			System.out.println("---------------------------------------------------------------------------------------");
		
		}
		
		@Test (priority = 2)
		public void feedbackLandingPage()throws InterruptedException, IOException {		
			// Feedback page testing 
			Actions action = new Actions(driver);
		    WebElement fb = driver.findElement(By.xpath("//img[contains(@src,'https://uat-clientspace.herokuapp.com/images/ic_chat.svg')]"));
		    action.moveToElement(fb).build().perform();	 Thread.sleep(5000);  
		   
		    System.out.println("Feedback link is displayed: "+fb.isDisplayed()); Thread.sleep(5000); 
		    System.out.println("Feedback link is enabled: " +fb.isEnabled());
		    action.moveToElement(fb).build().perform(); Thread.sleep(5000);
		    System.out.println("Feedback link is selected: " +fb.isSelected()); Thread.sleep(5000);
			fb.click(); Thread.sleep(5000); System.out.println("Successfully passed!, feedbackLandingPage()"); 
			System.out.println("------------------------------------------------------------------------------------------------");
			
		}
		
		@Test(priority=3)
		public void hoverFeedbackQuarters() throws InterruptedException, IOException {		
			// Hover Feedback quarters 
			Actions action1 = new Actions(driver);
			WebElement currentQuarter = driver.findElement(By.xpath("//li[contains(@class,'active')]")); Thread.sleep(5000);
			System.out.println("Current quarter on share is: " +currentQuarter.getText()); Thread.sleep(5000);
			action1.moveToElement(currentQuarter).build().perform(); Thread.sleep(5000); 
			FeedbackCS.captureScreenShot(driver); Thread.sleep(5000);
			
			WebElement message = driver.findElement(By.xpath("//div[contains(@class,'feedback-submitted')]")); Thread.sleep(5000);
			System.out.println("Current quarter feedback status: " +message.getText()); Thread.sleep(5000);
			System.out.println("Successfully passed!, hoverFeedbackQuarters");
			System.out.println("----------------------------------------------------------------------------------------------------");
		}
		
		@Test(priority=4)
		public void feedbackResults() throws InterruptedException {
				
			// scroll history quarters feedbacks 
			WebElement quarter = driver.findElement(By.xpath("//a[contains(@href,'https://uat-clientspace.herokuapp.com/feedback/10/2017')]"));
			System.out.println("june- august quarter is displayed: "+quarter.isDisplayed()); Thread.sleep(5000);
			System.out.println("Quarter used for testing is: " +quarter.getText()); Thread.sleep(3000);
			quarter.click(); Thread.sleep(5000);
			
			WebElement NPS = driver.findElement(By.xpath("//h1[contains(@class,'text-center')]"));
			System.out.println("NPS for this quarter is: " +NPS.getText()); Thread.sleep(5000);
			
			WebElement numberRespondes = driver.findElement(By.xpath("//div[contains(@class,'count-nps')]/p"));
			System.out.println("Number of respondes on this quarter were: "+numberRespondes.getText());
			Actions action2 = new Actions(driver);
			
			WebElement fd1 = driver.findElement(By.xpath("//*[@id=\"feedback\"]/div[2]/div[1]/form/div/div[3]")); Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fd1); Thread.sleep(5000); 		
			action2.moveToElement(fd1).build().perform(); Thread.sleep(4000);	
		
			WebElement fd2 = driver.findElement(By.xpath("//*[@id=\"feedback\"]/div[2]/div[1]/form/div/div[8]")); Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fd2); Thread.sleep(5000); 
			
			WebElement fd3 = driver.findElement(By.xpath("//*[@id=\"feedback\"]/div[2]/div[1]/form/div/div[1]")); Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fd3); Thread.sleep(5000);
			
			WebElement fd4 = driver.findElement(By.xpath("//h1[contains(@class,'text-center')]")); Thread.sleep(5000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fd4); Thread.sleep(5000);
			System.out.println("Successfully passed!, feedbackResults()"); 
			System.out.println("-----------------------------------------------------------------------------------------");
			
		}
			
		
		@Test(priority=5)
		public void hoverQuestionFeedback() throws IOException, InterruptedException {		
			// Hover on ? feedback
			WebElement questions= driver.findElement(By.xpath("//a[contains(@class,'helpicon')]")); Thread.sleep(5000);
			Actions hQ = new Actions(driver);
			hQ.moveToElement(questions).build().perform(); Thread.sleep(5000);
			
			FeedbackCS.captureScreenShot(driver); Thread.sleep(5000);    
			System.out.println("Successfully passed!, hoverQuestionFeedback()");
			System.out.println("-----------------------------------------------------");	
			
		}
		
		@Test (priority=6)
		public void feedbackDownload() throws Exception {
			WebElement downloadPDF = driver.findElement(By.xpath("//h4[contains(@class,'download_feedback_pdf')]"));
			System.out.println("Download pdf link for respective quarter is displayed: " +downloadPDF.isDisplayed());
			System.out.println("Download PDF link text is: " +downloadPDF.getText()); Thread.sleep(5000);
			WebElement shareName = driver.findElement(By.xpath("//h4[contains(@class,'text-center')]")); Thread.sleep(5000);
			System.out.println("Feedback QUARETR & share details: "+shareName.getText());
			//downloadPDF.click(); Thread.sleep(5000);// download feedback
			FeedbackCS.captureScreenShot(driver); 
			WebElement feed = driver.findElement(By.xpath("//li[contains(@class,'feed-button')]"));
			System.out.println("Feed link is displayed: "+feed); Thread.sleep(5000); feed.click(); Thread.sleep(5000);
			System.out.println("Successfully passed!,feedbackDownload()");
			System.out.println("------------------------------------------------------------------------------");
			
		}
			
		@Test (priority = 7)
		public void signout() throws InterruptedException, IOException {
			driver.findElement(By.xpath("//li[contains(@class,'pro-file')]/a")).click(); Thread.sleep(4000);
			Actions actionLogout = new Actions(driver);
			WebElement logout = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-2']/ul[2]/li[7]/ul/li[2]/a")); Thread.sleep(5000);
		    actionLogout.moveToElement(logout).build().perform(); Thread.sleep(4000);
		    FeedbackCS.captureScreenShot(driver);
			logout.click(); Thread.sleep(5000); //sign-out
			
			System.out.println("Signout done successfully");
			System.out.println("------------------------------------------------------------------------------------------");
			
		}
		
		public static void captureScreenShot(WebDriver driver) throws IOException{
			java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\feedback\\Screenshot.jpg"));	
			String filename =  new SimpleDateFormat("yyyy-MM-dd-hh-mm'.jpeg'").format(new Date());
			File dest = new File("C:\\Users\\HP\\eclipse-workspace\\UATcs\\capturescreen\\feedback\\" + filename);
			FileUtils.copyFile(screenshot, dest);
			 
		}
		
		@AfterTest
		public void close_browser() {		
			driver.close();
			System.out.println("Browser closed successgully");
			System.out.println("------------------------------------------------------------------------------------------");
		}
		
		}
