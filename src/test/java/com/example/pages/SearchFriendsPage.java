package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchFriendsPage {
    private static final SelenideElement NOT_FOUND_FRIENDS_BLOCK = $(By.className("stub-empty"));

    public SearchFriendsPage() {
        NOT_FOUND_FRIENDS_BLOCK.shouldBe(visible);
    }

    public boolean friendNotFound() {
        NOT_FOUND_FRIENDS_BLOCK.shouldBe(visible);
        return NOT_FOUND_FRIENDS_BLOCK.is(visible);
    }
}
