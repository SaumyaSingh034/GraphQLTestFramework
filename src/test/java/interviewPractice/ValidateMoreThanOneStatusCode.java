package interviewPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.core.Is.is;

public class ValidateMoreThanOneStatusCode {

    @Test
    public void validateStatusCode(){
        given().header("","")
                .when()
                .get()
                .then()
                .statusCode(anyOf(is(200), is(201)));

        RequestSpecification request = RestAssured.given();
        request.header("","").auth().oauth2("")
                .contentType(ContentType.JSON);
    }
}
