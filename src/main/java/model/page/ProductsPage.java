package model.page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static utils.DriverUtils.findElement;
import static base_tests.BaseTest.driver;

public class ProductsPage extends BasePage {
    public ProductsPage() {
        //
    }

    @Getter
    AddedProductToCartOverlay addedProductToCartOverlay = new AddedProductToCartOverlay();
    By searchProductInputField = By.xpath("//*[@id=\"search_product\"]");
    By submitSearchButton = By.xpath("//*[@id=\"submit_search\"]");

    private By getProductLocator(String product) {
        return By.xpath("//*[contains(text(),'" + product + "')]");
    }

    private By getAddToCartButton(String product) {
        return By.xpath("//p[text() = '" + product + "']/following-sibling::a[contains(@class, 'add-to-cart')]");
    }

    public void searchProduct(String product) {
        findElement(searchProductInputField).sendKeys(product);
        findElement(submitSearchButton).click();
    }

    public boolean isProductOnScreen(String product) {
        return findElement(getProductLocator(product)).isDisplayed();
    }

    public void addProductToCart(String product) {
        var searchedProduct = findElement(getProductLocator(product));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 600);
        actions.moveToElement(searchedProduct).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.moveToElement(findElement(getAddToCartButton(product))).perform();
        actions.click().perform();
    }
}
