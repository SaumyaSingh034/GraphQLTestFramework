package interviewPractice;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Preparation {
    RequestSpecification requestSpecification;

    @Test
    public void testData(){
        requestSpecification = given();
        requestSpecification.baseUri("test").contentType("Data");

        given().spec(requestSpecification).
                when().get("")
                .then().statusCode(200);
    }
}
