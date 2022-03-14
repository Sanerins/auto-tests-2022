package com.example.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codeborne.selenide.WebDriverRunner;

public interface Drivable {
    ChromeDriver browser = new ChromeDriver();;

    @BeforeAll
    static void createDriver() {
        System.setProperty("webdriver.chrome.driver",
                "/home/sanerin/GitHub/TestingTestProject/src/resources/chromedriver");
        WebDriverRunner.setWebDriver(browser);
    }

    @AfterAll
    static void closeDriver() {
        WebDriverRunner.closeWebDriver();
        browser.quit();
    }

}
