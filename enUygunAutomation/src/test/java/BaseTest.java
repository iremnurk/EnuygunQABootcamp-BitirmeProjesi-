import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;



public class BaseTest {

    protected WebDriver driver;
    EnUygunHomePage enUygunHomePage;


    @BeforeClass
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        enUygunHomePage=new EnUygunHomePage(driver);

    }

/*
    @AfterClass
    public  void tearDown(){
        System.out.println("Finished Test");
        driver.quit();
    }*/
}
