package test.selenide.project;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class PopupPageSteps extends PopupPageLocators{

    public void stepOpenPopup(){
        step("Открыть Поп-ап и проверить его наличие", () -> {
            new MainPageLocators().searchButton.click();
            popup.shouldBe(visible, Duration.ofSeconds(200));
            Assert.assertTrue(popup.isDisplayed(),"Не отображается поп-ап");
        });
    }

    public void stepCheckAllWebElementsInTabs(){
        step("Проверить наличие всех вэб элементов в табах Matches/Leagues", () -> {
            Assert.assertTrue(popup.isDisplayed(),"Не отображается поп-ап");
            Assert.assertTrue(popUpTitle.isDisplayed(),"Не отображается заголовок поп-ап");
            Assert.assertTrue(popUpClose.isDisplayed(),"Не отображается кнопка Закрыть поп-ап");
            Assert.assertTrue(popUpClear.isDisplayed(),"Не отображается кнопка Отчистить поле ввода");
            Assert.assertTrue(popUpMicrophoneButton.isDisplayed(),"Не отображается кнопка закрыть поп-ап");
            Assert.assertTrue(popUpSearchField.isDisplayed(),"Не отображается поле ввоа");
            Assert.assertTrue(popUpSearchButton.isDisplayed(),"Не отображается кнопка поиска");
            Assert.assertTrue(popUpTabLeagues.isDisplayed(),"Не отображается таб Leagues");
            Assert.assertTrue(popUpTabMatches.isDisplayed(),"Не отображается таб Matches");
            Assert.assertTrue(checkboxLive.isDisplayed(),"Не отображается кнопка закрыть поп-ап");
            Assert.assertTrue(checkboxSport.isDisplayed(),"Не отображается кнопка закрыть поп-ап");
            Assert.assertTrue(popUpCheckBoxNameExactMatch.isDisplayed(),"Не отображается текст чекбокса EXACTMATCH");
            Assert.assertTrue(popUpCheckBoxNameSport.isDisplayed(),"Не отображается текст чекбокса Sport");
            Assert.assertTrue(popUpCheckBoxNameLive.isDisplayed(),"Не отображается текст чекбокса Live");

        });
    }

    public void stepEnterRequest(String request){
        step("Ввожу запрос в поле поиска", () -> {
            popUpClear.click();
            popUpSearchField.setValue(request);
            popUpSearchButton.click();
            sleep(3000);
        }); }

    public void stepCheckCounterAndElementsCollection(){
        step("Проверить что количество результатов равно значению каунетра", () -> {
            String Counter = popUpCounter.getText();
            int popupCounter = Integer.parseInt(Counter);
            Assert.assertEquals(popupCounter, searchResults.size(),
                    "количество результатов не равно значению каунтеру \n" +
                            "Значение каунтера = " + " " + popUpCounter.getText() + "\n" +
                            "Количество результатов = " + " " + searchResults.size());
        });}

    public void stepCheckSearchResultsText(String request){
        step("Проверить что в результатах поиска есть совпадения в тексте по запросу", () -> {
            //1
            List<String> results = new ArrayList<>();
            for (SelenideElement element : searchResultsContent){
                results.add(element.getText());
            }
            //2
            for (String resultsText : results) {
                Assert.assertTrue(resultsText.toLowerCase().contains(request),
                        "Нет совпадений в текстe" + " " + resultsText);
            }
        }); }

    public void stepCoefficientsInLeaguesTab(){
        step("Проверить что не отображаются иконки коэффицентов", () -> {
            Assert.assertTrue(popUpCoefficients.isEmpty(),
                    "Отображаются коэфиценты в табе LEAGUES");
        }); }


    public void stepCheckNotSearchResultText(){
        step("Проверить что отображается заглушка", () -> {
            Assert.assertTrue(notSearchResultText.isDisplayed(),
                    "Не отображается текстовая заглушка (No results)");
        });}

    public void stepClickToElement(SelenideElement element){
        step("Проверить отображение Элемента", () -> {
            Assert.assertTrue(element.is(visible),
                    "Не отображается элемент" + element);
        });
        step("Кликнуть на элемент", () -> {
            element.click();
        });
    }

    public void stepCheckLiveIcons(){
        step("Проверить что кол-во иконок LIVE равно значению канутеоа", () -> {
        String Counter = popUpCounter.getText();
        int popupCounter = Integer.parseInt(Counter);
        Assert.assertEquals(popupCounter, iconLiveInResults.size(),
                "количество результатов не равно значению каунтеру \n" +
                        "Значение каунтера = " + " " + popUpCounter.getText() + "\n" +
                        "Количество результатов = " + " " + iconLiveInResults.size());
    });}

    public void stepCheckUrlInSearchResults(){
        step("Создаю список List из результатов по запросу, кликаю на каждый элемент и " +
                "проверяю что открылась корректная страница", () -> {
            //1
            ElementsCollection hrefs = $$(".search-popup-events__item>a");
            List<SelenideElement> links = new ArrayList<>(hrefs);
            //2
            for (SelenideElement listUrl : links) {
                String checkUrl = listUrl.getAttribute("href");
                listUrl.click();
                switchTo().window(1);
                sleep(3000);
                webdriver().shouldHave(url(checkUrl));
                closeWindow();
                switchTo().window(0);
            }
        });}

    public void checkSearchResultsCoefficients(){
        step("Создаю список List из коэфицентов в результатах по запросу, кликаю на каждый элемент и " +
                "Проверяю что появился блок o-bet-box-list", () -> {
            //1
            ElementsCollection coefficientElements = $$(".search-popup-coef__value");
            List<SelenideElement> coefficients = new ArrayList<>(coefficientElements);
            //2
            for (SelenideElement coefficient : coefficients) {
                coefficient.click();
                Assert.assertTrue(betBox.isDisplayed(), "Не отображается BetBOX после клика на коэффицент");
                coefficient.click();
                Assert.assertTrue(betBox.isEnabled(), "Отображается BetBOX после клика на коэффицент");
            }
        });}

    public void stepCheckMicrophoneAlert(){
        step("Проверить наличие всех вэб элементов в табах Matches/Leagues", () -> {
            Assert.assertTrue(microphoneAlertIcon.isDisplayed(),"Не отображается иконка microphoneAlertIcon");
            Assert.assertTrue(microphoneAlertContent.isDisplayed(),"Не отображается текст microphoneAlertContent");
            Assert.assertTrue(microphoneAlertButton.isDisplayed(),"Не отображается кнопка microphoneAlertButton");
            Assert.assertTrue(microphoneAlert.isDisplayed(),"Не отображается алерт microphoneAlert");
        });
    }



}
