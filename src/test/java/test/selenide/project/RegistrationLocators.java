package test.selenide.project;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationLocators {
    public SelenideElement registrationBlock = $("#MainPageRight");
    public SelenideElement registrationTitle = $(".c-registration__title");
    public SelenideElement registrationButton = $(".c-registration__button");
    public SelenideElement registrationByEmailButton = $(".c-registration__tabs>div:nth-child(1)");
    public SelenideElement registrationBySocialNetworksButton = $(".c-registration__tabs>div:nth-child(2)");
    public SelenideElement registrationCountry = $(".c-registration__block--country>div:nth-child(1)");
    public SelenideElement registrationCurrency = $(".c-registration__block--currency");
    public SelenideElement registrationPassword = $(".c-registration__field--password");
    public SelenideElement registrationCity = $(".c-registration__field--city");
    public SelenideElement registrationReenterPassword = $(".c-registration__field--password_repeat");
    public SelenideElement registrationFirstName = $(".c-registration__field--name");
    public SelenideElement registrationEmail = $(".c-registration__field--email");
    public SelenideElement registrationSurname = $(".c-registration__field--surname");
    public SelenideElement registrationPromoCode = $("#registration_ref_code");
    public SelenideElement registrationCaptcha = $(".c-registration__field--captcha");
    public SelenideElement registrationRules = $(".c-registration__rules");
    public SelenideElement registrationBonus = $("#registration_1st_bonus_link");
    public ElementsCollection registrationCountriesList = $$(".c-registration__block--country>div>div>ul>.multiselect__element");
    public ElementsCollection registrationCurrencyList = $$(".c-registration__block--currency>div>div>ul>.multiselect__element");
    public ElementsCollection registrationCityList = $$(".c-registration__block--city>div>div>ul>.multiselect__element");
    public SelenideElement registrationCountryBangladesh = $(".c-registration__block--country>div>div>ul>.multiselect__element:nth-child(1)");
    public SelenideElement registrationCountryMalaysia = $(".c-registration__block--country>div>div>ul>.multiselect__element:nth-child(2)");
    public SelenideElement registrationCountryVietnam = $(".c-registration__block--country>div>div>ul>.multiselect__element:nth-child(3)");
    public SelenideElement registrationCountryIndonesia = $(".c-registration__block--country>div>div>ul>.multiselect__element:nth-child(4)");
    public SelenideElement registrationCountryNepal = $(".c-registration__block--country>div>div>ul>.multiselect__element:nth-child(5)");



}
