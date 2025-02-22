package interviewPractice;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import requestBody.RequestBody;

import static io.restassured.RestAssured.given;

public class Tesr {

    @Test
    public void test1() {
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri("")
                .setContentType(ContentType.JSON)
                .setBody("")
                .build();
        Response response = null;
        JsonPath js = response.jsonPath();

    }

    @Test(dataProvider = "helloTest")
    public void validateResponse() {
        String response = RequestBody.requestBody3;
        JsonPath js = new JsonPath(response);
        int a = js.get("response.status");
        System.out.println(a);
        String country = js.get("response.jsonBody.country");
        System.out.println(country);
        int size = js.get("response.jsonBody.places.size()");

        for (int i = 0; i < size; i++) {
            String placeName;
            String state;
            placeName = js.get("response.jsonBody.places[" + i + "].place name");
            state = js.get("response.jsonBody.places[" + i + "].state");
            System.out.println(placeName);
            System.out.println(state);
        }
    }

    @DataProvider(name="helloTest")
    public Object[][] dataTest(){
        return new Object[][] {
                { "Saumya","Test Automation Engineer"},
                {"John","Actor"}
        };
    }
}
