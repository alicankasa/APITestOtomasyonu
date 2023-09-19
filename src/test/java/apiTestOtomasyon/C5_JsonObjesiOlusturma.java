package apiTestOtomasyon;

import org.json.JSONObject;
import org.junit.Test;

public class C5_JsonObjesiOlusturma {
    @Test
    public void test01(){
        /*
            {
            "firstname":"Jim",
            "additionalneeds":"Breakfast",
            "bookingdates":{
                    "checkin":"2018-01-01",
                    "checkout":"2019-01-01"   // 2 tane süslü parantez var içeriden başlayacağız
            },
            "totalprice":111,
            "depositpaid":true,
            "lastname":"Brown"
            }

         */

        JSONObject dateJsonObject = new JSONObject();
        dateJsonObject.put("checkin:","2018-01-01");
        dateJsonObject.put("checkout:","2019-01-01");

        JSONObject jsonObjectBody=new JSONObject();
        jsonObjectBody.put("firstname:","Jim");
        jsonObjectBody.put("additionalneeds:","Breakfast");
        jsonObjectBody.put("bookingdates:",dateJsonObject);
        jsonObjectBody.put("totalprice:",111);
        jsonObjectBody.put("depositpaid:",true);
        jsonObjectBody.put("lastname:","Brown");

        System.out.println(jsonObjectBody);



    }
}
