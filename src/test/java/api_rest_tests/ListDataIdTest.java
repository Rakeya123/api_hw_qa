package api_rest_tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import models.lombok.IdDataModel;
import models.lombok.IdModelDataItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.SetNameAndJobSpec.ListDataIdRequestSpec;


public class ListDataIdTest {

@BeforeAll static void setup() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }
    @Test
    void listDataIdTestAllure() {
        List<Integer> result =
                step("Make request", () -> {
                    var response = given(ListDataIdRequestSpec)


                            .when()
                            .get("https://reqres.in/api/unknown")

                            .then()
                            .log().status()
                            .log().body()
                            .statusCode(200)
                            .extract().as(IdDataModel.class);

                    List<Integer> ids = new ArrayList<>();
                    for (IdModelDataItem item : response.getData()) {
                        ids.add(item.getId());
                    }
                    return ids;
                    // return   response.getData().stream().map(IdModelDataItem::getId).toList();

                });

        step("Check list of Date", () ->
                assertEquals(result, List.of(1, 2, 3, 4, 5, 6)));
    }

//                .body("data.id", is(List.of(1, 2, 3, 4, 5, 6)));
//


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
    @Test
    void listDataIdTest() {


                    var response = given(ListDataIdRequestSpec)


                            .when()
                            .get("https://reqres.in/api/unknown")

                            .then()
                            .log().status()
                            .log().body()
                            .statusCode(200)
                            .extract().as(IdDataModel.class);

                    List<Integer> ids = new ArrayList<>();
                    for (IdModelDataItem item : response.getData()) {
                        ids.add(item.getId());
                    }
        List<Integer> result = ids;
                    // return   response.getData().stream().map(IdModelDataItem::getId).toList();



                assertEquals(result, List.of(1, 2, 3, 4, 5, 6));
    }
}