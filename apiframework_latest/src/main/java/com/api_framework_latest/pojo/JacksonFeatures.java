package com.api_framework_latest.pojo;

import com.fasterxml.jackson.databind.SerializationFeature;

public @interface JacksonFeatures {

    SerializationFeature[] serializationDisable();

}
