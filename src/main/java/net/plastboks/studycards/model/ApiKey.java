package net.plastboks.studycards.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alex on 12/16/15.
 */
@Entity
@Table(name = "ApiKey")
public class ApiKey
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", unique = true, nullable = false)
    private int apikeyid = 0;

    @Column(name = "user", unique = false, nullable = false)
    private int user;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "value", unique = true, nullable = false)
    private String value;
}
