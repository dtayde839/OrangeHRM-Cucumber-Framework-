package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage 
{
	WebDriver driver;
	 
	
	public PIMPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css=".orangehrm-header-container>button")
	WebElement addButton;
	
	@FindBy(tagName="input")
	private List<WebElement> empIDSearch;
	
	@FindBy(css=".oxd-form-actions>button[type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="(//input)[2]")
	WebElement empName;
	
	@FindBy(css=".oxd-table-card:nth-child(1)>.oxd-table-row>.oxd-table-cell:nth-child(3)>div")
	WebElement empFname;
	
	@FindBy(css=".oxd-form-row:nth-child(1)>.oxd-grid-4>.oxd-grid-item:nth-child(3)>.oxd-input-group>div:nth-child(2)")
	WebElement empStatus;
	
	@FindBy(xpath="//*[contains(text(),'Full-Time Contract')]")
	WebElement fullTimeCon;
	
	@FindBy(css="div>span.oxd-text")
	WebElement recordsFound;
	
	public void clickOnAddButton()
	{  
		addButton.click();
	}
	
	public void searchEmployeeId(String empID)
	{
		if(empIDSearch.size() > 2)
		{
			empIDSearch.get(2).sendKeys(empID);
		}
	}
	
	public void searchEmpName(String eName)
	{
		empName.sendKeys(eName);
	}
	
	public void clickOnSearchBtn() throws InterruptedException
	{
		submitBtn.click();
		Thread.sleep(3);
	}
	
	public String empFirstName()
	{
		return empFname.getText();
	}
	
	public void clickEmpStatus()
	{
		empStatus.click();
	}
	
	public void clickOnFullTimeContract()
	{
		fullTimeCon.click();
	}
	
	public String recordisDisplayedText()
	{
		return recordsFound.getText();
	}
}
