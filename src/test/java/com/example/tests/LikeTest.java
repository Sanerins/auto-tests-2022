package com.example.tests;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.pages.FeedPage;

public class LikeTest extends BaseTest {
    @Test
    void setLike() throws IOException {
        FeedPage feedPage = authorize();
        feedPage.unlikeFirstFeedBlock();

        int initialLikeCount = feedPage.getLikeCount();
        feedPage.likeFirstFeedBlock();

        Assertions.assertEquals(initialLikeCount + 1, feedPage.getLikeCount());
    }
}
