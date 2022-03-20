package com.example.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MessageTest implements Authorized {

    @Test
    public void openMessages() {
        $(By.xpath("//div[@id='msg_toolbar_button']")).click();
        $(By.xpath("//input[contains(@class, 'base-input')]")).shouldBe(appear);
    }

}
