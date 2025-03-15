package TestFolder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import globalPackage.GlobalClass;
import initComponents.InitComponentsClass;
import orangeDemo.DashboardPage;
import orangeDemo.OrangeWebPage;

public class TestRun extends InitComponentsClass {
	WebDriver driver;
	ExtentReports extent;
	@Test(dataProvider = "dataForLogin")
	
	
//****************************************************** Passing values through 2-D array **************************************
//	public void testRun(String user, String password) throws InterruptedException 
//	{
//		System.out.println("OP page "+op);
//		op.inputDetails(user, password);
//		Assert.assertEquals(op.errorMessage(), "Invalid credentials");
//	}
//	
//	@DataProvider(name="dataForLogin")
//	public Object[][] loginData()
//	{
//		String login[][]= {{"Admin","Admin"},{"admin","Admin"},{"Admin","admin"}};
//		return login;
//	}
	
	
//******************************************************* Passing values through HasMap ******************************************
	public void testRun(HashMap<String,String> loginData) throws InterruptedException 
	{
		
		DashboardPage dp = op.inputDetails(loginData.get("user"),loginData.get("password"));
		String heading = dp.getUiHeading();
		Assert.assertEquals(heading, "PIM");
//		Assert.assertEquals(op.errorMessage(), "Invalid credentials");
	}
	
	@DataProvider(name="dataForLogin")
//	public Object[][] loginData()
//	{
//		HashMap<Object, Object> loginData1 = new HashMap();
//		loginData1.put("user", "Admin");
//		loginData1.put("password", "Admin");
//		HashMap<Object, Object> loginData2 = new HashMap();
//		loginData2.put("user", "admin");
//		loginData2.put("password", "Admin");
//		HashMap<Object, Object> loginData3 = new HashMap();
//		loginData3.put("user", "Admin");
//		loginData3.put("password", "admin");
//		
//		Object login[][]= {{loginData1},{loginData2},{loginData3}};
//		return login;
//	}
	public Object[][] loginDetails() throws IOException {
		List<HashMap<String, String>> loginData = readData();
		System.out.println(loginData);
		Object login[][]= {{loginData.get(0)}};
		System.out.println(login);
//		,{loginData.get(1)},{loginData.get(2)}
//		HashMap<String, String> data = null;
//		for(int i = 0;i<loginData.size();i++)
//		{
//			data = loginData.get(i);
//		}
		return login;
		
	}
	
	
	
}


//,
//{
//"user": "Admin",
//"password":"admin"
//},
//{
//"user": "admin",
//"password":"Admin"
//}