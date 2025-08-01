package api.tests;

import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

import api.base.ApiBaseTest;
import io.restassured.http.ContentType;

public class LoginTest extends ApiBaseTest {

    @Test
    public void loginShouldReturnSuccess() {
        given()
            .contentType(ContentType.JSON)
            .body("{ \"username\": \"test\", \"password\": \"pass\" }")
        .when()
            .post("/login")
        .then()
            .statusCode(200);
            
    }
}