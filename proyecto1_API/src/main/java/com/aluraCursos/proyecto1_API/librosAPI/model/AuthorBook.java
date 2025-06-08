package com.aluraCursos.proyecto1_API.librosAPI.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
    Only save the name of the author.
    Ignore the other elements.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorBook(@JsonAlias("name") String nameAuthor) {
}
