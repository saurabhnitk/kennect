package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[text()='Dashboard']")
	WebElement dashboard;
	
	@FindBy(xpath="//div[text()='Remaining work']")
	WebElement remainingWork;
	
	@FindBy(xpath="//div[text()='Test Cost Calculator']")
	WebElement testCostCalculator;

	@FindBy(id="patient-test")
	WebElement addTestField;

	@FindBy(xpath="//label[text()='Discount']/following-sibling::div")
	WebElement discountField;
	
	@FindBy(xpath="//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li")
	List<WebElement> discountOptions;
		
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitTillDashboardIsDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(dashboard)); 
		wait.until(ExpectedConditions.visibilityOf(remainingWork));
	}
	
	public void scrollToCostCalculator() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", testCostCalculator);		
	}
	
	public void addTestForPatient() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.visibilityOf(addTestField));
		Actions a = new Actions(driver);
		a.sendKeys(addTestField,"AFP").perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
	}

	public void selectDiscount(String discount) throws InterruptedException {
		discountField.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(discountOptions));
		int n = discountOptions.size();
		for(int i=0;i<n;i++) {
			String s = discountOptions.get(i).getText();
			if(s.contains(discount)) {
				discountOptions.get(i).click();
				break;
			}
		}
	}
	
}
