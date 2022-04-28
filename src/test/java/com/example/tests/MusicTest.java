package com.example.tests;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.pages.FeedPage;
import com.example.pages.MusicPage;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class MusicTest extends BaseTest {
    private static FeedPage feedPage;

    @BeforeAll
    public static void openPage() {
        feedPage = new FeedPage();
        open(feedPage.getURL());
    }

    private static Stream<Arguments> getArtistsList() {
        return Stream.of(
                Arguments.of("Despacito"),
                Arguments.of("Noize"),
                Arguments.of("MORGENSHTERN")
        );
    }

    @ParameterizedTest
    @MethodSource("getArtistsList")
    public void findArtists(String arg) {
        MusicPage musicPage = feedPage.openMusic();
        musicPage.findArtist(arg);
        assertThat(musicPage.getNameOfFirstTrack()).isEqualTo(arg);
    }

    @Disabled
    public void findTrack() {
        //TODO
    }
}
