package model.page;

import org.openqa.selenium.By;

import static utils.DriverUtils.findElement;

public class CheckoutPage extends BasePage{

    By placeOrderLink = By.xpath("//a[@href=\"/payment\"]");

    public PaymentPage placeOrder(){
        findElement(placeOrderLink).click();
        return new PaymentPage();
    }
}
