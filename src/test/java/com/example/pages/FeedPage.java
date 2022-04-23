package com.example.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FeedPage {
    public static String URL = "https://ok.ru/feed";
    private static final HeaderBar FEED_NAV_BAR = new HeaderBar();
    private final SelenideElement FRIENDS_LINK = $(byXpath("//*[contains(@data-l, 't,userFriend')]"));
    private static final SelenideElement LIKE_BTN
            = $(byXpath("//*[contains(@class, 'feed-w')][1]//*[@data-like-icon]/parent::*"));
    private static final SelenideElement LIKE_COUNT
            = $(byXpath("//*[contains(@class, 'feed-w')][1]//*[@data-like-icon]//*[contains(@class, 'widget_count')]"));
    private static final SelenideElement OPEN_POSTING_MENU_BTN
            = $(byXpath("//*[contains(@class, 'pf-head __colored-svg')]"));
    private static final SelenideElement INPUT_POST_TEXT_FORM
            = $(byXpath("//*[contains(@class, 'posting_itx ')]"));
    private static final SelenideElement SUBMIT_POST_BTN
            = $(byXpath("//*[contains(@data-l, 't,button.submit')]"));
    private static final SelenideElement BEST_BACKGROUND
            = $(byXpath("//*[contains(@class, 'posting_cp_i js-color-picker-i js-color-picker-i-103')]"));
    private static final SelenideElement FIRST_POST_FROM_FEED
            = $(byXpath("//*[contains(@class, 'feed-list')]//*[contains(@class, 'media-text_cnt_tx')]"));;

    public FeedPage() {
        FEED_NAV_BAR.CONTENT.shouldBe(Condition.visible);
    }

    public static FeedPage openPage() {
        open(URL);
        return new FeedPage();
    }

    public LoginPage logout() {
        return FEED_NAV_BAR.logout();
    }

    public static String getURL() {
        return URL;
    }

    public MessagesPage openMessages() {
        return FEED_NAV_BAR.openMessages();
    }

    public FriendsPage openFriends() {
        FRIENDS_LINK.click();
        return new FriendsPage();
    }

    public GuestsPage openGuests() {
        return FEED_NAV_BAR.openGuests();
    }

    public NotificationsPage openNotifications() {
        return FEED_NAV_BAR.openNotifications();
    }


    public static boolean isOpen() {
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
        LIKE_BTN.click();
        LIKE_BTN.shouldHave(Condition.attribute("class", "widget  __active __wide-count"));
    }

    private static boolean containsClass(SelenideElement element, String className) {
        String attributes = element.getAttribute("class");
        if (attributes != null) {
            return attributes.contains(className);
        }
        return false;
    }

    public FeedPage publishPost(String quote) {
        OPEN_POSTING_MENU_BTN.click();
        INPUT_POST_TEXT_FORM.shouldBe(Condition.visible);
        INPUT_POST_TEXT_FORM.clear();
        INPUT_POST_TEXT_FORM.setValue(quote);
        BEST_BACKGROUND.click();
        SUBMIT_POST_BTN.click();
        return this;
    }

    public boolean checkWhetherPostWithTextDisplayed(String text) {
        return FIRST_POST_FROM_FEED.innerText().equals(text);
    }

    private static class HeaderBar {
        public final SelenideElement CONTENT = $(byXpath("//div[contains(@data-l, 't,filter')]"));
        private final SelenideElement MESSAGES_LINK = $(byXpath("//*[contains(@data-l, 't,messages')]"));
        private final SelenideElement GUESTS_LINK = $(byXpath("//*[contains(@data-l, 't,guests')]"));
        private static final SelenideElement NOTIFICATIONS_LINK = $(byXpath("//*[contains(@data-l, 't,notifications')]"));
        private static final SelenideElement MINI_USER_CARD = $(byXpath("//div[contains(@class, 'ucard-mini toolbar_ucard js-toolbar-menu')]"));
        private static final SelenideElement LOGOUT_LINK = $(byXpath("//a[@data-l='t,logout']"));
        private static final SelenideElement LOGOUT_CONFIRMATION = $(byId("hook_FormButton_logoff.confirm_not_decorate"));

        public MessagesPage openMessages() {
            MESSAGES_LINK.click();
            return new MessagesPage();
        }

        public GuestsPage openGuests() {
            GUESTS_LINK.click();
            return new GuestsPage();
        }

        public NotificationsPage openNotifications() {
            NOTIFICATIONS_LINK.click();
            return new NotificationsPage();
        }

        public LoginPage logout() {
            MINI_USER_CARD.click();
            LOGOUT_LINK.click();
            LOGOUT_CONFIRMATION.click();
            return LoginPage.openPage();
        }
    }
}
