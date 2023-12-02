package com.rest_assured.Files;

import io.restassured.path.json.JsonPath;

public class ReusableMethod {
    
    public static JsonPath rawtoJson(String response)

    {
        JsonPath js1 = new JsonPath(response);
        return js1;

    }
}
