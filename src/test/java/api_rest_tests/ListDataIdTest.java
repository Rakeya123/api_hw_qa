package api_rest_tests;

import io.restassured.RestAssured;
import models.lombok.JobAndNameResponseLombokModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.SetNameAndJobSpec.ListDataIdRequestSpec;
import static specs.SetNameAndJobSpec.nameAndJobRequestSpec;

public class ListDataIdTest {

    @BeforeAll
    static void setUpConfig() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/unknown";
    }
    @Test
    void listDataIdTestAllure() {

       step("Make request", () ->
                       given(ListDataIdRequestSpec)


                               .when()
                               .get(("https://reqres.in/api/unknown"))

                               .then()
                               .log().status()
                               .log().body()
                               .statusCode(200));
        step("Check list of Date", () ->
                assertEquals("[1, 2, 3, 4, 5, 6]", is(List.of(1, 2, 3, 4, 5, 6))));
    }

//                .body("data.id", is(List.of(1, 2, 3, 4, 5, 6)));
//

    }
//    @Test
//    void listDataIdTest() {
//
//        var request = given()
//                .contentType(JSON)
//                .log().uri()
//                .when();
//
//        var response = request.get("https://reqres.in/api/unknown");
//
//        var validateResponse = response.then();
//        validateResponse
//                .log().status()
//                .log().body()
//                .statusCode(200)
//                .body("data.id", is(List.of(1, 2, 3, 4, 5, 6)));
//
//
//    }
