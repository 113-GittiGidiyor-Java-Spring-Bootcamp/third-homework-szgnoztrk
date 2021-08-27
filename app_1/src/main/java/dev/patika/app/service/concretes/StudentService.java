package dev.patika.app.service.concretes;

import dev.patika.app.dao.StudentDao;
import dev.patika.app.model.Student;
import dev.patika.app.model.dto.GenderGroupDto;
import dev.patika.app.service.abstracts.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements BaseService<Student> {
    private StudentDao studentDao;
    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        Iterable<Student> studentIterable= this.studentDao.findAll();
        studentIterable.iterator().forEachRemaining(students::add);
        return students;
    }

    @Override
    public Student getById(int id) {
        return this.studentDao.findById(id);
    }

    @Override
    public Student save(Student student) {
        return (Student) this.studentDao.save(student);
    }

    @Override
    public Student update(Student student) {
        return (Student) this.studentDao.save(student);
    }

    @Override
    public String delete(int id) {
        Student student = this.studentDao.findById(id);
        this.studentDao.delete(student);
        return "Deleted.";
    }

    @Override
    public String deleteByName(String s) {
        Student student = this.studentDao.findByFullName(s);
        this.studentDao.delete(student);
        return "Deleted.";
    }

    public List<GenderGroupDto> genderWithGroup(){
        return this.studentDao.getGendersWithGroup();
    }
}
