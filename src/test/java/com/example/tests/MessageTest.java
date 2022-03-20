package com.example.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.example.pages.FeedPage;
import com.example.pages.MessagesPage;

import static com.codeborne.selenide.Selenide.$;

public class MessageTest implements Authorized {

    @Test
    public void openMessages() {
        FeedPage.openPage();
        $(By.xpath("//div[@id='msg_toolbar_button']")).click();
        if (!MessagesPage.isOpen()) {
            throw new UnsupportedOperationException();
        }
    }

}
