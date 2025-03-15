package initComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import orangeDemo.OrangeWebPage;

public class InitComponentsClass {
	public OrangeWebPage op;
	public WebDriver driver;
	String browserName;

	public WebDriver initializeDriver() {
		if(System.getProperty("browser")!=null)
		{
			browserName = System.getProperty("browser");			
		}
		else
		{
			browserName = "Chrome";
		}
		System.out.println(browserName);
		switch (browserName) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "Edge":
			driver = new EdgeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		default : 
			System.out.println("Wrong input... Choose from Chrome, Edge, Firefox");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}

	@BeforeMethod
	public OrangeWebPage LaunchWebsite() throws InterruptedException {
		System.out.println("Begin Testing...");
		driver = initializeDriver();
//		System.out.println(" " +driver);
		op = new OrangeWebPage(driver);
//		System.out.println("init page "+op);
		op.goTo();
		return op;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	public List<HashMap<String, String>> readData() throws IOException {
		String jsonContent = FileUtils.readFileToString(
				new File("D:\\SELENIUM\\OrangeHRM\\OrangeHRM\\src\\test\\java\\dataPackage\\dataFile.json"));
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String takeScreeshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		System.out.println("Driver " + driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("D:\\SELENIUM\\OrangeHRM\\OrangeHRM\\reports\\" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return "D:\\SELENIUM\\OrangeHRM\\OrangeHRM\\reports\\" + testCaseName + ".png";
	}
}
