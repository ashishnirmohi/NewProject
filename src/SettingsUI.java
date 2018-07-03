	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import org.openqa.selenium.interactions.Actions;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	
	public class SettingsUI {
	public WebDriver driver;
	private By domainmgmt = By.xpath("/html/body/section/div[3]/div[1]/div[1]/div/ul/li[1]/a"); 
	private By save = By.xpath("//*[@id=\"domain-management-tab\"]/div[2]/form/button");
	private By feedbackparatext = By.xpath("//*[@id=\"feedback-tab\"]/div[2]/p");
	private By reminderbeedbacktext = By.xpath("//*[@id=\"feedback-tab\"]/div[2]/div[2]/p[2]");
	private By accountheading = By.xpath("//*[@id=\"password-tab\"]/div[2]/p");	
	private By accounttextfieldlabel = By.xpath("//*[@id=\"password-tab\"]/div[2]/form/div/div[1]/label");		
	private By accounttext = By.xpath("//*[@id=\"password-tab\"]/div[2]/form/div/div[2]/input");
	private By disablemyaccount = By.xpath("//*[@id=\"password-tab\"]/div[2]/span/a"); 
	private By uploadbulk = By.xpath("//*[@id=\"bulk-invitation-tab\"]/div[2]/form/div[1]/button");
	private By permissionchecklabel = By.xpath("//*[@id=\"permissions-tab\"]/div[2]/form/div[1]/label");	
	private By emailnotificationheading = By.xpath("//*[@id=\"notifications-tab\"]/div[2]/p");
	
	@BeforeClass
	public void loginCS() throws InterruptedException {
		System.out.println("------------------------------------------------------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
		driver = new ChromeDriver();Thread.sleep(5000);
		driver.manage().window().maximize();Thread.sleep(5000);
		System.out.println("Successfully passed!, launchbrowser()");
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com"); Thread.sleep(5000);
		driver.findElement(By.id("password")).sendKeys("Test1234");
		driver.findElement(By.id("show-sent")).click(); Thread.sleep(5000);	
	}
	
	@Test (priority=1)
	public void openSettings() throws InterruptedException { 
		
		Actions share = new Actions(driver);
	    
		WebElement sh1 = driver.findElement(By.xpath("//img[contains(@alt,'MyVitae')]"));  Thread.sleep(5000);
		share.moveToElement(sh1).build().perform(); Thread.sleep(5000); sh1.click(); Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/nav/div/div[1]/ul[1]/li/ul/li[3]/a")).click(); Thread.sleep(5000);	
		
		System.out.println("Moved to desired share for testing successfully passed!, SwitchShare()");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		
		Thread.sleep(5000);	
		WebElement accountpic = driver.findElement(By.xpath("//span[@class='account-nav']"));
		Thread.sleep(5000); accountpic.click();
		
		WebElement settings = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[6]/ul/li[2]/a"));
		settings.click(); Thread.sleep(5000);
	}
	
	
	@Test(priority=2)
	public void getCssValue_SetttingDomainLink_TextFontSize(){
		WebElement setdmnfntwt = driver.findElement(domainmgmt);
		Assert.assertTrue(setdmnfntwt.isDisplayed());
		System.out.println("Font Size, domain managemnet tab link field is : "	+ setdmnfntwt.getCssValue("font-size"));
	}
	
	@Test(priority=3)
	public void getCssValue_AnalyticLink_TextFontFamily(){
		WebElement setdmnyfntfm = driver.findElement(domainmgmt);
		Assert.assertTrue(setdmnyfntfm.isDisplayed());
		System.out.println("Font family, domain managemnet tab link field is : " + setdmnyfntfm.getCssValue("font-family"));
			
	}
	
	@Test(priority=4)
	public void getCssValue_AnalyticLink_TextColor() {
		WebElement setdmncol = driver.findElement(domainmgmt);
		Assert.assertTrue(setdmncol.isDisplayed());
		System.out.println("Font color, domain managemnet tab link field is : "	+ setdmncol.getCssValue("color"));
	}
	
	@Test(priority=5)
	public void getCssValue_settingsLink_BackgroundColor() {
		WebElement setdmnbckcol = driver.findElement(domainmgmt); 
		Assert.assertTrue(setdmnbckcol.isDisplayed());
		System.out.println("Background color, domain managemnet tab link before mouse hover is : "	+ setdmnbckcol.getCssValue("background-color"));
		Actions action = new Actions(driver);
		action.moveToElement(setdmnbckcol).perform();
		System.out.println("Background color, domain managemnet tab link after mouse hover is : "	+ setdmnbckcol.getCssValue("background-color"));
		System.out.println("------------------------------------------------------------------------------------------");	
		
	}
	
	@Test(priority=6)
	public void getCssValue_SettingDomainMgmtSaveButton_TextFontSize(){
		WebElement savedmnfntsz = driver.findElement(save);
		Assert.assertTrue(savedmnfntsz.isDisplayed());
		System.out.println("Font Size, domain managemnet tab save setting button is : "	+ savedmnfntsz.getCssValue("font-size"));
		
	}
	
	@Test(priority=7)
	public void getCssValue_SettingDomainMgmtSaveButton_TextFontFamily(){
		WebElement savedmnfntfm = driver.findElement(save);
		Assert.assertTrue(savedmnfntfm.isDisplayed());
		System.out.println("Font family, domain managemnet tab save setting button is : "	+ savedmnfntfm.getCssValue("font-family"));
	}
	
	@Test(priority=8)
	public void getCssValue_SettingDomainMgmtSaveButton_TextFontWeight(){
		WebElement savedmnfntwt = driver.findElement(save);
		Assert.assertTrue(savedmnfntwt.isDisplayed());
		System.out.println("Font Weight, domain managemnet tab save setting button is : "	+getFontWeight(savedmnfntwt) );
		
	}
	
	@Test(priority=9)
	public void getCssValue_SettingDomainMgmtSaveButton_TextColor() {
		WebElement savedmncol = driver.findElement(save); 
		Assert.assertTrue(savedmncol.isDisplayed());
		System.out.println("Font color, domain managemnet tab save setting before mouse hover is : "	+ savedmncol.getCssValue("color"));
			
	}
	
	@Test(priority=10)
	public void getCssValue_SettingFeedbackParagraphText_TextFontSize(){
		WebElement feedback = driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div[1]/div/ul/li[3]/a"));
		Assert.assertTrue(feedback.isDisplayed());
		feedback.click(); //feedback click
		WebElement setfeedhlptxtfntsz = driver.findElement(feedbackparatext);
		Assert.assertTrue(setfeedhlptxtfntsz.isDisplayed());
		System.out.println("Font Size, feedback paragraph help text setting is : "	+ setfeedhlptxtfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=11)
	public void getCssValue_SettingFeedbackParagraphText() {
		WebElement setfeedhlptxtfntfm = driver.findElement(feedbackparatext);		
		Assert.assertTrue(setfeedhlptxtfntfm.isDisplayed()); 
		System.out.println("Font family, feedback paragraph help text setting is : "	+ setfeedhlptxtfntfm.getCssValue("font-family"));
			
	}
	
	@Test(priority=12)
	public void getCssValue_SettingFeedbackParagraphText_TextColor() {
		WebElement setfeedhlptxtcol = driver.findElement(feedbackparatext);
		Assert.assertTrue(setfeedhlptxtcol.isDisplayed()); 
		System.out.println("Font color, feedback paragraph help text setting is : "	+ setfeedhlptxtcol.getCssValue("color"));
	}
	
	@Test(priority=13)
	public void getCssValue_SettingFeedbackparagraphText_TextFontWeight(){
		WebElement setfeedhlptxtfntwt = driver.findElement(feedbackparatext);
		Assert.assertTrue(setfeedhlptxtfntwt.isDisplayed()); 
		System.out.println("Font Weight, feedback paragraph help text setting is : "	+getFontWeight(setfeedhlptxtfntwt) );
		System.out.println("------------------------------------------------------------------------------------------");	
	}
	
	
	@Test(priority=14)
	public void getCssValue_SettingfeedbackReminderlabelText_TextFontSize(){
		WebElement setremtxtfntsz = driver.findElement(reminderbeedbacktext);
		Assert.assertTrue(setremtxtfntsz.isDisplayed()); 
		System.out.println("Font Size, fedback reminder help text settings is : "	+ setremtxtfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=15)
	public void getCssValue_SettingfeedbackReminderlabelText_TextFontFamily(){
		WebElement setremtxtfntfamy = driver.findElement(reminderbeedbacktext);
		Assert.assertTrue(setremtxtfntfamy.isDisplayed()); 
		System.out.println("Font family, fedback reminder help text settings is : "	+ setremtxtfntfamy.getCssValue("font-family"));
			
	}
	
	@Test(priority=16)
	public void getCssValue_SettingfeedbackReminderlabelText_TextColor() {
		WebElement setremtxtcol = driver.findElement(reminderbeedbacktext);
		Assert.assertTrue(setremtxtcol.isDisplayed()); 
		System.out.println("Font color, fedback reminder help text settings is : "	+ setremtxtcol.getCssValue("color"));
	}
	
	@Test(priority=17)
	public void getCssValue_SettingfeedbackReminderlabelText_TextFontWeight(){
		WebElement setremtxtfntwt = driver.findElement(reminderbeedbacktext);
		Assert.assertTrue(setremtxtfntwt.isDisplayed()); 
		System.out.println("Font Weight, fedback reminder help text settings is : "	+getFontWeight(setremtxtfntwt) );
		System.out.println("------------------------------------------------------------------------------------------");	
	}
	
	@Test(priority=18)
	public void getCssValue_SettingAccountformLabelHeading_TextFontSize() throws InterruptedException{
		WebElement account = driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div[1]/div/ul/li[6]/a")); //account
		Assert.assertTrue(account.isDisplayed()); 
		account.click(); Thread.sleep(5000);
		WebElement setacthedfntsz = driver.findElement(accountheading);
		Assert.assertTrue(setacthedfntsz.isDisplayed()); 
		System.out.println("Font Size, account form heading settings is : "	+ setacthedfntsz.getCssValue("font-size"));
		
	}
	
	@Test(priority=19)
	public void getCssValue_SettingAccountformLabelHeading_TextFontFamily(){
		WebElement setacthedfntfamy = driver.findElement(accountheading);
		Assert.assertTrue(setacthedfntfamy.isDisplayed()); 
		System.out.println("Font family, account form heading settings is : "	+ setacthedfntfamy.getCssValue("font-family"));
			
	}
	
	@Test(priority=20)
	public void getCssValue_SettingAccountformLabelHeading_TextColor() {
		WebElement setacthedcol = driver.findElement(accountheading);
		Assert.assertTrue(setacthedcol.isDisplayed()); 
		System.out.println("Font color, account form heading field is : "	+ setacthedcol.getCssValue("color"));
	}
	
	@Test(priority=21)
	public void getCssValue_SettingAccountformLabelHeading_TextFontWeight(){
		WebElement setacthedfntwt = driver.findElement(accountheading);
		Assert.assertTrue(setacthedfntwt.isDisplayed()); 
		System.out.println("Font Weight, account form heading settings is : "	+getFontWeight(setacthedfntwt) );
		System.out.println("------------------------------------------------------------------------------------------");	
	}
	
	@Test(priority=22)
	public void getCssValue_SettingAccountTextfieldLabel_TextFontSize() {
		WebElement setacttxtlbfntsz = driver.findElement(accounttextfieldlabel);
		Assert.assertTrue(setacttxtlbfntsz.isDisplayed()); 
		System.out.println("Font Size, account text field label settings is : "	+ setacttxtlbfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=23)
	public void getCssValue_SettingAccountTextfieldLabel__TextFontFamily(){
		WebElement setacttxtlbfmy = driver.findElement(accounttextfieldlabel);
		Assert.assertTrue(setacttxtlbfmy.isDisplayed()); 
		System.out.println("Font family, account text field label settings is : "	+ setacttxtlbfmy.getCssValue("font-family"));
			
	}
	
	@Test(priority=24)
	public void getCssValue_SettingAccountTextfieldLabel__TextColor() {
		WebElement setacttxtlbcol = driver.findElement(accounttextfieldlabel);
		Assert.assertTrue(setacttxtlbcol.isDisplayed()); 
		System.out.println("Font color, account text field label settings is : "	+ setacttxtlbcol.getCssValue("color"));
	}
	
	
	@Test (priority=25)
	public void getCssvalue_SettingAccountTextfieldLabel__BackgroundColor() {
		WebElement setacttxtlbbckcol = driver.findElement(accounttextfieldlabel);
		Assert.assertTrue(setacttxtlbbckcol.isDisplayed()); 
		System.out.println("Background-color, account text field label settings is : "	+ setacttxtlbbckcol.getCssValue("background-color"));
	}
	
	@Test(priority=26)
	public void getCssValue_SettingAccountTextfieldLabel_FontWeight(){
		WebElement setacttxtlbfntwt = driver.findElement(accounttextfieldlabel);
		Assert.assertTrue(setacttxtlbfntwt.isDisplayed()); 
		System.out.println("Font Weight, account text field label settings is "	+getFontWeight(setacttxtlbfntwt));
		System.out.println("------------------------------------------------------------------------------------------");
	}
	 
	@Test(priority=27)
	public void getCssValue_SettingAccountTextfieldText_TextFontSize() {
		WebElement setacttxtfntsz = driver.findElement(accounttext);
		Assert.assertTrue(setacttxtfntsz.isDisplayed()); 
		System.out.println("Font Size, account text field settings is : "	+ setacttxtfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=28)
	public void getCssValue_SettingAccountTextfieldText_TextFontFamily(){
		WebElement setacttxtfntfmy = driver.findElement(accounttext);
		Assert.assertTrue(setacttxtfntfmy.isDisplayed()); 
		System.out.println("Font family, account text field settings is : "	+ setacttxtfntfmy.getCssValue("font-family"));
			
	}
	
	@Test(priority=29)
	public void getCssValue_SettingAccountTextfieldText_TextColor() {
		WebElement setacttxtlbcol = driver.findElement(accounttext);
		Assert.assertTrue(setacttxtlbcol.isDisplayed()); 
		System.out.println("Font color, account text field settings is : "	+ setacttxtlbcol.getCssValue("color"));
	}
	
	
	@Test (priority=30)
	public void getCssvalue_SettingAccountTextfieldText_BackgroundColor() {
		WebElement setacttxtbckcol = driver.findElement(accounttext);
		Assert.assertTrue(setacttxtbckcol.isDisplayed()); 
		System.out.println("Background-color, account text field settings is : "	+ setacttxtbckcol.getCssValue("background-color"));
	}
	
	@Test(priority=31)
	public void getCssValue_SettingAccountTextfieldText_FontWeight(){
		WebElement setacttxtfntwt = driver.findElement(accounttext);
		Assert.assertTrue(setacttxtfntwt.isDisplayed()); 
		System.out.println("Font Weight, account text field settings is "	+getFontWeight(setacttxtfntwt));
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	@Test(priority=32)
	public void getCssValue_SettingAccountDMAText_TextFontSize() {
		WebElement setactdmafntsz = driver.findElement(disablemyaccount);
		Assert.assertTrue(setactdmafntsz.isDisplayed());
		System.out.println("Font Size, disable my account settings is : "	+ setactdmafntsz.getCssValue("font-size"));
	}
	
	@Test(priority=33)
	public void getCssValue_SettingAccountDMAText_TextFontFamily(){
		WebElement setactdmafmy = driver.findElement(disablemyaccount);
		Assert.assertTrue(setactdmafmy.isDisplayed());
		System.out.println("Font family, disable my account settings is : "	+ setactdmafmy.getCssValue("font-family"));
			
	}
	
	@Test(priority=34)
	public void getCssValue_SettingAccountDMAText_TextColor() {
		WebElement setactdmacol = driver.findElement(disablemyaccount);
		Assert.assertTrue(setactdmacol.isDisplayed());
		System.out.println("Font color, disable my account settings is : "	+ setactdmacol.getCssValue("color"));
	}
	
	
	@Test (priority=35)
	public void getCssvalue_SettingAccountDMAText_BackgroundColor() {
		WebElement setactdmabckcol = driver.findElement(disablemyaccount);
		Assert.assertTrue(setactdmabckcol.isDisplayed());
		System.out.println("Background-color, disable my account settings is : "	+ setactdmabckcol.getCssValue("background-color"));
	}
	
	@Test(priority=36)
	public void getCssValue_SettingAccountDMAText_FontWeight(){
		WebElement setactdmafntwt = driver.findElement(disablemyaccount);
		Assert.assertTrue(setactdmafntwt.isDisplayed());
		System.out.println("Font Weight, disable my account settings is "	+getFontWeight(setactdmafntwt));
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	@Test(priority=37)
	public void getCssValue_SettingAccountBulkUploadButton_TextFontSize() throws InterruptedException {
		WebElement bulkInvite = driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div[1]/div/ul/li[8]/a"));
		Assert.assertTrue(bulkInvite.isDisplayed());
		bulkInvite.click(); Thread.sleep(5000);
		WebElement setbulkbtnfntsz = driver.findElement(uploadbulk);
		Assert.assertTrue(setbulkbtnfntsz.isDisplayed());
		System.out.println("Font Size, bulk upload button settings is : "	+ setbulkbtnfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=38)
	public void getCssValue_SettingAccountBulkUploadButton_TextFontFamily(){
		WebElement setbulkbtnfntfmy = driver.findElement(uploadbulk);
		Assert.assertTrue(setbulkbtnfntfmy.isDisplayed());
		System.out.println("Font family, bulk upload button settings is : "	+ setbulkbtnfntfmy.getCssValue("font-family"));
			
	}
	
	@Test(priority=39)
	public void getCssValue_SettingAccountBulkUploadButton_TextColor() {
		WebElement setbulkbtnlbcol = driver.findElement(uploadbulk);
		Assert.assertTrue(setbulkbtnlbcol.isDisplayed());
		System.out.println("Font color, bulk upload button settings is : "	+ setbulkbtnlbcol.getCssValue("color"));
	}
	
	
	@Test (priority=40)
	public void getCssvalue_SettingAccountBulkUploadButton_BackgroundColor() {
		WebElement setbulkbrnbckcol = driver.findElement(uploadbulk);
		Assert.assertTrue(setbulkbrnbckcol.isDisplayed());
		System.out.println("Background-color, bulk upload button settings is : "	+ setbulkbrnbckcol.getCssValue("background-color"));
	}
	
	@Test(priority=41)
	public void getCssValue_SettingAccountBulkUploadButton_FontWeight(){
		WebElement setbulkbtnfntwt = driver.findElement(uploadbulk);
		Assert.assertTrue(setbulkbtnfntwt.isDisplayed());
		System.out.println("Font Weight, bulk upload button settings is "	+getFontWeight(setbulkbtnfntwt));
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	@Test(priority=42)
	public void getCssValue_SettingPermissionCheckLabel_TextFontSize() throws InterruptedException {
		WebElement permissions = driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div[1]/div/ul/li[7]/a"));
		Assert.assertTrue(permissions.isDisplayed());
		permissions.click(); Thread.sleep(5000);
		WebElement setperchklbfntsz = driver.findElement(permissionchecklabel);
		Assert.assertTrue(setperchklbfntsz.isDisplayed());
		System.out.println("Font Size, permission check box label settings is : "	+ setperchklbfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=43)
	public void getCssValue_SettingPermissionCheckLabel_TextFontFamily(){
		WebElement setperchklbfntfmy = driver.findElement(permissionchecklabel);
		Assert.assertTrue(setperchklbfntfmy.isDisplayed());
		System.out.println("Font family, permission check box label settings is : "	+ setperchklbfntfmy.getCssValue("font-family"));
			
	}
	
	@Test(priority=44)
	public void getCssValue_SettingPermissionCheckLabel_TextColor() {
		WebElement setperchklbcol = driver.findElement(permissionchecklabel);
		Assert.assertTrue(setperchklbcol.isDisplayed());
		System.out.println("Font color, permission check box label settings is : "	+ setperchklbcol.getCssValue("color"));
	}
	
	
	@Test (priority=45)
	public void getCssvalue_SettingPermissionCheckLabel_BackgroundColor() {
		WebElement setperchklbbckcol = driver.findElement(permissionchecklabel);
		Assert.assertTrue(setperchklbbckcol.isDisplayed());
		System.out.println("Background-color, permission check box label settings is : "	+ setperchklbbckcol.getCssValue("background-color"));
	}
	
	@Test(priority=46)
	public void getCssValue_SettingPermissionCheckLabel_FontWeight(){
		WebElement setperchklbfntwt = driver.findElement(permissionchecklabel);
		Assert.assertTrue(setperchklbfntwt.isDisplayed());
		System.out.println("Font Weight, permission check box label settings is "	+getFontWeight(setperchklbfntwt));
		System.out.println("------------------------------------------------------------------------------------------");
	}
		
	@Test(priority=47)
	public void getCssValue_SettingEmailNotification_TextFontSize() {
		WebElement emailnotification = driver.findElement(By.xpath("/html/body/section/div[3]/div[1]/div[1]/div/ul/li[5]/a"));
		Assert.assertTrue(emailnotification.isDisplayed());	
		emailnotification.click();
		WebElement setemlnotichklbfntsz = driver.findElement(emailnotificationheading);
		Assert.assertTrue(setemlnotichklbfntsz.isDisplayed());
		System.out.println("Font Size, email notification check box label settings is : "	+ setemlnotichklbfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=48)
	public void getCssValue_SettingEmailNotification_TextFontFamily() {
		WebElement setemlnotichklbfntfmy = driver.findElement(emailnotificationheading);
		Assert.assertTrue(setemlnotichklbfntfmy.isDisplayed());	
		System.out.println("Font family, email notification check box label settings is : "	+ setemlnotichklbfntfmy.getCssValue("font-family"));
			
	}
	
	@Test(priority=49)
	public void getCssValue_SettingEmailNotification_TextColor() {
		WebElement setemlnotichklbcol = driver.findElement(emailnotificationheading);
		Assert.assertTrue(setemlnotichklbcol.isDisplayed());	
		System.out.println("Font color, email notification check box label settings is : "	+ setemlnotichklbcol.getCssValue("color"));
	}
	
	
	@Test (priority=50)
	public void getCssvalue_SettingEmailNotification_BackgroundColor() {
		WebElement setemlnotichklbbckcol = driver.findElement(emailnotificationheading);
		Assert.assertTrue(setemlnotichklbbckcol.isDisplayed());	
		System.out.println("Background-color, email notification check box label settings is : "	+ setemlnotichklbbckcol.getCssValue("background-color"));
	}
	
	@Test(priority=51)
	public void getCssValue_SettingEmailNotification_FontWeight() {
		WebElement setemlnotichklbfntwt = driver.findElement(emailnotificationheading);
		Assert.assertTrue(setemlnotichklbfntwt.isDisplayed());	
		System.out.println("Font Weight, email notification check box label settings is "	+getFontWeight(setemlnotichklbfntwt));
		System.out.println("------------------------------------------------------------------------------------------");
	}
	
	public String getFontWeight(WebElement element) {
		//Output will return as 400 for font-weight : normal, and 700 for font-weight : bold
		return element.getCssValue("font-weight");
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
		System.out.println("Browser closed successgully");
		
		}
	
	}
