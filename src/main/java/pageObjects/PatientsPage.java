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

	@FindBy(name="height")
	WebElement heightField;

	@FindBy(name="weight")
	WebElement weightField;
	
	@FindBy(id="mui-component-select-gender")
	WebElement genderField;
	
	@FindBy(xpath="//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li")
	List<WebElement> genderOptions;
	
	@FindBy(name="age")
	WebElement ageField;
	
	@FindBy(name="systolic")
	WebElement systolicField;

	@FindBy(name="diastolic")
	WebElement diastolicField;	
	
	@FindBy(xpath="(//span[text()='Add Tests'])[2]")
	WebElement addTestsButton;
	
	@FindBy(xpath="//div[text()='Test Cost Calculator']")
	WebElement testCostCalculator;
	
	@FindBy(xpath="//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li")
	List<WebElement> commissionOptions;
	
	@FindBy(id="mui-component-select-doctor_commission")
	WebElement commissionField;
	
	@FindBy(id="patient-tests-labs")
	WebElement labsField;
	
	@FindBy(name="doctor_name")
	WebElement doctorField;
	
	@FindBy(xpath="//span[text()='add_box']")
	WebElement addEquipmentIcon;
	
	@FindBy(xpath="//tr[@class='MuiTableRow-root']/td//*[local-name()='svg']")
	WebElement equipmentNameDropdown;
	
	@FindBy(xpath="//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li")
	List<WebElement> equipmentOptions;
	
	@FindBy(xpath="//tr[@class='MuiTableRow-root']/td[4]/div/button[1]")
	WebElement addIcon;
	
	@FindBy(xpath="//div[text()='Patient added successfully.']")
	WebElement patientAddedText;
	
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
	}
	
	public void enterPatientContactDetails(String name,String email,String phone) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(nameField));
		nameField.sendKeys(name);
		emailField.sendKeys(email);
		phoneField.sendKeys(phone);
	}
	
	public void clickGeneralDetailsButton() {
		generalDetailsButton.click();
	}
	
	public void enterGeneralDetails(String height,String weight,String age,String systolic,String diastolic) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(heightField));
		heightField.sendKeys(height);
		weightField.sendKeys(weight);
		ageField.sendKeys(age);
		systolicField.sendKeys(systolic);
		diastolicField.sendKeys(diastolic);
	}
	
	public void selectGender(String gender) {
		genderField.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(genderOptions));
		int n = genderOptions.size();
		for(int i=0;i<n;i++) {
			String s = genderOptions.get(i).getText();
			if(s.contains(gender)) {
				genderOptions.get(i).click();
				break;
			}
		}
	}
	
	public void scrollToAddTestButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", addTestsButton);		
	}
	
	public void clickAddTestsButton() {
		addTestsButton.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(testCostCalculator));
	}
	
	public void selectCommission(String commission) {
		commissionField.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(commissionOptions));
		int n = commissionOptions.size();
		for(int i=0;i<n;i++) {
			String s = commissionOptions.get(i).getText();
			if(s.contains(commission)) {
				commissionOptions.get(i).click();
				break;
			}
		}
	}
	
	public void selectLab() throws InterruptedException {
		Actions a = new Actions(driver);
		a.sendKeys(labsField, "Sion").perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	public void selectDoctor() throws InterruptedException {
		Actions a = new Actions(driver);
		a.click(doctorField).perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
	}
	
	public void clickAddEquipment(String equipment) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", addEquipmentIcon);		
		addEquipmentIcon.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(equipmentNameDropdown));	
		equipmentNameDropdown.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(equipmentOptions));
		int n = equipmentOptions.size();
		for(int i=0;i<n;i++) {
			String s = equipmentOptions.get(i).getText();
			if(s.contains(equipment)) {
				equipmentOptions.get(i).click();
				break;
			}
		}
	}
	
	public void clickAddIcon() throws InterruptedException {
		addIcon.click();
		Thread.sleep(3000);
	}
	
	public String getPatientAddedText() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(patientAddedText));	
		return patientAddedText.getText();
	}
}
