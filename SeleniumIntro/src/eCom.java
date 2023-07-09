import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class eCom extends CommonMethods {

	public static String baseUrl = "https://rahulshettyacademy.com/seleniumPractise/#/";
	public static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
		buyProductsTest();

	}
	
	public static void buyProductsTest() {
		driver.get(baseUrl);
		CommonMethods.waitForElement();
		eComMethods.addProductToCart("Cucumber");
		
		CommonMethods.waitForElement();
		
		for(int i = 0; i<3 ; i++) {
			eComMethods.incrementItemCount("Tomato");
		}
		CommonMethods.waitForElement();
		eComMethods.addProductToCart("Tomato");
		
		eComMethods.proceedToTheBasker();
		
		CommonMethods.waitSeconds(3);
		
		eComMethods.addPromotion();
		
		driver.findElement(By.xpath("//button[.='Place Order']")).click();
		
		CommonMethods.waitSeconds(3);
		
		WebElement countryList = driver.findElement(By.tagName("select"));
		Select countrySelection = new Select(countryList);
		countrySelection.selectByValue("Peru");
		
		driver.findElement(By.tagName("input")).click();
		
		driver.findElement(By.xpath("//button[.='Proceed']")).click();
		
	}

}
