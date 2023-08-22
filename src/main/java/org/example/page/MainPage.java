package org.example.page;

import io.qameta.allure.Step;
import org.example.constants.BrowsConst;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BrowsConst {
    private final By makeBurger = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By bunButton = By.xpath(".//span[text()='Булки']");
    private final By saucesButton = By.xpath(".//span[text()='Соусы']");
    private final By fillingsButton = By.xpath(".//span[text()='Начинки']");
    public final By headerText = By.xpath(".//*[text()='Соберите бургер']");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидание загрузки главной страницы")
    public void waitForLoad() {
        waitForVisibility(makeBurger);
    }

    public String getMenu(){
        return driver.findElement(makeBurger).getText();
    }

    @Step("Нажатие на кнопку Личный кабинет")
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    @Step("Нажатие на кнопку Войти в аккаунт")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажатие на пункт меню Булки")
    public void clickBunButton() {
        driver.findElement(bunButton).click();
    }

    @Step("Нажатие на пункт меню Соусы")
    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }


    @Step("Нажатие на пункт меню Начинки")
    public void clickFillingsButton() {
        driver.findElement(fillingsButton).click();
    }

    @Step("Получить текст кнопки Оформить заказ")
        public boolean isOrderButtonVisible() {
            return driver.findElement(headerText).isDisplayed();
        }
}
