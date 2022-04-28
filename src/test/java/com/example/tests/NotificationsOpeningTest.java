package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

import com.example.pages.FeedPage;
import com.example.pages.NotificationsPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class NotificationsOpeningTest extends BaseTest {
    private static FeedPage feedPage;

    @BeforeAll
    public static void openPage() {
        feedPage = new FeedPage();
        open(feedPage.getURL());
    }

    @Test
    @Tag("Notifications")
    @DisplayName("Open notifications test")
    public void openNotifications() {
        NotificationsPage notificationsPage = feedPage.openNotifications();
        assertThat(notificationsPage.isOpen()).isTrue();
    }

    @BeforeEach
    public void setup() throws IOException {
        authorize(createUser());
    }

    @AfterEach
    public void finish() throws IOException {
        logOff();
    }
}