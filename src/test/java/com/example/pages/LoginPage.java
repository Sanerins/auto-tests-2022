package com.example.pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;
import com.example.utils.User;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage implements Page {
    private static final SelenideElement LOGIN_FORM = $(byXpath("//form[contains(@class, \"login-form\")]"));
    private static final SelenideElement EMAIL_FIELD = LOGIN_FORM.find(By.id("field_email"));
    private static final SelenideElement PASSWORD_FIELD = LOGIN_FORM.find(By.id("field_password"));
    private static final SelenideElement LOGIN_BUTTON = $(byXpath("//input[@data-l='t,sign_in']"));
    public static final String URL = "https://ok.ru";

    public FeedPage login(User user) {
        EMAIL_FIELD.shouldBe(visible).setValue(user.getLogin());
        PASSWORD_FIELD.shouldBe(visible).setValue(user.getPassword());
        LOGIN_BUTTON.shouldBe(visible).click();
        return new FeedPage();
    }

    @Override
    public void await() {
        LOGIN_FORM.shouldBe(visible);
    }

    @Override
    public String getURL() {
        return URL;
    }
}
