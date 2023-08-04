package model.page;

import org.openqa.selenium.By;

import static utils.DriverUtils.findElement;

public class HeaderMenu {

    By loginSignUpLink = By.xpath("//a[@href=\"/login\"]");
    By productsLink = By.xpath("//a[@href=\"/products\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By loggedInField = By.xpath("//*[@class=\"fa fa-user\"]/..");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");

    public SignUpLoginPage navigateToSignUpLoginPage(){
        findElement(loginSignUpLink).click();
        return new SignUpLoginPage();
    }

    public ProductsPage navigateToProductsPage(){
        findElement(productsLink).click();
        return new ProductsPage();
    }
    public SignUpLoginPage logOut(){
        findElement(logoutLink).click();
        return new SignUpLoginPage();
    }

    public void deleteAccount(){
        findElement(deleteAccountLink).click();
    }

    public boolean isLoggedIn(String username){
        return findElement(loggedInField).getText().equals("Logged in as " + username);
    }
}
