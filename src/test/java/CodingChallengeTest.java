import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CodingChallengeTest {

    private WebDriver driver;

    @BeforeTest
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver","target/test-classes/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void CleanUp() {
        driver.close();
    }

    @Test
    public void Login() {

        driver.get("https://snapengage-qa.appspot.com/signin?to=hub");

        driver.findElement(By.id("email")).sendKeys("pedroalmodovar@test.com");
        driver.findElement(By.id("password")).sendKeys("1q2w3e");
        driver.findElement(By.name("Submit")).click();

        Wait wait = new WebDriverWait(driver,5);
        wait.until(d -> driver.findElement(By.xpath("//div[@id='intro-box']/div[contains(@class,'StyledGreeting')]")).isDisplayed());

        String greeting = driver.findElement(By.xpath("//div[@id='intro-box']/div[contains(@class,'StyledGreeting')]")).getText();
        Assert.assertTrue(greeting.contains("Pedro Almodovar!"));

        this.TakeScreenshot(driver);

    }

    public void TakeScreenshot(WebDriver driver){

        driver.manage().window().maximize();

        byte [] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

        try {
            LocalDateTime now = LocalDateTime.now();
            Files.write(Paths.get("./screens/screenshot_" + now.format(DateTimeFormatter.ISO_DATE_TIME) + ".jpg"),
                    screenshot, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}