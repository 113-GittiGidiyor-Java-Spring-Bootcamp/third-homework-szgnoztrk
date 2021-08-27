package dev.patika.app.dao;

import dev.patika.app.model.Instructor;
import dev.patika.app.model.dto.InstructorSalaryDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorDao<T extends Instructor> extends CrudRepository<T, Integer> {
    Instructor findById(int id);
    Instructor findByFullName(String s);

    @Query(nativeQuery = true, value = "SELECT TOP 3 i.instructor_fullname, IFNULL(vr.hourly_salary, pi.fixed_salary) AS salary FROM instructors i LEFT JOIN visiting_researchers vr ON(i.instructor_id = vr.instructor_id) LEFT JOIN permanent_instructors pi ON(i.instructor_id = pi.instructor_id) ORDER BY salary DESC")
    List<InstructorSalaryDto> getTop3MaxSalary();

    @Query(nativeQuery = true, value = "SELECT TOP 3 i.instructor_fullname as fullName, IFNULL(vr.hourly_salary, pi.fixed_salary) AS salary FROM instructors i LEFT JOIN visiting_researchers vr ON(i.instructor_id = vr.instructor_id) LEFT JOIN permanent_instructors pi ON(i.instructor_id = pi.instructor_id) ORDER BY salary")
    List<InstructorSalaryDto> getTop3MinSalary();
}
