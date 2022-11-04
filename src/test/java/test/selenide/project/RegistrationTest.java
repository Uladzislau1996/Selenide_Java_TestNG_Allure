package test.selenide.project;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

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

    @Test(description = "Dropdown country has 5 countries")
    public void fieldCountryHasAllCountriesTest(){
        RegistrationSteps registration = new RegistrationSteps();
        sleep(2000);
        registration.checkSizeInElementsCollection(registrationCountriesList, 5);
    }

    @Test(description = "Dropdown currency has 4 currency")
    public void fieldCurrencyHasAllCountriesTest(){
        RegistrationSteps registration = new RegistrationSteps();
        registration.clickOnTheElement(registrationCurrency);
        registration.checkSizeInElementsCollection(registrationCurrencyList, 4);
    }

    @Test(description = "Dropdown city has 799 cities in India")
    public void fieldCityHasAllCountriesInIndiaTest(){
        RegistrationSteps registration = new RegistrationSteps();
        registration.checkSizeInElementsCollection(registrationCityList, 799);
    }

    @Test(description = "Dropdown city has 15 cities in Bangladesh")
    public void fieldCityHasAllCountriesInBangladeshTest(){
        RegistrationSteps registration = new RegistrationSteps();
        registration.clickOnTheElement(registrationCountry);
        registration.clickOnTheElement(registrationCountryBangladesh);
        sleep(2000);
        registration.checkSizeInElementsCollection(registrationCityList, 15);
    }

    @Test(description = "Dropdown city has 61 cities in Malaysia")
    public void fieldCityHasAllCountriesInMalaysiaTest(){
        RegistrationSteps registration = new RegistrationSteps();
        registration.clickOnTheElement(registrationCountry);
        registration.clickOnTheElement(registrationCountryMalaysia);
        sleep(2000);
        registration.checkSizeInElementsCollection(registrationCityList, 61);
    }

    @Test(description = "Dropdown city has 59 cities in Vietnam")
    public void fieldCityHasAllCountriesInVietnamTest(){
        RegistrationSteps registration = new RegistrationSteps();
        registration.clickOnTheElement(registrationCountry);
        registration.clickOnTheElement(registrationCountryVietnam);
        sleep(2000);
        registration.checkSizeInElementsCollection(registrationCityList, 59);
    }

    @Test(description = "Dropdown city has 145 cities in Indonesia")
    public void fieldCityHasAllCountriesInIndonesiaTest(){
        RegistrationSteps registration = new RegistrationSteps();
        registration.clickOnTheElement(registrationCountry);
        registration.clickOnTheElement(registrationCountryIndonesia);
        sleep(2000);
        registration.checkSizeInElementsCollection(registrationCityList, 145);
    }

    @Test(description = "Dropdown city has 7 cities in Nepal")
    public void fieldCityHasAllCountriesInNepalTest(){
        RegistrationSteps registration = new RegistrationSteps();
        registration.clickOnTheElement(registrationCountry);
        registration.clickOnTheElement(registrationCountryNepal);
        sleep(2000);
        registration.checkSizeInElementsCollection(registrationCityList, 7);
    }




}
