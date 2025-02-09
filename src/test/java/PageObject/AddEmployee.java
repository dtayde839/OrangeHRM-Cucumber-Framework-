package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployee 
{

	WebDriver driver;
	
	public AddEmployee(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
//	elements
	
	@FindBy(name="firstName")
	WebElement firstname;
	
	@FindBy(name="lastName")
	WebElement lastname;
	
	@FindBy(css="button[type='submit']")
	WebElement save;
	
	@FindBy(id="oxd-toaster_1")
	WebElement successMsg;
	
//	actions
	
	public void setFirstName(String fname)
	{
		firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void clickOnSave()
	{
		save.click();
	}
	
	public String getSuccessMsg()
	{
		return successMsg.getText();
	}
}
