import org.example.page.MainPage;
import org.example.page.PageLogin;
import org.example.page.ProfPage;
import org.example.page.RegPage;
import org.example.user.User;
import org.example.user.UserAction;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProfilePageTest extends BaseTest {
    MainPage mainPage;
    PageLogin pageLogin;
    RegPage regPage;
    private ProfPage profPage;
    private User user;

    @Before
    public void setUp() {
        mainPage = new MainPage(driver);
        pageLogin = new PageLogin(driver);
        regPage = new RegPage(driver);
        profPage = new ProfPage(driver);

        String name = "Star-Burger-Big";
        email = "super@star.burg";
        password = "1234321Test";
        user = new User(email, password, name);
        UserAction.createUser(user);
        mainPage.clickLoginButton();
        pageLogin.waitForLoad();

        pageLogin.loginForm(email, password);
        pageLogin.clickLoginButton();
        mainPage.waitForLoad();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет».")
    public void testEnterPersonalAccount() {
        mainPage.clickAccountButton();
        profPage.waitForLoad();
        Assert.assertTrue("Вход в личный кабинет не выполнен", profPage.isProfileButtonVisible());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void testEnterConstructorByConstructorButton() {
        mainPage.waitForLoad();
        mainPage.clickAccountButton();
        profPage.waitForLoad();
        profPage.clickConstructor();
        mainPage.waitForLoad();
        Assert.assertTrue("Переход в конструктор не произошел", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void testEnterConstructorByLogo() {
        mainPage.waitForLoad();
        mainPage.clickAccountButton();
        profPage.waitForLoad();
        profPage.clickLogo();
        mainPage.waitForLoad();
        Assert.assertTrue("Переход в конструктор не произошел", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Проверка выхода по кнопке Выйти")
    public void testLogoutByButtonLogout() {
        mainPage.waitForLoad();
        mainPage.clickAccountButton();
        profPage.waitForLoad();
        profPage.clickLogout();
        pageLogin.waitForLoad();
        Assert.assertTrue("Выход не произошел", PageLogin.validateOpeningLoginPage());
    }
}
