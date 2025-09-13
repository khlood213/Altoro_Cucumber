package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class P03_MainPage extends PageBase{

    public P03_MainPage(WebDriver driver){
        super(driver);
    }

    private final By HEADER_TEXT=By.xpath("(//h1)");

    public String getLoginSuccessfullyMessage(){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.HEADER_TEXT));
        return driver.findElement(this.HEADER_TEXT).getText();
    }
}
