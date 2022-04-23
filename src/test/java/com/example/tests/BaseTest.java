package com.example.tests;

import com.codeborne.selenide.Configuration;
import com.example.pages.FeedPage;
import com.example.pages.LoginPage;
import com.example.utils.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    private static final String BASE_URL = "https://ok.ru";

    static User createUser() throws IOException {
        //Создайте credentials.txt перед запуском
        //1 строка - логин
        //2 строка - пароль
        BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"));
        return User.builder()
                .setLogin(reader.readLine())
                .setPassword(reader.readLine())
                .build();
    }

    @BeforeAll
    public static void init() throws IOException {
        Configuration.baseUrl = BASE_URL;
        open("/");
        authorize();
    }

    @AfterAll
    public static void close() {
        logOff();
        closeWebDriver();
    }

    protected static FeedPage authorize() throws IOException {
        return LoginPage.openPage()
                .login(createUser());
    }

    protected static void logOff() {
        FeedPage.openPage()
                .logout();
    }

    protected void goToUrl(String url) {
        open(url);
    }
}
