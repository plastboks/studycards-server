package net.plastboks.studycards;

import net.plastboks.studycards.entity.*;
import net.plastboks.studycards.service.ColloquiumService;
import net.plastboks.studycards.service.DeckService;
import net.plastboks.studycards.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

/**
 * Created by alex on 12/17/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class ServiceTest
{
    @Mock StudentService studentService;
    @Mock ColloquiumService colloquiumService;
    @Mock DeckService deckService;

    @Test
    public void deckTest()
    {
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

        decks.forEach(deckService::save);

        Colloquium col1 = new Colloquium("Colloquium 1");
        col1.setDecks(decks);

        colloquiumService.save(col1);
    }

    @Test
    public void studentTest()
    {
        String email = "john@example.com";

        Student student = new Student(email);

        Set<ApiKey> keys = new HashSet<>();

        keys.add(new ApiKey("key1"));
        keys.add(new ApiKey("key2"));
        keys.add(new ApiKey("key3"));

        student.setKeys(keys);

        when(studentService.save(student)).thenReturn(student);
    }
}
