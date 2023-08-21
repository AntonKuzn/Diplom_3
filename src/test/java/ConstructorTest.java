import io.qameta.allure.junit4.DisplayName;
import org.example.page.MainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConstructorTest extends BaseTest {
    MainPage mainPage;

   @Before
    public void setUp() {
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Переход в 'Соусы'")
    public void testActiveSauceInConstructor() {
        mainPage.clickSaucesButton();
        String text = mainPage.getMenu();
        Assert.assertEquals("Соусы", text);
    }

    @Test
    @DisplayName("Переход в 'Начинки'")
    public void testActiveFillingInConstructor() {
        mainPage.clickFillingsButton();
        String text = mainPage.getMenu();
        Assert.assertEquals("Начинки", text);
    }

    @Test
    @DisplayName("Переход в 'Булки'")
    public void testActiveBunInConstructor() {
        mainPage.clickFillingsButton();
        mainPage.waitForLoad();
        mainPage.clickBunButton();
        String text = mainPage.getMenu();
        Assert.assertEquals("Булки", text);
    }
}
