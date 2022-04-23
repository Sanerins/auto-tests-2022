package com.example.tests;

import com.example.pages.MusicPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static com.example.tests.BaseTest.authorize;
import static org.assertj.core.api.Assertions.assertThat;

public class MusicTest {

    @ParameterizedTest
    @MethodSource("getArtistsList")
    public void findArtists(String arg) throws IOException {
        MusicPage musicPage = authorize().openMusic();

        musicPage.findMusic(arg);

        assertThat(musicPage.getNameOfFirstTrack()).isEqualTo(arg);
    }


    private static Stream<Arguments> getArtistsList() {
        return Stream.of(
                Arguments.of("Despacito"),
                Arguments.of("Noize"),
                Arguments.of("MORGENSHTERN")
        );
    }

    @Disabled
    public void findTrack() {
        //TODO
    }
}
