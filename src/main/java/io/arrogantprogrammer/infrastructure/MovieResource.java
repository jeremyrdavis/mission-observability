package io.arrogantprogrammer.infrastructure;

import io.arrogantprogrammer.domain.Movie;
import io.arrogantprogrammer.domain.MovieRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/movies")
public class MovieResource {

    static final Logger LOGGER = LoggerFactory.getLogger(MovieResource.class);

    @Inject
    MovieRepository movieRepository;

    @GET@Transactional
    public Response randomMovie() {

        Movie movie = movieRepository.randomMovie();
        return Response.ok().entity(movie).build();
    }
}