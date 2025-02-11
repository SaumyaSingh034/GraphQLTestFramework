package interviewPractice;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.auth.AUTH;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BuildRequestSpec {
    @Test
    public void buildRequestSpecification(){
        RequestSpecification spec = new RequestSpecBuilder()
                .setBaseUri("")
                .setContentType(ContentType.JSON)
                .build();

        given().spec(spec)
                .body("")
                .when()
                .post("")
                .then().assertThat().log().all().statusCode(200);




    }
}
