package dev.patika.app.dao;

import dev.patika.app.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends CrudRepository<Course, Integer> {
    Course findById(int id);
    Course findByName(String s);
}
