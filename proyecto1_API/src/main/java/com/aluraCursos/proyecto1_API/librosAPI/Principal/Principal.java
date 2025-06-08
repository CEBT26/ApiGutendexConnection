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

//Class Principal where developed all logic of the project
public class Principal {
    private ConsumeAPI consumeAPI = new ConsumeAPI();           //Variable to consume API information
    private DataConverter dataConverter = new DataConverter();  //Variable to convert API information to local object

    public void informationBooks()
    {
        AtomicInteger count = new AtomicInteger(1);                   //Variable count to determine the popular books
        var json = consumeAPI.obtenerDatos("https://gutendex.com/books/");  //Variable to get all API information
        System.out.println(json);                                               //Test to show the API information

        //Convert the API information to local objects
        var dataConverterObject = dataConverter.dataJson(json, BooksInformation.class);
        System.out.println(dataConverterObject);

        //General information of each book, only 5
        System.out.println("Books information: ");
        System.out.println("-----");
        List<Book> primeros5Libros = dataConverterObject.bookInformation()
                .stream()
                .limit(5)
                .collect(Collectors.toList());

        //Show the book´s information
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

        //10 more popular books into of API
        System.out.println("More popular books: ");
        json = consumeAPI.obtenerDatos("https://gutendex.com/books/?sort=popular");             //URL with command of the more popular books
        BooksInformation booksMorePopular = dataConverter.dataJson(json, BooksInformation.class);
        //System.out.println(booksMorePopular);

        //Books list with the information of each popular book
        List<Book> bookPopulars = booksMorePopular.bookInformation().stream()
                .limit(10)
                .collect(Collectors.toList());

        bookPopulars.forEach(book -> {
            System.out.println("Book more Popular " + count.getAndIncrement()+ ": " + book.title());
        });
    }

}
