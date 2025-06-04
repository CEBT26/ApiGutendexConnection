package Principal;

import com.aluraCursos.proyecto1_API.librosAPI.ConsumoAPI.ConsumoAPI;

public class Principal {

    public void informationBooks()
    {
        ConsumoAPI consumoApi = new ConsumoAPI();

        var json = consumoApi.obtenerDatos("https://gutendex.com/books/");
        System.out.println(json);


    }

}
