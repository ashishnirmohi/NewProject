	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	
	public class LoginMultipleUser {
	
	WebDriver driver;
	@Test (dataProvider="loginthreemembers")
	public void loginmember(String username, String password) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
		driver = new ChromeDriver(); Thread.sleep(5000); 
		driver.get("https://uat-clientspace.herokuapp.com"); Thread.sleep(4000);
		driver.findElement(By.id("email")).sendKeys(username); Thread.sleep(4000);
		driver.findElement(By.id("password")).sendKeys(password); Thread.sleep(4000);
		driver.findElement(By.id("show-sent")).click(); Thread.sleep(4000); 
		driver.close();
		
	}
	
	@DataProvider(name="loginthreemembers")
	public Object[][] pass_data(){
		Object[][] data = new Object[3][2];
		data[0][0]="ashish.nirmohi@gmail.com";
		data[0][1]="Test1234";
		
		data[1][0]="ashishkumar@ucreate.co.in";
		data[1][1]="@Test1234";
		
		data[2][0]="sahilsharma@ucreate.co.in";
		data[2][1]="@Test123";
		
		return data;	
		
	}
	}
