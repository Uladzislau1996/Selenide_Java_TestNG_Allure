package test.selenide.project;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class PopupPageLocators extends MainPageLocators{

    public SelenideElement popup = $(".v-modal-search");
    public SelenideElement popUpTitle = $(".search-popup__title");
    public SelenideElement popUpCounter = $(".search-popup__text");
    public SelenideElement popUpSearchField = $("#search-in-popup");
    public SelenideElement popUpTabMatches = $(".search-popup-tabs__header>button");
    public SelenideElement popUpTabLeagues = $(".search-popup-tabs__header>button+button");
    public SelenideElement popUpSearchButton = $(".search-popup__button");
    public SelenideElement popUpClose = $(".search-popup__close");
    public SelenideElement popUpClear = $(".search-popup__clear");
    public SelenideElement popUpCheckBoxLive = $(".search-popup__setting:first-child>.c-checkbox");
    public SelenideElement popUpCheckBoxNameLive = $x("//*[@for='liveFilter']");
    public SelenideElement popUpCheckBoxSport = $(".search-popup__setting:nth-child(2)>.c-checkbox");
    public SelenideElement popUpCheckBoxNameSport = $x("//*[@for='lineFilter']");
    public SelenideElement popUpCheckBoxExactMatch = $(".search-popup__setting:last-child>.c-checkbox");
    public SelenideElement popUpCheckBoxNameExactMatch = $x("//*[@for='accurateFilter']");
    public ElementsCollection searchResults = $$(".search-popup-events__item");
    public ElementsCollection iconLiveInResults = $$(".search-popup-event__live");
    public ElementsCollection searchResultsContent = $$(".search-popup-event__content");
    public SelenideElement popUpMicrophoneButton = $(".fa-microphone");
    public SelenideElement microphoneAlertIcon = $(".swal2-popup>.swal2-header");
    public SelenideElement microphoneAlertContent = $(".swal2-popup>.swal2-content");
    public SelenideElement microphoneAlertButton = $(".swal2-popup>.swal2-actions>.swal2-confirm");
    public SelenideElement notSearchResultText = $(".search-popup__nothing-find");
    public ElementsCollection popUpCoefficients = $$(".search-popup-coef");
    public SelenideElement microphoneAlert = $(".swal2-container>.swal2-popup");
    public SelenideElement checkboxLive =$(".search-popup__settings>.search-popup__setting:nth-child(1)");
    public SelenideElement checkboxSport =$(".search-popup__settings>.search-popup__setting:nth-child(2)");
    public SelenideElement betBox = $(".coupon__bets");

}
