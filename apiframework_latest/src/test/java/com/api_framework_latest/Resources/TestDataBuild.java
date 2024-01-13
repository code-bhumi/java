package com.api_framework_latest.Resources;

import java.util.ArrayList;
import java.util.List;
import com.api_framework_latest.pojo.AddPlace;
import com.api_framework_latest.pojo.Location;

public class TestDataBuild {
    
    public AddPlace addPlacePayLoad(String name, String language, String address)
    {
                
        AddPlace pl = new AddPlace();
        pl.setAccuracy(50);
        pl.setAddress(address);
        pl.setLanguage(language);
        pl.setName(name);
        pl.setPhone_number("(+91) 983 893 3937");
        pl.setWebsite("https://rahulshettyacademy.com");
        List<String> myList = new ArrayList<String>();
        myList.add("shop");
        myList.add("shoe park");

        pl.setTypes(myList);
        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        pl.setLocation(l);
        return pl;
    }

}
