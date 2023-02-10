package rs.raf.userservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Util {
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static String objectToJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
    public static <T> Object jsonToObject(T objectType, String json) throws IOException {
        return objectMapper.readValue(json, objectType.getClass());
    }
}
