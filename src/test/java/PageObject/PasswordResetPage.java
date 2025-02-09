package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetPage
{
	WebDriver ldriver;
	
	public PasswordResetPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="input[name='username']")
	WebElement username;
	
	public void setUsername(String uname)
	{
		username.sendKeys(uname);
	}
	
	@FindBy(css="button[type='submit']")
	WebElement resetBtn;
	
	public void clickonResetBtn()
	{
		resetBtn.click();
	}
	
	@FindBy(css="span.oxd-input-field-error-message")
	WebElement errMsg;
	
	public String getErrMsg()
	{
		return errMsg.getText();
	}
	
	@FindBy(css="button.orangehrm-forgot-password-button--cancel")
	WebElement cancelBtn;
	
	public void clickonCancelBtn()
	{
		cancelBtn.click();
	}
}
