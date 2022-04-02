package com.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GuestsPage {
    private static final String url = "https://ok.ru/guests";
    private static final SelenideElement guestsHeader = $(By.id("listBlockPanelUserGuests"));

    public GuestsPage() {
        guestsHeader.shouldBe(Condition.visible);
    }

    public static GuestsPage openPage() {
        open(url);
        return new GuestsPage();
    }

    public static boolean isOpen() {
        return guestsHeader.isDisplayed();
    }

    public static String getURL() {
        return url;
    }
}
