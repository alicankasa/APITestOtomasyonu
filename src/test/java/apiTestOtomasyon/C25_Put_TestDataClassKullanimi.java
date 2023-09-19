package apiTestOtomasyon;

import TestDatalari.TestDataJsonPlaceHolder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {

    @Test
    public void test01(){

        /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request
        yolladigimizda donen response’in
        status kodunun 200, content type’inin “application/json; charset=utf-8”, Connection header
        degerinin “keep-alive”
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body
        {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
        }

        Expected Data :
        {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
        }


         */

        // 1- endpoint ve request body oluştur

        specJsonPlaceholder.pathParams("pp1","posts","pp2","70");

        JSONObject requestBody= TestDataJsonPlaceHolder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");

        // 2- expected data oluştur
        JSONObject expectedData= TestDataJsonPlaceHolder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");

        // 3- request gönder dönen response kaydet

        Response response = given().spec(specJsonPlaceholder)
                                .when().body(requestBody.toString()).contentType(ContentType.JSON)
                                .put("/{pp1}/{pp2}");

        // 4- assertion

        JsonPath responseJsonPath= response.jsonPath();

        assertEquals(TestDataJsonPlaceHolder.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceHolder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceHolder.connectionHeader,response.header("Connection"));


        assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));
    }
}
