package io.arrogantprogrammer.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Movie extends PanacheEntity {

    String title;

    public Movie() {
    }

    public Movie(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }
}
