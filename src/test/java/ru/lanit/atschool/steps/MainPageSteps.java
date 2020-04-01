package ru.lanit.atschool.steps;

import io.cucumber.java.ru.*;
import net.bytebuddy.matcher.ElementMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.lanit.atschool.webdriver.WebDriverManager;

import static net.bytebuddy.matcher.ElementMatchers.is;

public class MainPageSteps {
    WebDriver driver = WebDriverManager.getDriver();

    @Пусть("открыт браузер и введен адрес \"(.*)\"$")
    public void openedBrowserAndEnteredUrl(String url) {
        driver.get(url);
    }

    @И("проверяет, что находится на главной странице")
    public void checkMainPage() {
        driver.findElement(By.tagName("h1")).isDisplayed();
        assertThat(driver.findElement(By.tagName("h1")).getText(), is("Lanit education"));
    }

    @И("переходит на страницу Категории")
    public void goOnPageCategories() {
        driver.findElement(By.linkText("Категории")).click();
    }

    @И("проверяет, что находится на странице категорий")
    public void checkPageCategories() {
        driver.findElement(By.xpath("//*[@id='categories-mount']")).isDisplayed();
        assertThat(driver.findElement(By.tagName("h1")).getText(), is("Категории"));
    }

    @И("переходит на страницу Пользователи")
    public void goOnPageUsers() {
        driver.findElement(By.linkText("Пользователи")).click();
    }

    @И("проверяет, что находится на странице пользователи")
    public void checkPageUsers() {
        driver.findElement(By.xpath("//*[@id='page-mount']")).isDisplayed();
        assertThat(driver.findElement(By.tagName("h1")).getText(), is("Пользователи"));
    }

    @И("вводит в поле поиск \"(.*)\"$")
    public void enterSearchName(String arg3) {
        driver.findElement(By.xpath("//*[@id='user-menu-mount']/div/div/div")).click();
        driver.findElement(By.xpath("//*[@id='user-menu-mount']//input")).isDisplayed();
        driver.findElement(By.xpath("//*[@id='user-menu-mount']//input")).sendKeys(arg3);
    }

    @И("проверяет, что пользователь {string} с таким именем найден")
    public void checkFoundUser(String name) {
        driver.findElement(By.xpath("//*[@id='user-menu-mount']//li[3]//div[2]/h5")).isDisplayed();
        assertThat(driver.findElement(By.tagName("h5")).getText(), is(name));
    }

    @Тогда("тест завершен")
    public void тестЗавершен() {
        driver.quit();
    }
    private void assertThat(String h1, ElementMatcher.Junction<Object> lanit_education) {
    }
}
