package test.selenide.project;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

public class RegistrationSteps extends RegistrationLocators {

    public void checkAllWebElements(){
        Assert.assertTrue(registrationBlock.isDisplayed(), "Не отображается блок регистрации");
        Assert.assertTrue(registrationTitle.isDisplayed(), "Не отображается тайтл регистрации");
        Assert.assertTrue(registrationButton.isDisplayed(), "Не отображается кнопка зарегистрироваться");
        Assert.assertTrue(registrationByEmailButton.isDisplayed(), "Не отображается кнопка регистрации по Email");
        Assert.assertTrue(registrationBySocialNetworksButton.isDisplayed(), "Не отображается кнопка регистрации через сети");
        Assert.assertTrue(registrationCountry.isDisplayed(), "Не отображается дроп даун City");
        Assert.assertTrue(registrationCurrency.isDisplayed(), "Не отображается дроп даун Currency");
        Assert.assertTrue(registrationPassword.isDisplayed(), "Не отображается поле Password");
        Assert.assertTrue(registrationCity.isDisplayed(), "Не отображается дроп даун City");
        Assert.assertTrue(registrationReenterPassword.isDisplayed(), "Не отображается поле Re-Password");
        Assert.assertTrue(registrationFirstName.isDisplayed(), "Не отображается поле FirstName");
        Assert.assertTrue(registrationEmail.isDisplayed(), "Не отображается поле Email");
        Assert.assertTrue(registrationSurname.isDisplayed(), "Не отображается поле Surname");
        Assert.assertTrue(registrationPromoCode.isDisplayed(), "Не отображается поле PromoCode");
        Assert.assertTrue(registrationCaptcha.isDisplayed(), "Не отображается блок Captcha");
        Assert.assertTrue(registrationRules.isDisplayed(), "Не отображается блок Rules");
        Assert.assertTrue(registrationBonus.isDisplayed(), "Не отображается кнопка Bonus");
    }

    public void clickOnTheElement(SelenideElement element){
        element.click();
    }

    public void checkSizeInElementsCollection(ElementsCollection collection, Integer size){
        Assert.assertEquals(collection.size(), size, "Not display all elements in the list");
    }

}
