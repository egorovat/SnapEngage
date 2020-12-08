import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotHelper {

    WebDriver driver;

    public ScreenshotHelper(WebDriver driver){
        this.driver = driver;
    }

    public void takeScreenshot(String result){

        driver.manage().window().maximize();

        byte [] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

        try {
            LocalDateTime now = LocalDateTime.now();
            Files.write(Paths.get("./screens/screenshot_" + result + "_" + now.format(DateTimeFormatter.ISO_DATE_TIME) + ".jpg"),
                    screenshot, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
