package net.plastboks.studycards.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by alex on 12/16/15.
 */
@Entity
@Table(name = "student")
public class Student implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(name = "password" , nullable = false)
    private String password;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "student")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<ApiKey> keys;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_colloquium", joinColumns =
            { @JoinColumn(name = "student_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "colloquium_id") })
    private Set<Colloquium> colloquia;

    private Student() {}

    public Student(String email)
    {
        this.email = email;
    }

    public Integer getId()
    {
        return id;
    }

    public String getEmail()
    {
        return email;
    }

    public Date getUpdated()
    {
        return updated;
    }

    public Date getCreated()
    {
        return created;
    }

    public Set<ApiKey> getKeys()
    {
        return keys;
    }

    public void setPassword(String password)
    {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void setEmail(String email)
    {
        this.email = email;
        // save default group
        Set<Colloquium> defaultColloquia = new LinkedHashSet<>();
        defaultColloquia.add(new Colloquium(email));
        setColloquia(defaultColloquia);
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setKeys(Set<ApiKey> keys)
    {
        this.keys = keys;
    }

    public Set<Colloquium> getColloquia()
    {
        return colloquia;
    }

    public void setColloquia(Set<Colloquium> colloquia)
    {
        this.colloquia = colloquia;
    }

}
