package com.yui.workshopmongo.models.embedded;

import com.yui.workshopmongo.models.entities.User;

import java.util.Objects;

public class Author {

    private String  id;
    private String name;

    public Author(){}

    public Author(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(User entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
