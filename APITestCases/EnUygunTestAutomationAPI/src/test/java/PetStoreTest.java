import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PetStoreTest {

    public static String url = "https://petstore.swagger.io/v2";
    public static Response response;
    Assert assertEquals;
    Random r=new Random(); //random sınıfı yardımıyla int değerinde id üretiyoruz
    int petID =r.nextInt(10)+1;  //1 den 10 a kadar olmasını istedim
    List<String> statusPet = Arrays.asList("available", "pending", "sold"); //Statüler için list oluşturdum



    @Test(priority=0)
    public void readAllAvailablePets() {

        // Test  :"available" parametresindeki tüm hayvanlar (GET)
        List<String> petListStatus;


        System.out.println("Test Edilen Durum:"+statusPet.get(0));
        response=  given()//response'un içine Postmande manuel olarak yaptığımız işleri kodun içinde doldurduk.
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .log().all()                        //.log().all() diyerek ayrıntılı bir şekilde response dönmesini istedik
                .get(url+"/pet/findByStatus?status="+statusPet.get(0))//statusPet.get(0) diyerek available durumunu atadık
                .then()
                .assertThat()
                .statusCode(200).extract().response();


        petListStatus= response.path("status");



        assertEquals(200,response.statusCode());    //statusCode kontrolü
        assertEquals("available",petListStatus.get(0));//Pet Status Kontrolü
        assertEquals("[application/json]",response.getHeaders().getValues("Content-Type").toString()); // Content-Type içeriyor mu Kontrol
        assertEquals("[GET, POST, DELETE, PUT]",response.getHeaders().getValues("Access-Control-Allow-Methods").toString()); // Access-Control-Allow-Methods içeriyor mu?Kontrol


        String res=response.asString();  //repons u görmek adına stringe atadık
        System.out.println(res);
    }
    @Test(priority=1)
    public void readAllPendingPets() {

        // Test :"pending" parametresindeki tüm hayvanlar (GET)
        List<String> petListStatus;


        System.out.println("Test Edilen Durum:"+statusPet.get(1));
        response=  given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .log().all()
                .get(url+"/pet/findByStatus?status="+statusPet.get(1))//statusPet.get(1) diyerek pending durumunu atadık
                .then()
                .assertThat()
                .statusCode(200).extract().response();


        petListStatus= response.path("status");
        assertEquals(200,response.statusCode());    //statusCode kontrolü
        assertEquals("pending",petListStatus.get(1));//Pet Status Kontrolü
        assertEquals("[application/json]",response.getHeaders().getValues("Content-Type").toString()); // Content-Type içeriyor mu Kontrol
        assertEquals("[GET, POST, DELETE, PUT]",response.getHeaders().getValues("Access-Control-Allow-Methods").toString()); // Access-Control-Allow-Methods içeriyor mu?Kontrol

    }

    @Test(priority=2)
    public void readAllSoldPets() {

        // Test :"sold" parametresindeki tüm hayvanlar (GET)
        List<String> petListStatus;


        System.out.println("Test Edilen Durum:"+statusPet.get(2));
        response=  given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .log().all()
                .get(url+"/pet/findByStatus?status="+statusPet.get(2))//statusPet.get(2) diyerek sold durumunu atadık
                .then()
                .assertThat()
                .statusCode(200).extract().response();


        petListStatus= response.path("status");
        assertEquals(200,response.statusCode());    //statusCode kontrolü
        assertEquals("sold",petListStatus.get(2));//Pet Status Kontrolü
        assertEquals("[application/json]",response.getHeaders().getValues("Content-Type").toString()); // Content-Type içeriyor mu Kontrol
        assertEquals("[GET, POST, DELETE, PUT]",response.getHeaders().getValues("Access-Control-Allow-Methods").toString()); // Access-Control-Allow-Methods içeriyor mu?Kontrol
    }

    @Test(priority=3)
    public void addNewPet(){
        // Test: Bodyde String değişken kullanarak  yeni bir evcil hayvan ekleme (POST)
        RestAssured.baseURI = url;
        String x="{\n" +
                "  \"id\": "+ petID +",\n" +
                "  \"category\": {\n" +
                "    \"id\": 61,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 61,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}\n";

        response = given().contentType("application/json")
                .accept("application/json")
                .body(x)
                .when().post(url+"/pet").then()
                .assertThat()
                .statusCode(200).extract().response();

        System.out.println("id : "+ petID);

    }
    @Test(priority=4)
    public void deletePet() {
        // Test :Yeni oluşturduğumuz evcil hayvanı silme durumu (DELETE)
        System.out.println(petID);
        given()
                .when()
                .delete(url+"/pet/"+ petID)
                .then()
                .assertThat()
                .statusCode(200);

    }
    @Test(priority=5)
    public void checkDeletedAgainPet() {

        // Test : Tekrar Silinmiş Pet'i kontrol etme     (DELETE)

        given()
                .when()
                .delete(url+"/pet/"+petID)
                .then()
                .assertThat()
                .statusCode(404);

    }

}
