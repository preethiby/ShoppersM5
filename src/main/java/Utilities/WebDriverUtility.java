package Utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * Author: Preethi when we get Element click intercepted execution(when element
	 * is hidden by other element) then we will use java script click
	 * 
	 * @param driver
	 * @param ele
	 */

	public void javaScriptClick(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ele);
	}

	/**
	 * Author: Preethi
	 * 
	 * @param driver
	 * @param ele
	 * @param data
	 */

	public void javaScriptSendKeys(WebDriver driver, WebElement ele, String data) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].Value=arguments[1];", ele, data);
	}

	/**
	 * Author: Preethi
	 * 
	 * @param driver
	 * @param ele
	 */

	public void javaScriptScrollTillWebElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	/**
	 * Author: Preethi This method will scroll the webpage with given coordinates
	 * 
	 * @param driver
	 * @param xCoordinate
	 * @param yCoordinate
	 */

	public void javaScriptScrollByCoordinates(WebDriver driver, int xCoordinate, int yCoordinate) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(" + xCoordinate + "," + yCoordinate + ");");
	}

	/**
	 * Author: Preethi this method will highlight the WebElement border with 2xp red
	 * color
	 * 
	 * @param driver
	 * @param ele
	 */

	public void javaScriptHighLightWebElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("rguments[0].style.border='2px solid red';", ele);
	}

	/**
	 * Author: Preethi To perform mouse over operation on webelement
	 * 
	 * @param driver
	 * @param ele
	 */

	public void mouseOverAction(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

	}

	public void rightClick(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.contextClick(ele).perform();
	}

	public void doubleClick(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.doubleClick(ele).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement draggingElement, WebElement droppingElement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(draggingElement, droppingElement).perform();
	}

	public void clickAndHold(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.clickAndHold(ele).perform();
	}

	public void scrollToWebElementByActionClass(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.scrollToElement(ele).perform();
	}

	public void explicitlyWaitForelementToBeClickable(WebDriver driver, int timeDelay, String CompleteTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeDelay));
		wait.until(ExpectedConditions.titleIs(CompleteTitle));
	}

}
