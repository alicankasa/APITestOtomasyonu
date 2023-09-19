package apiTestOtomasyon;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C1_GetRequest_ResponseBodyYazdirma {

    @Test

    public void get01(){

        //https://restful-booker.herokuapp.com/booking/10 url'ine
        //bir GET request gonderdigimizde donen Respons'u yazdirin

        // 1- request body ve end-point hazirlama
        String url= "https://restful-booker.herokuapp.com/booking/10";

        // 2- expected data hazirlama
        // 3- request gonderip, donen respons'i kaydetme
        Response response= given().when().get(url);
        response.prettyPrint();

        // 4- assertion
    }
}
