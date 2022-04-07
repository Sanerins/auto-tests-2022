package com.example.tests;

import com.example.pages.MessagesPage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class MessageOpeningTest extends BaseTest {
    @Test
    void openMessages() throws IOException {
        authorize().openMessages();
        assertThat(MessagesPage.isOpen()).isTrue();
    }
}
