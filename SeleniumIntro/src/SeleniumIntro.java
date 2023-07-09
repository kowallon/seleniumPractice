
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;


public class SeleniumIntro {
	
	public static String baseUrl = "https://demoqa.com/books";
	public static String user1 = "cyTester";
	public static String password1 = "cyTest123!";
	public static WebDriver driver = new ChromeDriver();
	public static String formsUrl = "https://demoqa.com/automation-practice-form";
	public static String selectsUrl = "https://demoqa.com/select-menu";
	
	
	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
		//Can be commented because of Selenium Manager
		//addBook();
		
		//selects();
		
		//forms();
		//checboxes();
		
		alerts();
		
		//driver.quit();		
	}

	public static void addBook() {
		CommonMethods.login(user1, password1);
		CommonMethods.waitForElement();
		CommonMethods.clickXPathElement("//a[contains(text(), 'Git')]");
		driver.navigate().back();
				
		CommonMethods.checkIfXPathElementHasCorrectText("//div[@id='searchBox-wrapper']//button", "Log out");
	}
	
	public static void selects() {
		CommonMethods.login(user1, password1);
		driver.get(selectsUrl);
		//static select
		WebElement colorDropdown = driver.findElement(By.id("oldSelectMenu"));
		Select colorSelection = new Select(colorDropdown);
		
		List<WebElement> colors = driver.findElements(By.xpath("//select[@id='oldSelectMenu']/option"));
		int randomColorIndex = (int) Math.floor(Math.random())*colors.size();
			System.out.println(colors.get(randomColorIndex).getText());
			
		colorSelection.selectByVisibleText(colors.get(randomColorIndex).getText());
				
		//multiSelect drop
		driver.findElement(By.xpath(" (//div[@class=' css-2b097c-container'])[3]")).click();
		driver.findElement(By.xpath(" (//*[.='Green'])[2]")).click();
		driver.findElement(By.xpath(" (//*[.='Blue'])[2]")).click();;
				
//		//multiselect standard
		WebElement carList = driver.findElement(By.id("cars"));
		Select carSelection = new Select(carList);
		carSelection.selectByIndex(0);
		carSelection.selectByIndex(2);
		
//		//dynamic dropdown
		driver.findElement(By.xpath("(//div[@class=' css-yk16xz-control'])[1]")).click();
		driver.findElement(By.xpath("//div[.='Group 2, option 2']")).click();
		
	}
	
	public static void forms() {			
		driver.get(formsUrl);
		
		//contact data
		driver.findElement(By.id("firstName")).sendKeys("Henry");
		driver.findElement(By.id("lastName")).sendKeys("Jones Jr.");
		driver.findElement(By.id("userEmail")).sendKeys("IndianaJones@MarshallColleage.com");
		driver.findElement(By.xpath("(//div[@class='custom-control custom-radio custom-control-inline'])[1]")).click();
		driver.findElement(By.id("userNumber")).sendKeys("1992331882");
		driver.findElement(By.id("subjectsInput")).sendKeys("history");
		driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
		
		//Calendar
		driver.findElement(By.id("dateOfBirthInput")).click();
		driver.findElement(By.className("react-datepicker__year-select")).click();
		//randomYear
		Random random = new Random();
        int randomYear = random.nextInt(54) + 1950; // Generate a random number between 0 and 53, then add 1950
        System.out.println(randomYear);
        driver.findElement(By.xpath("//option[@value='"+randomYear+"']")).click();
        //randomMonth
        driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")).click();
        int randomMonth = random.nextInt(12) + 1;
        CommonMethods.waitForElement();
        driver.findElement(By.xpath("(//select[@class='react-datepicker__month-select']/option)["+randomMonth+"]")).click();
        //randomDay
        int randomWeek = random.nextInt(5) + 1;
        int randomDay = random.nextInt(7) + 1;
        driver.findElement(By.xpath("(//div[@class='react-datepicker__week'])["+randomWeek+"]/div["+randomDay+"]")).click();
		CommonMethods.waitSeconds(3);
				
		//Checkboxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//label[contains(@for, 'hobbies-checkbox')]"));
		for(WebElement checkbox : checkboxes) {
			if(!checkbox.isSelected()) {
				checkbox.click();
			}
			else {
				break;
			}
		}
		
		//City dropdowns
		CommonMethods.waitSeconds(3);
		CommonMethods.waitForElement();
		driver.findElement(By.xpath("(//div[.='Select State'])")).click();
		CommonMethods.waitSeconds(1);
		driver.findElement(By.xpath("(//div[.='NCR'])")).click();
		CommonMethods.waitSeconds(1);
		driver.findElement(By.xpath("(//div[.='Select City'])")).click();
		CommonMethods.waitSeconds(1);
		driver.findElement(By.xpath("(//div[.='Delhi'])")).click();
		
		driver.findElement(By.id("submit")).click();
		CommonMethods.waitForElement();
		Assert.assertTrue(driver.findElement(By.className("modal-content")).isDisplayed());
		
	}
	
	public static void checboxes() {		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement check = driver.findElement(By.xpath("(//input[@id='checkBoxOption1'])[1]"));
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("num of checkboxes: " + checkboxes.size());
		check.click();
		Assert.assertEquals(check.isSelected(), true);
		check.click();
		Assert.assertEquals(check.isSelected(), false);
	}
	
	public static void alerts() {
		driver.get("https://demoqa.com/alerts");
		driver.findElement(By.id("alertButton")).click();
		CommonMethods.waitForElement();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
}

