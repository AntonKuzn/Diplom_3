package org.example.page;

import io.qameta.allure.Step;
import org.example.constants.BrowsConst;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPage extends BrowsConst {


    private final By registerTitle = By.xpath("//h2[text()='Регистрация']");
    private final By userName = By.xpath(".//label[text()='Имя']/../input");
    private final By userEmail = By.xpath(".//label[text()='Email']/../input");
    private final By userPassword = By.xpath(".//label[text()='Пароль']/../input");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By signInButton = By.xpath(".//a[text()='Войти']");
    private final By errorShortPass = By.xpath(".//p[text() = 'Некорректный пароль']");

    public RegPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидание загрузки страницы Регистрации")
    public void waitForLoad() {
        waitForVisibility(registerTitle);
    }

    @Step("Заполнение формы регистрации")
    public void fillRegistrationForm(String name, String email, String password) {
        driver.findElement(userName).sendKeys(name);
        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(userPassword).sendKeys(password);
    }

    @Step("Клик на кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Проверка видимости надписи 'Неправильный пароль'")
    public boolean isIncorrectPasswordLabelVisible() {
        return driver.findElement(errorShortPass).isDisplayed();
    }

    @Step("Клик на кнопку 'Войти'")
    public void clickLogin() {
        driver.findElement(signInButton).click();
    }
}
