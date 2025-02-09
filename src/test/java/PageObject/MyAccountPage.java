package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage 
{
	WebDriver driver;
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
//	elements
	
	@FindBy(css="li.oxd-userdropdown")
	WebElement userProfile;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	@FindBy(linkText="Admin")
	WebElement admin;
	
	@FindBy(linkText="PIM")
	WebElement pim;
	
//	methods
	
	public void clickOnUserProfile()
	{
		userProfile.click();
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}
	
	public void clickOnAdminSection()
	{
		admin.click();
	}
	
	public void clickOnPIM()
	{
		pim.click();
	}
	
//	public WebElement getFirstAdminLinkByText(String linkText)
//	{
//		List<WebElement> links = driver.findElements(By.linkText(linkText));
//		
//		if(!links.isEmpty())
//		{
//			return links.get(0);
//		}
//		else
//		{
//			throw new RuntimeException("No link found with text: " +linkText);
//		}
//	}
//	
//	public void clickAdminFirstLinkByText(String linkText)
//	{
//		getFirstAdminLinkByText(linkText).click();
//	}
}
