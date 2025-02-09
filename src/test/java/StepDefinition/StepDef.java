package StepDefinition;

import java.time.Duration;
import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.AddEmployee;
import PageObject.DashboardPage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import PageObject.PIMPage;
import PageObject.PasswordResetPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef 
{
	public WebDriver driver;
	public LoginPage loginPg;
	public MyAccountPage MyAcc;
	public PIMPage pim;
	public AddEmployee addEmp;
	public PasswordResetPage prp;
	public DashboardPage dbp;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		loginPg = new LoginPage(driver);
		MyAcc = new MyAccountPage(driver);
		pim = new PIMPage(driver);
		addEmp = new AddEmployee(driver);
		prp = new PasswordResetPage(driver);
		dbp = new DashboardPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) 
	{
		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String pwd) 
	{
	    loginPg.enterEmail(emailAdd);
	    loginPg.enterPassword(pwd);
	}

	@And("Click on Login")
	public void click_on_login() 
	{
	    loginPg.clickOnLoginBtn();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) 
	{
	    String actualTitle = driver.getTitle();
	    
	    if(actualTitle.equals(expectedTitle))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}
	
	@Then("I should see following errors {string} at {string}")
	public void i_should_see_following_errors_at(String expected_result, String messageLocator) 
	{
		WebElement error = getElementByLocator(messageLocator);
		String actMsg = error.getText();
		Assert.assertEquals(expected_result, actMsg);
	}

	private WebElement getElementByLocator(String locator) 
	{
		if(locator.startsWith("xpath:"))
		{
			return driver.findElement(By.xpath(locator.replace("xpath:", "")));
		}
		else if(locator.startsWith("css:")) 
		{
            return driver.findElement(By.cssSelector(locator.replace("css:", "")));
		}
		else {
            throw new IllegalArgumentException("Unsupported locator strategy: " + locator);
        }
	}
	
//########################################### Forgot your password ##################################
	@Then("Forgot your password link is visible and enabled")
	public void forgot_your_password_link_is_visible_and_enabled() 
	{
	    loginPg.isForgotPasswordLinkDisplayed();
	    loginPg.isForgotPasswordLinkEnabled();
	}
	
	@When("User clicks on Forgot your password? link")
	public void user_clicks_on_forgot_your_password_link() 
	{
	    loginPg.clickOnForgotPassword();
	}
	@Then("User should navigate to {string}")
	public void user_should_navigate_to(String expURL) 
	{
	    String actURL = driver.getCurrentUrl();
	    Assert.assertEquals(expURL, actURL);
	}
	
//	############################ password reset page ##############################
	@Then("User enter {string} in usename field")
	public void user_enter_in_usename_field(String uname) 
	{
	    prp.setUsername(uname);
	}

	@Then("Click on Reset Password button")
	public void click_on_reset_password_button()
	{
	    prp.clickonResetBtn();
	}
	
	@And("User clicks on Cancel button")
	public void user_clicks_on_cancel_button() 
	{
	    prp.clickonCancelBtn();
	}
	
	@Then("User should see the message {string}")
	public void user_should_see_the_message(String expMsg)
	{
		String actMSG = driver.findElement(By.tagName("h6")).getText();
	    Assert.assertEquals(expMsg, actMSG);
	}
	
	@Then("User should see Required alert.")
	public void user_should_see_required_alert() 
	{
	  String msg = prp.getErrMsg();
//	  System.out.println(msg);
	}
	
//	################################# dashboard ##############################
	
	@Then("username should be {string}")
	public void username_should_be(String uname)
	{
	  Assert.assertEquals(uname, "ShehanRamesh RaoShah");
	}
	
	@Then("Dashboard components should be displayed.")
	public void dashboard_components_should_be_displayed() 
	{
	    dbp.isTimeAtWorkDisplayed();
	    String expText = dbp.getTimeatworkText();
	    Assert.assertEquals(expText, "Time at Work");
	    
	    dbp.isMyActionsDisplayed();
	}
	
	@When("User clicks on user profile")
	public void user_clicks_on_user_profile()
	{
	    dbp.clickonUserProfile();
	}
	
	@Then("Logout link should be displayed")
	public void logout_link_should_be_displayed() 
	{
	    dbp.logoutlinkisDisplayed();
	}

	@When("Clicks on logout link")
	public void clicks_on_logout_link() 
	{
	    dbp.clickonLogout();
	}


//	################### Add User ########################
	@Then("Click on Admin section")
	public void click_on_admin_section()
	{
	   MyAcc.clickOnAdminSection();
	}
	
	@Then("Click on Add button")
	public void click_on_add_button() 
	{
		pim.clickOnAddButton();
	}
	
	@Given("User Navigate to the PIM menu")
	public void navigate_to_the_pim_menu() {
	    
		MyAcc.clickOnPIM();
	}
	
	@When("User Navigate to the PIM menu and select ADD Employee")
	public void click_on_pim_section_and_select_add_employee() 
	{
		MyAcc.clickOnPIM();
		pim.clickOnAddButton();
	}
	
//	################### Enter employee details ####################
	
	@Then("Enter Employee First Name as {string} and Last Name as {string}")
	public void enter_employee_first_name_and_last_name_as(String fname, String lname) 
	{
	    addEmp.setFirstName(fname);
	    addEmp.setLastName(lname);
	}

	@And("Click on Save button")
	public void click_on_save_button()
	{
		addEmp.clickOnSave();
	}
	
//######################### success message #########################
	
	@Then("Success message should contains {string}")
	public void success_message_should_display(String msg)
	{
		addEmp.getSuccessMsg().contains(msg);
	}
	
//	###################### Search Employee ######################
	@When("User enter {string} in Employee ID search field")
	public void user_enter_in_employee_id_search_field(String empID)
	{
			pim.searchEmployeeId(empID);
	}
	
	@When("User enter {string} in Employee Name search field")
	public void user_enter_in_employee_name_search_field(String eName) 
	{
	    pim.searchEmpName(eName);
	}
	
	@When("User select Full-Time Contract from Employee Status menu")
	public void user_select_full_time_contract_from_employee_status_menu()
	{
	    pim.clickEmpStatus();
	    pim.clickOnFullTimeContract();
	}
	
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException
	{
	    pim.clickOnSearchBtn();
	    Thread.sleep(5000);
	}
	
	@Then("User should found Email in the Search Table")
	public void user_should_found_email_in_the_search_table() throws InterruptedException 
	{
		Thread.sleep(5000);
		String emp_ID = "0039";
		String message_actual = "";
		
	   List<WebElement> rows = driver.findElements(By.xpath("(//div[@role='row'])"));
	   
	   if(rows.size()>1)
	   {
		  message_actual = driver.findElement(By.xpath("((//div[@role='row'])[2]/div[@role='cell'])[2]")).getText();
	   }
	   
	   Assert.assertEquals(emp_ID, message_actual);
	}
	
	@Then("Verify that record is found in search table")
	public void verify_that_record_is_found_in_search_table() 
	{
		String expEmpFname = "Rahul";
		String actEmpFname = pim.empFirstName();
		
		Assert.assertEquals(expEmpFname, actEmpFname);
	}
	
	@Then("Verify that record is displayed")
	public void verify_that_record_is_displayed()
	{
	   String expRes = "Record Found";
	   String actRes = pim.recordisDisplayedText();
	   
	   Assert.assertTrue(actRes.contains(expRes));
	}

	
//	########################## Logout ###########################
	
	@Then("Click on the User Profile and then on Logout button")
	public void click_on_the_user_profile_and_then_on_logout_button()
	{
		MyAcc.clickOnUserProfile();
		MyAcc.clickOnLogout();
	}
	
	@Then("Page URL should be {string}")
	public void page_url_should_be(String expURL)
	{
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expURL, actualURL);
	}

	@Then("close browser")
	public void close_browser()
	{
	    driver.close();
	    driver.quit();
	}
}
