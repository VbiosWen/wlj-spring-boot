package org.geeksword.springboot.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JackSonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static String toJson(Object object){
        try {
            return  objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
