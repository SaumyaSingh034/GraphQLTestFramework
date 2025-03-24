package interviewPractice;

import io.restassured.path.json.JsonPath;
import requestBody.RequestBody;

public class Assignment {
    public static void main(String[] args){
        String response = RequestBody.requestBody4;
        JsonPath js = new JsonPath(response);

        // 1. Print No of courses returned by API
        int size = js.getInt("courses.size()");
        for(int i=0;i<size;i++){
            System.out.println(js.getString("courses["+i+"].title"));
        }

        // 2.Print Purchase Amount
        System.out.println(js.getInt("dashboard.purchaseAmount"));

        //3. Print Title of the first course
        System.out.println(js.getString("courses[0].title"));

        //4. Print All course titles and their respective Prices
        for(int i=0;i<size;i++){
            System.out.println("Course --> "+js.getString("courses["+i+"].title")
            +" Prices --> "+js.getInt("courses["+i+"].price"));
        }

        // 5  . Print no of copies sold by RPA Course
        for(int i=0;i<size;i++){
            if(js.getString("courses["+i+"].title").equals("RPA")){
                System.out.println(js.getInt("courses["+i+"].copies"));
            }
        }
        // 6. Verify if Sum of all Course prices matches with Purchase Amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        int sum = 0;
        for(int i=0;i<size;i++){
            int price = js.getInt("courses["+i+"].price");
            int copies = js.getInt("courses["+i+"].copies");
            int result = price * copies;
            sum += result;

        }
        if(purchaseAmount == sum){
            System.out.println("All Courses Price Matches with Purchase Amount");
        }
        else{
            System.out.println("Different Amount");
        }
        System.out.println(purchaseAmount);
        System.out.println(sum);
    }
}
