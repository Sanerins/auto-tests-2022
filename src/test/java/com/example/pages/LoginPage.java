package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.utils.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    public static String url = "https://ok.ru";
    private static final SelenideElement LOGIN_FORM = $(byXpath("//form[contains(@class, \"login-form\")]"));
    private static final SelenideElement EMAIL_FIELD = LOGIN_FORM.find(By.id("field_email"));
    private static final SelenideElement PASSWORD_FIELD = LOGIN_FORM.find(By.id("field_password"));
    private static final SelenideElement LOGIN_BUTTON = $(byXpath("//input[@data-l='t,sign_in']"));

    public LoginPage() {
        LOGIN_FORM.shouldBe(visible);
    }

    public static LoginPage openPage() {
        open(url);
        return new LoginPage();
    }

    public FeedPage login(User user) {
        EMAIL_FIELD.shouldBe(visible).setValue(user.getLogin());
        PASSWORD_FIELD.shouldBe(visible).setValue(user.getPassword());
        LOGIN_BUTTON.shouldBe(visible).click();
        return new FeedPage();
    }
}
