package net.plastboks.studycards.model.type;

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
@Table(name = "deck")
public class Deck implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="did", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "decks")
    private Set<Colloquium> colloquia;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "deck_question", joinColumns =
            { @JoinColumn(name = "did", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "qid") })
    private Set<Question> questions;

    public Deck(String name)
    {
        this.name = name;
    }

    private Deck() {}

    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Date getCreated()
    {
        return created;
    }

    public Date getUpdated()
    {
        return updated;
    }

    public Set<Colloquium> getColloquia()
    {
        return colloquia;
    }

    public void setGroups(Set<Colloquium> colloquia)
    {
        this.colloquia = colloquia;
    }

    public Set<Question> getQuestions()
    {
        return questions;
    }

    public void setQuestions(Set<Question> questions)
    {
        this.questions = questions;
    }
}
