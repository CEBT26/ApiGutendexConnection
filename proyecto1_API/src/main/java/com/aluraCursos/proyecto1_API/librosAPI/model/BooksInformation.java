package com.aluraCursos.proyecto1_API.librosAPI.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/*
    Record to save the principally information of json file
    the more important information is results in the json file, that is the information of the books.
    This is an array.
    Ignore the other elements.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record BooksInformation(@JsonAlias("results") List<Book> bookInformation) {
}
