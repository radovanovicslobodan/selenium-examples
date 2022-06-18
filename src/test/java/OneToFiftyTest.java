import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OneToFiftyTest {

    @Test
    public void solveGameSelenium() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://zzzscore.com/1to50/en/?ts=1565597472067#");

        for (int i = 1; i <= 50; i++) {
            driver.findElement(By.xpath("//div[text()='" + i + "']")).click();
        }
    }
}
