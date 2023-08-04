package model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.DriverUtils.findElement;

public class AccountCreatedPage extends BasePage{
    public AccountCreatedPage(){
    }

    By accountCreatedMessage = By.xpath("//*[@data-qa=\"account-created\"]");
    By continueButton = By.xpath("//*[@data-qa=\"continue-button\"]");

    public boolean isAccountCreated(){
        return findElement(accountCreatedMessage).isDisplayed();
    }
    public HomePage clickContinue(){
       findElement(continueButton).click();
       return new HomePage();
    }
}
