package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage implements Page {
    private static final HeaderBar FEED_NAV_BAR = new HeaderBar();
    private static final SelenideElement LIKE_BTN
            = $(byXpath("//*[contains(@class, 'feed-w')][1]//*[@data-like-icon]/parent::*"));
    private static final SelenideElement LIKE_COUNT
            = $(byXpath(
            "//*[contains(@class, 'feed-w')][1]//*[@data-like-icon]//*[contains(@class, 'widget_count')]"));
    private static final SelenideElement OPEN_POSTING_MENU_BTN
            = $(byXpath("//*[contains(@class, 'pf-head __colored-svg')]"));
    private static final SelenideElement INPUT_POST_TEXT_FORM
            = $(byXpath("//*[contains(@class, 'posting_itx ')]"));
    private static final SelenideElement SUBMIT_POST_BTN
            = $(byXpath("//*[contains(@data-l, 't,button.submit')]"));
    private static final SelenideElement BEST_BACKGROUND
            = $(byXpath("//*[contains(@class, 'posting_cp_i js-color-picker-i js-color-picker-i-103')]"));
    private static final SelenideElement FIRST_POST_FROM_FEED
            = $(byXpath("//*[contains(@class, 'feed-list')]//*[contains(@class, 'media-text_cnt_tx')]"));
    public static final String URL = "https://ok.ru/feed";
    private final SelenideElement FRIENDS_LINK = $(byXpath("//*[contains(@data-l, 't,userFriend')]"));

    private static boolean containsClass(SelenideElement element, String className) {
        String attributes = element.getAttribute("class");
        if (attributes != null) {
            return attributes.contains(className);
        }
        return false;
    }

    public LoginPage logout() {
        return FEED_NAV_BAR.logout();
    }

    public MessagesPage openMessages() {
        return FEED_NAV_BAR.openMessages();
    }

    public FriendsPage openFriends() {
        FRIENDS_LINK.shouldBe(visible).click();
        return new FriendsPage();
    }

    public GuestsPage openGuests() {
        return FEED_NAV_BAR.openGuests();
    }

    public MusicPage openMusic() {
        return FEED_NAV_BAR.openMusic();
    }

    public NotificationsPage openNotifications() {
        return FEED_NAV_BAR.openNotifications();
    }

    public boolean isOpen() {
        return FEED_NAV_BAR.CONTENT.isDisplayed();
    }

    public int getLikeCount() {
        return Integer.parseInt(LIKE_COUNT.getText());
    }

    public void unlikeFirstFeedBlock() {
        if (containsClass(LIKE_BTN, "__active")) {
            LIKE_BTN.click();
        }
    }

    public void likeFirstFeedBlock() {
        LIKE_BTN.shouldBe(visible).click();
        LIKE_BTN.shouldHave(attribute("class", "widget  __active __wide-count"));
    }

    public FeedPage publishPost(String quote) {
        OPEN_POSTING_MENU_BTN.shouldBe(visible).click();
        INPUT_POST_TEXT_FORM.shouldBe(visible).clear();
        INPUT_POST_TEXT_FORM.setValue(quote);
        BEST_BACKGROUND.shouldBe(visible).click();
        SUBMIT_POST_BTN.shouldBe(visible).click();
        return this;
    }

    public boolean checkWhetherPostWithTextDisplayed(String text) {
        return FIRST_POST_FROM_FEED.shouldBe(visible).innerText().equals(text);
    }

    public String getURL() {
        return URL;
    }

    public void await() {
        FEED_NAV_BAR.CONTENT.shouldBe(visible);
    }
}
