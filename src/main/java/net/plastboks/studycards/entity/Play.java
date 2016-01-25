package net.plastboks.studycards.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alex on 12/18/15.
 */
@Entity
@Table(name = "play")
public class Play
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Integer id;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    private Play() {}

    public Integer getId()
    {
        return id;
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
