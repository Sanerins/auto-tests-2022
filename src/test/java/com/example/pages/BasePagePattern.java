package com.example.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePagePattern {
    public static String url = "https://ok.ru";

    public static void openPage() {
        open(url);
        if (!isOpen()) {
            throw new UnsupportedOperationException();
        }
    }

    public static String getURL() {
        return url;
    }

    public static boolean isOpen() {
        return $(By.xpath(" ")).exists();
    }
}

