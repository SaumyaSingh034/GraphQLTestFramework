package interviewPractice;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ThrottlingLimit {
    public static void main(String[] args){
        for(int i=0;i<=10; i++) {
            Response response = given().header("content-type", "application/json")
                    .when().get("");
            int statusCode = response.statusCode();
            System.out.println("Status Code : " + statusCode+" Attempted : "+(i+1));
            if (statusCode == 429) {
                System.out.println("Rate Limit Exceed");
            }
        }

    }
}
