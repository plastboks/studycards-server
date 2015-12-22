package net.plastboks.studycards.repository;

import net.plastboks.studycards.model.type.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by alex on 12/20/15.
 */
@RepositoryRestResource(collectionResourceRel = "student", path = "student")
public interface StudentRepository extends PagingAndSortingRepository<Student, Long>
{
    List<Student> findByEmail(@Param("email") String email);
}
