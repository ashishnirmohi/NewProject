
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	
	public class CommunityUI {
	public WebDriver driver;
	//private By community = By.xpath("/html/body/section/section/div/div/div[1]/div/div[4]/span");
	private By all = By.xpath("/html/body/section/div[2]/div[1]/div/div/div[1]/div[3]/ul/li[1]/a");
	private By seller = By.xpath("/html/body/section/div[2]/div[1]/div/div/div[1]/div[3]/ul/li[2]/a");
	private By bio = By.xpath("/html/body/section/div[2]/div[1]/div/div/div[3]/div[1]/div[3]/div/div[1]/div[3]/p");
	private By jobprofile = By.className("community-member-designation");
	private By company = By.className("community-member-company");
	private By nameuser = By.className("community-member-name");
	
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
	public void openCommunity() throws InterruptedException {		
		Thread.sleep(5000);		
		WebElement community = driver.findElement(By.xpath("//a[@class='community_member_link']"));
		System.out.println("Community link displayed: " +community.isDisplayed());
		community.click(); Thread.sleep(5000);		
	}
	
	/*
	@Test(priority=2)
	public void getCssValue_CommunityLink_TextFontSize(){
		WebElement cmtyfntsz = driver.findElement(community);
		System.out.println("Font Size, community link field is : "	+ cmtyfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=3)
	public void getCssValue_CommunityLink_TextFontFamily(){
		WebElement cmtyfntfm = driver.findElement(community);
		System.out.println("Font family, community link field is : " + cmtyfntfm.getCssValue("font-family"));
			
	}
	
	@Test(priority=4)
	public void getCssValue_CommunityLink_TextFontWeight(){
		WebElement cmtyfntwt = driver.findElement(community);
		System.out.println("Font Weight, Community text field is "	+getFontWeight(cmtyfntwt));
		
	}
	
	@Test(priority=5)
	public void getCssValue_CommunityLink_TextColor() {
		WebElement cmtycol = driver.findElement(community);
		System.out.println("Font color, community link text field is : "	+ cmtycol.getCssValue("color"));
	}
	
	@Test(priority=6)
	public void getCssValue_CommunityLink_BackgroundColor() {
		WebElement cmtybckcol = driver.findElement(community); 
		System.out.println("Background color, community link field before mouse hover is : "	+ cmtybckcol.getCssValue("background-color"));
		Actions action = new Actions(driver);
		action.moveToElement(cmtybckcol).perform();
		System.out.println("Background color, community link field after mouse hover is : "	+ cmtybckcol.getCssValue("background-color"));
		System.out.println("------------------------------------------------------------------------------------------");	
		
	}
	*/
	
	@Test(priority=7)
	public void getCssValue_CommunityAll_TextFontSize(){
		WebElement allfntwt = driver.findElement(all);
		System.out.println("Font Size, community all field is : "	+ allfntwt.getCssValue("font-size"));
	}
	
	@Test(priority=8)
	public void getCssValue_CommunityAll_TextFontFamily(){
		WebElement allfntfm = driver.findElement(all);
		System.out.println("Font family, community all link is : " + allfntfm.getCssValue("font-family"));
			
	}
	
	@Test(priority=9)
	public void getCssValue_CommunityAll_TextColor() {
		WebElement allcol = driver.findElement(all);
		System.out.println("Font color, community all link is : "	+ allcol.getCssValue("color"));
	}
	
	@Test(priority=10)
	public void getCssValue_CommunityAll_TextFontWeight(){
		WebElement allfntwt = driver.findElement(all);
		System.out.println("Font Weight, Community all link is "	+getFontWeight(allfntwt));
		
	}
	
	@Test(priority=11)
	public void getCssValue_CommunityAll_BackgroundColor() {
		WebElement allbckcol = driver.findElement(all); 
		System.out.println("Background color, community all link field before mouse hover is : "	+ allbckcol.getCssValue("background-color"));
		Actions actionall = new Actions(driver);
		actionall.moveToElement(allbckcol).perform();
		System.out.println("Background color, community all link field after mouse hover is : "	+ allbckcol.getCssValue("background-color"));
		System.out.println("------------------------------------------------------------------------------------------");	
		
	}
	
	@Test(priority=12)
	public void getCssValue_CommunitySeller_TextFontSize(){
		WebElement selfnsz = driver.findElement(seller);
		System.out.println("Font Size, seller link field is : "	+ selfnsz.getCssValue("font-size"));
	}
	
	@Test(priority=13)
	public void getCssValue_CommunitySeller_TextFontFamily(){
		WebElement selfntfm = driver.findElement(seller);
		System.out.println("Font family, seller link field is : " + selfntfm.getCssValue("font-family"));
			
	}
	
	@Test(priority=14)
	public void getCssValue_CommunitySeller_TextColor() {
		WebElement selcol = driver.findElement(seller);
		System.out.println("Font color, seller link field is : "	+ selcol.getCssValue("color"));
	}
	
	@Test(priority=15)
	public void getCssValue_CommunitySeller_TextFontWeight(){
		WebElement selfntwt = driver.findElement(all);
		System.out.println("Font Weight, Community text field is "	+getFontWeight(selfntwt));
		
	}
	
	@Test(priority=16)
	public void getCssValue_CommunitySeller_BackgroundColor() {
		WebElement selbckcol = driver.findElement(seller); 
		System.out.println("Background color, seller link field before mouse hover is : "	+ selbckcol.getCssValue("background-color"));
		Actions actionseller = new Actions(driver);
		actionseller.moveToElement(selbckcol).perform();
		System.out.println("Background color, seller link field after mouse hover is : "	+ selbckcol.getCssValue("background-color"));
		System.out.println("------------------------------------------------------------------------------------------");	
		
	}
	
	@Test(priority=17)
	public void getCssValue_CommunityBiography_TextFontSize(){
		WebElement biofntsz = driver.findElement(bio);
		System.out.println("Font Size, community bio field is : "	+ biofntsz.getCssValue("font-size"));
	}
	
	@Test(priority=18)
	public void getCssValue_CommunityBiography_TextFontFamily(){
		WebElement biofntfm = driver.findElement(bio);
		System.out.println("Font family, community bio field is : " + biofntfm.getCssValue("font-family"));
			
	}
	
	@Test(priority=19)
	public void getCssValue_CommunityBiography_TextFontWeight(){
		WebElement biofntwt = driver.findElement(bio);
		System.out.println("Font Weight, Community bio field is "	+getFontWeight(biofntwt));
		
	}
	
	@Test(priority=20)
	public void getCssValue_CommunityBiography_TextColor() {
		WebElement biocol = driver.findElement(bio);
		System.out.println("Font color, community bio text field is : "	+ biocol.getCssValue("color"));
	}
	
	@Test(priority=21)
	public void getCssValue_CommunityBiography_BackgroundColor() {
		WebElement cmtybckcol = driver.findElement(bio); 
		System.out.println("Background color, community bio field before mouse hover is : "	+ cmtybckcol.getCssValue("background-color"));
		Actions actionbio = new Actions(driver);
		actionbio.moveToElement(cmtybckcol).perform();
		System.out.println("Background color, community bio field after mouse hover is : "	+ cmtybckcol.getCssValue("background-color"));
		System.out.println("------------------------------------------------------------------------------------------");	
		
	}
	
	
	@Test(priority=22)
	public void getCssValue_CommunityJobProfile_TextFontSize(){
		WebElement jpfntsz = driver.findElement(jobprofile);
		System.out.println("Font Size, community bio field is : "	+ jpfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=23)
	public void getCssValue_CommunityJobProfile_TextFontFamily(){
		WebElement jpfntfm = driver.findElement(jobprofile);
		System.out.println("Font family, community bio field is : " + jpfntfm.getCssValue("font-family"));
			
	}
	
	@Test(priority=24)
	public void getCssValue_CommunityJobProfile_TextFontWeight(){
		WebElement jpfntwt = driver.findElement(jobprofile);
		System.out.println("Font Weight, Community bio field is "	+getFontWeight(jpfntwt));
		
	}
	
	@Test(priority=25)
	public void getCssValue_CommunityJobProfile_TextColor() {
		WebElement jpcol = driver.findElement(jobprofile);
		System.out.println("Font color, community bio text field is : "	+ jpcol.getCssValue("color"));
	}
	
	@Test(priority=26)
	public void getCssValue_CommunityJobProfile_BackgroundColor() {
		WebElement jpbckcol = driver.findElement(jobprofile); 
		System.out.println("Background color, community bio field before mouse hover is : "	+ jpbckcol.getCssValue("background-color"));
		Actions actionjp = new Actions(driver);
		actionjp.moveToElement(jpbckcol).perform();
		System.out.println("Background color, community bio field after mouse hover is : "	+ jpbckcol.getCssValue("background-color"));
		System.out.println("------------------------------------------------------------------------------------------");	
		
	}
	
	@Test(priority=27)
	public void getCssValue_CommunityComapanyName_TextFontSize(){
		WebElement cmsfntsz = driver.findElement(company);
		System.out.println("Font Size, community bio field is : "	+ cmsfntsz.getCssValue("font-size"));
	}
	
	@Test(priority=28)
	public void getCssValue_CommunityComapanyName_TextFontFamily(){
		WebElement cmsfntfm = driver.findElement(company);
		System.out.println("Font family, community bio field is : " + cmsfntfm.getCssValue("font-family"));
			
	}
	
	@Test(priority=29)
	public void getCssValue_CommunityComapanyName_TextFontWeight(){
		WebElement cmsfntwt = driver.findElement(company);
		System.out.println("Font Weight, Community bio field is "	+getFontWeight(cmsfntwt));
		
	}
	
	@Test(priority=30)
	public void getCssValue_CommunityComapanyName_TextColor() {
		WebElement cmscol = driver.findElement(company);
		System.out.println("Font color, community bio text field is : "	+ cmscol.getCssValue("color"));
	}
	
	@Test(priority=31)
	public void getCssValue_CommunityComapanyName_BackgroundColor() {
		WebElement cmsbckcol = driver.findElement(company); 
		System.out.println("Background color, community bio field before mouse hover is : "	+ cmsbckcol.getCssValue("background-color"));
		Actions actioncomnm = new Actions(driver);
		actioncomnm.moveToElement(cmsbckcol).perform();
		System.out.println("Background color, community bio field after mouse hover is : "	+ cmsbckcol.getCssValue("background-color"));
		System.out.println("------------------------------------------------------------------------------------------");	
	}
	
	@Test(priority=32)
	public void getCssValue_CommunityNameUser_TextFontSize(){
		WebElement nmufntsz = driver.findElement(nameuser);
		System.out.println("Font Size, community name field is : "	+ nmufntsz.getCssValue("font-size"));
	}
	
	@Test(priority=33)
	public void getCssValue_CommunityNameUser_TextFontFamily(){
		WebElement nmufntfm = driver.findElement(nameuser);
		System.out.println("Font family, community name field is : " + nmufntfm.getCssValue("font-family"));
			
	}
	
	@Test(priority=34)
	public void getCssValue_CommunityNameUser_TextFontWeight(){
		WebElement nmufntwt = driver.findElement(nameuser);
		System.out.println("Font Weight, Community name field is "	+getFontWeight(nmufntwt));
		
	}
	
	@Test(priority=35)
	public void getCssValue_CommunityNameUser_TextColor() {
		WebElement nmucol = driver.findElement(nameuser);
		System.out.println("Font color, community name text field is : "	+ nmucol.getCssValue("color"));
	}
	
	@Test(priority=36)
	public void getCssValue_CommunityNameUser_BackgroundColor() {
		WebElement nmubckcol = driver.findElement(nameuser); 
		System.out.println("Background color, community name field before mouse hover is : "	+ nmubckcol.getCssValue("background-color"));
		Actions actionnmus = new Actions(driver);
		actionnmus.moveToElement(nmubckcol).perform();
		System.out.println("Background color, community bio field after mouse hover is : "	+ nmubckcol.getCssValue("background-color"));
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