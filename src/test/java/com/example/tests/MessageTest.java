package com.example.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.example.pages.FeedPage;
import com.example.pages.MessagesPage;

import static com.codeborne.selenide.Selenide.$;

public class MessageTest implements Authorized {

    @Test
    public void openMessages() {
        FeedPage page = new FeedPage();
        if(!FeedPage.isOpen()) {
            System.err.println("The page provided wasn't a main page");
            assert(false);
        } else {
            page.openMessages().checkOpened();
        }
    }

}
