package interviewPractice;

import PojoPractice.Practice1.Company;
import PojoPractice.Practice1.Employee;
import PojoPractice.Practice1.EmployeeDetails;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import requestBody.RequestBody;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class HitPostRequest {

    @Test
    public void postRequest(){
        Response response = given().baseUri("")
                .log().all()
                .contentType(ContentType.JSON)
                .header("","")
                .body("")
                .when()
                .post("");

        response.then().assertThat().statusCode(200);
        int statusCode = response.getStatusCode();
        JsonPath js = new JsonPath(response.asString());
        js.get("");
    }

    @Test
    public void callRequestBody(){
        String response = RequestBody.requestBody1;
        JsonPath js = new JsonPath(response);
        int size = js.get("company.employee.size()");
        System.out.println(size);
        for(int i=0;i<size;i++){
            String name = js.get("company.employee["+i+"].name");
            System.out.println(name);
        }
    }

    @Test
    public void buildRequestBodyThroughPojo(){
        EmployeeDetails details = new EmployeeDetails();
        EmployeeDetails details1 = new EmployeeDetails();
        details.setId(4);
        details.setName("Saumya");
        details.setRole("Automation Engineer");
        details1.setId(5);
        details1.setName("Rahul");
        details1.setRole("SAP developer");
        ArrayList<EmployeeDetails> data = new ArrayList<>();
        data.add(details);
        data.add(details1);



        Employee employee = new Employee();
        employee.setEmployee(data);
        Company company = new Company();
        company.setEmp(employee);



        System.out.println(company.getEmp().getEmployee());
        System.out.println(company.getEmp().getEmployee().get(0).getName());
        System.out.println(company.getEmp().getEmployee().get(1).getName());

//        given().log().all().body(company)
//                .log().all().post("");
    }
}
