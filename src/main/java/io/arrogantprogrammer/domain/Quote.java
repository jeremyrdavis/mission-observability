package io.arrogantprogrammer.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Quote extends PanacheEntity {

    String text;

    String charachter;

    public Quote() {
    }

    public Quote(String text, String charachter) {
        this.text = text;
        this.charachter = charachter;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "text='" + text + '\'' +
                ", charachter='" + charachter + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public String getCharachter() {
        return charachter;
    }
}
