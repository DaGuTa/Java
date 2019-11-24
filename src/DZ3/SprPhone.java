package DZ3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SprPhone {
    Map<String, ArrayList<String>> sprPhone;

    public void add(String fam, String phone) {
        ArrayList<String> resPhone = sprPhone.get(fam);
        if (resPhone == null) {
            resPhone = new ArrayList<String>();
        }
        resPhone.add(phone);
        sprPhone.put(fam, resPhone);
    }
    public void get(String fam){
        ArrayList<String> resPhone = sprPhone.get(fam);
        if (resPhone != null){
            System.out.println(fam +" номер(а):");
            for (int i = 0; i < resPhone.size(); i++) {
                System.out.println(resPhone.get(i));
            }
        } else{
            System.out.println(fam + "нет в справочнике");
        }
    }

    {
        sprPhone = new HashMap<>();
    }
}
