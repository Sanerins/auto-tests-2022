package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class SearchFriendsPage {
    private static final SelenideElement NOT_FOUND_FRIENDS_BLOCK = $(byClassName("stub-empty"));

    public SearchFriendsPage() {
        NOT_FOUND_FRIENDS_BLOCK.shouldBe(visible);
    }

    public boolean friendNotFound() {
        NOT_FOUND_FRIENDS_BLOCK.shouldBe(visible);
        return NOT_FOUND_FRIENDS_BLOCK.is(visible);
    }
}
