package com.aluraCursos.proyecto1_API.librosAPI.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record BooksInformation(@JsonAlias("results") List<Book> bookInformation) {
}
