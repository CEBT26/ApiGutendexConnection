package com.aluraCursos.proyecto1_API.librosAPI.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record authorBook(@JsonAlias("name") String nameAuthor) {
}
