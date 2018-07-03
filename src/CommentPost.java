
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
	import org.openqa.selenium.interactions.Actions;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	public class CommentPost {
	public WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() throws IOException, Exception {

		System.out.println("---------------------------------------------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
		driver = new ChromeDriver(); Thread.sleep(5000); 
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
		CategoryFilter.captureScreenShot(driver);
		
		System.out.println("Login form submitted"); System.out.println(driver.getCurrentUrl());	Thread.sleep(5000);
		System.out.println("Successfully passed!, HomepageCS()");	
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	@Test (priority=2)
	public void plain_CommentText_post() throws Exception {
		Actions CommenT = new Actions(driver);
		WebElement comment = driver.findElement(By.xpath("//textarea[contains(@class,'no-border')]")); Thread.sleep(5000);
		CommenT.moveToElement(comment).build().perform(); Thread.sleep(4000);
		System.out.println("Comment fiels is displayed: " +comment.isDisplayed());  Thread.sleep(4000);
		comment.click();  Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		comment.sendKeys("Hello test comment without URL");  Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		
		WebElement send = driver.findElement(By.xpath("//input[contains(@name,'sendmessage')]"));  Thread.sleep(5000);
		CommenT.moveToElement(send).build().perform(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		System.out.println("Comment send link is displayed: " +send.isDisplayed());  Thread.sleep(4000);
		System.out.println("Comment send link text is: " +send.getText());  Thread.sleep(4000);
		send.click(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		driver.navigate().refresh(); Thread.sleep(5000);
		
		System.out.println("Successfully passed: plain_CommentText_post()");
		System.out.println("---------------------------------------------------------------------------------");
	}
	/*
	@Test (priority=3)
	public void URL_CommentText_post() throws Exception {
		Actions Comment = new Actions(driver);
		WebElement comment = driver.findElement(By.xpath("//textarea[contains(@class,'comment-area')]")); Thread.sleep(4000);
		Comment.moveToElement(comment).build().perform(); Thread.sleep(4000);
		System.out.println("Comment fiels is displayed: " +comment.isDisplayed());  Thread.sleep(4000);
		comment.click();  Thread.sleep(4000);
		comment.sendKeys("Test comment http://www.clientshare.com ");  Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		
		WebElement send = driver.findElement(By.xpath("//input[contains(@name,'sendmessage')]"));  Thread.sleep(4000);
		Comment.moveToElement(send).build().perform(); Thread.sleep(4000);
		System.out.println("Comment submit link is displayed: " +send.isDisplayed());  Thread.sleep(4000);
		System.out.println("Comment submit link text is: " +send.getText());  Thread.sleep(4000);
		send.click(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		driver.navigate().refresh(); Thread.sleep(5000);
		
		System.out.println("Successfully passed: URL_CommentText_post()");
		System.out.println("---------------------------------------------------------------------------------");
		
	}
	
	@Test (priority=4)
	public void edit_CommentText_post() throws Exception {
		Actions hover = new Actions(driver);
		WebElement Threedot = driver.findElement(By.xpath("//div[contains(@class,'dots')]"));  Thread.sleep(4000);
		System.out.println("Comment submit link is displayed: " +Threedot.isDisplayed());  Thread.sleep(4000);
		hover.moveToElement(Threedot).build().perform(); Thread.sleep(4000);
		
		WebElement editcom = driver.findElement(By.xpath("//li[contains(@class,'domain_inp_edit')]"));  Thread.sleep(4000);
		System.out.println("Comment submit link is displayed: " +editcom.isDisplayed());  Thread.sleep(4000);
		hover.moveToElement(editcom).build().perform(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		System.out.println("Edit Comment submit link text is: " +editcom.getText());  Thread.sleep(4000);
		editcom.click(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		
		WebElement editcomtform = driver.findElement(By.xpath("//textarea[contains(@class,'edit_comment')]"));  Thread.sleep(4000);
		System.out.println("Comment submit link is displayed: " +editcomtform.isDisplayed());  Thread.sleep(4000);
		editcomtform.clear(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		editcomtform.sendKeys("Comment is edited !! :) "); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		
		WebElement saveEdit = driver.findElement(By.xpath("//button[contains(@class,'save_comment')]"));  Thread.sleep(4000);
		hover.moveToElement(saveEdit).build().perform(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		System.out.println("Comment submit link is displayed: " +saveEdit.isDisplayed());  Thread.sleep(4000);
		saveEdit.click(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		driver.navigate().refresh(); Thread.sleep(5000);
		
		System.out.println("Successfully passed: edit_CommentText_post()");
		System.out.println("---------------------------------------------------------------------------------");
		
		
	}
	
	@Test (priority=5)
	public void showMore_CommentText_post() throws Exception {
		Actions CommenT = new Actions(driver);
		WebElement comment = driver.findElement(By.xpath("//textarea[contains(@class,'comment-area')]")); Thread.sleep(4000);
		CommenT.moveToElement(comment).build().perform(); Thread.sleep(4000);
		System.out.println("Comment fiels is displayed: " +comment.isDisplayed());  Thread.sleep(4000);
		comment.click();  Thread.sleep(4000);
		comment.sendKeys("Hello test comment without URLHello test comment without URLHello test comment without URLHello test comment without URLHello test comment without URLHello test comment without URLHello test comment without URLHello test comment without URLHello test comment without URLHello test comment without URL");  Thread.sleep(4000);
		
		WebElement send = driver.findElement(By.xpath("//input[contains(@class,'send_comment')]"));  Thread.sleep(4000);
		System.out.println("Comment submit link is displayed: " +send.isDisplayed());  Thread.sleep(4000);
		System.out.println("Comment submit link text is: " +send.getText());  Thread.sleep(4000);
		send.click(); Thread.sleep(9000);	
		
		WebElement showmore = driver.findElement(By.xpath("//span[contains(@class,'show_extra_comment')]"));  Thread.sleep(4000);
		CommenT.moveToElement(showmore).build().perform(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		System.out.println("Show More link is displayed: " +showmore.isDisplayed());  Thread.sleep(4000);
		System.out.println("Show More link text is: " +showmore.getText());  Thread.sleep(4000);
		showmore.click(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		
		WebElement showless = driver.findElement(By.xpath("//span[contains(@class,'not_show_comment')]"));  Thread.sleep(4000);
		System.out.println("Show Less link is displayed: " +showless.isDisplayed());  Thread.sleep(4000);
		CommenT.moveToElement(showless).build().perform(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000); 
		showless.click(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000);
		driver.navigate().refresh(); Thread.sleep(5000);
		
		System.out.println("Successfully passed: showMore_CommentText_post()");
		System.out.println("---------------------------------------------------------------------------------");
		
	}
	
	@Test (priority=6)
	public void delete_CommentText_post() throws Exception {
		Actions Hover = new Actions(driver);
		WebElement Threedot = driver.findElement(By.xpath("//div[contains(@class,'member-wrap')]"));  Thread.sleep(4000);
		System.out.println("Comment submit link is displayed: " +Threedot.isDisplayed());  Thread.sleep(4000);
		Hover.moveToElement(Threedot).build().perform(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000);
		
		WebElement dOtmenu = driver.findElement(By.xpath("//a[contains(@class,'dots')]"));  Thread.sleep(4000);
		System.out.println("Comment submit link is displayed: " +dOtmenu.isDisplayed());  Thread.sleep(4000);
		Hover.moveToElement(dOtmenu).build().perform(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000);
		dOtmenu.click(); Thread.sleep(4000); 	
		
		WebElement deleteComment = driver.findElement(By.xpath("//li[contains(@class,'domain_inp_delete')]"));  Thread.sleep(4000);
		System.out.println("Delete comment link is displayed: " +deleteComment.isDisplayed());  Thread.sleep(4000);
		System.out.println("Delete Comment link text is: " +deleteComment.getText());  Thread.sleep(4000);
		Hover.moveToElement(deleteComment).build().perform(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000);
		deleteComment.click(); Thread.sleep(4000); 	
		
		WebElement delete = driver.findElement(By.xpath("//a[contains(@class,'modal_initiate_btn del_comment')]"));  Thread.sleep(4000);
		System.out.println("Cofirm delete comment link is displayed: " +delete.isDisplayed());  Thread.sleep(4000);
		System.out.println("Confirm Delete Comment link text is: " +delete.getText());  Thread.sleep(4000);
		Hover.moveToElement(delete).build().perform(); Thread.sleep(4000);
		CommentPost.captureScreenShot(driver); Thread.sleep(5000);
		delete.click(); Thread.sleep(4000); 	
		driver.navigate().refresh(); Thread.sleep(5000);
		
		System.out.println("Successfully passed: delete_CommentText_post()");
		System.out.println("---------------------------------------------------------------------------------");
		
	}
	*/
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