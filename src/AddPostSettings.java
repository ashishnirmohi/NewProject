
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
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	public class AddPostSettings {
	public WebDriver driver;

	@BeforeTest
	public void launchbrowser() throws Exception {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		driver = new ChromeDriver(options);Thread.sleep(5000);
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
	
	@Test (priority=2)
	public void newPost_Minimize() throws IOException, InterruptedException {
		Actions mIni = new Actions(driver); Thread.sleep(5000); 
		WebElement cogSettinG = driver.findElement(By.xpath("//*[@id=\"post_4ef89120-1199-4d0b-87a3-743f008ca7a4\"]/div/div[1]/div[1]/div[2]/div[1]/a/img")); Thread.sleep(4000);
		
		System.out.println("Settings post link is displayed: " +cogSettinG.isDisplayed()); Thread.sleep(4000);
		mIni.moveToElement(cogSettinG).build().perform(); Thread.sleep(4000);
		cogSettinG.click(); Thread.sleep(4000);
		
		WebElement mini = driver.findElement(By.xpath("//*[@id=\"post_4ef89120-1199-4d0b-87a3-743f008ca7a4\"]/div/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")); Thread.sleep(4000);
		System.out.println("Minimize post link is displayed: " +mini.isDisplayed()); Thread.sleep(4000);
		mIni.moveToElement(mini).build().perform(); Thread.sleep(4000);
		System.out.println("MiniMise post link text is: " +mini.getText()); Thread.sleep(4000);
		mini.click(); Thread.sleep(5000);	
		
		System.out.println("Successfully passed: newPost_Minimize");
		System.out.println("---------------------------------------------------------------------------------");				
	}	
	
	@Test (priority=3)
	public void newPost_Expand() throws IOException, InterruptedException {
		
		Actions expanD = new Actions(driver);
		WebElement cogSetting = driver.findElement(By.xpath("//*[@id=\"post_4ef89120-1199-4d0b-87a3-743f008ca7a4\"]/div/div[1]/div[1]/div[2]/div[1]/a/img")); Thread.sleep(4000);
		System.out.println("Setting post link is displayed: " +cogSetting.isDisplayed()); Thread.sleep(4000);
		expanD.moveToElement(cogSetting).build().perform(); Thread.sleep(4000);
		cogSetting.click(); Thread.sleep(4000);
		
		WebElement expand = driver.findElement(By.xpath("//*[@id=\"post_4ef89120-1199-4d0b-87a3-743f008ca7a4\"]/div/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")); Thread.sleep(4000);		
		System.out.println("Expand post link is displayed: " +expand.isDisplayed()); Thread.sleep(4000);		
		expanD.moveToElement(expand).build().perform(); Thread.sleep(4000);
		System.out.println("Expand post link text is: " +expand.getText()); Thread.sleep(4000);		
		expand.click(); Thread.sleep(5000);		
		
		System.out.println("Successfully passed: newPost_Expand()");
		System.out.println("---------------------------------------------------------------------------------");
				
	}
	
	@Test (priority=4)
	public void pin_NewPost() throws Exception {	
		Actions piN = new Actions(driver);	
		WebElement cogSEtting = driver.findElement(By.xpath("//*[@id=\"post_4ef89120-1199-4d0b-87a3-743f008ca7a4\"]/div/div[1]/div[1]/div[2]/div[1]/a/img")); Thread.sleep(4000);
		System.out.println("Settings post link is displayed: " +cogSEtting.isDisplayed()); Thread.sleep(4000);
		piN.moveToElement(cogSEtting).build().perform(); Thread.sleep(4000);
		cogSEtting.click(); Thread.sleep(4000);
		
		WebElement pin = driver.findElement(By.xpath("//*[@id=\"post_4ef89120-1199-4d0b-87a3-743f008ca7a4\"]/div/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));Thread.sleep(4000);
		System.out.println("Pins post link is displayed: " +pin.isDisplayed()); Thread.sleep(4000);
		piN.moveToElement(pin).build().perform(); Thread.sleep(4000); 
		System.out.println("Pin post link text is: " +pin.getText());Thread.sleep(4000);
		pin.click(); Thread.sleep(7000);
		
		System.out.println("Successfully passed: pin_NewPost()");
		System.out.println("---------------------------------------------------------------------------------");
	}
	
	@Test (priority=5)
	public void unpin_NewPost() throws Exception {	
		Actions unpiN = new Actions(driver);	
		WebElement cOgStting = driver.findElement(By.xpath("//*[@id=\"post_4ef89120-1199-4d0b-87a3-743f008ca7a4\"]/div/div[1]/div[1]/div[2]/div[1]/a/img")); Thread.sleep(4000);
		System.out.println("Settings post link is displayed: " +cOgStting.isDisplayed()); Thread.sleep(4000);
		unpiN.moveToElement(cOgStting).build().perform(); Thread.sleep(4000);
		cOgStting.click(); Thread.sleep(4000);
		
		WebElement unpin = driver.findElement(By.xpath("//*[@id=\"post_4ef89120-1199-4d0b-87a3-743f008ca7a4\"]/div/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));  Thread.sleep(4000);
		System.out.println("Unpin post link is displayed: " +unpin.isDisplayed()); Thread.sleep(4000);
		unpiN.moveToElement(unpin).build().perform(); Thread.sleep(4000); 
		System.out.println("Pin post link text is: " +unpin.getText());  Thread.sleep(4000); 
		unpin.click(); Thread.sleep(7000);
		
		System.out.println("Successfully passed: unpin_NewPost()");
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