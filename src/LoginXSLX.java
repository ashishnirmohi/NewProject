	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import jxl.Sheet;
	import jxl.Workbook;
	import jxl.read.biff.BiffException;
	
	public class LoginXSLX {
		WebDriver driver;
		@Test (dataProvider="empLogin")
		public void loginmember(String username, String password) throws Exception {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\UATcs\\browserexe\\chromedriver.exe");
			driver = new ChromeDriver(); Thread.sleep(5000); 
			driver.manage().window().maximize();
			driver.get("https://uat-clientspace.herokuapp.com"); Thread.sleep(4000);
			driver.findElement(By.id("email")).sendKeys(username); Thread.sleep(4000);
			driver.findElement(By.id("password")).sendKeys(password); Thread.sleep(4000);
			driver.findElement(By.id("show-sent")).click(); Thread.sleep(4000); 	
	}
		
		@DataProvider(name="empLogin")
		public Object[][] loginData() {
			Object[][] arrayObject = getExcelData("C:\\newone.xls","Sheet1");
			return arrayObject;
		}
	
		public String[][] getExcelData(String fileName, String sheetName) {
			String[][] arrayExcelData = null;
			try {
				FileInputStream fs = new FileInputStream(fileName);
				Workbook wb = Workbook.getWorkbook(fs);
				Sheet sh = wb.getSheet(sheetName);
	
				int totalNoOfCols = sh.getColumns();
				int totalNoOfRows = sh.getRows();
				
				arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
				
				for (int i= 1 ; i < totalNoOfRows; i++) {
	
					for (int j=0; j < totalNoOfCols; j++) {
						arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
					}
				}
				
			}
			
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
				e.printStackTrace();
			} 
			catch (BiffException e) {
				e.printStackTrace();
			}
			return arrayExcelData;
		}
	
	}
		
		
	
		
		
	
