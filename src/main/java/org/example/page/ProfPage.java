package org.example.page;


import io.qameta.allure.Step;
import org.example.constants.BrowsConst;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfPage extends BrowsConst {
    By logoutButton = By.xpath(".//button[text()='Выход']");
    By buttonConstructor = By.linkText("Конструктор");
    By logoButton = By.className("AppHeader_header__logo__2D0X2");
    By profileButton = By.xpath("//a[@href='/account/profile']");

    public ProfPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидание загрузки главной страницы")
    public void waitForLoad() {
        waitForVisibility(profileButton);
    }

    @Step("Проверка видимости кнопки 'Профиль'")
    public boolean isProfileButtonVisible() {
        return driver.findElement(profileButton).isDisplayed();
    }

    @Step("Клик на кнопку 'Конструктор'")
    public void clickConstructor() {
        driver.findElement(buttonConstructor).click();
    }

    @Step("Клик на логотип")
    public void clickLogo() {
        driver.findElement(logoButton).click();
    }

    @Step("Клик на 'Выйти'")
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}
