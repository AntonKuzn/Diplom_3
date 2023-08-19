package org.example.page;

import io.qameta.allure.Step;
import org.example.constants.BrowsConst;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RePassPage extends BrowsConst {
    private final By recoveryPassword = By.xpath("//h2[text()='Восстановление пароля']");
    private final By buttonEnter = By.xpath("//a[@href='/login']");
    private By recPasswordButton = By.xpath("//a[@href='/forgot-password']");

    public RePassPage (WebDriver driver) {
        super(driver);
    }

    @Step("Клик на 'Войти'")
    public void clickLogin() {
        driver.findElement(buttonEnter).click();
    }

    @Step("Клик на 'Восстановить пароль'")
    public void clickReset() {
        driver.findElement(recPasswordButton).click();
    }
    @Step("Ожидание загрузки страницы восстановления пароля")
    public void waitForLoad() {
        waitForVisibility(recoveryPassword);
    }
}
