import java.util.List;
import java.util.ArrayList;

import org.testng.TestNG;

public class TestRunner {

	public static void main(String [] args) {
		TestNG runner = new TestNG();
		List <String> list = new ArrayList<String>();
		
		list.add("C:\\Users\\user\\eclipse-workspace\\NewProject\\test-output\\testng-failed.xml");
		runner.setTestSuites(list);
		
		runner.run();
	}
	
}
