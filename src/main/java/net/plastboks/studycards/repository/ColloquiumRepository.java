package net.plastboks.studycards.repository;

import net.plastboks.studycards.entity.Colloquium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alex on 1/10/16.
 */
@Repository
public interface ColloquiumRepository extends JpaRepository<Colloquium, Integer>
{
}
