package com.example.demo.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {

    public static String getJsonString(Object object){

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = null;
            jsonString = mapper.writeValueAsString(object);
            System.out.println(jsonString);
            return jsonString.toString();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
