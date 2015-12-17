package net.plastboks.studycards.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by alex on 12/16/15.
 */
@Entity
@Table(name = "User")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", unique = true, nullable = false)
    private int userid = 0;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "passwd", unique = true, nullable = false)
    private String password;
}
