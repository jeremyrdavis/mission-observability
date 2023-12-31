package io.arrogantprogrammer.infrastructure;

import io.arrogantprogrammer.domain.Movie;
import io.arrogantprogrammer.domain.MovieRepository;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/movies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    static final Logger LOGGER = LoggerFactory.getLogger(MovieResource.class);

    @Inject
    MovieRepository movieRepository;

    @GET
    @Transactional
    @WithSpan("randomMovieSpan")
    public Response randomMovie() {

        LOGGER.debug("returning random movie");
        Movie movie = movieRepository.randomMovie();
        return Response.ok().entity(movie).build();
    }

    @GET
    @Path("/all")
    @Transactional
    @WithSpan("allMoviesSpan")
    public Response allMovies() {

        LOGGER.debug("returning all movies");
        return Response.ok().entity(movieRepository.listAll()).build();
    }
}
