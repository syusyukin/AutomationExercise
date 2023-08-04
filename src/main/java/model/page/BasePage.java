package model.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class BasePage {
    @Getter
    HeaderMenu headerMenu;
    public BasePage(){
        this.headerMenu = new HeaderMenu();
    }

}
