package Day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class First {
    int id;

    @Test(priority = 1)
    void getUser() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200)
                .body("title[0]", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .log().all();

    }

    @Test(priority = 2)
    void create() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "pavan");
        data.put("job", "Trainer");

        id = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .jsonPath().getInt("id");
        ;
//                .then()
//                .statusCode(201)
//                .log().all();

    }

    @Test(priority = 3, dependsOnMethods = {"create"})
    void update() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "pavan");
        data.put("job", "Trainer");
        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put("https://jsonplaceholder.typicode.com/posts/" + id)
                .then()
                .statusCode(200)
                .log().all();
    }

}