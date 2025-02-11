package interviewPractice;

import org.testng.annotations.Test;
import requestBody.RequestBody;

import java.io.FileWriter;
import java.io.IOException;

public class JsonResponseInAFile {

    @Test
    public void responseInFile(){
        String response = RequestBody.requestBody1;
        System.out.println(response);
        try {
            FileWriter file = new FileWriter("src/main/java/resources/response.json");
            file.write(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
