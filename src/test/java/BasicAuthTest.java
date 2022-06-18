import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthTest {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void basicAuthTest() {
        String appUrl = "https://the-internet.herokuapp.com/basic_auth";

        ((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));

        driver.get(appUrl);
    }

    @Test
    public void secondAuthTest() {
        String appUrl = "https://the-internet.herokuapp.com/basic_auth";

        ((HasAuthentication) driver).register(() -> new UsernameAndPassword("admin", "admin"));

        driver.get(appUrl);
    }

    @Test
    public void thirdAuthTest() {
        String appUrl = "https://admin:admin@the-internet.herokuapp.com/basic_auth";

        driver.get(appUrl);
    }
}
