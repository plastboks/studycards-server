package net.plastboks.studycards.repository;

import net.plastboks.studycards.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alex on 1/10/16.
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>
{
}
