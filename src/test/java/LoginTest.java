import org.example.constants.BrowsConst;
import org.example.page.MainPage;
import org.example.page.PageLogin;
import org.example.page.RePassPage;
import org.example.page.RegPage;
import org.example.user.User;
import org.example.user.UserAction;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import io.qameta.allure.junit4.DisplayName;

public class LoginTest extends BaseTest {

    MainPage mainPage;
    PageLogin pageLogin;
    RegPage regPage;
    private User user;

    @Before
    public void setUp() {
        initializationWebDriver();
        mainPage = new MainPage(driver);
        pageLogin = new PageLogin(driver);
        regPage = new RegPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site");


        //создаем нового пользователя
        String name = "Star-Burger-Big";
        email = "super@star.burg";
        password = "1234321Test";
        user = new User(email, password, name);
        UserAction.createUser(user);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице")
    public void testLoginOnMainPage() {
        //клик на кнопку войти
        mainPage.clickLoginButton();
        //заполняем форму логина
        pageLogin.loginForm(email, password);
        pageLogin.clickLoginButton();
        //Проверяем что появилась кнопка оформить заказ
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка оформить заказ не появилась", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void testLoginByPersonalButton() {
        //клик на кнопку личный кабинет
        mainPage.clickAccountButton();
        pageLogin.loginForm(email, password);
        pageLogin.clickLoginButton();
        //Проверяем что появилась кнопка оформить заказ
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка оформить заказ не появилась", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void testLoginOnRegistrationPage() {
        mainPage.clickLoginButton();
        pageLogin.clickRegistrationButton();
        regPage.clickLogin();
        pageLogin.loginForm(email, password);
        pageLogin.clickLoginButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка оформить заказ не появилась", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void testLoginOnResetPasswordPage() {
        RePassPage regPage = new RePassPage(driver);

        mainPage.clickLoginButton();
        pageLogin.clickForgotPasswordButton();
        regPage.clickLogin();
        pageLogin.loginForm(email, password);
        pageLogin.clickLoginButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка оформить заказ не появилась", mainPage.isOrderButtonVisible());
    }
}
