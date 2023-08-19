
import org.example.constants.RestConfig;
import org.example.user.User;

import org.example.user.UserAction;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    WebDriver driver;
    String email;
    String password;

    public void initializationWebDriver() {

        //Для запуска тестов на Yandex
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\ПК\\SW\\WebDriver\\bin\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);
        driver.get(RestConfig.URL);

        //Для запуска тестов на Chrome
   /*  ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(RestConfig.URL);*/

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
