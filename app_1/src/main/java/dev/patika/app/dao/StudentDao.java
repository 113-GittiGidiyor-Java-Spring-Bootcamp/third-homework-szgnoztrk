package dev.patika.app.dao;

import dev.patika.app.model.Student;
import dev.patika.app.model.dto.GenderGroupDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer> {
    Student findById(int i);
    Student findByFullName(String s);

    @Query(nativeQuery = true, value = "SELECT s.student_gender AS gender, count(s.student_gender) AS counter FROM students s GROUP BY s.student_gender")
    List<GenderGroupDto> getGendersWithGroup();
}
