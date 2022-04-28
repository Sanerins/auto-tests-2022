package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import java.net.URL;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class SearchFriendsPage implements Page {
    private static final SelenideElement NOT_FOUND_FRIENDS_BLOCK = $(byClassName("stub-empty"));
    private static final String URL = "https://ok.ru/friends";

    public boolean friendNotFound() {
        NOT_FOUND_FRIENDS_BLOCK.shouldBe(visible);
        return NOT_FOUND_FRIENDS_BLOCK.is(visible);
    }

    @Override
    public void await() {
        NOT_FOUND_FRIENDS_BLOCK.shouldBe(visible);
    }

    @Override
    public String getURL() {
        return URL;
    }
}
