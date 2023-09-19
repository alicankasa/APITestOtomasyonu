package apiTestOtomasyon;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C21_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {

    @Test
    public void test01(){

        /*
        1- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini
            yazarak “firstname” degeri “Eric” olan rezervasyon oldugunu test edecek bir GET
            request gonderdigimizde, donen response’un status code’unun 200 oldugunu ve “Eric”
            ismine sahip en az bir booking oldugunu test edin
         */

        // 1- endpoint ve request body oluştur

        specHerokuapp.pathParam("pp1","booking").queryParam("firstname","Susan"); //queryparamı burada kullanıyoruz

        //2- expected data oluştur

        // 3- request gönder dönen response kaydet

        Response response=given().when().spec(specHerokuapp).get("/{pp1}");

        // 4- assertion
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(2));
    }

    @Test
    public void test02(){

        /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini
            yazarak “firstname” degeri “Jim” ve “lastname” degeri “Jackson” olan rezervasyon
            oldugunu test edecek bir GET request gonderdigimizde, donen response’un status
            code’unun 200 oldugunu ve “Jim Jackson” ismine sahip en az bir booking oldugunu test
            edin
         */

        specHerokuapp.pathParams("pp1","booking")
                                .queryParams("firstname","Susan","lastname","Jones");

        Response response= given().when().spec(specHerokuapp).get("/{pp1}");


        response.then().assertThat().statusCode(200).body("bookingid",Matchers.hasSize(2));

    }
}
