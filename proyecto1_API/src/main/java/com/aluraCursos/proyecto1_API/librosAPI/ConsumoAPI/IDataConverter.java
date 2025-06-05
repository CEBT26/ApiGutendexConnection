package com.aluraCursos.proyecto1_API.librosAPI.ConsumoAPI;

public interface IDataConverter {
    <T> T dataJson(String json, Class<T> kindClass);
}
