package com.bdd.Resources;

// enum is special class in java which has collection of constants or method
public enum API_Resources {
    
        AddPlaceAPI("/maps/api/place/add/json"),
        getPlaceAPI("/maps/api/place/get/json"),
        deletePlaceAPI("/maps/api/place/delete/json");

        private String resource;

        API_Resources(String resource)
        {
                this.resource = resource;
        }

        public String getResource() 
        {
                return resource;
        }

}
