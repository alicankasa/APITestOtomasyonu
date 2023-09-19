package apiTestOtomasyon;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {
    @Test

    public void test01(){
        JSONObject kisiselBilgiler=new JSONObject();
        JSONObject adresBilgileri =new JSONObject();

        JSONArray telefonBilgileriArray=new JSONArray();
        JSONObject cepTelefonuBilgileri=new JSONObject();
        JSONObject evTelefonuBilgileri=new JSONObject();

        adresBilgileri.put("streetAddress","naist street");
        adresBilgileri.put("city","Nara");
        adresBilgileri.put("postalCode","630-0192");


        cepTelefonuBilgileri.put("type","iPhone");
        cepTelefonuBilgileri.put("number","0123-4567-8888");
        evTelefonuBilgileri.put("type","home");
        evTelefonuBilgileri.put("number","0123-4567-8910");
        telefonBilgileriArray.put(cepTelefonuBilgileri);
        telefonBilgileriArray.put(evTelefonuBilgileri);

        kisiselBilgiler.put("firstname","John");
        kisiselBilgiler.put("lastname","Doe");
        kisiselBilgiler.put("age",26);
        kisiselBilgiler.put("address",adresBilgileri);
        kisiselBilgiler.put("phoneNumbers",telefonBilgileriArray);

        System.out.println(kisiselBilgiler);
        System.out.println(kisiselBilgiler.get("firstname"));

        System.out.println(kisiselBilgiler.getJSONObject("address").get("city"));
        System.out.println(kisiselBilgiler.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));


    }
}
