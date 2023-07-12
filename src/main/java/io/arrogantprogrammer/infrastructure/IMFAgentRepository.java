package io.arrogantprogrammer.infrastructure;

import io.arrogantprogrammer.domain.IMFAgent;
import io.arrogantprogrammer.domain.Movie;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class IMFAgentRepository implements PanacheRepository<IMFAgent> {

    static final Logger LOGGER = LoggerFactory.getLogger(IMFAgentRepository.class);
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
}
