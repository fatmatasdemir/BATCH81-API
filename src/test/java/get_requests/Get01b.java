package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get01b {


        /*
           Given
               https://reqres.in/api/users/3
           When
               User sends a GET Request to the url //Kullanıcı url'ye bir GET İsteği gönderir
           Then
               HTTP Status Code should be 200  //HTTP Durum Kodu 200 olmalıdır
           And
               Content Type should be JSON  //İçerik Türü JSON olmalıdır
           And
               Status Line should be HTTP/1.1 200 OK  //Durum Satırı HTTP1.1 200 OK olmali
        */
      @Test
        public  void get01(){

            //Set the URL
            String url = "https://reqres.in/api/users/3";

            //Set The Expected Data

            //Send The Request and Get The Response  //İsteği Gönderin ve Yanıtı Alın
            Response response = given().when().get(url);
            response.prettyPrint();

            //Do Assertion

//        HTTP Status Code should be 200
//        Content Type should be JSON
//        Status Line should be HTTP/1.1 200 OK
            response.
                    then().
                    statusCode(200).
                    contentType(ContentType.JSON).
                    statusLine("HTTP/1.1 200 OK");
        }
    }















