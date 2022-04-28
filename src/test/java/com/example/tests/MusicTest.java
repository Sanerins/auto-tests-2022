package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.example.pages.FeedPage;
import com.example.pages.MusicPage;
import com.example.utils.ArtistsProvider;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class MusicTest extends BaseTest {
    private static FeedPage feedPage;

    @BeforeAll
    public static void openPage() {
        feedPage = new FeedPage();
        open(feedPage.getURL());
    }

    @ParameterizedTest
    @ArgumentsSource(ArtistsProvider.class)
    public void findArtists(String arg) {
        MusicPage musicPage = feedPage.openMusic();
        musicPage.findArtist(arg);
        assertThat(musicPage.getNameOfFirstTrack()).isEqualTo(arg);
    }

    @Disabled
    public void findTrack() {
        //TODO
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
