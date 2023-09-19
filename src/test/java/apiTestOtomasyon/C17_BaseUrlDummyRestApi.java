package apiTestOtomasyon;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlDummyRestApi extends BaseUrlJsonPlaceholder {

    /*
    Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin





    3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
    gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
    null oldugunu test edin
     */

    @Test
    public void test01(){

        /*
        1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde
            donen response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test
                edin
         */

        // 1- endpoint ve request body oluştur

        specJsonPlaceholder.pathParam("pp1","posts"); // base url'imiz specJsonPlaceholder olduğu için
                                                            // içerisinde de / dan sonra posts geldiği için
                                                            // pathparam kullanıyoruz eğer /dan sonra birden fazla
                                                            // parametre olsaydı pathparams kullanacaktık.
                                                            // içerisine de ilk önce bir isim verip sonrasında
                                                            // baseurlden sonraki parametreleri yazıyoruz.

        // 2- expected data oluştur
        // 3- request gönder ve dönen response'i kaydet

        Response response=given()
                                .when().spec(specJsonPlaceholder) //normalde get()'in içine url yazardık ama urlimiz zaten specJsonPlaceholder olduğu için when den sonra spec olarak belirttik. get'in içine yazdığımız ise baseurlden sonra gelen parametreyi belirtmek için.
                                .get("/{pp1}");

        // 4- assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));

    }

    @Test
    public void test02(){

        /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve “title” degerinin
        “optio dolor molestias sit” oldugunu test edin
         */

        // 1- endpoint ve request body oluştur
        specJsonPlaceholder.pathParams("pp1","posts","pp2",44);

        // 2- expected data oluştur
        // 3- request gönder ve dönen response'i kaydet

        Response response= given()
                                .when().spec(specJsonPlaceholder)
                                .get("/{pp1}/{pp2}");

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));


    }
}
