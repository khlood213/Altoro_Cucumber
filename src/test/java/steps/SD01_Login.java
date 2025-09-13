package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.P01_HomePage;
import pages.P02_LoginPage;

import java.io.IOException;

import static drivers.DriverHolder.getDriver;
import static util.Utility.getExcelData;
import static util.Utility.getSingleJsonData;

public class SD01_Login {
    String username = getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/data/credientialsnotarray.json","username");
    String password = getExcelData(1,0,"fr");

    public SD01_Login() throws IOException, ParseException {
    }


    @When("click signin button")
    public void clickSigninButton() {
        System.out.println("Step 2: Click signin button");
        new P01_HomePage(getDriver()).clickSignin();
    }

    @And("enter valid credientials to login form")
    public void enterValidCredientialsToLoginForm() {
        System.out.println("Step 3: Enter valid credentials");
        new P02_LoginPage(getDriver()).enterUsername(username).enterPassword(password);
    }

    @And("click login button")
    public void clickLoginButton() {
        System.out.println("Step 4: Click login button");
        new P02_LoginPage(getDriver()).clickOnLoginButton();
    }

    @Then("system shall navigate to admin profile page")
    public void systemShallNavigateToAdminProfilePage() {
        System.out.println("Step 5: Navigate to admin profile page");
        Assert.assertTrue(getDriver().getPageSource().contains("Congratulations"));
    }


}
