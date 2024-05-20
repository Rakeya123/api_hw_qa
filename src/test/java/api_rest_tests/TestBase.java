package api_rest_tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setUpConfig() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/2";
    }
}
