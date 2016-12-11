package net.plastboks.studycards;

import net.plastboks.studycards.entity.*;
import net.plastboks.studycards.repository.ColloquiumRepository;
import net.plastboks.studycards.repository.StudentRepository;
import net.plastboks.studycards.service.ColloquiumService;
import net.plastboks.studycards.service.DeckService;
import net.plastboks.studycards.service.StudentService;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

/**
 * Created by alex on 12/17/15.
 */
public class ServiceTest
{
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

        DeckService mockDecksService = mock(DeckService.class);
        decks.forEach(mockDecksService::create);

        Colloquium col1 = new Colloquium("Colloquium 1");
        col1.setDecks(decks);

        ColloquiumService mockCollRepository = mock(ColloquiumService.class);
        mockCollRepository.create(col1);
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

        StudentService mockStudentService = mock(StudentService.class);
        mockStudentService.create(student);
    }
}
