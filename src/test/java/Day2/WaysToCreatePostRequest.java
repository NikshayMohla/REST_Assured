package Day2;

import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class WaysToCreatePostRequest {

    //    @Test(priority = 1)
//    void testPostUsingHashmap() {
//        HashMap data = new HashMap<>();
//        data.put("name", "Nikshay");
//        data.put("location", "Chandigarh");
//        data.put("phone", "099887766554");
//        String courseArr[] = {"C", "C++"};
//        data.put("courses", courseArr);
//
//        given()
//                .contentType("application/json")
//                .body(data)
//                .when()
//                .post("http://localhost:3000/students")
//
//                .then()
//                .statusCode(201)
//                .body("name", equalTo("Nikshay"))
//                .body("location", equalTo("Chandigarh"))
//                .body("phone", equalTo("099887766554"))
//                .header("content-type", "application/json; charset=utf-8")
//                .log().all();
//    }
//    @Test(priority = 2)
//    void testPostUsingJsonLibrary() {
//        JSONObject data = new JSONObject();
//        data.put("name", "Nikshay");
//        data.put("location", "Chandigarh");
//        data.put("phone", "099887766554");
//        String courseArr[] = {"C", "C++"};
//        data.put("courses", courseArr);
//
//
//        given()
//                .contentType("application/json")
//                .body(data.toString())
//                .when()
//                .post("http://localhost:3000/students")
//
//                .then()
//                .statusCode(201)
//                .body("name", equalTo("Nikshay"))
//                .body("location", equalTo("Chandigarh"))
//                .body("phone", equalTo("099887766554"))
//                .header("content-type", "application/json; charset=utf-8")
//                .log().all();
//    }

    @Test(priority = 2)
    void testPostUsingPOJOClass() {//plain old java object
        POJO_postreq data = new POJO_postreq();
        data.setName("Nikshay");
        data.setLocation("Mohali");
        data.setPhone("2020202020");
        String[] arr = {"C++", "C"};
        data.setCoursesArr(arr);


        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name", equalTo("Nikshay"))
                .body("location", equalTo("Chandigarh"))
                .body("phone", equalTo("099887766554"))
                .header("content-type", "application/json; charset=utf-8")
                .log().all();
    }

    @Test(priority = 3)
    void deleteStudent() {
        given()
                .when()
                .delete("http://localhost:3000/students/11")
                .then().statusCode(200);
    }
}