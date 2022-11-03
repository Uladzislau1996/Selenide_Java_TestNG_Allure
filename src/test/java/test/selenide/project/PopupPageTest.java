package test.selenide.project;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;


public class PopupPageTest  {

    @BeforeMethod (description = "В сэтапе открываю Поп-ап")
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "2460x1440";
        Configuration.headless = false;
        Configuration.pageLoadTimeout = 300000;
        Selenide.open("https://www.oppabet.com");
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepOpenPopup();

    }

    @AfterMethod (description = "Отчищаю кэш и куки, закрываю браузер")
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }


    @Test (dataProvider = "searchRequest",
            description = "Проверяю что Поп-ап содержит все элементы, в табах Matches/Leagues")
    public void allWebElementsInMatchesTest(String request){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepEnterRequest(request);
        popupSteps.stepCheckAllWebElementsInTabs();
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        popupSteps.stepCheckAllWebElementsInTabs();
    }

    @Test (dataProvider = "searchRequest",
            description = "Проверяю, что после нажатия на кнопку поиска подтянулись результаты " +
                    "которые равны значению каунтера в Табe Matches")
    public void searchButtonInMatchesTest(String request){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepEnterRequest(request);
        popupSteps.stepCheckCounterAndElementsCollection();
    }


    @Test (dataProvider = "searchRequest",
            description = "Проверяю, что после нажатия на кнопку поиска подтянулись результаты " +
                    "которые равны значению каунтера в Табе Leagues")
    public void searchButtonInLeaguesTest(String request){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        popupSteps.stepEnterRequest(request);
        popupSteps.stepCheckCounterAndElementsCollection();
    }


    @Test (dataProvider = "searchRequest",
            description = "Проверяю, что каунтер в PopUp в табе MATCHES = кол-ву результатов")
    public void popUpCounterTest(String request){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepEnterRequest(request);
        popupSteps.stepCheckCounterAndElementsCollection();
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        sleep(3000);
        popupSteps.stepCheckCounterAndElementsCollection();
    }

    @Test (dataProvider = "searchRequest",
            description = "Проверяю, что в табе League. " +
            "нет мконок коэфицентов")
    public void popUpNotHasCoefficientsInLeaguesTabTest(String request){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepEnterRequest(request);
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        sleep(3000);
        popupSteps.stepCoefficientsInLeaguesTab();
    }

    @Test (description = "Проверяю, что отображается заглушка если нет запроса в поиске в табах LEAGUES/MATCHES")
    public void stubTestWithEmptyRequestTest(){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepCheckNotSearchResultText();
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        popupSteps.stepCheckNotSearchResultText();
    }

    @Test (description = "Проверяю, что отображается заглушка если введен не корректный запрос в табах LEAGUES/MATCHES")
    public void stubTestWithInvalidRequestTest(){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepEnterRequest("test123QA");
        popupSteps.stepCheckNotSearchResultText();
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        popupSteps.stepCheckNotSearchResultText();
    }


    @Test (description = "Проверяю, что каунтер = 0 если нет запроса в поиске в табах LEAGUES/MATCHES")
    public void counterWithIEmptyRequestTest(){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepCheckNotSearchResultText();
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        popupSteps.stepCheckNotSearchResultText();
    }

    @Test (description = "Проверяю, что каунтер = 0 если введен не корретный запрос поиске в табах LEAGUES/MATCHES")
    public void counterWithIncorrectRequestTest(){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepEnterRequest("test123QA");
        popupSteps.stepCheckNotSearchResultText();
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        popupSteps.stepCheckNotSearchResultText();
    }

    @Test (description = "Проверяю, что только при включенном чекбоксе 'Live' всегда отображается ячейка Live" +
            " напротив результатов в табе MATCHES")
    public void liveIconsAreDisplayedTest(){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepEnterRequest("football");
        popupSteps.stepClickToElement(popupSteps.popUpCheckBoxNameSport);
        sleep(3000);
        popupSteps.stepCheckLiveIcons();
    }


    @Test (description = "Проверяю, что только при включенном чекбоксе 'Live' всегда отображается ячейка Live" +
            " напротив результатов в табе LEAGUES")
    public void liveIconsAreDisplayedLeaguesTest(){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepEnterRequest("football");
        popupSteps.stepClickToElement(popupSteps.popUpCheckBoxSport);
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        sleep(3000);
        popupSteps.stepCheckLiveIcons();
    }

    @Test (dataProvider = "searchRequest",
            description = "Проверяю, что подтягиваются результаты поиска если включенны все чекбоксы" +
            "Live/Sports/Exact")
    public void resultsWithAllCheckBoxesTest(String request){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepEnterRequest(request);
        popupSteps.stepClickToElement(popupSteps.popUpCheckBoxExactMatch);
        sleep(3000);
        popupSteps.stepCheckCounterAndElementsCollection();
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        sleep(3000);
        popupSteps.stepCheckCounterAndElementsCollection();
    }

    @Test (dataProvider = "searchRequest",
            description = "Проверяю, что подтягиваются результаты поиска если включенны чекбоксы Sports/Exact match")
    public void resultsWithSportsAndExactMatchCheckBoxesTest(String request){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepEnterRequest(request);
        popupSteps.stepClickToElement(popupSteps.popUpCheckBoxExactMatch);
        popupSteps.stepClickToElement(popupSteps.popUpCheckBoxLive);
        sleep(3000);
        popupSteps.stepCheckCounterAndElementsCollection();
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        sleep(3000);
        popupSteps.stepCheckCounterAndElementsCollection();
    }

    @Test (dataProvider = "searchRequest",
            description = "Проверяю, что не подтягиваются результаты, если выключены чекбоксы")
    public void resultsWithoutCheckBoxesTest(String request){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepEnterRequest(request);
        popupSteps.stepClickToElement(popupSteps.popUpCheckBoxLive);
        popupSteps.stepClickToElement(popupSteps.popUpCheckBoxSport);
        sleep(3000);
        popupSteps.stepCheckNotSearchResultText();
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        sleep(3000);
        popupSteps.stepCheckNotSearchResultText();
    }

    @Test (description = "Проверяю, работу кнопки удалить текст в поле поиска")
    public void deleteRequestButtonTest(){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepEnterRequest("football");
        popupSteps.stepClickToElement(popupSteps.popUpClear);
        popupSteps.stepClickToElement(popupSteps.popUpSearchButton);
        sleep(3000);
        popupSteps.stepCheckNotSearchResultText();
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        sleep(3000);
        popupSteps.stepCheckNotSearchResultText();
    }

    @Test (dataProvider = "searchRequest",
            description = "Проверить, что текст результата поиска кликабелен и ведет на соответсвующую страницу" +
            " в табе Matches")
    public void urlInSearchResultsTest(String request){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepEnterRequest(request);
        popupSteps.stepCheckUrlInSearchResults();
    }

    @Test (dataProvider = "searchRequest",
            description = "Проверить, что текст результата поиска кликабелен и ведет на соответсвующую страницу" +
                    " в табе LEAGUES")
    public void searchResultsLeaguesTest(String request){
        PopupPageSteps popupSteps = new PopupPageSteps();
        popupSteps.stepClickToElement(popupSteps.popUpTabLeagues);
        popupSteps.stepEnterRequest(request);
        popupSteps.stepCheckUrlInSearchResults();
    }


    @DataProvider
    public Object [][] searchRequest(){
        return new Object[][]{
                {"arsenal"},
                {"football"}
        };
    }

}
