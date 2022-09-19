package test.selenide.project;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;


public class MainPageLocators {
    public SelenideElement searchField = $(".dashboard>section:first-child>div:first-child>div:first-child>div>div>input");
    public SelenideElement searchButton = $x("//*[@id='sports_main_new']/section[1]/div[1]/div[1]/div/div/button");


    public void enterRequest(String request){
        step("Открыть поп-ка с введеным запроссм", () -> {
            searchField.sendKeys("request");
            Assert.assertTrue(searchButton.isDisplayed());
            searchButton.click();
        }); }
}

