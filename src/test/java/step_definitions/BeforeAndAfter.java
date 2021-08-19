package step_definitions;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class BeforeAndAfter{
    public static WebDriver driver;

    
    @Before
    public void openBrowser() throws MalformedURLException {
    }

     
    @After
    public void embedScreenshot() {
    }
    
}