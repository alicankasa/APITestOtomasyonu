package apiTestOtomasyon;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class C9_Get_TestYaparakenTekrarlardanKurtulma {
    @Test
    public void test01() {

        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
        donen Response’un,
        status code’unun 200,
        ve content type’inin application-json,
        ve response body’sindeki
        "firstname“in, "Susan",
        ve "lastname“in, "Jackson",
        ve "totalprice“in, 612,
        ve "depositpaid“in, false,
        ve "additionalneeds“in, boş
        oldugunu test edin

         */

        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);

        /*
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Susan"))
                .body("lastname", Matchers.equalTo("Jackson"))
                .body("totalprice", Matchers.equalTo(612))
                .body("depositpaid", Matchers.equalTo(false))
                .body("additionalneeds", Matchers.notNullValue());

         */


        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Eric"),
                        "lastname", equalTo("Jackson"),
                        "totalprice", lessThan(1000),
                        "depositpaid", equalTo(false),
                        "additionalneeds", notNullValue());

    }
}