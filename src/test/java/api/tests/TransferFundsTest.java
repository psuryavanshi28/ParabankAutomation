package api.tests;
import static io.restassured.RestAssured.given;


import org.testng.annotations.Test;

import api.base.ApiBaseTest;
import io.restassured.http.ContentType;

public class TransferFundsTest extends ApiBaseTest {

    @Test
    public void transferShouldReturnSuccess() {
        given()
            .contentType(ContentType.JSON)
            .body("{ \"fromAccount\": \"1234\", \"toAccount\": \"5678\", \"amount\": 100 }")
        .when()
            .post("/transferFunds")
        .then()
            .statusCode(200);
    }
}