package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HeaderBar {
    private static final SelenideElement NOTIFICATIONS_LINK = $(byXpath("//*[contains(@data-l, 't,notifications')]"));
    private static final SelenideElement MINI_USER_CARD = $(byXpath("//div[contains(@class, 'ucard-mini toolbar_ucard js-toolbar-menu')]"));
    private static final SelenideElement LOGOUT_LINK = $(byXpath("//a[@data-l='t,logout']"));
    private static final SelenideElement LOGOUT_CONFIRMATION = $(byId("hook_FormButton_logoff.confirm_not_decorate"));
    public final SelenideElement CONTENT = $(byXpath("//div[contains(@data-l, 't,filter')]"));
    private final SelenideElement MESSAGES_LINK = $(byXpath("//*[contains(@data-l, 't,messages')]"));
    private final SelenideElement GUESTS_LINK = $(byXpath("//*[contains(@data-l, 't,guests')]"));
    private final SelenideElement MUSIC_LINK = $(byXpath("//*[contains(@data-l, 't,music')]"));

    public MessagesPage openMessages() {
        MESSAGES_LINK.shouldBe(visible).click();
        return new MessagesPage();
    }

    public GuestsPage openGuests() {
        GUESTS_LINK.shouldBe(visible).click();
        return new GuestsPage();
    }

    public MusicPage openMusic() {
        MUSIC_LINK.click();
        return new MusicPage();
    }

    public NotificationsPage openNotifications() {
        NOTIFICATIONS_LINK.shouldBe(visible).click();
        return new NotificationsPage();
    }

    public LoginPage logout() {
        MINI_USER_CARD.shouldBe(visible).click();
        LOGOUT_LINK.shouldBe(visible).click();
        LOGOUT_CONFIRMATION.shouldBe(visible).click();
        return new LoginPage();
    }
}
