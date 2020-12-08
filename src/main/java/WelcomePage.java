import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {

    Wait wait;

    public WelcomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,5);
    }

    @FindBy(xpath="//div[@id='intro-box']/div[contains(@class,'StyledGreeting')]")
    WebElement greetingMessage;

    @FindBy(xpath="//form[@name='signin']//div[@class='msg']")
    WebElement errorMessage;

    public String greetingMessage() {

        try {
            wait.until(d -> greetingMessage.isDisplayed());
        } catch (Exception e) {
            return "Greeting message not found";
        }

        return greetingMessage.getText();
    }

    public String errorMessage() {

        try {
            wait.until(d -> errorMessage.isDisplayed());
        } catch (Exception e) {
            return "Error message not found";
        }

        return errorMessage.getText();
    }
}
