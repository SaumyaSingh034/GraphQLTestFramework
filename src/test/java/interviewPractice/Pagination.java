package interviewPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Pagination {

    @Test
    public void setupPagination(){
        int page = 1;
        while(true) {
            Response response = given().header("Content-Type", "Application/json")
                    .queryParam("page", page)
                    .when()
                    .get("")
                    .then().statusCode(200)
                    .extract().response();
            int totalUser = response.jsonPath().getList("data").size();
            if(totalUser == 0)
                break;
            page++;
        }

    }
}
