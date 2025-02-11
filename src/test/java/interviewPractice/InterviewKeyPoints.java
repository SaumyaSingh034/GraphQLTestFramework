package interviewPractice;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;

public class InterviewKeyPoints {

    @Test
    public void checkForSpecificField(){
        when().get()
                .then().body("$", hasKey("lastName"))
                .body("$", not(hasKey("age")));
    }

    @Test
    public void createHashMap(){
        Map<String, String> workspace = new HashMap<>();
        workspace.put("name", "workspace");
        workspace.put("id", "X1234");
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("workspace", workspace);


    }

    @Test
    public void authentication(){
        given().auth().basic("username","password").when()
                .post("");
    }
}
