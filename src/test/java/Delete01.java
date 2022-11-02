
import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

    public class Delete01 extends JsonplaceholderBaseUrl {
  /*  Given
    https://jsonplaceholder.typicode.com/todos/198
    When
    I send DELETE Request to the Url
            Then
    Status code is 200
    And Response body is { }*/


        @Test
        public void delete01() {

            //1. step : set the url
            spec.pathParams("1","todos","2","198");

            //2. step: set the expected data

            Map<String,Object> expectedData=new HashMap<>();

            //3. step: send delete request and get the response
            Response response=given().spec(spec).when().delete("/{1}/{2}");

            //4.step: do assertion
            Map<String,Object> actualData=response.as(HashMap.class);
            response.then().assertThat().statusCode(200);

            assertEquals(actualData,expectedData);
        }
    }


/*


{
    "userId": 10,
    "id": 198,
    "title": "quis eius est sint explicabo",
    "completed": true
}
 */