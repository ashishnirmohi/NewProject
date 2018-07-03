import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExecutiveSummary {
WebDriver driver;

@BeforeTest	
public void Lauchbrowser() throws Exception{

	System.out.println("---------------------------------------------------------------------------------");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
	driver = new ChromeDriver(); Thread.sleep(5000); 
	driver.manage().window().maximize(); Thread.sleep(5000);
	System.out.println("Successfully passed: launchbrowser()");
	System.out.println("---------------------------------------------------------------------------------");
}
	
@Test (priority=1)
public void loginAdmin() throws Exception {
	driver.navigate().to("https://uat-clientspace.herokuapp.com");
	driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com"); Thread.sleep(3000);
	driver.findElement(By.id("password")).sendKeys("Test1234"); Thread.sleep(3000);
	driver.findElement(By.id("show-sent")).click();	Thread.sleep(6000);
	Assert.assertEquals("Client Share", driver.getTitle(), "Title is matching");
	
}	
 @Test (priority=2)
 
 public void executiveSummary_add() throws IOException, InterruptedException {
	 WebElement exepen = driver.findElement(By.xpath("//*[@id=\"left-content\"]/div/div[4]/div[3]/span[2]/a/img"));
	 Actions expen = new Actions(driver);
	 expen.moveToElement(exepen).build().perform();
	 Assert.assertTrue(exepen.isDisplayed());
	 exepen.click();
	
	 WebElement summbox = driver.findElement(By.xpath("//*[@id=\"executive_summary_save\"]/div[1]/div[1]/textarea"));
	 expen.moveToElement(summbox).build().perform();
	//Assert.assertTrue(summbox.isDisplayed());
	summbox.click(); Thread.sleep(4000);
	summbox.clear(); Thread.sleep(4000);
	summbox.sendKeys("Lorem ipsum dummy test executive summary airtel vodafone clientshare.");
	
	WebElement cross = driver.findElement(By.xpath("//img[@class='delete_summary_files']"));
	expen.moveToElement(cross).build().perform(); Thread.sleep(4000);
	Assert.assertTrue(cross.isDisplayed()); Thread.sleep(4000);
	cross.click(); Thread.sleep(4000);
	
	WebElement uploadlink = driver.findElement(By.xpath("//*[@id=\"executive_summary_save\"]/div[1]/div[4]/span/div/span[2]"));
	uploadlink.click(); Thread.sleep(4000);
	Runtime.getRuntime().exec("C:\\Autoit\\bulkupload2006.exe");
	
	driver.findElement(By.xpath("//*[@id=\"executive_summary_save\"]/div[1]/div[5]/button[1]")).click();
	
 	}
		
}
