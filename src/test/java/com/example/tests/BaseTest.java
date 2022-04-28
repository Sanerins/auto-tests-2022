package com.example.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;
import com.example.pages.FeedPage;
import com.example.pages.LoginPage;
import com.example.utils.User;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    private static final String BASE_URL = "https://ok.ru";

    protected static User createUser() throws IOException {
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
    }

    @AfterAll
    public static void close() {
        closeWebDriver();
    }

    protected static void authorize(User user) throws IOException {
        new LoginPage().login(user);
    }

    protected static void logOff() {
        new FeedPage().logout();
    }
}
