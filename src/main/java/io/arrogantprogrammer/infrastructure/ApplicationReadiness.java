package io.arrogantprogrammer.infrastructure;

import io.arrogantprogrammer.domain.IMFAgentRepository;
import io.arrogantprogrammer.domain.MovieRepository;
import io.arrogantprogrammer.domain.QuoteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Readiness
@ApplicationScoped
public class ApplicationReadiness implements HealthCheck {

    static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadiness.class);

    @Inject
    IMFAgentRepository imfAgentRepository;

    @Inject
    MovieRepository movieRepository;

    @Inject
    QuoteRepository quoteRepository;

    @Override
    @Transactional
    public HealthCheckResponse call() {
        if (
                imfAgentRepository.listAll().size() >= 1
                && movieRepository.listAll().size() >= 1
                && quoteRepository.listAll().size() >=1
        ){
            return HealthCheckResponse.up("Database is up");
        }
        return HealthCheckResponse.down("Database not up");
    }
}
