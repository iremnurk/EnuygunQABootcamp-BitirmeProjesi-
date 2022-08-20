import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import static io.restassured.RestAssured.given;


public class GroceryStore {
    String url="";
    String endpoint="/allGrocery";

    // TEST: GET /allGrocery
    @Test
    public void allGrocery(){


        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when()
                        .get(url+endpoint)
                        .then()
                        .statusCode(200)
                        .extract().response();


        int id = response.path("id");
        int price = response.path("price");
        int stock = response.path("stock");
        String name = response.path("name").toString();

        Assert.assertEquals(200,response.statusCode());  //Status CODE Control
        Assert.assertEquals(1,id);   //ID CONTROL
        Assert.assertEquals(3,price);  //PRICE CONTROL
        Assert.assertEquals(100,stock);  //STOCK CONTROL
        Assert.assertEquals("apple",name);  //NAME CONTROL


    }




    // TEST :GET /allGrocery/{name}
    @Test
    public void allGroceryName(){
        List<String> fruitList = Arrays.asList("apple", "banana", "grapes");
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when()
                        .get(url+endpoint+fruitList.get(0))
                        .then()
                        .statusCode(200)
                        .extract().response();

    }
   //TEST :GET /allGrocery/{name}   unSuccessful
    @Test
    public void unSuccessfulAllGroceryName(){
        String unSuccesfulFruit="/applexXxx";
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when()
                        .get(url+endpoint+unSuccesfulFruit)//meyve ismi yanlış girildiğinde
                        .then()
                        .statusCode(404)
                        .extract().response();

    }

    //TEST :POST /add
    @Test
    public void addGrocery(){
      String data="{\n" +
              "\"id\": 4,\n" +
              "\"name\": \"string\",\n" +
              "\"price\": 12.3,\n" +
              "\"stock\": 3\n" +
              "}";
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(data)
                        .when()
                        .post(url)
                        .then()
                        .statusCode(200)
                        .extract().response();

    }

}



