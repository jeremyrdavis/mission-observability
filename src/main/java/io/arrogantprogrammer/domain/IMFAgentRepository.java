package io.arrogantprogrammer.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class IMFAgentRepository implements PanacheRepository<IMFAgent> {

    static final Logger LOGGER = LoggerFactory.getLogger(IMFAgentRepository.class);

    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    @Transactional
    void init() {

        LOGGER.debug("initialized IMFAgentRepository");
        List<IMFAgent> imfAgents = new ArrayList<>(){{
            add(new IMFAgent("Luther Stickell"));
            add(new IMFAgent("Benji Dunn"));
            add(new IMFAgent("William Brandt"));
            add(new IMFAgent("Grace"));
        }};
        imfAgents.forEach(imfAgent -> {
            imfAgent.persist();
        });

    }

//    @Fallback(fallbackMethod = "defaultIMFAgent")
    public IMFAgent randomAgent() {
        LOGGER.debug("returning a random agent");

        // potential failure
        final Long invocationNumber = counter.getAndIncrement();
        if (invocationNumber % 4 > 1) { // alternate 2 successful and 2 failing invocations
            LOGGER.error("failing with: {}!", invocationNumber);
            throw new RuntimeException("Service failed.");
        }
        List<IMFAgent> imfAgents = IMFAgent.listAll();
        return imfAgents.get(new Random().nextInt(imfAgents.size()));
    }

    IMFAgent defaultIMFAgent() {
        return new IMFAgent("Ethan Hunt");
    }
}
