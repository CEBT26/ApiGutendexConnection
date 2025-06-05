package com.aluraCursos.proyecto1_API.librosAPI.Principal;

import com.aluraCursos.proyecto1_API.librosAPI.ConsumoAPI.ConsumeAPI;
import com.aluraCursos.proyecto1_API.librosAPI.ConsumoAPI.DataConverter;
import com.aluraCursos.proyecto1_API.librosAPI.model.BooksInformation;

public class Principal {
    private ConsumeAPI consumeAPI = new ConsumeAPI();
    private DataConverter dataConverter = new DataConverter();

    public void informationBooks()
    {
        var json = consumeAPI.obtenerDatos("https://gutendex.com/books/");
        System.out.println(json);

        //var dataConverter = dataConverter.dataJson(json, BooksInformation.class);
        //System.out.println(dataConverter);

    }

}
