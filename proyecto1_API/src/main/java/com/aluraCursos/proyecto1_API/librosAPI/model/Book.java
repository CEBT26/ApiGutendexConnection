package com.aluraCursos.proyecto1_API.librosAPI.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/*
    Save the information of each book.
    In the author is an array.
    Ignore the other elements.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(Integer id,
                   String title,
                   @JsonAlias("authors") List<AuthorBook> author,
                   @JsonAlias("summaries") List<String> resume,
                   @JsonAlias("languages") List<String> languages) {
}
