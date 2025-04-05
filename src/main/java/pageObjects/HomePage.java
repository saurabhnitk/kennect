package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[text()='Test Cost Calculator']")
	WebElement testCostCalculator;

	@FindBy(id="patient-test")
	WebElement addTestField;

	@FindBy(xpath="//label[text()='Discount']/following-sibling::div")
	WebElement discountField;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void scrollToCostCalculator() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", testCostCalculator);
		
	}
	
	public void addTestForPatient() {
		Actions a = new Actions(driver);
		a.sendKeys(addTestField,"AFP").perform();
	}

	public void selectDiscount() throws InterruptedException {
		Actions a = new Actions(driver);
		a.click(discountField).perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.ENTER).perform();
	}
}
