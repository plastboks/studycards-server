package net.plastboks.studycards.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alex on 12/16/15.
 */
@Entity
@Table(name = "User")
public class User implements Serializable
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private int id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "passwd", unique = true, nullable = false)
    private String password;

    public User(String email)
    {
        this.email = email;
    }

}
