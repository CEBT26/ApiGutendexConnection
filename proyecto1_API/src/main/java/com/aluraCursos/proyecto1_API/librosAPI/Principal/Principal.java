package com.aluraCursos.proyecto1_API.librosAPI.Principal;

import com.aluraCursos.proyecto1_API.librosAPI.ConsumoAPI.ConsumeAPI;
import com.aluraCursos.proyecto1_API.librosAPI.ConsumoAPI.DataConverter;
import com.aluraCursos.proyecto1_API.librosAPI.model.AuthorBook;
import com.aluraCursos.proyecto1_API.librosAPI.model.Book;
import com.aluraCursos.proyecto1_API.librosAPI.model.BooksInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Principal {
    private ConsumeAPI consumeAPI = new ConsumeAPI();           //Variable to consume API information
    private DataConverter dataConverter = new DataConverter();  //Variable to convert API information to object

    public void informationBooks()
    {
        AtomicInteger count = new AtomicInteger(1);
        var json = consumeAPI.obtenerDatos("https://gutendex.com/books/");
        System.out.println(json);

        var dataConverterObject = dataConverter.dataJson(json, BooksInformation.class);
        System.out.println(dataConverterObject);

        System.out.println("Books information: ");
        System.out.println("-----");
        List<Book> primeros5Libros = dataConverterObject.bookInformation()
                .stream()
                .limit(5) // esto toma solo los primeros 5 elementos
                .collect(Collectors.toList());

        primeros5Libros.forEach(book -> {
            System.out.println("ID: " + book.id());
            System.out.println("Título: " + book.title());
            System.out.println("Autor(es): " +
                    book.author().stream()
                            .map(AuthorBook::nameAuthor)
                            .collect(Collectors.joining(", "))
            );
            System.out.println("Resumen: " + (book.resume().isEmpty() ? "Sin resumen" : book.resume().get(0)));
            System.out.println("Idiomas: " + String.join(", ", book.languages()));
            System.out.println("-----");
        });

        System.out.println("More popular books: ");
        json = consumeAPI.obtenerDatos("https://gutendex.com/books/?sort=popular");
        BooksInformation booksMorePopular = dataConverter.dataJson(json, BooksInformation.class);
        //System.out.println(booksMorePopular);

        List<Book> bookPopulars = booksMorePopular.bookInformation().stream()
                .limit(10)
                .collect(Collectors.toList());

        bookPopulars.forEach(book -> {
            System.out.println("Book more Popular " + count.getAndIncrement()+ ": " + book.title());
        });
    }

}
