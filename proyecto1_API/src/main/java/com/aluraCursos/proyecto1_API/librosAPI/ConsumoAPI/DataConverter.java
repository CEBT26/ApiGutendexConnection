package com.aluraCursos.proyecto1_API.librosAPI.ConsumoAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
    Class to convert the API information to the objects with ObjectMapper.
 */
public class DataConverter implements IDataConverter{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T dataJson(String json, Class<T> kindClass){
        try{
            return objectMapper.readValue(json, kindClass);
        }catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
