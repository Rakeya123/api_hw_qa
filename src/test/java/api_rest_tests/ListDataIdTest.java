package api_rest_tests;

import io.restassured.RestAssured;
import models.lombok.IdDataModel;
import models.lombok.IdModelDataItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.SetNameAndJobSpec.ListDataIdRequestSpec;

public class ListDataIdTest {

    @BeforeAll
    static void setUpConfig() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/unknown";
    }
    @Test
    void listDataIdTestAllure() {
AtomicReference<List<Integer>> result = new AtomicReference<>();
       step("Make request", () -> {
        var response =    given(ListDataIdRequestSpec)


                   .when()
                   .get()

                   .then()
                   .log().status()
                   .log().body()
                   .statusCode(200)
                .extract().as(IdDataModel.class);

           result.set(response.getData().stream().map(IdModelDataItem::getId).toList());

       });

        step("Check list of Date", () ->
                assertEquals(result.get(),List.of(1, 2, 3, 4, 5, 6)));
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
