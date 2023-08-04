package model.page;

import org.openqa.selenium.By;

import static utils.DriverUtils.findElement;

public class CartPage extends BasePage {
    By proceedToCheckoutButton = By.xpath("//a[@class=\"btn btn-default check_out\"]");

    public By getProductInCart(String product) {
        return By.xpath("//*[@id=\"cart_info_table\"]//*[contains(text(),'" + product + "')]");
    }

    public boolean isProductInCart(String product) {
        return findElement(getProductInCart(product)).isDisplayed();
    }

    public CheckoutPage goToCheckout() {
        findElement(proceedToCheckoutButton).click();
        return new CheckoutPage();
    }
}
