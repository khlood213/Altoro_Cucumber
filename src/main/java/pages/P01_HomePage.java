package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static drivers.DriverHolder.getDriver;

public class P01_HomePage extends PageBase{
    // TODO: constructor to intailize webdriver
    public P01_HomePage(WebDriver driver){
        super(driver);
    }

    // TODO: define locators using By
    private final By SIGNIN_LINK=By.id("LoginLink");


    // TODO: public action methods
    public P01_HomePage clickSignin(){
        shortWait(getDriver()).until(ExpectedConditions.elementToBeClickable(SIGNIN_LINK));
        driver.findElement(this.SIGNIN_LINK).sendKeys(Keys.ENTER);
        return this;
    }


}
