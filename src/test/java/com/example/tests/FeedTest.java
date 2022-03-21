package com.example.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.example.pages.FeedPage;
import com.example.pages.MessagesPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class FeedTest implements Authorized {

    @BeforeEach
    public void openFeedPage() {
        new FeedPage()
                .openPage();
    }

    @Test
    public void openMessages() {
        new FeedPage()
                .checkOpened()
                .openMessages()
                .checkOpened();
    }

    @Test
    public void findNonExistentFriendTest() {
        new FeedPage()
                .checkOpened()
                .openFriends()
                .checkOpened()
                .searchPerson("Пивень")
                .checkFriendsNotFound();
    }

}
