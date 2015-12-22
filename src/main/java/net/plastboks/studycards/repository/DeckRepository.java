package net.plastboks.studycards.repository;

import net.plastboks.studycards.model.type.Deck;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by alex on 12/20/15.
 */
@RepositoryRestResource(collectionResourceRel = "deck", path = "deck")
public interface DeckRepository extends PagingAndSortingRepository<Deck, Long>
{
    List<Deck> findByName(@Param("name") String name);
}
