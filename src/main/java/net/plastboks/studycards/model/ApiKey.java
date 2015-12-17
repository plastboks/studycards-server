package net.plastboks.studycards.model;

import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.util.DigestUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.security.MessageDigest;

/**
 * Created by alex on 12/16/15.
 */
@Entity
@Table(name = "ApiKey")
public class ApiKey implements Serializable
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private int id;

    @Column(name = "user", unique = false, nullable = false)
    private User user;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "value", unique = true, nullable = false)
    private String value;

    public ApiKey(String name)
    {
        this.name = name;
    }
}
