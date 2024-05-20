package api_rest_tests;

import models.lombok.JobAndNameLombokModel;

import models.lombok.JobAndNameResponseLombokModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.SetNameAndJobSpec.nameAndJobRequestSpec;

public class LombokNameAndJobTest extends TestBase {

    @DisplayName("Checking the successful user update with put method")
    @Test

    void successNameAndJobJobChangeTest() {

        JobAndNameLombokModel bodyParams = new JobAndNameLombokModel();
        bodyParams.setName("morpheus");
        bodyParams.setJob("zion resident");

        JobAndNameResponseLombokModel response = step("Make request", ()->
               given(nameAndJobRequestSpec)

                .body(bodyParams)



                .when()
                .put()

                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(JobAndNameResponseLombokModel.class));
        step("Check response Name", ()->
        assertEquals("morpheus", response.getName()) );
        step("Check response Job", ()->
        assertEquals("zion resident", response.getJob() ));
    }

    @Test
    void successNameChangeTest() {
        String authData = "{\"name\": \"morpheus1\", \"job\": \"zion resident\"}";


        given()
                .body(authData)
                .contentType(JSON)
                .log().uri()

                .when()
                .put("https://reqres.in/api/users/2")

                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", is("morpheus1"));
    }

    @Test
    void notNameChangeTest() {
        String authData = "{\"job\": \"zion resident\"}";


        given()
                .body(authData)
                .contentType(JSON)
                .log().uri()

                .when()
                .put("https://reqres.in/api/users/2")

                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", nullValue());
    }

    @Test
    void jobIsNotNullTest() {
        String authData = "{\"job\": \"zion resident\"}";

        var request = given()
                .body(authData)
                .contentType(JSON)
                .log().uri()
                .when();

        var response = request.put("https://reqres.in/api/users/2");

        var validateResponse = response.then();
        validateResponse
                .log().status()
                .log().body()
                .statusCode(200)
                .body("job", notNullValue());

    }

    @Test
    void listDataIdTest() {

        var request = given()
                .contentType(JSON)
                .log().uri()
                .when();

        var response = request.get("https://reqres.in/api/unknown");

        var validateResponse = response.then();
        validateResponse
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(List.of(1, 2, 3, 4, 5, 6)));


    }
}
