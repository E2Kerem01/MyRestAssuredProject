import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

public class Test01_GET {




    @Test
    void test_01(){

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.getBody());
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());

        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);



    }

    @Test
    void test_02 () {
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);

        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .body("data.id[0]", equalTo(7));


    }


}
