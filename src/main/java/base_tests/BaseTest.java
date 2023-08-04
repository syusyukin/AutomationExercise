package base_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import model.page.AccountCreatedPage;
import model.page.BasePage;
import model.page.HomePage;
import model.page.ProductsPage;
import model.person.RegistrationData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static model.page.HomePage.HOME_PAGE_URL;

public class BaseTest {
    @Getter
    public static WebDriver driver;

    public static List<RegistrationData> createdAccounts = new ArrayList<>();



    protected AccountCreatedPage createAccount(RegistrationData registrationData, BasePage basePage) {
        var accountCreatedPage = basePage
                .getHeaderMenu()
                .navigateToSignUpLoginPage()
                .startSignUP(registrationData.getName(), registrationData.getEmail())
                .signUp(registrationData);
        createdAccounts.add(registrationData);
        return accountCreatedPage;
    }



    protected ProductsPage searchProduct(String product, BasePage basePage) {
        var productsPage = basePage
                .getHeaderMenu()
                .navigateToProductsPage();
        productsPage.searchProduct(product);
        return productsPage;
    }

}
