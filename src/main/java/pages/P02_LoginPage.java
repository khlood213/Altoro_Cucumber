package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static drivers.DriverHolder.getDriver;

public class P02_LoginPage extends PageBase{
    // TODO: constructor to intailize webdriver
    public P02_LoginPage(WebDriver driver){
        super(driver);
    }

    // TODO: define locators using By
    private final By USERNAME_TEXT=By.xpath("//input[@id='uid']");
    private final By PASSWORD_TEXT=By.xpath("//input[@id='passw']");
    private final By LOGIN_BUTTON=By.xpath("(//input)[5]");


    // TODO: public action methods
    public P02_LoginPage enterUsername(String username){
        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(USERNAME_TEXT));
        driver.findElement(this.USERNAME_TEXT).sendKeys(username);
        return this;
    }
    public P02_LoginPage enterPassword(String Password){
        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_TEXT));
        driver.findElement(this.PASSWORD_TEXT).sendKeys(Password);
        return this;
    }
    public P03_MainPage clickOnLoginButton(){
        shortWait(getDriver()).until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        driver.findElement(this.LOGIN_BUTTON).sendKeys(Keys.ENTER);
        return new P03_MainPage(driver);
    }
    public String getLoginSuccessfullyMessage(){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h1)")));
        return driver.findElement(By.xpath("(//h1)")).getText();
    }


}
