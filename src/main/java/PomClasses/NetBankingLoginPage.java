package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NetBankingLoginPage {

	public NetBankingLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@title='Netbanking Login'] ")
	private WebElement netBankingLoginFrame;

	public WebElement getNetBankingLoginFrame() {
		return netBankingLoginFrame;
	}

	@FindBy(xpath = "//input[@id='User ID'] ")
	private WebElement userIdTextField;

	public WebElement getUserIdTextField() {
		return getUserIdTextField();

	}
	@FindBy(xpath = "//input[@id='Password']] ")
	private WebElement passwordTextField;

	public WebElement getpasswordTextField() {
		return getpasswordTextField();
}
	@FindBy(xpath = "//button[@id='Submit']] ")
	private WebElement submitButton;

	public WebElement getSubmitButton() {
		return submitButton;
	}

		
	
}
