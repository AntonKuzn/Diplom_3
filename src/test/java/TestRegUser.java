import io.qameta.allure.junit4.DisplayName;
import org.example.page.MainPage;
import org.example.page.PageLogin;
import org.example.page.RegPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRegUser extends BaseTest {
    MainPage mainPage;
    PageLogin pageLogin;
    RegPage regPage;

    @Before
    public void setUp() {
        mainPage = new MainPage(driver);
        pageLogin = new PageLogin(driver);
        regPage = new RegPage(driver);
        mainPage.clickLoginButton();
        pageLogin.clickRegistrationButton();
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void testRegisterNewUser() {

        String name = "Burger-Big";
        email = "sup@star.burg";
        password = "1234321Test";
        regPage.fillRegistrationForm(name, email, password);
        regPage.clickRegisterButton();
        pageLogin.waitForLoad();
        pageLogin.loginForm(email, password);
        pageLogin.clickLoginButton();
        Assert.assertTrue("Регистрация не произошла", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля. Минимальный пароль — шесть символов")
    public void testErrorPassword() {
        String name = "Star-Burger-Big";
        email = "super@star.burg";
        password = "12343";
        regPage.fillRegistrationForm(name, email, password);
        regPage.clickRegisterButton();
        Assert.assertTrue("Ошибка о некорректном пароле не появилась",
                regPage.isIncorrectPasswordLabelVisible());
    }
}
