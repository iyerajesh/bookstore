package com.xylia.domain.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @JsonIgnore
    private String id = UUID.randomUUID().toString();
    private String name;

    public Author(String author) {
        this.name = author;
    }

}
