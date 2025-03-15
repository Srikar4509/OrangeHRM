package globalPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GlobalClass {
	WebDriver driver;
	public GlobalClass(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	
}
