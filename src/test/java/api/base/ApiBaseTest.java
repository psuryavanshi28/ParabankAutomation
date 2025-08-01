package api.base;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ApiBaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://f2c56800-7f17-4a0b-83da-c9ff2073c941.mock.pstmn.io"; // replace with your actual mock URL
    }
}

