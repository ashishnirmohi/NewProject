
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
		import org.openqa.selenium.interactions.Actions;
		import org.testng.Assert;
		import org.testng.annotations.AfterTest;
		import org.testng.annotations.BeforeTest;
		import org.testng.annotations.Test;
	
		public class DomainManagement {
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

		@Test(priority=2)
		public void validation_mandatoryDomaintext() throws Exception {
			Actions Dmain = new Actions(driver);
			WebElement accountpic = driver.findElement(By.xpath("//span[@class='account-nav']"));
			Thread.sleep(5000); accountpic.click();
			
			WebElement settings = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[6]/ul/li[2]/a"));
			settings.click(); Thread.sleep(5000);
			System.out.println("The Setting cog link is displayed: " +settings.isDisplayed()); Thread.sleep(4000);	
			Assert.assertTrue(settings.isDisplayed());  Thread.sleep(4000);
			Dmain.moveToElement(settings).build().perform(); Thread.sleep(4000);
				
			WebElement addDomainLink = driver.findElement(By.xpath("//a[text()='Add email domain']"));  Thread.sleep(4000);
			Assert.assertTrue(addDomainLink.isDisplayed()); Thread.sleep(4000);
			System.out.println("The add domain link is displayed: " +addDomainLink.isDisplayed()); Thread.sleep(4000);
			addDomainLink.click(); Thread.sleep(4000);
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
	
			WebElement saveB = driver.findElement(By.xpath("//button[contains(@class,'save-last')]")); Thread.sleep(4000);
			Assert.assertTrue(saveB.isDisplayed()); Thread.sleep(4000);
			System.out.println("The SAVE link is displayed: " +saveB.isDisplayed()); Thread.sleep(4000);
			Dmain.moveToElement(saveB).build().perform(); Thread.sleep(5000);
			saveB.click(); Thread.sleep(4000); //WORKING
			driver.navigate().refresh();
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			
			System.out.println("Successfully passed: validation_mandatoryDomaintext()");
			System.out.println("---------------------------------------------------------------------------------");
			
		}
		
		@Test(priority=3)
		public void domainManagement_addDomain() throws Exception {
			driver.navigate().refresh();
			Actions Domain = new Actions(driver);
			WebElement ADDDomainLnk = driver.findElement(By.xpath("//a[contains(@class,'add_domain_row')]"));  Thread.sleep(4000);
			Assert.assertTrue(ADDDomainLnk.isDisplayed()); Thread.sleep(4000);
			System.out.println("The add domain link is displayed: " +ADDDomainLnk.isDisplayed());	Thread.sleep(4000);
			Domain.moveToElement(ADDDomainLnk).build().perform(); Thread.sleep(4000);
			ADDDomainLnk.click(); Thread.sleep(4000);
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			
			WebElement ADDDomainField = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[4]/input")); Thread.sleep(4000);
			Assert.assertTrue(ADDDomainField.isDisplayed()); Thread.sleep(4000);
			System.out.println("The add domain text field is displayed: " +ADDDomainField.isDisplayed());	Thread.sleep(4000);
			Domain.moveToElement(ADDDomainField).build().perform();Thread.sleep(4000); 
			ADDDomainField.click(); Thread.sleep(2000);
			ADDDomainField.sendKeys("QA.com"); Thread.sleep(4000); 
			
			WebElement saveButon = driver.findElement(By.xpath("//button[contains(@class,'save-last')]")); Thread.sleep(4000);
			Assert.assertTrue(saveButon.isDisplayed()); Thread.sleep(4000);
			System.out.println("The SAVE domain LINK is displayed: " +saveButon.isDisplayed());	Thread.sleep(4000);
			Domain.moveToElement(saveButon).build().perform(); Thread.sleep(5000);
			saveButon.click(); Thread.sleep(4000); //WORKING		
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			
			WebElement blueThankDman = driver.findElement(By.xpath("//span[contains(@class,'success-msg')]")); Thread.sleep(4000);
			System.out.println("Success message text is : " +blueThankDman.getText()); Thread.sleep(4000);
			blueThankDman.click(); Thread.sleep(4000);  //WORKING
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
					
			System.out.println("Successfully passed: domainManagement_addDomain()");
			System.out.println("---------------------------------------------------------------------------------");
			
		}
		
		@Test(priority=4)
		public void domainManagement_editDomain() throws Exception {
			Actions dOMomaiN = new Actions(driver);
			
			WebElement threeDotMenu = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[4]/div/a")); Thread.sleep(4000); 
			Assert.assertTrue(threeDotMenu.isDisplayed()); Thread.sleep(4000);
			System.out.println("Three DOT link displayed: " +threeDotMenu.isDisplayed()); Thread.sleep(4000);
			dOMomaiN.moveToElement(threeDotMenu).build().perform(); Thread.sleep(5000);
			threeDotMenu.click(); Thread.sleep(4000);  //WORKING
			DomainManagement.captureScreenShot(driver);  Thread.sleep(4000);
			
			WebElement eddomain = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[4]/div/ul/li[1]/a")); Thread.sleep(4000);
			System.out.println("Edit domain link is displayed: " +eddomain.isDisplayed()); Thread.sleep(4000);
			System.out.println("Edit domain link text is: " +eddomain.getText()); Thread.sleep(4000);
			dOMomaiN.moveToElement(eddomain).build().perform(); Thread.sleep(4000);
			eddomain.click(); Thread.sleep(4000);
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);	
		
			WebElement AddDnField = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[4]/input")); Thread.sleep(4000);
			Assert.assertTrue(AddDnField.isDisplayed()); Thread.sleep(4000);
			System.out.println("ADD DOMAIN text FIELD link displayed: " +AddDnField.isDisplayed()); Thread.sleep(4000);
			dOMomaiN.moveToElement(AddDnField).build().perform();Thread.sleep(4000); 
			AddDnField.click(); Thread.sleep(4000); AddDnField.clear();
			AddDnField.sendKeys("QAEdited.co.in"); Thread.sleep(4000); 
			
			WebElement SaveBton = driver.findElement(By.xpath("//button[contains(@class,'save-last')]")); Thread.sleep(4000);
			Assert.assertTrue(SaveBton.isDisplayed()); Thread.sleep(4000);
			System.out.println("SAVE link displayed: " +SaveBton.isDisplayed()); Thread.sleep(4000);
			dOMomaiN.moveToElement(SaveBton).build().perform(); Thread.sleep(5000);
			SaveBton.click(); Thread.sleep(4000); //WORKING		
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			
			WebElement blueThankDomain = driver.findElement(By.xpath("//span[contains(@class,'success-msg')]")); Thread.sleep(4000);
			System.out.println("Success message text is : " +blueThankDomain.getText()); Thread.sleep(4000);
			blueThankDomain.click(); Thread.sleep(4000);  //WORKING
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			
			System.out.println("Successfully passed: domainManagement_editDomain()");
			System.out.println("---------------------------------------------------------------------------------");
			
		}
		
		@Test(priority=5)
		public void domainManagement_deleteDomain() throws Exception {
			Actions DomAIn = new Actions(driver);		
			WebElement domainmgmtL = driver.findElement(By.xpath("//a[contains(@href,'#domain-management-tab')]"));  Thread.sleep(4000);
			Assert.assertTrue(domainmgmtL.isDisplayed()); Thread.sleep(4000);
			System.out.println("Domain management link is displayed: " +domainmgmtL.isDisplayed()); Thread.sleep(4000);
			DomAIn.moveToElement(domainmgmtL).build().perform(); Thread.sleep(4000);
			domainmgmtL.click(); Thread.sleep(4000);
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			
			WebElement threeDoT = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[4]/div/a")); Thread.sleep(4000); 
			Assert.assertTrue(threeDoT.isDisplayed()); Thread.sleep(4000);
			System.out.println("Three DOT MENU link is displayed: " +threeDoT.isDisplayed()); Thread.sleep(4000);
			DomAIn.moveToElement(threeDoT).build().perform(); Thread.sleep(5000);
			threeDoT.click(); Thread.sleep(4000);  //WORKING
			DomainManagement.captureScreenShot(driver);
			
			WebElement Deletedain = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[4]/div/ul/li[2]/a")); Thread.sleep(4000);
			System.out.println("Delete domain link is displayed: " +Deletedain.isDisplayed()); Thread.sleep(4000);
			DomAIn.moveToElement(Deletedain).build().perform(); Thread.sleep(4000);
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			System.out.println("Delete domain link text is: " +Deletedain.getText()); Thread.sleep(4000);
			Deletedain.click(); Thread.sleep(4000);
			
			WebElement saveButn = driver.findElement(By.xpath("//button[contains(@class,'save-last')]")); Thread.sleep(4000);
			Assert.assertTrue(saveButn.isDisplayed()); Thread.sleep(4000);
			System.out.println("The SAVE domain LINK is displayed: " +saveButn.isDisplayed());	Thread.sleep(4000);
			DomAIn.moveToElement(saveButn).build().perform(); Thread.sleep(5000);
			saveButn.click(); Thread.sleep(4000); //WORKING		
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			
			WebElement blueThaDman = driver.findElement(By.xpath("//span[contains(@class,'success-msg')]")); Thread.sleep(4000);
			System.out.println("Success message text is : " +blueThaDman.getText()); Thread.sleep(4000);
			blueThaDman.click(); Thread.sleep(4000);  //WORKING
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			
			System.out.println("Successfully passed: domainManagement_deleteDomain()");
			System.out.println("---------------------------------------------------------------------------------");
		
		}
		
		@Test(priority=6)
		public void validation_mandatoryDomainMinimumText() throws Exception {
			Actions DDomain = new Actions(driver);
				
			WebElement DomainmgmtLk = driver.findElement(By.xpath("//a[contains(@href,'#domain-management-tab')]"));  Thread.sleep(4000);
			Assert.assertTrue(DomainmgmtLk.isDisplayed()); Thread.sleep(4000);
			System.out.println("Domain management link is displayed: " +DomainmgmtLk.isDisplayed()); Thread.sleep(4000);
			DDomain.moveToElement(DomainmgmtLk).build().perform(); Thread.sleep(4000);
			DomainmgmtLk.click(); Thread.sleep(4000);
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			
			WebElement addDomainLink = driver.findElement(By.xpath("//a[contains(@class,'add_domain_row')]"));  Thread.sleep(4000);
			Assert.assertTrue(addDomainLink.isDisplayed()); Thread.sleep(4000);
			System.out.println("Add Domain link is displayed: " +addDomainLink.isDisplayed()); Thread.sleep(4000);
			DDomain.moveToElement(addDomainLink).build().perform(); Thread.sleep(4000);
			addDomainLink.click(); Thread.sleep(4000);
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			
			WebElement addDomnFld = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[8]/input")); Thread.sleep(4000);
			Assert.assertTrue(addDomnFld.isDisplayed()); Thread.sleep(4000);
			System.out.println("Add Domain text field is displayed: " +addDomnFld.isDisplayed()); Thread.sleep(4000);
			DDomain.moveToElement(addDomnFld).build().perform();Thread.sleep(4000); 
			addDomnFld.click(); Thread.sleep(4000);
			addDomnFld.sendKeys("QA"); Thread.sleep(4000); 
			
			WebElement svButton = driver.findElement(By.xpath("//button[contains(@class,'save-last')]")); Thread.sleep(4000);
			Assert.assertTrue(svButton.isDisplayed()); Thread.sleep(4000);
			System.out.println("SAVE Add Domain text Limk is displayed: " +svButton.isDisplayed()); Thread.sleep(4000);
			DDomain.moveToElement(svButton).build().perform(); Thread.sleep(5000);
			svButton.click(); Thread.sleep(4000); //WORKING		
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			
			WebElement validaMsg = driver.findElement(By.xpath("//span[contains(@class,'error-msg')]")); Thread.sleep(4000);
			System.out.println("Validation message is displayed: " +validaMsg.isDisplayed()); Thread.sleep(4000);
			System.out.println("Validation message text is: " +validaMsg.getText()); Thread.sleep(4000);
			
			System.out.println("Successfully passed: validation_mandatoryDomainMinimumText()");
			System.out.println("---------------------------------------------------------------------------------");
			
		}
		
		@Test(priority=7)
		public void validation_atleastOneDomainField() throws Exception {
			Actions DoMaIn = new Actions(driver);
					
			WebElement domAinmgmtLink = driver.findElement(By.xpath("//a[contains(@href,'#domain-management-tab')]"));  Thread.sleep(4000);
			Assert.assertTrue(domAinmgmtLink.isDisplayed()); Thread.sleep(4000);
			System.out.println("Domain management link is displayed: " +domAinmgmtLink.isDisplayed()); Thread.sleep(4000);
			DoMaIn.moveToElement(domAinmgmtLink).build().perform(); Thread.sleep(4000);
			domAinmgmtLink.click(); Thread.sleep(4000);
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			
			WebElement threedotMenu = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[5]/div/a")); Thread.sleep(4000); 
			Assert.assertTrue(threedotMenu.isDisplayed()); Thread.sleep(4000);
			System.out.println("Three dot link is displayed: " +threedotMenu.isDisplayed()); Thread.sleep(4000);
			DoMaIn.moveToElement(threedotMenu).build().perform(); Thread.sleep(5000);
			threedotMenu.click(); Thread.sleep(4000);  //WORKING
			DomainManagement.captureScreenShot(driver);
			
			WebElement DltDomain = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[5]/div/ul/li[2]/a")); Thread.sleep(4000);
			System.out.println("Delete domain link is displayed: " +DltDomain.isDisplayed()); Thread.sleep(4000);
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			System.out.println("Delete domain link text is: " +DltDomain.getText()); Thread.sleep(4000);
			DoMaIn.moveToElement(DltDomain).build().perform(); Thread.sleep(4000);
			DltDomain.click(); Thread.sleep(4000);	
			
			WebElement ThreedotMenu = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[4]/div/a")); Thread.sleep(4000); 
			Assert.assertTrue(threedotMenu.isDisplayed()); Thread.sleep(4000);
			System.out.println("Three dot menu link is displayed: " +ThreedotMenu.isDisplayed()); Thread.sleep(4000);
			DoMaIn.moveToElement(ThreedotMenu).build().perform(); Thread.sleep(5000);
			ThreedotMenu.click(); Thread.sleep(4000);  //WORKING
			
			WebElement DeleteDOmain = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[4]/div/ul/li[2]/a")); Thread.sleep(4000);
			System.out.println("Delete domain link is displayed: " +DeleteDOmain.isDisplayed()); Thread.sleep(4000);
			DoMaIn.moveToElement(DeleteDOmain).build().perform(); Thread.sleep(4000);
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			DeleteDOmain.click(); Thread.sleep(4000);	
			
			WebElement ThreedoTMenu = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[3]/div/a")); Thread.sleep(4000); 
			Assert.assertTrue(ThreedoTMenu.isDisplayed()); Thread.sleep(4000);
			DoMaIn.moveToElement(ThreedoTMenu).build().perform(); Thread.sleep(5000);
			ThreedoTMenu.click(); Thread.sleep(4000);  //WORKING
			
			WebElement DeleteDMain = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[3]/div/ul/li[2]/a")); Thread.sleep(4000);
			System.out.println("Edit domain link is displayed: " +DeleteDMain.isDisplayed()); Thread.sleep(4000);
			DoMaIn.moveToElement(DeleteDMain).build().perform(); Thread.sleep(4000);
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			DeleteDMain.click(); Thread.sleep(4000);	
			
			WebElement ThreedoTMeu = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[2]/div/a")); Thread.sleep(4000); 
			Assert.assertTrue(ThreedoTMeu.isDisplayed()); Thread.sleep(4000);
			DoMaIn.moveToElement(ThreedoTMeu).build().perform(); Thread.sleep(5000);
			ThreedoTMeu.click(); Thread.sleep(4000);  //WORKING
			
			WebElement DeleteDeMain = driver.findElement(By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/div/div[2]/div/ul/li[2]/a")); Thread.sleep(4000);
			System.out.println("Delete domain link is displayed: " +DeleteDeMain.isDisplayed()); Thread.sleep(4000);
			DoMaIn.moveToElement(DeleteDeMain).build().perform(); Thread.sleep(4000);
			DomainManagement.captureScreenShot(driver); Thread.sleep(4000);
			DeleteDeMain.click(); Thread.sleep(4000);	
						
			WebElement valError = driver.findElement(By.xpath("//span[contains(@class,'error-msg')]")); Thread.sleep(4000);
			System.out.println("Error message 'Atleast one domain' is displayed: " +valError.isDisplayed()); Thread.sleep(4000);
			System.out.println("Error message is: " +valError.getText()); Thread.sleep(4000);
			
			System.out.println("Successfully passed: validation_atleastOneDomainField()");
			System.out.println("---------------------------------------------------------------------------------");
			
		}
		
		public static void captureScreenShot(WebDriver driver) throws IOException{
			java.io.File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(screenshot, new File("C:\\Users\\HP\\eclipse-workspace\\CS\\capturescreen\\community\\Screenshot.jpg"));	
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