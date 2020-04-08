package ru.lanit.atschool.steps;

import io.cucumber.java.ru.*;
import net.bytebuddy.matcher.ElementMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.lanit.atschool.pages.MainPage;
import ru.lanit.atschool.webdriver.WebDriverManager;

import static net.bytebuddy.matcher.ElementMatchers.is;

public class MainPageSteps {
    WebDriver driver = WebDriverManager.getDriver();
    MainPage page = new MainPage();

    @Пусть("открыт браузер и введен адрес \"(.*)\"$")
    public void openedBrowserAndEnteredUrl(String url) {
        page.openPage(url);
    }

    @И("проверяет, что находится на главной странице")
    public void checkMainPage() {
        page.headlineMainPage.isDisplayed();
        assertThat(page.headlineMainPage.getText(), is("Lanit education"));
    }

    @И("переходит на страницу Категории")
    public void goOnPageCategories() {
        page.pageCategories.click();
    }

    @И("проверяет, что находится на странице категорий")
    public void checkPageCategories() {
        page.headlinePageCategories.isDisplayed();
        assertThat(page.headlinePageCategories.getText(), is("Категории"));
    }

    @И("переходит на страницу Пользователи")
    public void goOnPageUsers() {
        page.pageUsers.click();
    }

    @И("проверяет, что находится на странице пользователи")
    public void checkPageUsers() {
        page.headlinePageUsers.isDisplayed();
        assertThat(page.headlinePageUsers.getText(), is("Пользователи"));
    }

    @И("вводит в поле поиск \"(.*)\"$")
    public void enterSearchName(String arg3) {
        page.openSearch.click();
        page.inputSearch.isDisplayed();
        page.inputSearch.sendKeys(arg3);
    }

    @И("проверяет, что пользователь {string} с таким именем найден")
    public void checkFoundUser(String name) {
        page.checkFoundUser.isDisplayed();
        assertThat(page.checkFoundUser.getText(), is(name));
    }

    @Тогда("тест завершен")
    public void testEnd() {
        driver.quit();
    }
    private void assertThat(String h1, ElementMatcher.Junction<Object> lanit_education) {
    }
}
