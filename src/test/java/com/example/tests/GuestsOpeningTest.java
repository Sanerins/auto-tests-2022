package com.example.tests;

import com.example.pages.GuestsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class GuestsOpeningTest extends BaseTest {
    @Test
    @Tag("Guests")
    @DisplayName("Best guests test ever")
    public void openGuests() throws IOException {
        authorize().openGuests();
        assertThat(GuestsPage.isOpen()).isTrue();
    }
}
