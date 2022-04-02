package com.example.tests;

import com.example.pages.GuestsPage;
import com.example.pages.MessagesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GuestsOpeningTest extends BaseTest {
    @Test
    void openGuests() throws IOException {
        authorize().openGuests();
        Assertions.assertTrue(GuestsPage.isOpen());
    }
}
