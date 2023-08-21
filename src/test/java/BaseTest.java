import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.page.MainPage;
import org.example.user.User;
import org.example.user.UserAction;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.example.constants.RestConfig.URL;

public class BaseTest {
    String email;
    String password;
    private final String chromeBrowser = "Chrome";
    private final String yandexBrowser = "Yandex";
    protected WebDriver driver;
    protected MainPage mainPage;

    @Before
    public void initializationWebDriver() {
        WebDriverManager.chromedriver().setup();
        selectBrowser(yandexBrowser);
        mainPage = new MainPage(driver);
        driver.get(URL);
        driver.manage().window().maximize();
    }

    public void selectBrowser(String browser) {
        if (browser.equals(yandexBrowser)) {
            driver = new ChromeDriver();
        } else if (browser.equals(chromeBrowser)) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\yandexdriver.exe");
            driver = new ChromeDriver();
        }
    }

    @After
    public void tearDown() {
        String accessToken = UserAction.loginUser(new User(email, password)).then().extract().path("accessToken");
        if (accessToken != null) {
            UserAction.deleteUser(accessToken);
        }
        driver.quit();
    }
}
