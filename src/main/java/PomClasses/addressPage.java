package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addressPage {

	public WebDriver driver;

	public addressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/addressform']")
	private WebElement addAddressForm;

	public WebElement getAddAddressForm() {
		return addAddressForm;
	}

	@FindBy(xpath = "//strong[text()='LOveBirds']/../../..//input")
	private WebElement lovebirdAddress;

	public WebElement getlovebirdAddress() {
		return lovebirdAddress;

	}

	@FindBy(xpath = "//button[text()='Proceed']")
	private WebElement proceedButton;

	public WebElement getproceedButton() {
		return proceedButton;

	}
}
