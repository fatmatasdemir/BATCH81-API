package get_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonplaceholderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
          I send a GET request to the Url     // URL'ye bir GET isteği gönderiyorum
       And
           Accept type is "application/json"  // Kabul türü "applicationjson"
       Then
           HTTP Status Code should be 200    //HTTP Durum Kodu 200 olmalıdır
       And
           Response format should be "application/json" // Yanıt formatı "applicationjson" olmalıdır
       And
           There should be 200 todos      // 200 todo olmalı
       And
           "quis eius est sint explicabo" should be one of the todos title //todos başlıklarından biri olmalı
       And
           2, 7, and 9 should be among the userIds   // 2, 7 ve 9 kullanıcı kimlikleri arasında olmalıdır
     */

    @Test
    public void get01(){

        // 1. Set The Url

        spec.pathParam("first","todos");

        // 2. Set The expected Data

        // 3. Send The request And get The Response
        Response response=given().spec(spec).when().accept(ContentType.JSON).get("/{first}");
        response.prettyPrint();

        // 4. Do Assertion

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id",hasSize(200),
                        "title",hasItem("quis eius est sint explicabo"),
                        "userId",hasItems(2,7,9));



    }


}