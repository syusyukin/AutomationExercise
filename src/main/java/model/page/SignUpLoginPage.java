package model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.DriverUtils.findElement;

public class SignUpLoginPage extends BasePage {

    public SignUpLoginPage() {
    }

    By signupNameInputField = By.xpath("//input[@data-qa=\"signup-name\"]");
    By emailSignupInputField = By.xpath("//input[@data-qa=\"signup-email\"]");
    By signUPButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    By emailLoginInputField = By.xpath("//input[@data-qa=\"login-email\"]");
    By passwordLoginInputField = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");


    public SignUpPage startSignUP(String username, String email){
        findElement(signupNameInputField).sendKeys(username);
        findElement(emailSignupInputField).sendKeys(email);
        findElement(signUPButton).click();
        return new SignUpPage();
    }
    public HomePage login(String email, String password){
        findElement(emailLoginInputField).sendKeys(email);
        findElement(passwordLoginInputField).sendKeys(password);
        findElement(loginButton).click();
        return new HomePage();
    }

}
