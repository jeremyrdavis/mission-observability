package io.arrogantprogrammer.infrastructure;

import io.arrogantprogrammer.domain.QuoteRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/quotes")
public class QuotesResource {
    static final Logger LOGGER = LoggerFactory.getLogger(QuotesResource.class);

    @Inject
    QuoteRepository quoteRepository;

    @GET
    @Transactional
    public Response randomQuote() {

        return Response.ok().entity(quoteRepository.randomQuote()).build();
    }
}
