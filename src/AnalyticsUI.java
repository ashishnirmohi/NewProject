
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class AnalyticsUI {
	public WebDriver driver;
	private By analytic = By.xpath("//*[contains(@class,'hidden')]");
	private By selectlabeltext = By.xpath("/html/body/section/form/div/div[1]/div/ul/li[2]/div/div[1]/h4/label"); 
	private By download = By.xpath("//button[@id=\"analytics-download-dropdown\"]");
	private By panelheading = By.xpath("//*[@id=\"analytics\"]/div[2]/div[1]/div[1]/div/div[2]/p");
	private By monthanalytic = By.xpath("//*[@id=\"analytics\"]/div[1]/div[2]/button/span[1]");
	private By yearanalytic = By.xpath("//*[@id=\"analytics\"]/div[1]/div[1]/button/span[1]");
	
	@BeforeClass
	public void loginCS() throws InterruptedException {
		System.out.println("------------------------------------------------------------------------------------------");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		driver = new ChromeDriver(options);Thread.sleep(5000);
		driver.manage().window().maximize();Thread.sleep(5000);
		System.out.println("Successfully passed!, launchbrowser()");
		driver.navigate().to("https://uat-clientspace.herokuapp.com");
		driver.findElement(By.id("email")).sendKeys("ashish.nirmohi@gmail.com"); Thread.sleep(5000);
		driver.findElement(By.id("password")).sendKeys("Test1234");
		driver.findElement(By.id("show-sent")).click(); Thread.sleep(5000);	
	}
	
	@Test (priority=1)
	public void openAnalytic() throws InterruptedException {
		Thread.sleep(5000);		
		WebElement analytics = driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-2\"]/ul[2]/li[2]/a/span[2]"));  Thread.sleep(4000);		
		System.out.println("Analitics link displayed: " +analytics.isDisplayed());  Thread.sleep(4000);	
		analytics.click(); Thread.sleep(4000);			
	}
	
	@Test(priority=2)
	public void getCssValue_AnalyticLink_TextFontSize(){
		WebElement anlyfntwt = driver.findElement(analytic);
		System.out.println("Font Size, analytics link field is : "	+ anlyfntwt.getCssValue("font-size"));
	}
	
	@Test(priority=3)
	public void getCssValue_AnalyticLink_TextFontFamily(){
		WebElement anlyfntfm = driver.findElement(analytic);
		System.out.println("Font family, analytics link field is : " + anlyfntfm.getCssValue("font-family"));
			
	}
	
	@Test(priority=4)
	public void getCssValue_AnalyticLink_TextColor() {
		WebElement anlycol = driver.findElement(analytic);
		System.out.println("Font color, analytics link field is : "	+ anlycol.getCssValue("color"));
	}
	
	@Test(priority=5)
	public void getCssValue_AnalyticsLink_BackgroundColor() {
		WebElement anlybckcol = driver.findElement(analytic); 
		System.out.println("Background color, analytics link field before mouse hover is : "	+ anlybckcol.getCssValue("background-color"));
		Actions action = new Actions(driver);
		action.moveToElement(anlybckcol).perform();
		System.out.println("Background color, aanalytics link field after mouse hover is : "	+ anlybckcol.getCssValue("background-color"));
		System.out.println("------------------------------------------------------------------------------------------");	
		
	}
	
	@Test(priority=6)
	public void getCssValue_AnalyticsSelectCS_TextFontSize(){
		WebElement selsfntsz = driver.findElement(selectlabeltext);
		System.out.println("Font Size, select share label is : "	+ selsfntsz.getCssValue("font-size"));
		
	}
	
	@Test(priority=7)
	public void getCssValue_AnalyticSelectCS_TextFontFamily(){
		WebElement selsfntfm = driver.findElement(selectlabeltext);
		System.out.println("Font family, select share label is : "	+ selsfntfm.getCssValue("font-family"));
	}
	
	@Test(priority=8)
	public void getCssValue_AnalyticSelectCS_TextFontWeight(){
		WebElement selsfntwt = driver.findElement(selectlabeltext);
		System.out.println("Font Weight, select share label is : "	+getFontWeight(selsfntwt) );
		
	}
	
	@Test(priority=9)
	public void getCssValue_AnalyticsSelectCS_TextColor() {
		WebElement selscol = driver.findElement(selectlabeltext); 
		System.out.println("Font color, select share label before mouse hover is : "	+ selscol.getCssValue("color"));
		Actions actionCS = new Actions(driver);
		actionCS.moveToElement(selscol).perform();
		System.out.println("Font color, select share label after mouse hover is : "	+ selscol.getCssValue("color"));
		System.out.println("------------------------------------------------------------------------------------------");	
	}
	
	@Test(priority=10)
	public void getCssValue_AnalyticsPanelCS_TextFontSize(){
		WebElement pnlfntsz = driver.findElement(panelheading);
		System.out.println("Font Size,  heading panel text field is : "	+ pnlfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=11)
	public void getCssValue_AnalyticPanelCS_TextFontFamily(){
		WebElement pnlfntfm = driver.findElement(panelheading);
		System.out.println("Font family, heading panel text field is : "	+ pnlfntfm.getCssValue("font-family"));
			
	}
	
	@Test(priority=12)
	public void getCssValue_AnalyticsPanelCS_TextColor() {
		WebElement pnlcol = driver.findElement(panelheading);
		System.out.println("Font color, heading panel text field is : "	+ pnlcol.getCssValue("color"));
	}
	
	@Test(priority=13)
	public void getCssValue_AnalyticPanelCS_TextFontWeight(){
		WebElement pnlfntwt = driver.findElement(panelheading);
		System.out.println("Font Weight, heading panel text field is "	+getFontWeight(pnlfntwt) );
		System.out.println("------------------------------------------------------------------------------------------");	
	}
	
	
	@Test(priority=14)
	public void getCssValue_AnalyticsYearFilter_TextFontSize(){
		WebElement yrfntsz = driver.findElement(yearanalytic);
		System.out.println("Font Size, year filer analytics is : "	+ yrfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=15)
	public void getCssValue_AnalyticYearFilter_TextFontFamily(){
		WebElement yrfntfamy = driver.findElement(yearanalytic);
		System.out.println("Font family, year filer analytics is : "	+ yrfntfamy.getCssValue("font-family"));
			
	}
	
	@Test(priority=16)
	public void getCssValue_AnalyticYearFilter_TextColor() {
		WebElement yrcol = driver.findElement(yearanalytic);
		System.out.println("Font color, heading panel text field is : "	+ yrcol.getCssValue("color"));
	}
	
	@Test(priority=17)
	public void getCssValue_AnalyticYearFilter_TextFontWeight(){
		WebElement yrfntwt = driver.findElement(yearanalytic);
		System.out.println("Font Weight, year filer analytics is : "	+getFontWeight(yrfntwt) );
		System.out.println("------------------------------------------------------------------------------------------");	
	}
	
	@Test(priority=18)
	public void getCssValue_AnalyticsMonthFilter_TextFontSize(){
		WebElement monfntsz = driver.findElement(monthanalytic);
		System.out.println("Font Size, month filter analytics is : "	+ monfntsz.getCssValue("font-size"));
		
	}
	
	@Test(priority=19)
	public void getCssValue_AnalyticMonthFilter_TextFontFamily(){
		WebElement monfntfamy = driver.findElement(monthanalytic);
		System.out.println("Font family, month filter analytics is : "	+ monfntfamy.getCssValue("font-family"));
			
	}
	
	@Test(priority=20)
	public void getCssValue_AnalyticMonthFilter_TextColor() {
		WebElement moncol = driver.findElement(monthanalytic);
		System.out.println("Font color, heading panel text field is : "	+ moncol.getCssValue("color"));
	}
	
	@Test(priority=21)
	public void getCssValue_AnalyticMonthFilter_TextFontWeight(){
		WebElement monfntwt = driver.findElement(monthanalytic);
		System.out.println("Font Weight, month filter analytics is : "	+getFontWeight(monfntwt) );
		System.out.println("------------------------------------------------------------------------------------------");	
	}
	
	@Test(priority=22)
	public void getCssValue_AnalticDownloadButton_TextFontSize() {
		WebElement dwnfntsz = driver.findElement(download);
		System.out.println("Font Size, button Download analytics is : "	+ dwnfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=23)
	public void getCssValue_AnalyticDownloadButton_TextFontFamily(){
		WebElement dwnfntfmy = driver.findElement(download);
		System.out.println("Font family, button Download analytics is : "	+ dwnfntfmy.getCssValue("font-family"));
			
	}
	
	@Test(priority=24)
	public void getCssValue_AnalyticDownloadButton_TextColor() {
		WebElement dwncol = driver.findElement(download);
		System.out.println("Font color, button Download analytics is : "	+ dwncol.getCssValue("color"));
	}

	
	@Test (priority=25)
	public void getCssvalue_AnalyticDownloadButton_BackgroundColor() {
		WebElement dwnbckcol = driver.findElement(download);
		System.out.println("Background-color, button Download analytics is : "	+ dwnbckcol.getCssValue("background-color"));
	}
	
	@Test(priority=26)
	public void getCssValue_AnalyticButtonFontWeight(){
		WebElement dwnbtnfntwt = driver.findElement(download);
		System.out.println("Font Weight, button Download analytics is "	+getFontWeight(dwnbtnfntwt));
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