package com.aluraCursos.proyecto1_API.librosAPI.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(Integer id,
                   String title,
                   @JsonAlias("authors") List<AuthorBook> author,
                   @JsonAlias("summaries") List<String> resume,
                   @JsonAlias("languages") List<String> languages) {
}
