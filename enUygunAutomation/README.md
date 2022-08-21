<h1 align="center" > ENUYGUN TEST OTOMASYONU  </h1>


## 🎉src > main > java  
### <i>{Klasöründeki sınıflar ve açıklamaları}</i>
❕Gösterilen kodlar tüm kodları kapsamamaktadır markdown için örnek olarak proje içinden alınmışlardır.Kodlara klasörlerin altından ulaşabilirsiniz.

✨BasePage 

Bu classta  ortak kullanılacak değişkenler mevcut. Hepsini tekrar tekrar yazmak yerine buradan kalıtım yoluyla elde edebiliriz.

WebElement metodlarını oluşturdum
click sendKey ve find için ve metodlara parametreler verdim bu parametreler locaterlardan oluşuyor.


``` java
 public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void sendKey(By locator , String text){
        find(locator).sendKeys(text);
    }


```



✨EnUygunHomePage

``` java
public class EnUygunHomePage extends BasePage
```

Locaterların değişkenlere atanıp bulunduğu class .Locayerlar id ,cssSelector ve xPath ile bulunmuştur.

Yapılacak test işlemleri için metodlar oluşturuldu.



## 🎉src > test > java  
### <i>{Klasöründeki sınıflar ve açıklamaları}</i>

✨BaseTest

EnUygunHomePage nesnesi oluşturulup ,
ChromeDriver setup edilen class.
``` java
  @BeforeClass
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        enUygunHomePage=new EnUygunHomePage(driver);

    }
 ```   

 ✨FlightTicketTest
 ``` java 
 public class FlightTicketTest extends BaseTest 
 ```
 Testlerimizin olduğu class.
  ```
  
    @Test(priority = 4)
    public void setFirstDestination(){
        enUygunHomePage.setFirstDestination();
    }//-. Çıkan Sonuçlardan ilkine tıklanır

  ```

  ## Testlerin Tamamlanma Durumu
  ### <i>(6/14)</i><br><br>

  ✅1. Enuygun Flight ana sayfasına gidilir

  ✅2. Nereden input alanına Testte parametrik olarak alınan yurtiçi bir
şehir ismi girilir

✅3. Çıkan Sonuçlardan ilkine tıklanır

✅4. Nereye input alanına Testte parametrik olarak alınan yurtdışı bir
şehir ismi girilir.

✅5. Çıkan sonuçlardan ilki seçilir

✅6. Gidiş Tarihi input alanına tıklanır

❎7. Testten parametre olarak bugünden itibaren kaç gün sonra
gidilmek istendiği alınacak. Kaç gün sonra ise ona göre tarih
seçilecek.

❎8. Dönüş Tarihi input alanına tıklanır

❎9. Tessten parametre olarak gidişten kaç gün sonra dönülmek
istendindiği alınacak. Kaç gün sonra ise ona göre tarih seçilecek

❎10. Ucuz Bilet bul butonuna tıklanır

❎11. Verilen parameterlere uygun gidiş ve dönüş uçuşları bulunur.
Bu uçuşlar aynı paket içinde olmak zorunda

❎12. Gidiş uçuşu seçilir

❎13. Dönüş uçuşu seçilir

❎14. Seç butonuna tıklanır
