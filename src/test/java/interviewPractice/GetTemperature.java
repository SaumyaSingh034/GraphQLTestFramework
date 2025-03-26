package interviewPractice;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import requestBody.RequestBody;

public class GetTemperature {
    @Test
    public void testInterview(){
        String response = RequestBody.requestBody5;
        JsonPath js = new JsonPath(response);
        int size = js.getInt("cities.size()");

        for(int i=0;i<size;i++){
            if(js.getInt("cities["+i+"].temp") > 40){
                System.out.println(js.getString("cities["+i+"].name"));
            }
        }
    }

    @Test
    public void testInterview1()
    {
        String response = RequestBody.requestBody5;
        //JSONPObject js = new JSONPObject(response.getBo);


    }}
