package com.pojo;

import com.fasterxml.jackson.databind.SerializationFeature;

public @interface JacksonFeatures {

    SerializationFeature[] serializationDisable();

}
