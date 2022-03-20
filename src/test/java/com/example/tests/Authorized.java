package com.example.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.example.pages.FeedPage;
import com.example.pages.LoginPage;
import com.example.utils.User;

public interface Authorized {
    User user = new User();

    @BeforeAll
    static void authorize() throws IOException {
        //Создайте credentials.txt перед запуском
        //1 строка - логин
        //2 строка - пароль
        createUser();
        LoginPage.openPage();
        LoginPage.login(user);
    }

    @AfterAll
    static void logOff() {
        FeedPage.openPage();
        FeedPage.logOff();
    }

    static void createUser() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"));
        user.login = reader.readLine();
        user.password = reader.readLine();
    }
}
