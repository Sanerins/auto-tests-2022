package com.example.tests;

import com.example.pages.FeedPage;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class LikeTest extends BaseTest {
    private static FeedPage feedPage;

    @BeforeAll
    public static void openPage() {
        feedPage = new FeedPage();
        open(feedPage.getURL());
    }
    
    @Test
    @Tag("Likes")
    @DisplayName("Likes test")
    public void setLike() {
        feedPage.unlikeFirstFeedBlock();

        int initialLikeCount = feedPage.getLikeCount();
        feedPage.likeFirstFeedBlock();

        assertThat(feedPage.getLikeCount()).isEqualTo(initialLikeCount + 1);
    }

    @AfterAll
    static void unlike() {
        feedPage.unlikeFirstFeedBlock();
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
