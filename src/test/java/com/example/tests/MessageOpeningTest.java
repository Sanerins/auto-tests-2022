package com.example.tests;

import com.example.pages.MessagesPage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageOpeningTest extends BaseTest {
    @Test
    public void openMessages() throws IOException {
        authorize().openMessages();
        assertThat(MessagesPage.isOpen()).isTrue();
    }
}
