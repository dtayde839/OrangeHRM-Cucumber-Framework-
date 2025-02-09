package StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestToaster {

	public static void main(String[] args) {
		// oxd-toaster_1 id
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("PIM")).click();
		
//		driver.findElement(By.xpath("(//input)[2]")).sendKeys("Rahul");
//		driver.findElement(By.cssSelector(".oxd-form-actions>button[type='submit']")).click();
//		String text = driver.findElement(By.cssSelector(".oxd-table-card:nth-child(1)>.oxd-table-row>.oxd-table-cell:nth-child(3)>div")).getText();
//		System.out.println(text);
		//		String act_msg = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']")).getText();
//		System.out.println(act_msg);
//		List<WebElement> element = driver.findElements(By.xpath("//span[@class='oxd-text oxd-text--span']"));
//		
//		for(int i = 0; i < element.size(); i++)
//		{
//			System.out.println(i + element.get(i).getText());
//		}
		
		driver.findElement(By.cssSelector(".oxd-form-row:nth-child(1)>.oxd-grid-4>.oxd-grid-item:nth-child(3)>.oxd-input-group>div:nth-child(2)")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Full-Time Contract')]")).click();
		
		driver.findElement(By.cssSelector(".oxd-form-actions>button[type='submit']")).click();
		
		String text = driver.findElement(By.cssSelector("div>span.oxd-text")).getText();
		System.out.println(text);
		
		WebElement records = driver.findElement(By.cssSelector("div>span.oxd-text"));
//		Assert.assertTrue(records.contains("Record Found"), "Expected string does not contain the substring"); 
	}
}
