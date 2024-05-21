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
import static org.junit.jupiter.api.Assertions.*;
import static specs.SetNameAndJobSpec.nameAndJobRequestSpec;

public class LombokNameAndJobTest extends TestBase {

    @DisplayName("Checking the successful user Name and Job update with put method")
    @Test
    void successNameAndJobJobChangeTest() {

        JobAndNameLombokModel bodyParams = new JobAndNameLombokModel();
        bodyParams.setName("morpheus");
        bodyParams.setJob("zion resident");

        JobAndNameResponseLombokModel response = step("Make request", () ->
                given(nameAndJobRequestSpec)

                        .body(bodyParams)


                        .when()
                        .put()

                        .then()
                        .log().status()
                        .log().body()
                        .statusCode(200)
                        .extract().as(JobAndNameResponseLombokModel.class));
        step("Check response Name", () ->
                assertEquals("morpheus", response.getName()));
        step("Check response Job", () ->
                assertEquals("zion resident", response.getJob()));
    }

    @DisplayName("Checking the successful user Name update with put method")
    @Test
    void successNameChangeTest() {
        // String authData = "{\"name\": \"morpheus1\", \"job\": \"zion resident\"}";
        JobAndNameLombokModel bodyParams = new JobAndNameLombokModel();
        bodyParams.setName("morpheus");

        JobAndNameResponseLombokModel response = step("Make request", () ->
                given(nameAndJobRequestSpec)


                        .body(bodyParams)

                        .when()
                        .put()

                        .then()
                        .log().status()
                        .log().body()
                        .statusCode(200)
                        .extract().as(JobAndNameResponseLombokModel.class));
        step("Check response Name", () ->
                assertEquals("morpheus", response.getName()));
    }

    @DisplayName("Checking nullValue user Name with put method")
    @Test
    void notNameChangeTest() {

        JobAndNameLombokModel bodyParams = new JobAndNameLombokModel();
        bodyParams.setJob("zion resident");

        JobAndNameResponseLombokModel response = step("Make request", () ->
                given(nameAndJobRequestSpec)


                        .body(bodyParams)

                        .when()
                        .put()

                        .then()
                        .log().status()
                        .log().body()
                        .statusCode(200)
                        .extract().as(JobAndNameResponseLombokModel.class));
        step("Check response null Name ", () ->
                //   assertEquals(nullValue(), response.getName()));
                assertNull(response.getName()));
    }
               // .body("name", nullValue());

    @DisplayName("Checking Job not nullValue")
    @Test
    void jobIsNotNullTestAllure() {
        JobAndNameLombokModel bodyParams = new JobAndNameLombokModel();
        bodyParams.setJob("zion resident");

        JobAndNameResponseLombokModel response = step("Make request", () ->
                given(nameAndJobRequestSpec)


                        .body(bodyParams)

                        .when()
                        .put()

                        .then()
                        .log().status()
                        .log().body()
                        .statusCode(200)
                        .extract().as(JobAndNameResponseLombokModel.class));
        step("Check response Job not null  ", () ->
                assertNotNull(response.getJob()));

    }

    @DisplayName("Checking Job not nullValue")
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

}
