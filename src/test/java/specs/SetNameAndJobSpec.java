package specs;


import io.restassured.specification.RequestSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.RestAssured.with;
public class SetNameAndJobSpec {
    public static RequestSpecification nameAndJobRequestSpec = with()
           // .filter(withCustomTemplates())
            .log().all()
            .contentType(JSON);

    public static RequestSpecification ListDataIdRequestSpec = with()
            //.filter(withCustomTemplates())
            .log().all()
            .contentType(JSON);

}
