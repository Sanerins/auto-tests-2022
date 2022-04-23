package com.example.tests;

import com.example.pages.NotificationsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class NotificationsOpeningTest extends BaseTest {
    @Test
    @Tag("Notifications")
    @DisplayName("Open notifications test")
    public void openNotifications() throws IOException {
        authorize().openNotifications();
        assertThat(NotificationsPage.isOpen()).isTrue();
    }
}