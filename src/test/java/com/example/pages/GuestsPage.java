package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GuestsPage implements Page {
    private static final String URL = "https://ok.ru/guests";
    private static final SelenideElement GUESTS_HEADER = $(byId("hook_Block_UserGuests"));

    public boolean isOpen() {
        return GUESTS_HEADER.isDisplayed();
    }

    public void await() {
        GUESTS_HEADER.shouldBe(visible);
    }

    @Override
    public String getURL() {
        return URL;
    }
}
