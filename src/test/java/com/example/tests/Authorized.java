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

    static void createUser() throws IOException {
        //Создайте credentials.txt перед запуском
        //1 строка - логин
        //2 строка - пароль
        BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"));
        user.login = reader.readLine();
        user.password = reader.readLine();
    }

    @BeforeAll
    static void authorize() throws IOException {
        createUser();
        new LoginPage()
                .openPage()
                .checkOpened()
                .login(user)
                .checkOpened();
    }

    @AfterAll
    static void logOff() {
        new FeedPage()
                .openPage()
                .checkOpened()
                .logOff()
                .checkOpened();
    }
}
