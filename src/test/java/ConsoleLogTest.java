import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class ConsoleLogTest {

    @Test
    public void consoleLogTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://makeseleniumeasy.com/");

        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = entry.getAll();

        for (LogEntry e : logs) {
            System.out.println(e);
        }

        for (LogEntry e : logs) {
            System.out.println("Message is: " + e.getMessage());
            System.out.println("Level is: " + e.getLevel());
        }
    }
}
