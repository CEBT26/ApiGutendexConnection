package com.aluraCursos.proyecto1_API.librosAPI.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Book(Integer id,
                   String title,
                   authorBook author,
                   @JsonAlias("summaries") String resume,
                   String lenguages) {
}
