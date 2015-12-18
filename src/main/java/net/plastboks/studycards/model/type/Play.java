package net.plastboks.studycards.model.type;

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
    @Column(name="pid", unique = true, nullable = false)
    private Long id;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    private Play() {}
}
