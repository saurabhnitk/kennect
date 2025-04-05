package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientsPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Patients']")
	WebElement patients;

	@FindBy(xpath="//span[text()='Add Patient']")
	WebElement addPatientButton;
	
	@FindBy(name="name")
	WebElement nameField;
	
	@FindBy(name="email")
	WebElement emailField;
	
	@FindBy(name="phone")
	WebElement phoneField;
	
	@FindBy(xpath="//span[text()='cancel']/../following-sibling::button")
	WebElement generalDetailsButton;
	
	public PatientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickPatients() {
		patients.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(addPatientButton));
	}

	public void clickAddPatientButton() {
		addPatientButton.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(nameField));
	}
	
	public void enterPatientContactDetails(String name,String email,String phone) {
		nameField.sendKeys(name);
		emailField.sendKeys(email);
		phoneField.sendKeys(phone);
	}
	
	public void clickGeneralDetailsButton() {
		generalDetailsButton.click();
	}
}
