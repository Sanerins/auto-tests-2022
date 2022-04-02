package com.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchFriendsPage {
    private static final SelenideElement notFoundFriendsBlock = $(By.className("stub-empty"));

    public SearchFriendsPage() {
        notFoundFriendsBlock.shouldBe(Condition.visible);
    }

    public boolean friendNotFound() {
        notFoundFriendsBlock.shouldBe(Condition.visible);
        return notFoundFriendsBlock.is(Condition.visible);
    }
}
