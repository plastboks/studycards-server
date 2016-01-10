package net.plastboks.studycards.repository;

import net.plastboks.studycards.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alex on 1/10/16.
 */
@Repository
public interface DeckRepository extends JpaRepository<Deck, Integer>
{
}
