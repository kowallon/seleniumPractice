import org.openqa.selenium.By;
import org.testng.Assert;

public class eComMethods extends eCom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void addProductToCart(String productName) {
		driver.findElement(By.xpath("//h4[contains(text(),'"+ productName +"')]/..//button")).click();
	}
	
	public static void incrementItemCount(String productName) {
		driver.findElement(By.xpath("//h4[contains(text(),'"+ productName +"')]/..//a[@class='increment']")).click();
	}
	
	public static void decrementItemCount(String productName) {
		driver.findElement(By.xpath("//h4[contains(text(),'"+ productName +"')]/..//a[@class='decrement']")).click();
	}
	
	public static void proceedToTheBasker() {
		driver.findElement(By.className("cart-icon")).click();
		driver.findElement(By.xpath("//button[.='PROCEED TO CHECKOUT']")).click();
	}
	
	public static void addPromotion() {
		float totalPrice = Float.parseFloat(driver.findElement(By.className("totAmt")).getText());
		System.out.println(totalPrice);
		
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		
		
		CommonMethods.waitSeconds(6);
		float reducedPrice = Float.parseFloat(driver.findElement(By.className("discountAmt")).getText());
		System.out.println(reducedPrice);
		
		boolean priceReduced = reducedPrice < totalPrice;
		
		Assert.assertTrue(priceReduced);
	}
}
