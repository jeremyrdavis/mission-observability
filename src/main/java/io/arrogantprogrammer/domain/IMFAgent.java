package io.arrogantprogrammer.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class IMFAgent extends PanacheEntity {

    String name;

    public IMFAgent() {
    }

    public IMFAgent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IMFAgent{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
