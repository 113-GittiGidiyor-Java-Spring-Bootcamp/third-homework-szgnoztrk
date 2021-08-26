package dev.patika.app.dao;

import dev.patika.app.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer> {
    Student findById(int i);
    Student findByFullName(String s);
}
