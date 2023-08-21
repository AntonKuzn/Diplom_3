package org.example.page;
import io.qameta.allure.Step;
import org.example.constants.BrowsConst;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin extends BrowsConst {
    private static final By enterDocket = By.xpath("//h2[text()='Вход']");
    private final By enterButton = By.xpath("//h2[text()='Вход']");
    private final By emailInput = By.xpath("//input[@name='name']");
    private final By passwordInput = By.xpath("//input[@name='Пароль']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registrationButton = By.xpath(".//a[(@class='Auth_link__1fOlj' and text()='Зарегистрироваться')]");
    private final By forgotPasswordButton = By.xpath(".//a[(@class='Auth_link__1fOlj' and text()='Восстановить пароль')]");

    public PageLogin(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидание загрузки страницы авторизации")
    public void waitForLoad() {
        waitForVisibility(enterButton);
    }

    public void loginForm(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Клик на кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажатие на ссылку Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Нажатие на ссылку Восстановить пароль")
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    @Step("Validate opening login page")
    public static boolean validateOpeningLoginPage() {
            return driver.findElement(enterDocket).isDisplayed();
        }
    }

