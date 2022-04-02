package com.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.example.utils.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    public static String url = "https://ok.ru";
    private static final SelenideElement loginForm = $(By.xpath("//form[contains(@class, \"login-form\")]"));
    private static final SelenideElement emailField = loginForm.find(By.id("field_email"));
    private static final SelenideElement passwordField = loginForm.find(By.id("field_password"));
    private static final SelenideElement loginButton = $(By.xpath("//input[@data-l='t,sign_in']"));

    public LoginPage() {
        loginForm.shouldBe(Condition.visible);
    }

    public static LoginPage openPage() {
        open(url);
        return new LoginPage();
    }

    public FeedPage login(User user) {
        emailField.setValue(user.getLogin());
        passwordField.setValue(user.getPassword());
        loginButton.click();
        return new FeedPage();
    }

    public static String getURL() {
        return url;
    }

    public static boolean isOpen() {
        return loginForm.isDisplayed();
    }
}
