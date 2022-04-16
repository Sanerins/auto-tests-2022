package com.example.tests;

import com.example.pages.FeedPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchForFriendTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("provideNonExistentFriends")
    public void findNonExistentFriendTest(String nonExistentFriendName) throws IOException {
        authorize();
        assertThat(new FeedPage()
                .openFriends()
                .searchPerson(nonExistentFriendName)
                .friendNotFound()).isTrue();
        logOff();
    }

    private static Stream<Arguments> provideNonExistentFriends() {
        return Stream.of(
                Arguments.of("Пивень"),
                Arguments.of("ПивПивыч"),
                Arguments.of("Пивчанский")
        );
    }
}
