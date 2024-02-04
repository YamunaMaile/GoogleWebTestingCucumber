package StepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Pages.loginPF;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sFLoginPF {

	WebDriver driver;
	  loginPF obj,obj2;
	  
	  @Given("User is on Chrome browser")
	  public void user_is_on_chrome_browser() {
	     System.out.println("Chrome browser is launched");
	  }

	  @Then("User is able to enter sales force login URL")
	  public void user_is_able_to_enter_sales_force_login_url() {
		  System.out.println("User is entered sales force url in tab");
	  }

	  @Then("user click on enter button")
	  public void user_click_on_enter_button() {
		  System.out.println("User click on enter button");
	  }


	  
	  
	  @Before
	  public void setUp()
	  {
		  System.out.println("Page factory-->inside setUp() before hook");
		  driver=new ChromeDriver();
		  System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir"+"src\\test\\resources\\ChromeDriver\\chromedriver.exe"));
		  driver.get("https://login.salesforce.com/?locale=in");
	  }
	  
	  @BeforeStep(value="@smoke", order=1) //conditional hook- to execute at mentioned tag only
	  public void executeBeforeEveryStep() 
	  { 
		  System.out.println("Before step-- order=1");    
	
	  }
	  
	  /*@BeforeStep(value="@smoke", order=-1) //conditional hook- to execute at mentioned tag only
	  public void executeBeforeEveryStep1() 
	  { 
		  System.out.println("Before step 1-- order=-1");    
	
	  }
	  
	  @BeforeStep(value="@smoke", order=0) //conditional hook- to execute at mentioned tag only
	  public void executeBeforeEveryStep2() 
	  { 
		  System.out.println("Before step-- order=0");    
	
	  }
	  
	  @BeforeStep
	  public void executeBeforeEveryStep3() 
	  { 
		  System.out.println("Before step 3 with no order");    

	  }
	  
	  */
	  
	  
	  @AfterStep ("@regression") //this will not execute because @regression tag is not present in this feature
	  public void executeAfterEveryStep() {
		System.out.println("After step");  
	  }
	
	  @AfterStep
	  public void takeScreenshot(io.cucumber.java.Scenario sc) throws IOException
	  {
		  if(sc.isFailed() || !sc.isFailed()) {
		  TakesScreenshot ts=(TakesScreenshot)driver;
		 File file=ts.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(file,new File("C:\\Softwares\\GoogleWebTestingCucumber\\Reports\\screenshots\\FailTC_img1.jpg"));
		byte file2[]=ts.getScreenshotAs(OutputType.BYTES);
		  sc.attach(file2, "FaileSS/png", "screenshot attached");
		  }
		  
	  }
	  
	@Given("User is on sales force login page")
	public void user_is_on_sales_force_login_page() {
	  
	obj=new loginPF(driver);
	obj.SFLoginPageTitleVerify();
	}

	@When("^User enter (.*) and (.*)$")
	public void user_enter_testing_and_usernmpass123(String user, String pass) {
		
	obj.enterUserName(user);
	obj.enterPass(pass);
		 
	}

	@And("Click on forgot password link")
	public void click_on_forgot_password_link() {
		 System.out.println("and method");
		 obj.clickOnForgotPasswordLink();
	}

	@Then("user is navigate to Forgot password page")
	public void user_is_navigate_to_forgot_password_page() {
		 System.out.println("then method");
		 obj.verifyForgotPasswordTitle();
		 
	}
	
	
	@Given("User click on Use Custom domain link")
	public void user_click_on_use_custom_domain_link() throws InterruptedException {
		System.out.println("Scenario2 background test"); 
		obj2=new loginPF(driver);
		obj2.clickOnUseDomainLink();
	}

	@When("User is navigated to UCD page")
	public void user_is_navigated_to_ucd_page() {
		System.out.println("Scenario2 background test"); 
		obj2.verifyUseDomainTitle();
	}

 @After
 public void tearDown() throws IOException, InterruptedException
 {
	 Thread.sleep(2000);
	 // takeScreenshot();
	 System.out.println("Page factory-->inside tearDown() after hook");
	 driver.quit(); 
 }
	
}
