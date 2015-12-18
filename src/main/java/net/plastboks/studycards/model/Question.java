package net.plastboks.studycards.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by alex on 12/18/15.
 */
@Entity
@Table(name = "question")
public class Question implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="qid", unique = true, nullable = false)
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "questions")
    private Set<Deck> decks;

    @Column(name = "question", unique = false, nullable = false)
    private String question;

    @Column(name = "answer", unique = false, nullable = false)
    private String answer;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    public Question(String question, String answer)
    {
        this.question = question;
        this.answer = answer;
    }
}
