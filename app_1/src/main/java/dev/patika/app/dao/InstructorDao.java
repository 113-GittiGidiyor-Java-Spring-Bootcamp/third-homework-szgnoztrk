package dev.patika.app.dao;

import dev.patika.app.model.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDao<T extends Instructor> extends CrudRepository<T, Integer> {
}
