package ru.lanit.atschool.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    /**
     * Метод открывает браузер на заданной странице
     */
    public void openPage(String url) {
        driver.get(url);
        logger.info("Выполнен вход на страницу: " + url);
    }

    /**
     * Проверяет, что находится на главной странице
     */

    @FindBy(tagName = "h1")
    public WebElement headlineMainPage;

    /**
     * Переходит на страницу Категории
     */

    @FindBy(linkText = "Категории")
    public WebElement pageCategories;

    /**
     * Проверяет, что находится на странице категорий
     */

    @FindBy(tagName = "h1")
    public WebElement headlinePageCategories;

    /**
     * Переходит на страницу Пользователи
     */

    @FindBy(linkText = "Пользователи")
    public WebElement pageUsers;

    /**
     * Проверяет, что находится на странице пользователи
     */

    @FindBy(tagName = "h1")
    public WebElement headlinePageUsers;

    /**
     * Открывает поле поиск
     */

    @FindBy(xpath = "//*[@id='user-menu-mount']/div/div/div")
    public WebElement openSearch;

    /**
     * Вводит в поле поиск имя пользователя
     */

    @FindBy(xpath = "//*[@id='user-menu-mount']//input")
    public WebElement inputSearch;

    /**
     * Проверяет, что пользователь с таким именем найден
     */

    @FindBy(tagName = "h5")
    public WebElement checkFoundUser;
}