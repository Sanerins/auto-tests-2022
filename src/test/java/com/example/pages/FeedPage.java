package com.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FeedPage {
    public static String url = "https://ok.ru/feed";
    private static final SelenideElement feedNavBar = $(By.xpath("//div[contains(@data-l, 't,filter')]"));
    private static final SelenideElement friendsLink = $(By.xpath("//*[contains(@data-l, 't,friends')]"));
    private static final SelenideElement messagesLink = $(By.xpath("//*[contains(@data-l, 't,messages')]"));
    private static final SelenideElement guestsLink = $(By.xpath("//*[contains(@data-l, 't,guests')]"));
    private static final SelenideElement miniUserCard =
            $(By.xpath("//div[contains(@class, 'ucard-mini toolbar_ucard js-toolbar-menu')]"));
    private static final SelenideElement logoutLink = $(By.xpath("//a[@data-l='t,logout']"));
    private static final SelenideElement logoutConfirmation =
            $(By.id("hook_FormButton_logoff.confirm_not_decorate"));

    public FeedPage() {
        feedNavBar.shouldBe(Condition.visible);
    }

    public FeedPage openPage() {
        open(url);
        return new FeedPage();
    }

    public LoginPage logout() {
        miniUserCard.click();
        logoutLink.click();
        logoutConfirmation.click();
        return LoginPage.openPage();
    }

    public static String getURL() {
        return url;
    }

    public MessagesPage openMessages() {
        messagesLink.click();
        return new MessagesPage();
    }

    public FriendsPage openFriends() {
        friendsLink.click();
        return new FriendsPage();
    }

    public GuestsPage openGuests() {
        guestsLink.click();
        return new GuestsPage();
    }

    public static boolean isOpen() {
        return feedNavBar.isDisplayed();
    }
}
