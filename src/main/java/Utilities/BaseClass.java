package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomClasses.AccountSettingPage;
import PomClasses.HomePage;
import PomClasses.LoginPage;
import PomClasses.WelComePage;

public class BaseClass {
	public static WebDriver driver;
	public DataUtility data = new DataUtility();
	public WebDriverUtility wu=new WebDriverUtility();
	public DropDownUtility drpu=new DropDownUtility();

	@BeforeClass
	public void lanchingBrowser() throws Throwable {
		System.out.println("----------lanchingBrowser-----------");
		String BROWSER = data.dataFromPropertiesFile("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		String URL = data.dataFromPropertiesFile("url");
		driver.get(URL);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

	}

	@BeforeMethod
	public void loginToApplication() throws Throwable {
		System.out.println("----------login To application----------");
	
		WelComePage WLpage = new WelComePage(driver);
		Thread.sleep(5000);
		WLpage.getMainLoginButton().click();

		LoginPage Lpage = new LoginPage(driver);
		
		String emailId = data.dataFromPropertiesFile("email");
		Lpage.getEmailTextField().sendKeys(emailId);

		String password = data.dataFromPropertiesFile("password");
		Lpage.getPasswordTextField().sendKeys(password);

		Lpage.getLoginButton().click();

	}

	@AfterMethod
	public void logoutFromApplication() throws Throwable {
		System.out.println("----------logout From application----------");
		Thread.sleep(6000);

		HomePage Hpage = new HomePage(driver);
		Hpage.javaScriptClick(driver);

		AccountSettingPage ASpage = new AccountSettingPage(driver);
		ASpage.getLogOutIcon().click();

	}

	@AfterClass
	public void quitBrowser() {
		System.out.println("----------quite the Browser----------");
		driver.quit();

	}
}
