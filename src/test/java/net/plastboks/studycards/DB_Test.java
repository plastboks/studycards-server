package net.plastboks.studycards;

import net.plastboks.studycards.entity.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by alex on 12/17/15.
 */
public class DB_Test
{

    @Test
    public void baseTest()
    {
        String email = "john@example.com";

        Set<ApiKey> keys = new HashSet<>();

        keys.add(new ApiKey("key1"));
        keys.add(new ApiKey("key2"));
        keys.add(new ApiKey("key3"));


        Colloquium col1 = new Colloquium("Col1");
        Set<Deck> decks = new HashSet<>();

        Deck deck1 = new Deck("Physics");
        Set<Card> questions1 = new HashSet<>();
        questions1.add(new Card("Physics - Question1", "Answer1"));
        questions1.add(new Card("Physics - Question2", "Answer1"));
        questions1.add(new Card("Physics - Question3", "Answer1"));
        questions1.add(new Card("Physics - Question4", "Answer1"));
        deck1.setCards(questions1);

        Deck deck2 = new Deck("Maths");
        Set<Card> questions2 = new HashSet<>();
        questions2.add(new Card("Math - Question1", "Answer1"));
        questions2.add(new Card("Math - Question2", "Answer1"));
        questions2.add(new Card("Math - Question3", "Answer1"));
        questions2.add(new Card("Math - Question4", "Answer1"));
        deck2.setCards(questions2);

        decks.add(deck1);
        decks.add(deck2);
        col1.setDecks(decks);
    }
}
