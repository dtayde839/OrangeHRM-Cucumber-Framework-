package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	WebElement passwd;
	
	@FindBy(tagName="button")
	WebElement loginBtn;
	
	public void enterEmail(String emailId)
	{
		email.clear();
		email.sendKeys(emailId);
	}
	
	public void enterPassword(String pwd)
	{
		passwd.clear();
		passwd.sendKeys(pwd);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
	
//	########################################## forget password ####################
	@FindBy(css=".orangehrm-login-forgot>p")
	WebElement ForgotPass;
	
	public boolean isForgotPasswordLinkDisplayed()
	{
		return ForgotPass.isDisplayed();
	}
	
	 public boolean isForgotPasswordLinkEnabled()
	 {
	        return ForgotPass.isEnabled();
	 }
	
	public void clickOnForgotPassword()
	{
		ForgotPass.click();
	}
	
}
