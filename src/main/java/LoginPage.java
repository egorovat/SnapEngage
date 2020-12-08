import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="email")
    WebElement userName;

    @FindBy(id="password")
    WebElement password;

    @FindBy(name="Submit")
    WebElement btnLogin;

    public void setUserName(String name){

        userName.sendKeys(name);
    }

    public void setPassword(String pass){

        password.sendKeys(pass);
    }

    public void clickLoginButton(){

        btnLogin.click();
    }

    public void loginAs(String name, String pass) {

        setUserName(name);
        setPassword(pass);
        clickLoginButton();
    }
}