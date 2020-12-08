import org.assertj.core.api.Assertions;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CodingChallengeTestSuite {

    private WebDriver driver;
    private LoginPage loginPage;
    private WelcomePage welcomePage;
    private ScreenshotHelper screenshot;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver","target/test-classes/drivers/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        welcomePage = new WelcomePage(driver);
        screenshot = new ScreenshotHelper(driver);
    }

    @After
    public void cleanUp() {
        driver.close();
    }

    @Test
    public void testLoginWithCorrectUserData_LoginSuccessful() {


        driver.get("https://snapengage-qa.appspot.com/signin?to=hub");

        loginPage.loginAs("pedroalmodovar@test.com", "1q2w3e1");

        try {

            Assertions.assertThat(welcomePage.greetingMessage().contains("Pedro Almodovar!")).isTrue();
        } catch (ComparisonFailure e){
            screenshot.takeScreenshot("fail");
            Assertions.fail(e.getMessage());
        }
        screenshot.takeScreenshot("pass");
    }

    @Test
    public void testLoginWrongUserData_loginFailed() {


        driver.get("https://snapengage-qa.appspot.com/signin?to=hub");

        loginPage.loginAs("pedroalmodovar@test.com", "1q2w3e1");

        try {

            Assertions.assertThat(welcomePage.errorMessage().contains("Invalid email address or password"));
        } catch (ComparisonFailure e){
            screenshot.takeScreenshot("fail");
            Assertions.fail(e.getMessage());
        }
        screenshot.takeScreenshot("pass");
    }

    @Test
    public void testLoginWrongUserData_Locked() {


        driver.get("https://snapengage-qa.appspot.com/signin?to=hub");

        loginPage.loginAs("pedroalmodovar@test.com", "1q2w3e1");

        try {

            Assertions.assertThat(welcomePage.errorMessage().contains("Too many failed login attempts!"));
        } catch (ComparisonFailure e){
            screenshot.takeScreenshot("fail");
            Assertions.fail(e.getMessage());
        }
        screenshot.takeScreenshot("pass");
    }
}