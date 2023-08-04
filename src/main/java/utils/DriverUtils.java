package utils;

import model.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static base_tests.BaseTest.driver;

public class DriverUtils {
    public static WebElement findElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));

        try{
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception ignored){
            //
        }

        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().build().perform();


        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
