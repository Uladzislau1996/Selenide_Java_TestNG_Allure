package test.selenide.project;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationLocators {
    private SelenideElement registrationBlock = $x("MainPageRight");
    private SelenideElement registrationTitle = $("c-registration__title");
    private SelenideElement registrationButton = $("c-registration__button");
    private SelenideElement emailButton = $(".c-registration__tabs>div:nth-child(1)");
    private SelenideElement emailSocialNetworksButton = $(".c-registration__tabs>div:nth-child(2)");
    private SelenideElement countryDropDown = $(".c-registration__block--country>div:nth-child(1)");


}
