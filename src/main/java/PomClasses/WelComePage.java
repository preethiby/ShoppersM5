package PomClasses;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;

public class WelComePage {

	public WebDriver driver;

	// Initialization
	public WelComePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// Declaration
	@FindAll({ @FindBy(id = "loginBtn"), @FindBy(xpath = "//button[text()='Login']") })
	private WebElement MainLoginButton;
	
	// getter
	public WebElement getMainLoginButton() {
		return MainLoginButton;
	}
	
	//Here am using javascript executer because above xpath is not find locater accuratly
	public void javaScriptClick(WebDriver driver) { 
		WebElement ele = driver.findElement(By.xpath("//button[text()='Login']"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("aeguments[0].click();", ele);

	
	}

}
