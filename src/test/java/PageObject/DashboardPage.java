package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage 
{
WebDriver ldriver;
	
	public DashboardPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div")
	WebElement timeatwork;
	
	public void isTimeAtWorkDisplayed()
	{
		timeatwork.isDisplayed();
	}
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/div/p")
	WebElement timeatworkText;
	
	public String getTimeatworkText()
	{
		return timeatworkText.getText();
	}
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div")
	WebElement myactions;
	
	public void isMyActionsDisplayed()
	{
		myactions.isDisplayed();
	}
	
	@FindBy(className="oxd-userdropdown-name")
	WebElement profile;
	
	public String getProfileName()
	{
		return profile.getText();
	}
	
	public void clickonUserProfile()
	{
		profile.click();
	}
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	public void logoutlinkisDisplayed()
	{
		logout.isDisplayed();
	}
	
	public void clickonLogout()
	{
		logout.click();
	}
}
