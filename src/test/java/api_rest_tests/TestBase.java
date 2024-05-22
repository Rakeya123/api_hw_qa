package api_rest_tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
     void setUpConfig() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/2";
    }
}
