package Day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DummyJSON {
    int id;

    @Test(priority = 1)
    void getSingle() {
        given()
                .when()
                .get("https://dummyjson.com/posts")
                .then()
                .statusCode(200)
                .body("posts[0].title", equalTo("His mother had always taught him"))
                .log().all();
    }

    @Test(priority = 2)
    void createPost() {
        HashMap<String, String> data = new HashMap<>();
        data.put("title", "Hi this is a new post");
        data.put("userId", "6");
        id = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://dummyjson.com/posts/add")
                .jsonPath().getInt("id");
    }

    @Test(priority = 3, dependsOnMethods = {"createPost"})
    void updatePosts() {
        HashMap<String, String> data = new HashMap<>();
        data.put("title", "Hi this is a new post update");
        data.put("userId", "6");
        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put("https://dummyjson.com/posts/5" )
                .then().log().all();
    }
    @Test(priority = 4)
    void deletePosts() {

        given()
                .when()
                .delete("https://dummyjson.com/posts/5" )
                .then().log().all();
    }

}