package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.Login;
import pageObjects.PatientsPage;

public class BaseTest {
	
	public WebDriver driver;
	
	public Login login; 
	public HomePage homepage;
	public PatientsPage patientPage;
	public String browserName;

	@BeforeClass
	public void setUp() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//GlobalData.properties");
		prop.load(fis);
		if(System.getProperty("browser") != null) {
			browserName = System.getProperty("browser");
			
		}else {
			browserName = prop.getProperty("browser"); 
		}
		if(browserName.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new EdgeDriver();
		}
       	driver.manage().window().maximize();
    	driver.get("https://gor-pathology.web.app/");
    	login = new Login(driver);
    	homepage = new HomePage(driver);
    	patientPage = new PatientsPage(driver);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports" + testCaseName + ".png";
	}

}
