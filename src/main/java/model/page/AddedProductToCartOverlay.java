package model.page;

import base_tests.BaseTest;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static base_tests.BaseTest.driver;
import static utils.DriverUtils.findElement;

@NoArgsConstructor
public class AddedProductToCartOverlay {
    By viewCartLink = By.xpath("//*[@class=\"modal-content\"]//a[@href=\"/view_cart\"]");
    public CartPage navigateToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        return new CartPage();
    }
}
