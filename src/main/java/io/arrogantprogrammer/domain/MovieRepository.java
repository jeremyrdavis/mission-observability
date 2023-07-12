package io.arrogantprogrammer.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie> {

    static final Logger LOGGER = LoggerFactory.getLogger(MovieRepository.class);
    public Movie randomMovie() {

        LOGGER.debug("returning a random movie");
        List<Movie> allMovies = Movie.listAll();
        return allMovies.get(new Random().nextInt(allMovies.size()));
    }

    @PostConstruct @Transactional
    void insertMovies() {
        List<Movie> allMovies = new ArrayList<>(){{
            add(new Movie("Mission: Impossible"));
            add(new Movie("Mission: Impossible II"));
            add(new Movie("Mission: Impossible III"));
            add(new Movie("Mission: Impossible - Ghost Protocol"));
            add(new Movie("Mission: Impossible - Rogue Nation"));
            add(new Movie("Mission: Impossible - Fallout"));
            add(new Movie("Mission: Impossible - Dead Reckoning Part One"));
        }};
        allMovies.forEach(movie -> {
            movie.persist();
        });
    }
}
