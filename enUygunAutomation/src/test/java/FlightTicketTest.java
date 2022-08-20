import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class FlightTicketTest extends BaseTest {

    @Test(priority = 0)  //CookieAlerti Kapatmak
    public void clickCookie(){
        enUygunHomePage.cookieAlert();
    }


    @Test(priority = 1)
    public void setOrigin() {
        enUygunHomePage.setOrigin("İstanbul");
    } //Nereden input alanına  yurtiçi bir şehir ismi girilir


    @Test(priority = 2)
    public void setFirstOrigin(){
        enUygunHomePage.setFirstOrigin();

    }//-. Çıkan Sonuçlardan ilkine tıklanır

    @Test(priority = 3)
    public void setDestination(){
        enUygunHomePage.setDestination("Amsterdam");
    }//Nereye input alanına yurtdışı bir şehir ismi girilir.

    @Test(priority = 4)
    public void setFirstDestination(){
        enUygunHomePage.setFirstDestination();
    }//-. Çıkan Sonuçlardan ilkine tıklanır

    @Test(priority = 5)
    public void setCalendar(){
        enUygunHomePage.setCalendar();
    }//-Gidiş Tarihi input alanına tıklanır




}
