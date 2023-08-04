import base_tests.BaseTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.factory.DataFactory;
import model.page.*;
import model.person.RegistrationData;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.extent_reports.ExtentManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static model.page.HomePage.HOME_PAGE_URL;
import static utils.extent_reports.ExtentTestManager.startTest;

public class Tests extends BaseTest {
    @BeforeClass
    private static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void declareDriver() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get(HOME_PAGE_URL);
    }

    @AfterTest(alwaysRun = true)
    void clear() {
        createdAccounts.forEach(registrationData -> deleteAccount(registrationData.getEmail(), registrationData.getPassword()));
        driver.close();
    }

    @AfterMethod
    void closeDriver() {
        driver.close();
    }

    @DataProvider(name = "registrationDataProvider")
    public Object[][] provideRegistrationData() {
        DataFactory dataFactory = new DataFactory();
        return new Object[][]{{dataFactory.createRegistrationData()}};
    }

    @DataProvider(name = "searchProductProvider")
    public Object[][] provideSearchProductData() {
        return new Object[][]{{"Fancy Green Top"}};
    }

    @Test(dataProvider = "registrationDataProvider")
    public void registerUserTest(RegistrationData registrationData) {
    startTest("registerUserTest", "Test that validates user can register a new account");
        AccountCreatedPage accountCreatedPage = createAccount(registrationData, new HomePage());
        Assert.assertTrue(accountCreatedPage.isAccountCreated());
        var hotHomePage = accountCreatedPage
                .clickContinue()
                .getHeaderMenu()
                .logOut()
                .login(registrationData.getEmail(), registrationData.getPassword());
        Assert.assertTrue(hotHomePage.getHeaderMenu().isLoggedIn(registrationData.getName()));
    }


    @Test(dataProvider = "searchProductProvider")
    public void searchForProductTest(String product) {
        startTest("searchForProductTest", "Test that validates user can search for products");
        ProductsPage productsPage = searchProduct(product, new HomePage());
        Assert.assertTrue(productsPage.isProductOnScreen(product));
    }


    @Test(dataProvider = "searchProductProvider")
    public void addToCartTest(String product) {
        startTest("addToCartTest", "Test that validates user can add products to cart");
        ProductsPage productsPage = searchProduct(product, new HomePage());
        productsPage.addProductToCart(product);
        CartPage cartPage = productsPage
                .getAddedProductToCartOverlay()
                .navigateToCart();
        Assert.assertTrue(cartPage.isProductInCart(product));
    }

    @Test(dataProvider = "searchProductProvider")
    public void checkoutTest(String product) {
        startTest("checkoutTest", "Test that validates user can purchase products");
        HomePage homePage = new HomePage();
        var registrationData = new DataFactory().getExistingAccountData();
        homePage = homePage.getHeaderMenu().navigateToSignUpLoginPage().login(registrationData.getEmail(), registrationData.getPassword());
        var productPage = searchProduct(product, homePage);
        productPage.addProductToCart(product);
        CartPage cartPage = productPage
                .getAddedProductToCartOverlay()
                .navigateToCart();
        Assert.assertTrue(cartPage
                .goToCheckout()
                .placeOrder()
                .payAndConfirm(new DataFactory().getCard())
                .isOrderPlaced());
    }

    protected void deleteAccount(String email, String password) {
        declareDriver();
        HomePage homePage = new HomePage();
        homePage
                .getHeaderMenu()
                .navigateToSignUpLoginPage()
                .login(email, password).getHeaderMenu()
                .deleteAccount();
    }

}
