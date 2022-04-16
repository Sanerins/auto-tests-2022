package com.example.tests;

import com.example.pages.GuestsPage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class GuestsOpeningTest extends BaseTest {
    @Test
    public void openGuests() throws IOException {
        authorize().openGuests();
        assertThat(GuestsPage.isOpen()).isTrue();
    }
}
