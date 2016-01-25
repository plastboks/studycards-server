package net.plastboks.studycards.entity;

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
@Table(name = "card")
public class Card implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Integer id;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "cards")
    private Set<Deck> decks;

    @Column(name = "question", unique = false, nullable = false)
    private String question;

    @Column(name = "answer", unique = false, nullable = false)
    private String answer;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    public Card(String question, String answer)
    {
        this.question = question;
        this.answer = answer;
    }

    private Card() {}

    public Integer getId()
    {
        return id;
    }

    public Set<Deck> getDecks()
    {
        return decks;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getAnswer()
    {
        return answer;
    }

    public Date getCreated()
    {
        return created;
    }

    public Date getUpdated()
    {
        return updated;
    }
}
