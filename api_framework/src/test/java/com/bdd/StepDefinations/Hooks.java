package com.bdd.StepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;


// execute this code only when place id in null
// write a code that gives you place id
public class Hooks {
    
    @Before("@DeletePlace")
    public void beforeScenario() throws IOException
    {
        stepDefination m = new stepDefination();

        if(stepDefination.place_id==null)
        {
        m.add_place_payload_with("Meenakshi", "hindi", "Australia");
        m.user_calls_with_http_request("AddPlaceAPI", "POST");
        m.verify_place_id_created_maps_to_using("Meenakshi", "getPlaceAPI");
        }

        
    }

}
