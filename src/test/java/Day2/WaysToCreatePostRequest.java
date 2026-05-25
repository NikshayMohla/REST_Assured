package Day2;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class WaysToCreatePostRequest {

    @Test
    void testPostUsingHashmap() {
        HashMap data = new HashMap<>();
        data.put("name", "Nikshay");
        data.put("location", "Chandigarh");
        data.put("phone", "099887766554");
        String courseArr[] = {"C", "C++"};
        data.put("courses", courseArr);

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name", equalTo("Nikshay"))
                .body("location", equalTo("Chandigarh"))
                .body("phone", equalTo("099887766554"))
                .header("content-type", "application/json")
                .log().all();
    }
}