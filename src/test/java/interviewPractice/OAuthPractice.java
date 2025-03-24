package interviewPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class OAuthPractice {
    RequestSpecification specification;
    Response response;
    String accessToken = null;

    @BeforeTest
    public void setUpRequestSpec(){
        specification = given().baseUri("https://rahulshettyacademy.com/oauthapi");
    }

    @BeforeMethod
    public void generateAccessToken(){
        response = given().spec(specification)
                .formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type","client_credentials")
                .formParam("scope","trust")
                .log().all()
                .when().post("oauth2/resourceOwner/token")
                .then().statusCode(200).log().all()
                .extract().response();
        accessToken = response.jsonPath().getString("access_token");

    }

    @Test
    public void getCourseDetails(){
        if(accessToken != null){
            given()
                    .queryParams("access_token",accessToken).log().all()
                    .when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
                    .then().log().all();
        }
    }
}
