package com.example.tests;

import com.example.pages.MessagesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class MessageOpeningTest extends BaseTest {
    @Test
    @Tag("Messages")
    @DisplayName("Open messages test")
    public void openMessages() throws IOException {
        authorize().openMessages();
        assertThat(MessagesPage.isOpen()).isTrue();
    }
}
