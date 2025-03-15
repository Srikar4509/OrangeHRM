package orangeDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import globalPackage.GlobalClass;

public class DashboardPage extends GlobalClass{
	WebDriver d;
	public DashboardPage(WebDriver driver) {
		super(driver);
		d= driver;
		PageFactory.initElements(d, this);
		
	}
	
	@FindBy(xpath = "//*[text()='My Info']")
	WebElement my_Info;
	
	@FindBy(tagName = "h6")
	WebElement heading;
	
	public String getUiHeading() throws InterruptedException
	{
		Thread.sleep(5000);
		my_Info.click();
		return heading.getText();
	}
	
}
