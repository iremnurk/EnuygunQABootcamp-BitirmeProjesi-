import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnUygunHomePage extends BasePage {

    //Locaters
    private final By cookieAlert=By.xpath("//*[@id=\"CookieAlert\"]/button");
    private final By originInputLocater = By.id("OriginInput");
    private final By firstOriginLocater = (new By.ByCssSelector("ul.react-autosuggest__suggestions-list  li[id='react-autowhatever-OriginInput-section-0-item-0']"));
    private final By destinationInputLocater = By.id("DestinationInput");
    private final By firstDestinationInputLocater =By.xpath("//li[@id='react-autowhatever-DestinationInput-section-0-item-1']");
    private final By calendarLocater = By.id("DepartureDate");
    private final By dayByDayCalendar =By.xpath("//div/table/tbody/tr/td[@aria-disabled='false']\n");


    public EnUygunHomePage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl);
        this.driver = driver;
    }

    public void setOrigin(String originText){
         sendKey(originInputLocater,originText);

    }
    public void setFirstOrigin(){
        click(firstOriginLocater);
    }


    public void setDestination(String destinationText){
      sendKey(destinationInputLocater,destinationText);

    }
    public void setFirstDestination(){
       click(firstDestinationInputLocater);
    }

    public void setCalendar(){
        click(calendarLocater);
    }

    public void cookieAlert(){
        click(cookieAlert);
    }



    }




