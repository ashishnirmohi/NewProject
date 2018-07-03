
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
	
	public class CategoryFilter {
	public WebDriver driver;
	 
	@BeforeTest
	public void launchbrowser() throws IOException, Exception {
		System.out.println("------------------------------------------------------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
		driver = new ChromeDriver();Thread.sleep(5000);
		driver.manage().window().maximize();Thread.sleep(5000);
		System.out.println("Browser opened ");
		System.out.println("Successfully passed!, launchbrowser()");
		CategoryFilter.captureScreenShot(driver);
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
		CategoryFilter.captureScreenShot(driver);
		
		System.out.println("Login form submitted"); System.out.println(driver.getCurrentUrl());	Thread.sleep(5000);
		System.out.println("Successfully passed!, HomepageCS()");	
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	@Test (priority=1)
		public void switchShare() throws InterruptedException, IOException {		
		Actions share = new Actions(driver);
	    WebElement sh = driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]")); Thread.sleep(5000);
	    share.moveToElement(sh).build().perform(); Thread.sleep(5000); sh.click(); Thread.sleep(5000);		
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[8]/a")).click(); Thread.sleep(5000); 
		
		WebElement sh1 = driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]"));  Thread.sleep(5000);
		share.moveToElement(sh1).build().perform(); Thread.sleep(5000); sh1.click(); Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/nav/div/div[1]/ul[1]/li/ul/li[3]/a")).click(); Thread.sleep(5000);	
		AnalyticsCS.captureScreenShot(driver); Thread.sleep(5000); 
		
		System.out.println("Moved to desired share for testing successfully passed!, SwitchShare()");
		System.out.println("Successfully passed!, switchShare()");	
		System.out.println("-----------------------------------------------------------------------------------------------------");
	}
	
	@Test(priority=2)
	public void categoryFilterSample() throws Exception {
		
		Actions cateGory = new Actions(driver);
		WebElement categoryPen = driver.findElement(By.xpath("//a[contains(@class,'edit-cat')]")); Thread.sleep(4000);
		Assert.assertTrue(categoryPen.isDisplayed()); categoryPen.click(); Thread.sleep(4000);
		CategoryFilter.captureScreenShot(driver); Thread.sleep(5000);	
		
		WebElement cancel = driver.findElement(By.xpath("//*[@id=\"edit_post_category_form\"]/div/div/button[2]"));
		Assert.assertTrue(cancel.isDisplayed());Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", cancel); Thread.sleep(5000); 
		cateGory.moveToElement(cancel).build().perform(); Thread.sleep(4000); cancel.click();Thread.sleep(5000);
		System.out.println("Successfully passed!, categoryFilterSample()");	
		System.out.println("-----------------------------------------------------------------------------------------------------");
	}
	
	@Test(priority=3)
	public void filterPostByCategory() throws Exception {
		Actions categorY = new Actions(driver);
		WebElement cat = driver.findElement(By.xpath("//*[@id=\"tour4\"]/ul/li[3]/a")); Thread.sleep(4000);
		categorY.moveToElement(cat).build().perform(); Thread.sleep(4000); 
		System.out.println("Category selected for searching posts is displayed: " +cat.isDisplayed()); Thread.sleep(4000);
		System.out.println("Category selected for searching posts is: " +cat.getText()); Thread.sleep(4000);
		cat.click(); Thread.sleep(7000); CategoryFilter.captureScreenShot(driver); Thread.sleep(5000);
		
		WebElement close = driver.findElement(By.xpath("//*[@id=\"tour4\"]/ul/li[3]/a/img"));
		categorY.moveToElement(close).build().perform(); Thread.sleep(5000);
		Assert.assertTrue(close.isDisplayed()); close.click(); Thread.sleep(5000);
		System.out.println("Successfully passed!, filterPostByCategory()");	
		System.out.println("-----------------------------------------------------------------------------------------------------");
		
	}
	
	
	@Test(priority=4)
	public void editCategoryFilter() throws Exception {
		
		Actions edTCat = new Actions(driver);
		WebElement caTegoryPen = driver.findElement(By.xpath("//a[contains(@class,'edit-cat')]")); Thread.sleep(4000);
		Assert.assertTrue(caTegoryPen.isDisplayed()); Thread.sleep(4000);
		CategoryFilter.captureScreenShot(driver); Thread.sleep(5000);
		caTegoryPen.click(); Thread.sleep(5000);		
		WebElement editCat = driver.findElement(By.xpath("//*[@id=\"edit_post_category_form\"]/div/ul/li[17]/input")); Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", editCat); Thread.sleep(5000);
		System.out.println("Category selected for edit is displayed: " +editCat.isDisplayed()); Thread.sleep(4000);
		System.out.println("Category selected for edit is: " +editCat.getText()); Thread.sleep(5000);
		editCat.clear();  editCat.sendKeys("categoryEdited"); Thread.sleep(4000);
		WebElement save = driver.findElement(By.xpath("//*[@id=\"edit_post_category_form\"]/div/div/button[1]")); Thread.sleep(4000);
		Assert.assertTrue(save.isDisplayed()); Thread.sleep(5000);
		edTCat.moveToElement(save).build().perform(); Thread.sleep(4000); 
		save.click(); Thread.sleep(8000);
		System.out.println("Successfully passed!, editCategoryFilter()");	
		System.out.println("-----------------------------------------------------------------------------------------------------");
		
	}
	
	@Test(priority=5)
	public void addCategoryNew() throws Exception {
		Actions canceL = new Actions(driver);
		WebElement caTegoryPen = driver.findElement(By.xpath("//a[contains(@class,'edit-cat')]")); Thread.sleep(4000);
		Assert.assertTrue(caTegoryPen.isDisplayed()); Thread.sleep(4000); 
		caTegoryPen.click(); Thread.sleep(4000);
		CategoryFilter.captureScreenShot(driver); Thread.sleep(5000);
		
		WebElement addCategory = driver.findElement(By.xpath("//a[contains(@class,'add-category-link')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", addCategory); Thread.sleep(5000); 
		System.out.println("Category filter the 'Add category link' is displayed: "+addCategory.isDisplayed()); Thread.sleep(5000); 
		System.out.println("Category filter the 'Add category link' is text is:" +addCategory.getText()); Thread.sleep(4000);
		addCategory.click(); Thread.sleep(4000);
		
		WebElement text = driver.findElement(By.xpath("//*[@id=\"edit_post_category_form\"]/div/ul/li[18]/input")); 
		Assert.assertTrue(text.isDisplayed()); Thread.sleep(5000);
		text.click(); Thread.sleep(5000); 
		
		WebElement caNcel = driver.findElement(By.xpath("//*[@id= \"edit_post_category_form\"]/div/div/button[2]"));
		System.out.println("CANCEL button on filter category is displayed: " +caNcel.isDisplayed()); Thread.sleep(4000);
		System.out.println("CANCEL button on filter category text is:" +caNcel.getText()); Thread.sleep(4000);
		canceL.moveToElement(caNcel).build().perform(); caNcel.click(); Thread.sleep(5000);
		System.out.println("Successfully passed!, HomepageCS()");	
		System.out.println("-----------------------------------------------------------------------------------------------------");
	
	}
	
	@AfterTest
	public void close_browser() throws Exception {	
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