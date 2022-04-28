package com.example.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FriendsPage {
    private static final SelenideElement FRIENDS_SEARCH_FIELD = $(byXpath("//input[@accesskey='s']"));
    public static String url = "https://ok.ru/friends";

    public FriendsPage() {
        FRIENDS_SEARCH_FIELD.shouldBe(visible);
    }

    public FriendsPage openPage() {
        open(url);
        return new FriendsPage();
    }

    public SearchFriendsPage searchPerson(String input) {
        char[] chars = input.toCharArray();
        for (char letter : chars) {
            FRIENDS_SEARCH_FIELD.append(String.valueOf(letter));
            /*
            В данной ситуации Sleep необходим, чтобы проэмулировать процесс печатания побуквенно, т.е так,
            как это делал бы обычный пользователь. Это необходимо так как это поле на сайте одноклассников поддерживает
            только такой, пользовательский ручной формат ввода. Если постараться просто добавить все буквы одновременно
            то одноклассники откажутся принимать ввод и будут считать, что поле все еще пустое
             */
            Selenide.sleep(50);
        }
        FRIENDS_SEARCH_FIELD.pressEnter();
        return new SearchFriendsPage();
    }
}

