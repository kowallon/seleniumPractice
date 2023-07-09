import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.By;



public class CommonMethods extends SeleniumIntro {

	public static void main(String[] args) {
		
	}
	
	public static void login(String userName, String userPassword) {
		driver.get(baseUrl);
		driver.findElement(By.id("login")).click();
		driver.findElement(By.xpath("//input[@placeholder='UserName']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(userPassword);
		waitSeconds(2);
		driver.findElement(By.id("login")).click();
	}
	
	public static void waitSeconds(int seconds) {
		long waitTime = seconds*1000;
		try{
			Thread.sleep(waitTime);
		}
		catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public static void waitForElement() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static void checkIfXPathElementHasCorrectText(String selector, String assertedText) {
		String extractedText = driver.findElement(By.xpath(selector)).getText();
		System.out.println(extractedText);
		Assert.assertEquals(extractedText, assertedText, "Text is not correct");
	}
	
	public static void clickXPathElement(String selector) {
		driver.findElement(By.xpath(selector)).click();
	}
	
	public static void checkIfElementIsDisplayed(String selector) {
		Assert.assertTrue(driver.findElement(By.xpath(selector)).isDisplayed());
	}
		
}
