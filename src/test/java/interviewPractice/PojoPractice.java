package interviewPractice;

import PojoPractice.RahulShetty.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PojoPractice {
    @Test
    public void setupBody() throws JsonProcessingException {
        Root root = new Root();
        Courses courses = new Courses();
        List<WebAutomation> webAutomationList = new ArrayList<>();
        List<Mobile> mobile = new ArrayList<>();
        List<Api> api = new ArrayList<>();
        WebAutomation automation1 = new WebAutomation();
        WebAutomation automation2 = new WebAutomation();
        WebAutomation automation3 = new WebAutomation();

        Mobile mobile1 = new Mobile();
        Mobile mobile2 = new Mobile();
        Mobile mobile3 = new Mobile();

        Api api1 = new Api();
        Api api2 = new Api();


        root.setInstructor("RahulShetty");
        root.setUrl("rahulshettycademy.com");
        root.setServices("projectSupport");
        root.setExpertise("Automation");
        root.setLinkedIn("https://www.linkedin.com/in/rahul-shetty-trainer/");
        //WebAutomation
        automation1.setCourseTitle("Selenium Webdriver Java");
        automation1.setPrice("50");
        automation2.setCourseTitle("Cypress");
        automation2.setPrice("40");
        automation3.setCourseTitle("Protractor");
        automation3.setPrice("40");

        mobile1.setCourseTitle("Appium-Mobile Automation using Java");
        mobile1.setPrice("50");

        api1.setCourseTitle("Rest Assured Automation using Java");
        api1.setPrice("50");
        api2.setCourseTitle("SoapUI Webservices testing");
        api2.setPrice("40");

        webAutomationList.add(automation1);
        webAutomationList.add(automation2);
        webAutomationList.add(automation3);

        mobile.add(mobile1);
        api.add(api1);
        api.add(api2);
        courses.setWebAutomationList(webAutomationList);
        courses.setMobile(mobile);
        courses.setApi(api);
        root.setCourses(courses);
        ObjectMapper obj = new ObjectMapper();
        obj.writeValueAsString(root);


        given().contentType(ContentType.JSON).body(obj).log().all().when().post();


    }
}