package net.plastboks.studycards;

import net.plastboks.studycards.model.ColloquiumDAO;
import net.plastboks.studycards.model.StudentDAO;
import net.plastboks.studycards.model.type.*;
import org.junit.Test;
import static org.junit.Assert.*;

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

        StudentDAO studentDAO = new StudentDAO();

        Student student = new Student(email, "ping");

        Set<ApiKey> keys = new HashSet<>();

        keys.add(new ApiKey("key1"));
        keys.add(new ApiKey("key2"));
        keys.add(new ApiKey("key3"));

        student.setKeys(keys);


        Colloquium col1 = new Colloquium("Col1");
        Set<Deck> decks = new HashSet<>();

        Deck deck1 = new Deck("Physics");
        Set<Question> questions1 = new HashSet<>();
        questions1.add(new Question("Physics - Question1", "Answer1"));
        questions1.add(new Question("Physics - Question2", "Answer1"));
        questions1.add(new Question("Physics - Question3", "Answer1"));
        questions1.add(new Question("Physics - Question4", "Answer1"));
        deck1.setQuestions(questions1);

        Deck deck2 = new Deck("Maths");
        Set<Question> questions2 = new HashSet<>();
        questions2.add(new Question("Math - Question1", "Answer1"));
        questions2.add(new Question("Math - Question2", "Answer1"));
        questions2.add(new Question("Math - Question3", "Answer1"));
        questions2.add(new Question("Math - Question4", "Answer1"));
        deck2.setQuestions(questions2);

        decks.add(deck1);
        decks.add(deck2);
        col1.setDecks(decks);

        student.getColloquia().add(col1);

        studentDAO.save(student);

        Student retrieve = studentDAO.getById(1, true);

        assertTrue(retrieve.getEmail().equals(email));
        assertTrue(retrieve.getColloquia().size() == 2);
        assertFalse(retrieve.getKeys().isEmpty());
        assertFalse(retrieve.getCreated() == null);

        for (Colloquium col : retrieve.getColloquia()) {
            ColloquiumDAO colloquiumDAO = new ColloquiumDAO();
            Colloquium c = colloquiumDAO.getById(col.getId(), true);

            assertTrue(col.getName().equals(c.getName()));
        }
    }
}
