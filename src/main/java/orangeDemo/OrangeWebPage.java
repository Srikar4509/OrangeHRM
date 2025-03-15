package orangeDemo;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import globalPackage.GlobalClass;

public class OrangeWebPage extends GlobalClass {
	WebDriver driver;
	public OrangeWebPage(WebDriver d)
	{
		super(d);
		driver = d;
		System.out.println("OP "+driver);
		PageFactory.initElements(driver, this);
	}

	public void goTo() 
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.get("https://nykaa.com");
		
	}
	
	@FindBy(css = "div input[name='username']")
	WebElement fullName;
	
	@FindBy(css = "div input[type='password']")
	WebElement password;
	
	@FindBy(css = "button[type='submit']")
	WebElement button;
	
	public DashboardPage inputDetails(String user, String pwd) throws InterruptedException
	{
		Thread.sleep(5000);
		fullName.sendKeys(user);
		password.sendKeys(pwd);
		button.click();
		DashboardPage dp = new DashboardPage(driver);
		return dp;
		
	}
	
	@FindBy (xpath = "//div[@role='alert']/div/p")
	WebElement errMessage;
	public String errorMessage()
	{
		String errorMessage;
		if(errMessage.getText()!=null)
		{
			System.out.println(errMessage.getText());
			errorMessage = 	errMessage.getText();
		}
		else
		{
			errorMessage = null;
		}
		return errorMessage;
	}


}
