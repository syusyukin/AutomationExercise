package model.page;

import model.person.Card;
import org.openqa.selenium.By;

import static utils.DriverUtils.findElement;

public class PaymentPage extends BasePage{
    By cardNameField = By.xpath("//input[@data-qa=\"name-on-card\"]");
    By cardNumberField = By.xpath("//input[@data-qa=\"card-number\"]");
    By cvcForm = By.xpath("//input[@data-qa=\"cvc\"]");
    By expirationMonthForm = By.xpath("//input[@data-qa=\"expiry-month\"]");
    By expirationYearForm = By.xpath("//input[@data-qa=\"expiry-year\"]");
    By payAndConfirmButton = By.xpath("//*[@id=\"submit\"]");

    public PaymentSuccessPage payAndConfirm(Card card){
        findElement(cardNameField).sendKeys(card.getName());
        findElement(cardNumberField).sendKeys(card.getNumber());
        findElement(cvcForm).sendKeys(card.getCcv());
        findElement(expirationMonthForm).sendKeys(card.getExpirationMonth());
        findElement(expirationYearForm).sendKeys(card.getExpirationMonth());
        findElement(payAndConfirmButton).click();
        return new PaymentSuccessPage();
    }
}
