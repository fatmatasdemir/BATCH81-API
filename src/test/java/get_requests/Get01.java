package get_requests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
 /*
 1-Postman'i  manuel API testleri icin kullandik
 2-Otomasyon testleri icin de Rest Assured Library kullanacagiz
 3-Otomasyon testlerimizi yaparken asagidaki adimlari izliyoruz

   a)Gereksinimleri anlamak,
   b)Test Case yaziyoruz
      i) Test Case yaziminda "Gherkin" dilini kullanacagiz.Bizler yazilim diline hakim olsakta ,karsimizdaki
      kisiler hakim olmayabilir ama herkin ile yazilan testleri anlamakta zorluk cekmeyeceklerdir.
      Gherkin dilinde kullanacagimiz keywordler;
      -Given: Ön kosullar,
      -When : Yapilacak aksiyonlar icin (get() ,put(), patch() , ve delete() )
      -Then: Istek yaptiktan  (request gönderdikten sonra) dogrulama
      -And : Coklu islemlerde kullanacagiz

    c)Test kodlarimizi yazmaya baslayacagiz
       i) Set the URL,
       ii)Set the expected Data (beklenen datanin olusturulmasi,Post ,Put ,Patch)
       iii)Type code to send request(Talep göndermek icin kod yazimi
       iv)Do Assertion(dogrulama yapmak)

 */



   /*
Given
 ""
    When
        User sends a GET Request to the url  //Kullanıcı url'ye bir GET İsteği gönderir
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
 */

 @Test
 public void get01(){
  // i) Set the URL
     String url=" https://restful-booker.herokuapp.com/booking/844";


     // ii)Set the expected Data (beklenen datanin olusturulmasi,Post ,Put ,Patch)
     //BIZDEN post ,put ,yada patch istemedigi icin bu case kullanmayacagiz


     //iii)Type code to send request(Talep göndermek icin kod yazimi)
    Response response= given().when().get(url);
    response.prettyPrint();


    //iv)Do Assertion(dogrulama yapmak)
     response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");
    //contentType JSON yazarsak fail olur bu yuzden (application/json) yazmamiz lazim yerine


   //Status Code konsola yazdiralim
     System.out.println("Status Code :"+response.getStatusCode());


     //Content Type konsola yazdiralim
     System.out.println("Content Type :"+ response.getContentType());


     //Status Line konsola yazdiralim
     System.out.println("Status Line :" +response.getStatusLine());


     //Header konsola yazdiralim
     System.out.println("Header :"+response.getHeader("Server"));

     //Headers konsola yazdiralim
     System.out.println("Header :" +response.getHeaders());

     //Time konsola yazdiralim
     System.out.println("Time :" +response.getTime());

 }







}
