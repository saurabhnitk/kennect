package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tests.BaseTest;

public class Testcases extends BaseTest{
	
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
		patientPage.enterPatientContactDetails("saurabh", "abc070425@xyz.com", "2037070425");
		patientPage.clickGeneralDetailsButton();
		patientPage.enterGeneralDetails("162","63","28","116","80");
		patientPage.selectGender();
		patientPage.clickAddTestsButton();
		homepage.addTestForPatient();
		patientPage.selectLab();
		patientPage.selectDoctor();
		patientPage.selectCommission("10");
		patientPage.clickAddEquipment("injection");
		patientPage.clickAddIcon();
		patientPage.clickAddTestsButton();
	}
	
}
