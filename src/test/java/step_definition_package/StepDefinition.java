package step_definition_package;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import globalPackage.GlobalClass;
import initComponents.InitComponentsClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import orangeDemo.DashboardPage;
import orangeDemo.OrangeWebPage;

public class StepDefinition extends InitComponentsClass{
	OrangeWebPage owp;
	DashboardPage dp;
	String heading;

	@Given("I landed on OrangeHRM loginPage")
	public void i_landed_on_orange_hrm_login_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		owp = LaunchWebsite();
	}

	@Given("Login with the username {string} and password {string}")
	public void login_with_the_username_and_password(String string, String string2) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		dp = owp.inputDetails(string, string2);
	}

	@When("I click on text My_Info")
	public void i_click_on_text_my_info() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		heading = dp.getUiHeading();

	}

	@Then("I will verify heading {string}")
	public void i_will_verify_heading(String string) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(heading, string);
		driver.close();
	}

	
}
