package com.kevenreyes.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IConverterData {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtainData(String json, Class<T> classConv) {

        try {
            return objectMapper.readValue(json, classConv);

        } catch (JsonProcessingException e) {

            throw new RuntimeException(e);
        }
    }
}
