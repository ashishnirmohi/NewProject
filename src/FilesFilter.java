import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FilesFilter {
	WebDriver driver;
	
	@BeforeTest	
	public void Lauchbrowser() throws Exception{

		System.out.println("---------------------------------------------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
		
		driver = new ChromeDriver();Thread.sleep(5000);
		driver.manage().window().maximize(); Thread.sleep(5000);
		System.out.println("Successfully passed: launchbrowser()");
		System.out.println("---------------------------------------------------------------------------------");
	}

	@Test (priority=0)
	public void login() throws Exception {
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com"); Thread.sleep(5000);
		driver.findElement(By.id("password")).sendKeys("Test1234"); Thread.sleep(3000);
		Account.captureScreenShot(driver); Thread.sleep(5000);
		driver.findElement(By.id("show-sent")).click();	Thread.sleep(5000);
		
	}	
	
	@Test (priority=1)
	public void files() throws Exception {
		WebElement file = driver.findElement(By.xpath("//*[@id=\"left-content\"]/div[1]/div[4]/a"));
		Assert.assertTrue(file.isDisplayed());
		file.click(); Thread.sleep(4000);
		WebElement textField = driver.findElement(By.name("file_name"));
		Assert.assertTrue(textField.isDisplayed());
		textField.sendKeys("v1"); Thread.sleep(4000);
		textField.clear(); Thread.sleep(4000);
		
	}
	
	
	@Test (priority=2)
	public void file_type() throws Exception {
		Actions pdf = new Actions(driver);
		WebElement PDF = driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div[2]/form/div[2]/div/a[1]"));
		Assert.assertTrue(PDF.isDisplayed());
		pdf.moveToElement(PDF).build().perform(); Thread.sleep(4000);
		PDF.click(); Thread.sleep(5000); //select
		PDF.click(); Thread.sleep(4000); //deselect
		
		Actions doc = new Actions(driver);
		WebElement DOC = driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div[2]/form/div[2]/div/a[2]"));
		Assert.assertTrue(DOC.isDisplayed());
		doc.moveToElement(DOC).build().perform(); Thread.sleep(4000);
		DOC.click(); Thread.sleep(4000); //select
		DOC.click(); Thread.sleep(4000); //deselect
	}
	
	
	@Test (priority=3)
	public void file_date() throws Exception {
		Actions arrow = new Actions(driver);
		WebElement dateText = driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div[2]/form/div[3]/input"));
		dateText.click(); Thread.sleep(2000);
		
		WebElement leftarrow = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/table/thead/tr[1]/th[1]/i"));	
		arrow.moveToElement(leftarrow).build().perform();
		Assert.assertTrue(leftarrow.isDisplayed());
		leftarrow.click();	
		
		WebElement date1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/table/tbody/tr[2]/td[1]"));
		date1.click(); Thread.sleep(2000);
		WebElement date2 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/table/tbody/tr[5]/td[5]"));
		date2.click(); Thread.sleep(2000);
		
		WebElement apply = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button[1]"));
		apply.click(); Thread.sleep(6000);
		
		dateText.clear(); Thread.sleep(6000); 		
		WebElement cancel = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", cancel);
		cancel.click(); Thread.sleep(4000);
	}
	
	
	@Test (priority=5)
	public void addedBy() throws Exception {
		WebElement addBytext = driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div[2]/form/div[5]/span/div/button"));
		Assert.assertTrue(addBytext.isDisplayed()); Thread.sleep(3000);
		WebElement dateText = driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div[2]/form/div[3]/input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", dateText);
		addBytext.click(); Thread.sleep(3000);
		
		WebElement search = driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div[2]/form/div[5]/span/div/ul/li[1]/div/input"));
		Assert.assertTrue(search.isDisplayed()); Thread.sleep(3000);
		search.click(); Thread.sleep(3000);
		search.sendKeys("Jonathan Davis"); Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div[2]/form/div[5]/span/div/ul/li[88]/a")).click();
		addBytext.click(); Thread.sleep(3000);
	}
	
	@Test (priority=6)
	public void category() throws Exception {
		WebElement categorytext = driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div[2]/form/div[6]/span/div/button"));
		Assert.assertTrue(categorytext.isDisplayed());
		categorytext.click();	Thread.sleep(3000);
		
		WebElement search = driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div[2]/form/div[6]/span/div/ul/li[1]/div/input"));
		Assert.assertTrue(search.isDisplayed());
		search.click();	Thread.sleep(3000); search.sendKeys("general"); Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div[2]/form/div[6]/span/div/ul/li[3]/a")).click();
		Thread.sleep(3000);
		categorytext.click(); Thread.sleep(3000);
	}
	
	@Test (priority=7)
	public void postSubject() throws Exception {	
		WebElement postsubtext = driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div[2]/form/div[4]/input"));
		Assert.assertTrue(postsubtext.isDisplayed()); Thread.sleep(4000);
		postsubtext.click(); Thread.sleep(4000);
		postsubtext.sendKeys("qwerty"); Thread.sleep(4000);
		postsubtext.clear();  Thread.sleep(4000);	
	}
	

@AfterTest
public void closeBrowser() {
	
	driver.close();
}

}
