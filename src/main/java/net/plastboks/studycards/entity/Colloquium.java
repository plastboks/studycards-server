package net.plastboks.studycards.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by alex on 12/18/15.
 */
@Entity
@Table(name = "colloquium")
public class Colloquium implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cid", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "colloquia")
    private Set<Student> students;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "colloquium_deck", joinColumns =
            { @JoinColumn(name = "cid", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "did") })
    private Set<Deck> decks = new LinkedHashSet<>(0);

    public Colloquium(String name)
    {
        this.name = name;
    }

    private Colloquium() {}

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

    public Set<Deck> getDecks()
    {
        return decks;
    }

    public void setDecks(Set<Deck> decks)
    {
        this.decks = decks;
    }

    public Set<Student> getStudents()
    {
        return students;
    }

    public void setStudents(Set<Student> students)
    {
        this.students = students;
    }
}
