package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tests.BaseTest;

public class Test extends BaseTest{
	
	WebDriver driver;

	@Test(description="verify user is able to login successfully",priority=1)
	@Parameters({ "email", "password" })
	public void login(String email, String password) throws InterruptedException {
		login.enterEmail(email);
		login.enterPassword(password);
		login.clickSubmit();
	}

	@Test(description="verify user is able to select test and apply discount",priority=2)
	public void selectTest() throws InterruptedException {
		homepage.scrollToCostCalculator();
		homepage.addTestForPatient();
		homepage.selectDiscount();
	}

	@Test(description="verify user is able to add patient",priority=3)
	public void addPatient() throws InterruptedException {
		patientPage.clickPatients();
		patientPage.clickAddPatientButton();
		patientPage.enterPatientContactDetails("saurabh", "abc@xyz.com", "9999999999");
		
	}
	
}
