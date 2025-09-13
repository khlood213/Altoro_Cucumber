package steps;

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;

public class Hooks {

    private static String PROJECT_NAME = null;
    private static String PROJECT_URL = null;
    static Properties prop;
    static FileInputStream readProperty;

    private void setProjectDetails() throws IOException {
        // TODO: Step1: define object of properties file
        readProperty = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/properties/environment.properties");
        prop = new Properties();
        prop.load(readProperty);

        // define project name from properties file
        PROJECT_NAME = prop.getProperty("projectName");
        PROJECT_URL = prop.getProperty("url");
    }


    @Before
    public void beforeScenario() throws IOException {
        System.out.println("Before Scenario Hook: Setting up browser and navigating to home page.");
        System.out.println("Step 1: Open browser and navigate to home page");

        setDriver(DriverFactory.getNewInstance(""));

        setProjectDetails();

        getDriver().get(PROJECT_URL);
    }

    @After
    public void afterScenario() {
        System.out.println("After Scenario Hook: Closing browser.");
        getDriver().quit();
    }

}
