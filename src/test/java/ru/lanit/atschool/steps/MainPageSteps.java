package ru.lanit.atschool.steps;

import io.cucumber.java.After;
import io.cucumber.java.ru.*;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import net.bytebuddy.matcher.ElementMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import ru.lanit.atschool.pages.MainPage;
import ru.lanit.atschool.webdriver.WebDriverManager;

import java.io.File;
import java.nio.file.Files;

import static net.bytebuddy.matcher.ElementMatchers.is;

@Epic("Тестирование страниц и поиска")
public class MainPageSteps {
    WebDriver driver = WebDriverManager.getDriver();
    MainPage page = new MainPage();

    @Step("открыт браузер и введен адрес")
    @Пусть("открыт браузер и введен адрес \"(.*)\"$")
    public void openedBrowserAndEnteredUrl(String url) {
        page.openPage(url);
    }

    @Step("проверяет, что находится на главной странице")
    @И("проверяет, что находится на главной странице")
    public void checkMainPage() {
        page.headlineMainPage.isDisplayed();
        assertThat(page.headlineMainPage.getText(), is("Lanit education"));
    }

    @Step("переходит на страницу Категории")
    @И("переходит на страницу Категории")
    public void goOnPageCategories() {
        page.pageCategories.click();
    }

    @Step("проверяет, что находится на странице категорий")
    @И("проверяет, что находится на странице категорий")
    public void checkPageCategories() {
        page.headlinePageCategories.isDisplayed();
        assertThat(page.headlinePageCategories.getText(), is("Категории"));
    }

    @Step("переходит на страницу Пользователи")
    @И("переходит на страницу Пользователи")
    public void goOnPageUsers() {
        page.pageUsers.click();
    }

    @Step("проверяет, что находится на странице пользователи")
    @И("проверяет, что находится на странице пользователи")
    public void checkPageUsers() {
        page.headlinePageUsers.isDisplayed();
        assertThat(page.headlinePageUsers.getText(), is("Пользователи"));
    }

    @Step("вводит в поле поиск")
    @И("вводит в поле поиск \"(.*)\"$")
    public void enterSearchName(String arg3) {
        page.openSearch.click();
        page.inputSearch.isDisplayed();
        page.inputSearch.sendKeys(arg3);
    }

    @Step("проверяет, что пользователь с таким именем найден")
    @И("проверяет, что пользователь {string} с таким именем найден")
    public void checkFoundUser(String name) {
        page.checkFoundUser.isDisplayed();
        assertThat(page.checkFoundUser.getText(), is(name));
    }

    @After
    public void testEnd() {
        driver.quit();
    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] saveScreenchot(byte[] screenShot){return screenShot;}


    private void assertThat(String h1, ElementMatcher.Junction<Object> lanit_education) {
    }
}
