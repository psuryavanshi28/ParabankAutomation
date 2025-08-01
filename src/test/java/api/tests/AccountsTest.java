package api.tests;


import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import api.base.ApiBaseTest;


public class AccountsTest extends ApiBaseTest{

    @Test
    public void getAccountsShouldReturnList() {
        given()
            .when()
            .get("/accounts")
            .then()
            .statusCode(200);
    }
}