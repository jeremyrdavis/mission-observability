package io.arrogantprogrammer.infrastructure;

import io.arrogantprogrammer.domain.QuoteRepository;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
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

@Path("/quotes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuotesResource {
    static final Logger LOGGER = LoggerFactory.getLogger(QuotesResource.class);

    @Inject
    QuoteRepository quoteRepository;

    @GET
    @Transactional
    @Timed(value = "QuotesResource.randomQuote")
    @Counted(value = "time.now")
    public Response randomQuote() {

        return Response.ok().entity(quoteRepository.randomQuote()).build();
    }
}
