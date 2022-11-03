package test.selenide.project;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends RegistrationSteps {

    @BeforeMethod(description = "Open main page")
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "2460x1440";
        Configuration.headless = true;
        Configuration.pageLoadTimeout = 300000;
        Selenide.open("https://www.oppabet.com");

    }

    @AfterMethod(description = "Clear cache and close browser")
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }

    @Test(description = "Check that all web elements are displayed")
    public void allWebElementsAreDisplayedTest(){
        RegistrationSteps registration = new RegistrationSteps();
        registration.checkAllWebElements();
    }

    @Test(description = "Drop down Country has 5th countries")
    public void fieldCountryHasAllCountriesTest(){
        RegistrationSteps registration = new RegistrationSteps();
        registration.clickOnTheElement(registrationCountry);
        registration.checkSizeInElementsCollection(registrationAvailableCountry, 5);
    }


}
