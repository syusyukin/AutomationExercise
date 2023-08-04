package model.page;

import org.openqa.selenium.By;

import static utils.DriverUtils.findElement;

public class PaymentSuccessPage extends BasePage{
    By orderConfirmedMessage = By.xpath("//*[@data-qa=\"order-placed\"]");

    public boolean isOrderPlaced(){
        return findElement(orderConfirmedMessage).isDisplayed();
    }
}
