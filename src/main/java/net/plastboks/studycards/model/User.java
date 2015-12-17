package net.plastboks.studycards.model;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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

    @OneToMany(mappedBy = "user")
    private Set<ApiKey> keys;

    public User(String email, String password)
    {
        this.email = email;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public Set<ApiKey> getKeys()
    {
        return keys;
    }

    public void setKeys(Set<ApiKey> keys)
    {
        this.keys = keys;
    }
}
