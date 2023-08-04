package model.page;

import model.person.RegistrationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.DriverUtils.findElement;

public class SignUpPage extends BasePage{

    public SignUpPage(){
    }

    By titleMr = By.xpath("//*[@id=\"uniform-id_gender1\"]");
    By titleMrs = By.xpath("//*[@id=\"uniform-id_gender2\"]");
    By passwordInputField = By.xpath("//*[@id=\"password\"]");
    By daySelectField = By.xpath("//*[@id=\"days\"]");
    By monthSelectField = By.xpath("//*[@id=\"months\"]");
    By yearSelectField = By.xpath("//*[@id=\"years\"]");
    By firstNameInputField = By.xpath("//*[@id=\"first_name\"]");
    By lastNameInputField = By.xpath("//*[@id=\"last_name\"]");
    By addressInputField = By.xpath("//*[@id=\"address1\"]");
    By stateInputField = By.xpath("//*[@id=\"state\"]");
    By cityInputField = By.xpath("//*[@id=\"city\"]");
    By zipcodeInputField = By.xpath("//*[@id=\"zipcode\"]");
    By mobileNumberInputField = By.xpath("//*[@id=\"mobile_number\"]");
    By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");

    private void setDay(String day){
        findElement(daySelectField).click();
        findElement(By.xpath("//*[@id=\"days\"]/option[@value=\"" + day +"\"]")).click();
    }

    private void setMonth(String month){
        findElement(monthSelectField).click();
        findElement(By.xpath("//*[@id=\"months\"]/option[@value=\"" + month +"\"]")).click();
    }

    private void setYear(String year){
        findElement(yearSelectField).click();
        findElement(By.xpath("//*[@id=\"years\"]/option[@value=\"" + year +"\"]")).click();
    }

    public AccountCreatedPage signUp(RegistrationData registrationData){
        if (registrationData.getTitle().equals(RegistrationData.Title.MR)){
            findElement(titleMr).click();
        }
        else findElement(titleMrs).click();

        findElement(passwordInputField).sendKeys(registrationData.getPassword());
        findElement(daySelectField).click();
        setDay("1");
        setMonth("1");
        setYear("2021");
        findElement(firstNameInputField).sendKeys(registrationData.getFirstName());
        findElement(lastNameInputField).sendKeys(registrationData.getLastName());
        findElement(addressInputField).sendKeys(registrationData.getAddress());
        findElement(stateInputField).sendKeys(registrationData.getState());
        findElement(cityInputField).sendKeys(registrationData.getCity());
        findElement(zipcodeInputField).sendKeys(registrationData.getZipCode());
        findElement(mobileNumberInputField).sendKeys(registrationData.getPhoneNumber());
        findElement(createAccountButton).click();
        return new AccountCreatedPage();
    }

}
