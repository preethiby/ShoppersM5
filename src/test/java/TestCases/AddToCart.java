package TestCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PomClasses.AccountSettingPage;
import PomClasses.AddressFormPage;
import PomClasses.HomePage;
import PomClasses.MyAddress;
import PomClasses.MyProfilePage;
import PomClasses.NetBankingPage;
import PomClasses.OrderConfirm;
import PomClasses.PaymentMethod;
import PomClasses.TshirtPage;
import PomClasses.addToCartPage;
import PomClasses.addressPage;
import Utilities.BaseClass;

@Listeners(Utilities.ListenersUtility.class)

public class AddToCart extends BaseClass {

	@Test(priority=2,dataProvider = "dataProviderAddress")
	public void Tc_AddAddress_001_Test(String home, String house_office, String street, String landmark, String country,
			String state, String city, String Dpin, String mobN) throws Throwable {
		System.out.println("add address");
		
		Thread.sleep(5000);

		HomePage hp = new HomePage(driver);
		hp.javaScriptClick(driver);
		// WebElement accountSetting=hp.getAccountSettingIcon();
		// accountSetting.click();

		AccountSettingPage as = new AccountSettingPage(driver);
		as.getMyProfileLink().click();

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/my-profile/my-profile-info");

		System.out.println(" The my profile page is opened");

		MyProfilePage mp = new MyProfilePage(driver);
		mp.getAddAddressLink().click();

		MyAddress ma = new MyAddress(driver);
		ma.getAddAddressformbutton().click();

		AddressFormPage afp = new AddressFormPage(driver);
		afp.getNameTextField().sendKeys(home);
		afp.getHouseOfficeInformationTextField().sendKeys(house_office);
		afp.getStreetInformationTextField().sendKeys(street);
		afp.getLandMarkTextField().sendKeys(landmark);
		WebElement countryDropDown = afp.getCountryDropDown();
		drpu.selectDropDownByVisibleText(country, countryDropDown);
		WebElement StateDropDown = afp.getStateDropDown();
		drpu.selectDropDownByVisibleText(state, StateDropDown);
		WebElement CityDropDown = afp.getCityDropDown();
		drpu.selectDropDownByVisibleText(city, CityDropDown);
		afp.getPincodeTextField().sendKeys(Dpin);
		afp.getPhoneNumberTextField().sendKeys(mobN);
		afp.getAddAddressButton().click();

		
	}

	@DataProvider
	public Object[][]dataProviderAddress() throws Throwable {
		return data.accessAllAddress();
	}

	@Test(dependsOnMethods = "Tc_AddAddress_001_Test")

	public void Tc_EndToEndCashOnDelivery_Test() throws Throwable {
		Thread.sleep(3000);

		System.out.println("First test case");
		String titleHomePage = driver.getTitle();
		Assert.assertEquals(titleHomePage, "ShoppersStack | Home");

		HomePage hp = new HomePage(driver);
		Thread.sleep(5000);
		WebElement menLink = hp.getmenManuLink();

		wu.mouseOverAction(driver, menLink);

		hp.getTshirtPopUpLink().click();

		TshirtPage tsp = new TshirtPage(driver);
		String currentUrl = driver.getCurrentUrl();

		Assert.assertEquals(currentUrl, "https://www.shoppersstack.com/sub-category/men-tshirt");
		wu.mouseOverAction(driver, tsp.gettshirtTopLink());

		tsp.getlevisMenRegularfitproduct_AddToCartButton().click();
		hp.getaddToCartLink().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/cart");
		System.out.println("The cart page is opened");

		addToCartPage ac = new addToCartPage(driver);
		String leviseProductTest = ac.getLevisProduct().getText();
		Assert.assertEquals(leviseProductTest, "Levis Mens Regular Fit Tee");
		System.out.println("the product is added to cart");

		ac.getBuyNowButtonInAddToCartPage().click();
		String addresPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(addresPageUrl, "https://www.shoppersstack.com/selectaddress");
		System.out.println("the product is address page is displayed");

		addressPage ap = new addressPage(driver);
		ap.getlovebirdAddress().click();
		ap.getproceedButton().click();
		
		PaymentMethod pm=new PaymentMethod(driver);
		pm.getcashOnDeliveryRadioButton().click();
		pm.getproceedButton().click();
		
		OrderConfirm oc= new OrderConfirm(driver);
		Assert.assertEquals(oc.getOrderConfirmedText().getText(),"Order Confirmed");
		System.out.println("The order got confirmed in cash on delivery");
	}
	
	@Test(priority=2,dependsOnMethods="Tc_AddAddress_001_Test")
	public void EndToEnd_NetBanking() throws Throwable {
		

		System.out.println("First test case");
		String titleHomePage = driver.getTitle();
		Assert.assertEquals(titleHomePage, "ShoppersStack | Login");

		HomePage hp = new HomePage(driver);   //HomePage class
		Thread.sleep(5000);
		WebElement menLink = hp.getmenManuLink();
        wu.mouseOverAction(driver, menLink);
        hp.getTshirtPopUpLink().click();

		TshirtPage tsp = new TshirtPage(driver);   //TshirtPage class
		String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.shoppersstack.com/sub-category/men-tshirt");
		wu.mouseOverAction(driver, tsp.gettshirtTopLink());

		tsp.getlevisMenRegularfitproduct_AddToCartButton().click();
		hp.getaddToCartLink().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/cart");
		System.out.println("The cart page is opened");

		addToCartPage ac = new addToCartPage(driver);       //addToCartPage class 
		String leviseProductTest = ac.getLevisProduct().getText();
		Assert.assertEquals(leviseProductTest, "Levis Mens Regular Fit Tee");
		System.out.println("the product is added to cart");
        ac.getBuyNowButtonInAddToCartPage().click();
		String addresPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(addresPageUrl, "https://www.shoppersstack.com/selectaddress");
		System.out.println("the product is address page is displayed");

		addressPage ap = new addressPage(driver);      //AddressPage class
		ap.getlovebirdAddress().click();
		ap.getproceedButton().click();
		
		PaymentMethod pm=new PaymentMethod(driver);      //Payment Method class
		pm.getNetBankingButton().click();
		pm.getproceedButton().click();
		
		NetBankingPage np= new NetBankingPage(driver);               //NetBankingLoginPage Class
		driver.switchTo().frame(np.getnetBankingFrameTag()); //iframe 
		
		np.getIDHC_radioButton().click();
		np.getSubmitButton().click();
		driver.switchTo().defaultContent(); 
		
	/**	NetBankingLoginPage nlp=new NetBankingLoginPage(driver);   //NetBankingLoginPage Class
		driver.switchTo().frame(nlp.getNetBankingLoginFrame());
		
		nlp.getUserIdTextField().sendKeys("abctest@gmail.com");
		nlp.getpasswordTextField().sendKeys("FYrpyz3");
		nlp.getSubmitButton().click();**/
		
	}
	

//	@Test
//	public void Tc_AddToCart_003_Test() throws Throwable {
//		Thread.sleep(5000);
//
//		System.out.println("Third test case");
//
//	}
}
