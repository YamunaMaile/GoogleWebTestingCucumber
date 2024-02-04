package StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Pages.loginPOM;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class salesFStepsPOM {

	WebDriver driver;
	loginPOM loginObj;

	@Given("User is on SalesForce login page")
	public void user_is_on_sales_force_login_page() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.driver.chrome",
				System.getProperty("user.dir") + "src\\test\\resources\\ChromeDriver\\chromedriver.exe");
		driver.get("https://login.salesforce.com/?locale=in");

	}

	@When("^User is enter (.*) and (.*)$")
	public void user_is_enter_username_and_password(String user, String pass) {
		loginObj = new loginPOM(driver);
		loginObj.enterUserName(user);
		loginObj.enterPass(pass);

	}

	@And("User click on Use Custom Domain")
	public void user_click_on_use_custom_domain() throws InterruptedException {
		loginObj.clickOnUseDomainLink();
		Thread.sleep(3000);
	}

	@Then("User is navigated Use Custom Domain Page")
	public void user_is_navigated_use_custom_domain_page() {

		loginObj.verifyUseDomainTitle();

		driver.quit();
	}

}
