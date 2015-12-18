package net.plastboks.studycards.model.type;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by alex on 12/16/15.
 */
@Entity
@Table(name = "apikey")
public class ApiKey implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="aid", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "value", unique = true, nullable = true)
    private String value;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    public ApiKey(String name)
    {
        this.name = name;
    }

    private ApiKey() {}

    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
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
