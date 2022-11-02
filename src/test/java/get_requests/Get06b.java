package get_requests;
import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

    public class Get06b extends ReqresBaseUrl {
     /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
              //3'ten büyük tüm kimlikleri konsolda yazdır / 3'ten büyük 3 kimlik olduğunu iddia et
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
              /Kimlikleri 3'ten küçük olan tüm adları konsolda yazdırın
               /Kimlikleri 3'ten küçük olan adların sayısının 2 olduğunu iddia edin
    */


        @Test
        public void get06(){

//Set the Url
            spec.pathParam("first","unknown");

//Set The Expected Data

//Send The Request and Get The Response
            Response response = given().spec(spec).when().get("/{first}");
            response.prettyPrint();

//Do Assertion
            JsonPath jsonPath = response.jsonPath();

//        1)Status code is 200
            assertEquals(200,response.getStatusCode());

//        2)Print all pantone_values /Tüm pantone_değerlerini yazdır
            System.out.println(jsonPath.getList("data.pantone_value"));

//        3)Print all ids greater than 3 on the console  /Konsolda 3'ten büyük tüm kimlikleri yazdır

            List<Integer> ids = jsonPath.getList("data.findAll{it.id>3}.id");
            System.out.println("ids = " + ids);

//        Assert that there are 3 ids greater than 3 //3 'ten büyük 3 kimlik olduğunu iddia edin
            assertEquals(3,ids.size());

//        4)Print all names whose ids are less than 3 on the console
            //Kimlikleri 3'ten küçük olan tüm adları konsolda yazdırın
            List<String> names = jsonPath.getList("data.findAll{it.id<3}.name");
            System.out.println("names = " + names);

//        Assert that the number of names whose ids are less than 3 is 2
            //Kimlikleri 3'ten küçük olan isimlerin sayısının 2 olduğunu iddia edin.
            assertEquals(2,names.size());


/*
[15-4020, 17-2031, 19-1664, 14-4811, 17-1456, 15-5217]   <------ data.pantone_value yazdirdik
ids = [4, 5, 6]
names = [cerulean, fuchsia rose]

 */





        }
    }









