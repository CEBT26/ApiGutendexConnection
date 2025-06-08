package com.aluraCursos.proyecto1_API.librosAPI.ConsumoAPI;

/*
    Interface to determine the method that will be used in other classes.
 */
public interface IDataConverter {
    <T> T dataJson(String json, Class<T> kindClass);
}
