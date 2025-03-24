package interviewPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LibraryAutomation {
    RequestSpecification requestSpecification;
    Response response;
    String id;

    @BeforeTest
    public void setUpBaseURI(){
        requestSpecification = given().baseUri("http://216.10.245.166");
    }

    @Test(priority = -1)
    public void postAddBook(){
        response = given().spec(requestSpecification)
                .body("{\n" +
                        "\n" +
                        "\"name\":\"Learn Appium Automation with Java\",\n" +
                        "\"isbn\":\"bagecd\",\n" +
                        "\"aisle\":\"2209927\",\n" +
                        "\"author\":\"John foe\"\n" +
                        "}\n").log().all()
                .when().post("Library/Addbook.php")
                .then().statusCode(200).log().all().extract().response();
        String msg = response.jsonPath().getString("Msg");
         id = response.jsonPath().getString("ID");
        System.out.println(msg);
        System.out.println(id);

    }

    @Test(enabled = false)
    public void getLibraryBookDetails(){
        given().spec(requestSpecification).queryParam("AuthorName","John foe")
                .log().all()
                .when().get("/Library/GetBook.php")
                .then().statusCode(200).log().all().extract().response();
    }

    @Test
    public void getBookById(){
        given().spec(requestSpecification).queryParam("ID",id)
                .log().all()
                .when().get("/Library/GetBook.php")
                .then().statusCode(200).log().all().extract().response();

    }

    @Test(priority = 1)
    public void deleteBookById(){
        response = given().spec(requestSpecification).body("{\n" +
                " \n" +
                "\"ID\" : \""+id+"\"\n" +
                " \n" +
                "} \n")
                .log().all()
                .when().post("/Library/DeleteBook.php")
                .then().statusCode(200).log().all()
                .extract().response();
        System.out.println(response.jsonPath().getString("msg"));
    }


}
