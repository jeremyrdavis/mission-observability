package io.arrogantprogrammer.infrastructure;

import io.arrogantprogrammer.domain.IMFAgentRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/imf")
public class IMFResource {
    static final Logger LOGGER = LoggerFactory.getLogger(IMFResource.class);

    @Inject
    IMFAgentRepository imfAgentRepository;

    @GET
    @Path("/agents")
    @Transactional
    public Response allAgents() {

        LOGGER.debug("returning all agents");
        return Response.ok().entity(imfAgentRepository.listAll()).build();
    }
}
