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
public class QuoteRepository implements PanacheRepository<Quote> {

    static final Logger LOGGER = LoggerFactory.getLogger(QuoteRepository.class);
    @PostConstruct
    @Transactional
    void init() {
        List<Quote> quotes = new ArrayList<>(){{
            add(new Quote("We Just Rolled Up A Snowball And Tossed It Into Hell. Now Let's See What Chance It Has.", "Ethan Hunt"));
            add(new Quote("I Am The Storm.", "Ethan Hunt"));
            add(new Quote("I Would Have Thought The Hardest Part Was Serving That Pressing Need Of Yours To Get Your Gun Off.", "Ethan Hunt"));
            add(new Quote("The CIA Has Been Infiltrated. I Don't Trust Anybody Outside Of This Room. We're Gonna' Have To Go Alone.", "Ethan Hunt"));
            add(new Quote("I've Got A Charge In My Head. I'm Going To Die Unless You Kill Me!", "Ethan Hunt"));
            add(new Quote("If The Secretary Wanted Me Out Of There, It Must Be Pretty Bad Out Here.", "Ethan Hunt"));
            add(new Quote("Just Stay Alive! I'm NOT Going To Lose You!", "Ethan Hunt"));
            add(new Quote("If You're Dealing With Someone Who's Crushed, Stabbed, Shot And Detonated Five Members Of His Own IMF Team, How Devastated Do You Think You're Gonna' Make Him By Marching Ma And Uncle Donald Down To The County Court House?", "Ethan Hunt"));
            add(new Quote("If I Let You Know Where I'm Going, I Won't Be On Holiday.", "Ethan Hunt"));
            add(new Quote("What's Done Is Done, When We SAY It's Done!", "Ethan Hunt"));
            add(new Quote("Gentlemen, This Is Solomon Lane. Mr. Lane, Meet The IMF.", "Ethan Hunt"));
            add(new Quote("Desperate Times, Desperate Measures.", "Ethan Hunt"));
            add(new Quote("By Fire. That's The Best Way, Really.", "Ethan Hunt"));
            add(new Quote("Mission ACCOMPLISHED!", "Ethan Hunt"));
            add(new Quote("Kittridge, You've Never SEEN Me Very Upset!", "Ethan Hunt"));
        }};
        quotes.forEach(quote -> {
            quote.persist();
        });
    }

    public Quote randomQuote() {

        LOGGER.debug("returning a random quote");
        List<Quote> quotes = Quote.listAll();
        return quotes.get(new Random().nextInt(quotes.size()));
    }
}
